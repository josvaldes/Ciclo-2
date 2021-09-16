/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jose-
 */
public class ConexionBD {

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/reto4bd", "root", "");
                System.out.println("Conexion exitosa");
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
            //cerrar();
        }
        return cnx;
        
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

    public PreparedStatement prepareStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
