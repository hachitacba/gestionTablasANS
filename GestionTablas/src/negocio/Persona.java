/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Nico
 */
public class Persona {
    private String apellido,nombre;
    private int edad;
    char genero;
    String[] pasatiempos;

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String[] getPasatiempos() {
        return pasatiempos;
    }

    public void setPasatiempos(String[] pasatiempos) {
        this.pasatiempos = pasatiempos;
    }
    
    public Persona(String ape,String nom,int ed, char gen, String[] pas)
    {
        apellido=ape;
        nombre=nom;
        edad=ed;
        genero=gen;
        pasatiempos=pas;
        
        
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "apellido=" + apellido + ", nombre=" + nombre + 
                ", edad=" + edad + ", genero=" + genero + ", pasatiempos=" +
                pasatiempos + '}';
    }
   
}
