/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.GestorPersonas;
import negocio.Persona;

/**
 *
 * @author alumno
 */
public class ConsultarPersonas extends JFrame {
    
    private JTable tabla;
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    private Menu principal;
    
    private JButton btnSalir;
    
    private GestorPersonas gestor;
    
    public ConsultarPersonas(Menu p,GestorPersonas g)
    {
        gestor=g;
        principal=p;
        principal.setVisible(false);
        
        this.setTitle("Consultar personas registradas");
        this.getContentPane().setLayout(null);
        this.setSize(800,450);

        //usando constructor sin parámetros
        //tabla = new JTable();
        
        /*usando constructor quer reciba como parámatro un objeto 
        DafaultTableModel, que a su vez, su constructor tampoco reciba
        parámetros*/
        //tabla = new JTable(new DefaultTableModel());
        
        /*Creo una matriz que se correspondrá con los datos de los registros*/
        /*Object[][] mat;
        mat=new Object[4][3];*/
        /*Creo un vector de String, que se correspondrá con los nombres 
        de los campos de la tabla*/
        /*mat[0][0]="Pérez";
        mat[0][1]="Juan";
        mat[0][2]=20;
        mat[1][0]="López";
        mat[1][1]="Ana";
        mat[1][2]=21;
        mat[2][0]="Martínez";
        mat[2][1]="Lucía";
        mat[2][2]=18;
        mat[3][0]="Rodríguez";
        mat[3][1]="Marcos";
        mat[3][2]=24;*/
        String[] cab={"Apellido","Nombre","Edad","Genero","Pasatiempo"};
        
        /*Object[][] mat1={{"Pérez","Juan",20},
                         {"López","Ana",21},
                         {"Marínez","Lucía",18},
                         {"Rodríguez","Marcos",24}
                        };*/
    
        
        
        /*usando constructor quer reciba como parámatro un objeto 
        DafaultTableModel, cuyo constructor reciba dos parámetros*/
        //tabla = new JTable(new DefaultTableModel(mat,cab));
        
        //tabla=new JTable(mat1,cab);
        

        //tabla=new JTable(new DefaultTableModel(cab,0));
        
        
        
        //Object[] vec={"Juárez","Lucas",22};
        //modelo.addRow(vec);
        
        int cant=gestor.cantPersonas();
        Object[][]mat;
        mat=new Object[cant][5];
        Persona pers=null;
        for(int i=0;i<cant;i++)
        {
            pers=gestor.getPersona(i);
            if(pers!=null)
            {
                mat[i][0]=pers.getApellido();
                mat[i][1]=pers.getNombre();
                mat[i][2]=pers.getEdad();
                mat[i][3]=pers.getGenero();
                mat[i][4]=Arrays.toString(pers.getPasatiempos());
            }
        }
        
        tabla=new JTable();
        DefaultTableModel modelo=new DefaultTableModel(mat,cab);
        tabla.setModel(modelo);
        
        
        tabla.setModel(modelo);
        
        scroll=new JScrollPane();
        scroll.setViewportView(tabla);
        
        scroll.setSize(700,300);
        scroll.setLocation(20,20);
        
        this.getContentPane().add(scroll);
        
        btnSalir = new JButton("Salir");
        btnSalir.setSize(200,20);
        btnSalir.setLocation(20,350);
        
        this.getContentPane().add(btnSalir);
        
        
        Escucha escucha=new Escucha(this,principal,gestor);
        btnSalir.addActionListener(escucha);
        
    }
    
    class Escucha implements ActionListener
    {
        private Menu principal;
        private ConsultarPersonas actual;
        private GestorPersonas gestor;
        public Escucha(ConsultarPersonas act,Menu p,GestorPersonas g)
        {
            gestor=g;
            actual=act;
            principal=p;
        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==btnSalir)
            {
                actual.dispose();
                principal.setVisible(true);
            }
        }

       
    }
    
}
