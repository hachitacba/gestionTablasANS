/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import presentacion.Menu;
/**
 *
 * @author Nico
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestorPersonas gestor=new GestorPersonas();
        Menu p=new Menu(gestor);
        p.setVisible(true);
    }
    
}
