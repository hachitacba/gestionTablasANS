/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.LinkedList;

/**
 *
 * @author Nico
 */
public class GestorPersonas {
    private LinkedList<Persona> personas;
    
    public GestorPersonas()
    {
        personas=new LinkedList();
    }
    
    public boolean addPersona(Persona p)
    {
        return personas.add(p);
    }
    
    public boolean removePersona(int pos)
    {
        boolean res=false;
        if(pos>=0 && pos<personas.size())
        {
            personas.remove(pos);
            res=true;
        }
        return res;
    }
    
    public boolean modificarPersona(int pos,String ape,String nom, int edad, char gen, String[] pas)
    {
        boolean res=false;
        Persona enc=getPersona(pos);
        if(enc!=null)
        {
            enc.setApellido(ape);
            enc.setNombre(nom);
            enc.setEdad(edad);
            enc.setGenero(gen);
            enc.setPasatiempos(pas);
            res=true;
        }
        return res;
    }
    
    public Persona getPersona(int pos)
    {
        Persona res=null;
        if(pos >= 0 && pos < personas.size())
            res= personas.get(pos);
        return res;
    }
    
    public int cantPersonas()
    {
        return personas.size();
    }
    
}
