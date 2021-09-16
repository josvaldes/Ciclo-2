/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import modelo.ConexionBD;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import controlador.*;
import java.util.LinkedList;
import modelo.*;

/**
 *
 * @author jose-
 */
public class PruebaUnitaria1 {

    public PruebaUnitaria1() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    ControladorProveedores p = new ControladorProveedores();

    @Test
    public void prueba1() throws SQLException, ClassNotFoundException {
        System.out.println("Consulta listado de proveedores");
        try {
            LinkedList<ModeloProveedores> ListaPrueba = p.ObtenerListaProveedoresBD(ConexionBD.obtener());
            assertTrue("Lista con datos de proveedores", ListaPrueba.size() > 0);

            for (int i = 0; i < ListaPrueba.size(); i++) {
                System.out.println("Proveedores " + ListaPrueba.get(i).getRazonSocial());

            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
}
