/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.ModeloProveedores;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import vista.GestionPedidos;

/**
 *
 * @author jose-
 */
public class ControladorProveedores implements ActionListener {

    private GestionPedidos vista;
    private ModeloProveedores modelo;
    private ConexionBD BD;
    private LinkedList<ModeloProveedores> ListaProveedores = new LinkedList<>();
    private LinkedList<ModeloProveedores> Proveedor2 = new LinkedList<>();
    private LinkedList<ModeloProveedores> ListaProveedoresInicialBD = new LinkedList<>();

    public ControladorProveedores(GestionPedidos vista, ModeloProveedores modelo) throws SQLException, ClassNotFoundException {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
    }

    public ControladorProveedores() {
    }

    public void iniciar() throws SQLException, ClassNotFoundException {
        vista.setTitle("Vista Proveedores");
        vista.setLocationRelativeTo(null);
        ListaProveedoresInicialBD = ObtenerListaProveedoresBD(ConexionBD.obtener());
        ListaProveedores = ListaProveedoresInicialBD;

        if (ListaProveedores == null) {
            vista.Panel.setEnabledAt(1, false);
        } else {
            vista.Panel.setEnabledAt(1, true);
        }

        AgregarProveedorTabla();
        reporteProveedores();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Se escuchan los eventos desde el boton guardar de la vista Proveedores
        if (ae.getSource() == vista.btnGuardar) {

            try {
                if (vista.txtBarrio.getText().isEmpty() || vista.txtCalleCarrera.getText().isEmpty() || vista.txtCiudad.getText().isEmpty() || vista.txtCorreoElectronico.getText().isEmpty() || vista.txtNit.getText().isEmpty() || vista.txtNumeroCalleCarrera.getText().isEmpty() || vista.txtRazonSocial.getText().isEmpty() || vista.txtRepresentanteLegal.getText().isEmpty() || vista.txtSitioWeb.getText().isEmpty() || vista.txtTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error Existen campos vacios");
                } else {
                    ModeloProveedores proveedor = new ModeloProveedores(vista.txtRazonSocial.getText(), vista.txtNit.getText(), vista.txtTelefono.getText(), vista.txtCorreoElectronico.getText(), vista.txtRepresentanteLegal.getText(), vista.txtCalleCarrera.getText(), vista.txtNumeroCalleCarrera.getText(), vista.txtBarrio.getText(), vista.txtCiudad.getText(), vista.txtSitioWeb.getText());
                    ListaProveedores.add(proveedor);
                    JOptionPane.showMessageDialog(null, "Proveedor guardado");
                    AgregarProveedorTabla();
                    vista.Panel.setEnabledAt(1, true);
                    vista.Panel.setEnabledAt(2, true);
                    LimpiarPestanaProveedores();
                    int clave = AgregarDireccionBD(ConexionBD.obtener(), proveedor);
                    AgregarProveedorBD(ConexionBD.obtener(), proveedor, clave);
                }
            } catch (HeadlessException e) {

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //Se escuchan los eventos desde el boton buscar de la vista Proveedores
        if (ae.getSource() == vista.btnBuscar) {
            try {
                if (vista.txtNit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error el campo NIT se encuentra vacio");
                } else {
                    ModeloProveedores proveedorbuscado = BuscarProveedorBD(ConexionBD.obtener(), vista.txtNit.getText());
                    if (proveedorbuscado == null) {
                        JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Proveedor encontrado");
                        vista.txtBarrio.setText(proveedorbuscado.getBarrio());
                        vista.txtCalleCarrera.setText(proveedorbuscado.getCalleCarrera());
                        vista.txtCiudad.setText(proveedorbuscado.getCiudad());
                        vista.txtCorreoElectronico.setText(proveedorbuscado.getCorreoElectronico());
                        vista.txtNumeroCalleCarrera.setText(proveedorbuscado.getNumeroCalleCarrera());
                        vista.txtRazonSocial.setText(proveedorbuscado.getRazonSocial());
                        vista.txtRepresentanteLegal.setText(proveedorbuscado.getRepresentanteLegal());
                        vista.txtSitioWeb.setText(proveedorbuscado.getSitioWeb());
                        vista.txtTelefono.setText(proveedorbuscado.getTelefono());
                    }
                }
            } catch (HeadlessException e) {

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ControladorProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Se escuchan los eventos desde el boton ediatar de la vista Proveedores
        if (ae.getSource() == vista.btnEditar) {

            try {
                if (vista.txtBarrio.getText().isEmpty() || vista.txtCalleCarrera.getText().isEmpty() || vista.txtCiudad.getText().isEmpty() || vista.txtCorreoElectronico.getText().isEmpty() || vista.txtNit.getText().isEmpty() || vista.txtNumeroCalleCarrera.getText().isEmpty() || vista.txtRazonSocial.getText().isEmpty() || vista.txtRepresentanteLegal.getText().isEmpty() || vista.txtSitioWeb.getText().isEmpty() || vista.txtTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error para editar primero debe realizar una busqueda");
                } else {
                    //ModeloProveedores proveedor = new ModeloProveedores(vista.txtRazonSocial.getText(), vista.txtNit.getText(), vista.txtTelefono.getText(), vista.txtCorreoElectronico.getText(), vista.txtRepresentanteLegal.getText(), vista.txtCalleCarrera.getText(), vista.txtNumeroCalleCarrera.getText(), vista.txtBarrio.getText(), vista.txtCiudad.getText(), vista.txtSitioWeb.getText());
                    //ModeloProveedores proveedorbuscado = BuscarProveedorBD(ConexionBD.obtener(), vista.txtNit.getText());
                    /*
                    String barrio=vista.txtBarrio.setText(vista.txtBarrio.getText());
                    vista.txtCalleCarrera.setText(proveedorbuscado.getCalleCarrera());
                    vista.txtCiudad.setText(proveedorbuscado.getCiudad());
                    vista.txtCorreoElectronico.setText(proveedorbuscado.getCorreoElectronico());
                    vista.txtNumeroCalleCarrera.setText(proveedorbuscado.getNumeroCalleCarrera());
                    vista.txtRazonSocial.setText(proveedorbuscado.getRazonSocial());
                    vista.txtRepresentanteLegal.setText(proveedorbuscado.getRepresentanteLegal());
                    vista.txtSitioWeb.setText(proveedorbuscado.getSitioWeb());
                    vista.txtTelefono.setText(proveedorbuscado.getTelefono());
                     */
                    ModeloProveedores ProveedorConId = BuscarProveedorBD(ConexionBD.obtener(), vista.txtNit.getText());
                    ModeloProveedores proveedoreditado = new ModeloProveedores(ProveedorConId.getIdproveedores(), vista.txtRazonSocial.getText(), vista.txtNit.getText(), vista.txtTelefono.getText(), vista.txtCorreoElectronico.getText(), vista.txtRepresentanteLegal.getText(), vista.txtSitioWeb.getText(), ProveedorConId.getIddirreciones(), vista.txtCalleCarrera.getText(), vista.txtNumeroCalleCarrera.getText(), vista.txtBarrio.getText(), vista.txtCiudad.getText());
                    EditarProveedorBD(ConexionBD.obtener(), proveedoreditado);

                    System.out.println("Por aqui vamos");
                    AgregarProveedorTabla();
                    //vista.Panel.setEnabledAt(1, true);
                    //vista.Panel.setEnabledAt(2, true);
                    LimpiarPestanaProveedores();
                    int clave = AgregarDireccionBD(ConexionBD.obtener(), proveedoreditado);
                    AgregarProveedorBD(ConexionBD.obtener(), proveedoreditado, clave);

                    ListaProveedoresInicialBD = ObtenerListaProveedoresBD(ConexionBD.obtener());
                    ListaProveedores = ListaProveedoresInicialBD;

                    if (ListaProveedores == null) {
                        vista.Panel.setEnabledAt(1, false);
                    } else {
                        vista.Panel.setEnabledAt(1, true);
                    }

                    AgregarProveedorTabla();

                    //System.out.println(RegistriEditado);
                    /*
                    if(RegistroEditado){
                        LimpiarPestanaProveedores();
                        JOptionPane.showMessageDialog(null, "Registro Proveedor editado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Registro Proveedor no editado");
                    }*/
                    //ListaProveedores.add(proveedor);
                    //AgregarProveedorTabla();
                    //vista.Panel.setEnabledAt(1, true);
                    //vista.Panel.setEnabledAt(2, true);
                    //int clave = AgregarDireccionBD(ConexionBD.obtener(), proveedor);
                    //AgregarProveedorBD(ConexionBD.obtener(), proveedor, clave);
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {

            }

        }

        //Se escuchan los eventos desde el boton eliminar de la vista Proveedores
        if (ae.getSource() == vista.btnEliminar) {

            try {
                if (vista.txtBarrio.getText().isEmpty() || vista.txtCalleCarrera.getText().isEmpty() || vista.txtCiudad.getText().isEmpty() || vista.txtCorreoElectronico.getText().isEmpty() || vista.txtNit.getText().isEmpty() || vista.txtNumeroCalleCarrera.getText().isEmpty() || vista.txtRazonSocial.getText().isEmpty() || vista.txtRepresentanteLegal.getText().isEmpty() || vista.txtSitioWeb.getText().isEmpty() || vista.txtTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error para eliminar primero debe realizar una busqueda");
                } else {
                    //ModeloProveedores proveedor = new ModeloProveedores(vista.txtRazonSocial.getText(), vista.txtNit.getText(), vista.txtTelefono.getText(), vista.txtCorreoElectronico.getText(), vista.txtRepresentanteLegal.getText(), vista.txtCalleCarrera.getText(), vista.txtNumeroCalleCarrera.getText(), vista.txtBarrio.getText(), vista.txtCiudad.getText(), vista.txtSitioWeb.getText());
                    ModeloProveedores proveedorbuscado = BuscarProveedorBD(ConexionBD.obtener(), vista.txtNit.getText());
                    /*
                    vista.txtBarrio.setText(proveedorbuscado.getBarrio());
                    vista.txtCalleCarrera.setText(proveedorbuscado.getCalleCarrera());
                    vista.txtCiudad.setText(proveedorbuscado.getCiudad());
                    vista.txtCorreoElectronico.setText(proveedorbuscado.getCorreoElectronico());
                    vista.txtNumeroCalleCarrera.setText(proveedorbuscado.getNumeroCalleCarrera());
                    vista.txtRazonSocial.setText(proveedorbuscado.getRazonSocial());
                    vista.txtRepresentanteLegal.setText(proveedorbuscado.getRepresentanteLegal());
                    vista.txtSitioWeb.setText(proveedorbuscado.getSitioWeb());
                    vista.txtTelefono.setText(proveedorbuscado.getTelefono());
                     */
                    EliminarProveedorBD(ConexionBD.obtener(), proveedorbuscado.getIdproveedores());
                    LimpiarPestanaProveedores();
                    JOptionPane.showMessageDialog(null, "Registro Proveedor eliminado");
                    ListaProveedoresInicialBD = ObtenerListaProveedoresBD(ConexionBD.obtener());
                    ListaProveedores = ListaProveedoresInicialBD;

                    if (ListaProveedores == null) {
                        vista.Panel.setEnabledAt(1, false);
                    } else {
                        vista.Panel.setEnabledAt(1, true);
                    }

                    AgregarProveedorTabla();
                    /*ystem.out.println("Por aqui vamos");
                    //AgregarProveedorTabla();
                    //vista.Panel.setEnabledAt(1, true);
                    //vista.Panel.setEnabledAt(2, true);
                    
                    int clave = AgregarDireccionBD(ConexionBD.obtener(), proveedorbuscado);
                    AgregarProveedorBD(ConexionBD.obtener(), proveedorbuscado, clave);

                    ListaProveedoresInicialBD = ObtenerListaProveedoresBD(ConexionBD.obtener());
                    ListaProveedores = ListaProveedoresInicialBD;

                    if (ListaProveedores == null) {
                        vista.Panel.setEnabledAt(1, false);
                    } else {
                        vista.Panel.setEnabledAt(1, true);
                    }

                    AgregarProveedorTabla();

                    //System.out.println(RegistriEditado);
                    /*
                    if(RegistroEditado){
                        LimpiarPestanaProveedores();
                        JOptionPane.showMessageDialog(null, "Registro Proveedor editado");
                    }else{
                        JOptionPane.showMessageDialog(null, "Registro Proveedor no editado");
                    }*/
                    //ListaProveedores.add(proveedor);
                    //AgregarProveedorTabla();
                    //vista.Panel.setEnabledAt(1, true);
                    //vista.Panel.setEnabledAt(2, true);
                    //int clave = AgregarDireccionBD(ConexionBD.obtener(), proveedor);
                    //AgregarProveedorBD(ConexionBD.obtener(), proveedor, clave);
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {

            }

        }

    }

    public void AgregarProveedorTabla() {
        String matriz[][] = new String[ListaProveedores.size()][10];

        for (int i = 0; i < ListaProveedores.size(); i++) {
            matriz[i][0] = ListaProveedores.get(i).getRazonSocial();
            matriz[i][1] = ListaProveedores.get(i).getNit();
            matriz[i][2] = ListaProveedores.get(i).getRepresentanteLegal();
            matriz[i][3] = ListaProveedores.get(i).getTelefono();
            matriz[i][4] = ListaProveedores.get(i).getSitioWeb();
            matriz[i][5] = ListaProveedores.get(i).getCiudad();
            matriz[i][6] = ListaProveedores.get(i).getCalleCarrera();
            matriz[i][7] = ListaProveedores.get(i).getNumeroCalleCarrera();
            matriz[i][8] = ListaProveedores.get(i).getBarrio();
            matriz[i][9] = ListaProveedores.get(i).getCorreoElectronico();

        }

        vista.TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Razon Social", "Nit", "Representante Legal", "Telefono", "Sitio Web", "Ciudad", "Calle Carrera", "Numero", "Barrio", "Correo Electronico"
                }
        ));

    }

    public void AgregarProveedorBD(Connection conexion, ModeloProveedores proveedores, int iddirrecion) throws SQLException {

        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO tb_proveedores (nit, razonsocial, correoelectronico,representantelegal, sitioweb, telefono, iddireccion) VALUES(?, ?, ?, ?, ?, ?, ?)");
            consulta.setString(1, proveedores.getNit());
            consulta.setString(2, proveedores.getRazonSocial());
            consulta.setString(3, proveedores.getCorreoElectronico());
            consulta.setString(4, proveedores.getRepresentanteLegal());
            consulta.setString(5, proveedores.getSitioWeb());
            consulta.setString(6, proveedores.getTelefono());
            consulta.setString(7, String.valueOf(iddirrecion));

            int resultado = consulta.executeUpdate();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public int AgregarDireccionBD(Connection conexion, ModeloProveedores proveedores) throws SQLException {

        try {
            PreparedStatement consulta;
            String query = "INSERT INTO tb_direcciones (callecarrera, numero, barrio, ciudad) VALUES(?, ?, ?, ?)";
            consulta = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            consulta.setString(1, proveedores.getCalleCarrera());
            consulta.setString(2, proveedores.getNumeroCalleCarrera());
            consulta.setString(3, proveedores.getBarrio());
            consulta.setString(4, proveedores.getCiudad());

            int resultado = consulta.executeUpdate();

            if (resultado > 0) {
                ResultSet LlaveTablaDirecciones = consulta.getGeneratedKeys();
                if (LlaveTablaDirecciones.next()) {
                    int iddirecciones = LlaveTablaDirecciones.getInt(1);
                    return iddirecciones;
                }
            }

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return 0;
    }

    public ModeloProveedores BuscarProveedorBD(Connection conexion, String Nit) throws SQLException {

        try {
            PreparedStatement consulta;
            String query;
            query = "SELECT * FROM tb_proveedores AS p INNER JOIN tb_direcciones AS d on p.idDireccion = d.Id WHERE p.Nit=?;";
            consulta = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            consulta.setString(1, Nit);
            ResultSet resultado = consulta.executeQuery();

            //System.out.println(resultado.toString());
            while (resultado.next()) {
                int idproveedores = resultado.getInt(1);
                //String nit = resultado.getString(2);
                String RazonSocial = resultado.getString(3);
                String Telefono = resultado.getString(4);
                String CorreoElectronico = resultado.getString(5);
                String RepresentanteLegal = resultado.getString(6);
                String SitioWeb = resultado.getString(7);
                int iddirecciones = resultado.getInt(8);
                String CalleCarrera = resultado.getString(10);
                String NumeroCalleCarrera = resultado.getString(11);
                String Barrio = resultado.getString(12);
                String Ciudad = resultado.getString(13);
                ModeloProveedores proveedor = new ModeloProveedores(idproveedores, RazonSocial, Nit, Telefono, CorreoElectronico, RepresentanteLegal, SitioWeb, iddirecciones, CalleCarrera, NumeroCalleCarrera, Barrio, Ciudad);
                return proveedor;

            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        ModeloProveedores proveedor2 = null;

        return proveedor2;
    }

    public void LimpiarPestanaProveedores() {
        vista.txtBarrio.setText("");
        vista.txtCalleCarrera.setText("");
        vista.txtCiudad.setText("");
        vista.txtCorreoElectronico.setText("");
        vista.txtNit.setText("");
        vista.txtNumeroCalleCarrera.setText("");
        vista.txtRazonSocial.setText("");
        vista.txtRepresentanteLegal.setText("");
        vista.txtSitioWeb.setText("");
        vista.txtTelefono.setText("");
    }

    public LinkedList<ModeloProveedores> ObtenerListaProveedoresBD(Connection conexion) throws SQLException {
        //LinkedList<ModeloProveedores> proveedor2 = null;
        try {
            PreparedStatement consulta;
            String query;
            query = "SELECT * FROM tb_proveedores AS p INNER JOIN tb_direcciones AS d on p.idDireccion = d.Id";
            consulta = conexion.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {

                int idproveedores = resultado.getInt(1);
                String nit = resultado.getString(2);
                String RazonSocial = resultado.getString(3);
                String Telefono = resultado.getString(4);
                String CorreoElectronico = resultado.getString(5);
                String RepresentanteLegal = resultado.getString(6);
                String SitioWeb = resultado.getString(7);
                int iddirecciones = resultado.getInt(8);
                String CalleCarrera = resultado.getString(10);
                String NumeroCalleCarrera = resultado.getString(11);
                String Barrio = resultado.getString(12);
                String Ciudad = resultado.getString(13);
                ModeloProveedores proveedor = new ModeloProveedores(idproveedores, RazonSocial, nit, Telefono, CorreoElectronico, RepresentanteLegal, SitioWeb, iddirecciones, CalleCarrera, NumeroCalleCarrera, Barrio, Ciudad);
                ListaProveedores.add(proveedor);
            }
            return ListaProveedores;

        } catch (SQLException ex) {
            //throw new SQLException(ex);
            LinkedList<ModeloProveedores> proveedor2;
            proveedor2 = null;
            //LinkedList<ModeloProveedores> proveedor2 = new LinkedList<>();
            //LinkedList<ModeloProveedores> proveedor2 = null;
            return proveedor2;
            //throw new SQLException(ex);
        }

    }

    public void EditarProveedorBD(Connection conexion, ModeloProveedores proveedoreditado) throws SQLException {

        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE tb_proveedores SET Nit=?, RazonSocial=?, Telefono=?, CorreoElectronico=?, RepresentanteLegal=?, SitioWeb=? WHERE id=?");
            //consulta.setInt(1, proveedoreditado.getIdproveedores());
            consulta.setString(1, proveedoreditado.getNit());
            consulta.setString(2, proveedoreditado.getRazonSocial());
            consulta.setString(3, proveedoreditado.getTelefono());
            consulta.setString(4, proveedoreditado.getCorreoElectronico());
            consulta.setString(5, proveedoreditado.getRepresentanteLegal());
            consulta.setString(6, proveedoreditado.getSitioWeb());
            //consulta.setInt(8, proveedorbuscado.getIddirreciones());
            consulta.setInt(7, proveedoreditado.getIdproveedores());

            int resultado;
            resultado = consulta.executeUpdate();
            System.out.println("act1");
            System.out.println(resultado);
            //JOptionPane.showMessageDialog(null, "Por aqui vamos");

            //Actualizacion tabla direcciones
            PreparedStatement consulta2;
            consulta2 = conexion.prepareStatement("UPDATE tb_direcciones SET CalleCarrera=?, Numero=?, Barrio=?, Ciudad=? WHERE id=?");
            //consulta2.setInt(1, proveedorbuscado.getIddirreciones());
            consulta2.setString(1, proveedoreditado.getCalleCarrera());
            consulta2.setString(2, proveedoreditado.getNumeroCalleCarrera());
            consulta2.setString(3, proveedoreditado.getBarrio());
            consulta2.setString(4, proveedoreditado.getCiudad());
            consulta2.setInt(5, proveedoreditado.getIddirreciones());
            System.out.println("zzzzzzzzzzzzzzzzz");
            int resultado2 = consulta2.executeUpdate();

            System.out.println("act2");
            System.out.println(resultado2);
            //return resultado>0 && resultado2>0;

        } catch (SQLException ex) {
            //return false;
            System.out.println(ex);
            throw new SQLException(ex.getMessage());
            //return false;
            //throw new SQLException(ex);

        }
        //return false;
    }

    public void EliminarProveedorBD(Connection conexion, int clave) throws SQLException {

        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM tb_proveedores WHERE id =?");
            consulta.setInt(1, clave);
            consulta.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void reporteProveedores() throws SQLException {
        LinkedList<ModeloProveedores> reporteProveedores = new LinkedList<>();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {

            reporteProveedores = ObtenerListaProveedoresBD(ConexionBD.obtener());

            for (int i = 0; i < reporteProveedores.size(); i++) {
                dataset.setValue((reporteProveedores.get(i).getIdproveedores()),
                        String.valueOf(reporteProveedores.get(i).getIdproveedores()),
                        reporteProveedores.get(i).getRazonSocial());

                JFreeChart graficoBarras
                        = ChartFactory.createBarChart3D("Reporte Proveedores",
                                "Categoria", "Value Axis", dataset);
                ChartPanel panel = new ChartPanel(graficoBarras);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(200, 200));
                vista.reporteProveedores.setLayout(new BorderLayout());
                vista.reporteProveedores.add(panel, BorderLayout.SOUTH);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }

    }

}
