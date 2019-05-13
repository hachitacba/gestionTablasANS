/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import negocio.GestorPersonas;

/**
 *
 * @author Nico
 */
public class Menu extends JFrame{
    private JMenuBar barra;
    private JMenu personas,reportes,salir;
    private JMenuItem nuevaPersona,consultarPersonas,salirItem,eliminarPersona,modificarPersona;
    private GestorPersonas gestor;
    
    public Menu(GestorPersonas g)
    {
        this.setTitle("Menú principal");
        gestor=g;
        barra=new JMenuBar();
        personas=new JMenu("Personas");
        reportes=new JMenu("Reportes");
        salir=new JMenu("Salir");
        nuevaPersona=new JMenuItem("Nueva persona");
        consultarPersonas=new JMenuItem("Consultar personas");
        eliminarPersona=new JMenuItem("Eliminar persona");
        modificarPersona=new JMenuItem("Modificar persona");
        salirItem=new JMenuItem("Salir");
        
        personas.add(nuevaPersona);
        personas.add(eliminarPersona);
        personas.add(modificarPersona);
        reportes.add(consultarPersonas);
        salir.add(salirItem);
        
        barra.add(personas);
        barra.add(reportes);
        barra.add(salir);
        
        this.getContentPane().setLayout(null);
        
        this.setSize(600,400);
        barra.setSize(600,20);
        barra.setLocation(0,0);
        this.getContentPane().add(barra);
        
        Escucha escucha=new Escucha(this,gestor);
        nuevaPersona.addActionListener(escucha);
        eliminarPersona.addActionListener(escucha);
        modificarPersona.addActionListener(escucha);
        consultarPersonas.addActionListener(escucha);
        salirItem.addActionListener(escucha);
    }
    
    class Escucha implements ActionListener
    {
        private Menu principal;
        private GestorPersonas gestor;
        
        public Escucha(Menu p,GestorPersonas g)
        {
            gestor=g;
            principal=p;
        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==nuevaPersona)
            {
                NuevaPersona np=new NuevaPersona(principal,gestor);
                np.setVisible(true);
            }
            else
                if(e.getSource()==consultarPersonas)
                {
                    ConsultarPersonas v1=new ConsultarPersonas(principal,gestor);
                    v1.setVisible(true);
                }
                else
                    if(e.getSource()==salirItem)
                    {
                        principal.dispose();
                    }
                    else
                        if(e.getSource()==eliminarPersona)
                        {
                            EliminarPersona ep = new EliminarPersona(principal,gestor);
                            ep.setVisible(true);
                        }
                        else
                            if(e.getSource()==modificarPersona)
                            {
                                ModificarPersona mp=new ModificarPersona(principal,gestor);
                                mp.setVisible(true);
                            }
        }
    }
    
    
}
