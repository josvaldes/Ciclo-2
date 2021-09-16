/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosemana5;

import controlador.ControladorProveedores;
import java.sql.SQLException;
import modelo.ModeloProveedores;
import vista.GestionPedidos;

/**
 *
 * @author jose-
 */
public class RetoSemana5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        ModeloProveedores modeloMVC=new ModeloProveedores();
        GestionPedidos vistaMVC=new GestionPedidos();
        
        ControladorProveedores controladorMVC=new ControladorProveedores(vistaMVC, modeloMVC);
        
        controladorMVC.iniciar();
        vistaMVC.setVisible(true);
        
    }
    
}
