/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import negocio.GestorPersonas;
import negocio.Persona;

/**
 *
 * @author Nico
 */
public class NuevaPersona extends JFrame{
    
    private JLabel lblApellido,lblNombre,lblEdad;
    private JTextField txtApellido,txtNombre,txtEdad;
    private JButton btnGuardar,btnCancelar,btnSalir;
    private Menu principal;
    private GestorPersonas gestor;

// tarea    
    private javax.swing.JCheckBox chkOtras;
    private javax.swing.JCheckBox chkPasearMascotas;
    private javax.swing.JCheckBox chkPatinar;
    private javax.swing.JCheckBox chkVerSeries;
    private javax.swing.JCheckBox chkVideoJuegos;
    private javax.swing.ButtonGroup grupGenero;
    private javax.swing.JRadioButton rbtFemenino;
    private javax.swing.JRadioButton rbtMasculino;
    private javax.swing.JLabel lblseleccione;
    
    public NuevaPersona(Menu p,GestorPersonas g)
    {
        gestor=g;
        principal = p;
        principal.setVisible(false);
        
        this.setTitle("Registrar nueva persona");
        lblApellido=new JLabel("Apellido: ");
        lblNombre=new JLabel("Nombre: ");
        lblEdad=new JLabel("Edad: ");
        
        txtApellido=new JTextField();
        txtNombre=new JTextField();
        txtEdad=new JTextField();
        
        btnGuardar=new JButton("Guardar");
        btnCancelar=new JButton("Cancelar");
        btnSalir=new JButton("Salir");

//tarea    
        grupGenero = new javax.swing.ButtonGroup();
        rbtMasculino = new javax.swing.JRadioButton("Masculino");
        rbtFemenino = new javax.swing.JRadioButton("Femenino");
        chkVideoJuegos = new javax.swing.JCheckBox("Videos Juegos");
        chkPatinar = new javax.swing.JCheckBox("Patinar");
        chkVerSeries = new javax.swing.JCheckBox("Ver Series");
        chkPasearMascotas = new javax.swing.JCheckBox("Pasear con mascotas");
        chkOtras = new javax.swing.JCheckBox("Otras"); 
        lblseleccione =new  JLabel("Seleccione pasatiempos: ");
        
        this.setSize(500,500);
        this.getContentPane().setLayout(new GridLayout(9,2));
        this.getContentPane().add(lblApellido);
        this.getContentPane().add(txtApellido);
        this.getContentPane().add(lblNombre);
        this.getContentPane().add(txtNombre);
        this.getContentPane().add(lblEdad);
        this.getContentPane().add(txtEdad);
        
        
        this.getContentPane().add(rbtMasculino);
        this.getContentPane().add(rbtFemenino);
        this.getContentPane().add(chkVerSeries);
        this.getContentPane().add(lblseleccione);
        this.getContentPane().add(chkVideoJuegos);
        this.getContentPane().add(chkPatinar);
        this.getContentPane().add(chkVerSeries);
        this.getContentPane().add(chkPasearMascotas);
        this.getContentPane().add(chkOtras);
        
        
        grupGenero.add(rbtMasculino);
        grupGenero.add(rbtFemenino);


        this.getContentPane().add(btnGuardar);
        this.getContentPane().add(btnCancelar);
        this.getContentPane().add(btnSalir);
        
        Escucha escucha=new Escucha(this,principal,gestor);
        btnSalir.addActionListener(escucha);
        btnGuardar.addActionListener(escucha);
        btnCancelar.addActionListener(escucha);
            
    }
    
    public void limpiar()
    {
        txtApellido.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        grupGenero.clearSelection();
        chkOtras.setSelected(false);
        chkPasearMascotas.setSelected(false);
        chkPatinar.setSelected(false);
        chkVerSeries.setSelected(false);
        chkVideoJuegos.setSelected(false);
        
    }
    
    class Escucha implements ActionListener
    {
        private NuevaPersona ventanaActual;
        private Menu principal;
        private GestorPersonas gestor;
        
        public Escucha(NuevaPersona np,Menu p,GestorPersonas g)
        {
            ventanaActual=np;
            principal=p;
            gestor=g;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            
            if(e.getSource()==btnSalir)
            {
                ventanaActual.dispose();
                principal.setVisible(true);
            }
            else
                if(e.getSource()==btnGuardar)
                {
                    String ape=txtApellido.getText();
                    String nom=txtNombre.getText();
                    int ed=Integer.parseInt(txtEdad.getText());
                    char gen='x';
                    if (rbtMasculino.isSelected()) {
                        gen='M';
                    }else 
                        gen='F';
                    
                    String[] pas=new String[5];
                    if (chkVideoJuegos.isSelected()) {
                        pas[0]="Videos Juegos";
                    } else
                        pas[0]="";
                    if (chkPatinar.isSelected()) {
                        pas[1]="Patinar";
                    } else
                        pas[1]="";
                    if (chkVerSeries.isSelected()) {
                        pas[2]="Ver Series";
                    } else 
                        pas[2]="";
                    if (chkPasearMascotas.isSelected()) {
                        pas[3]="Pasear mascotas";
                    } else
                        pas[3]="";
                    if (chkOtras.isSelected()) {
                        pas[4]="Otras";
                    } else
                        pas[4]="";
                    Persona p=new Persona(ape,nom,ed,gen,pas);
                    gestor.addPersona(p);
                    
                    ventanaActual.limpiar();
                }
                
                    if(e.getSource()==btnCancelar)
                    {
                        ventanaActual.limpiar();
                    }   
            txtApellido.requestFocus();
        }

       
    
    }
}
