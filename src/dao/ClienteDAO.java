package dao;

import bd.Conexion;
import entity.Cliente;
import java.awt.Font;

// Librerías de para la conexión con BD
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

//Librería para gestionar tabla de la vista
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//Librería para mostrar mensajes de alerta
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 * 01-10-2020
 *
 * @author Emilio
 */
public class ClienteDAO {

    //Variables
    private String mensaje = "";

    //Método agregar
    public String agregarCliente(Connection con, Cliente cli) {

        /*
        //Insertar registro usando sentencia sql
        PreparedStatement pst = null; 
        
        String sql = "INSERT INTO CLIENTE(ID_CLIENTE, NOMBRE, TELEFONO, CORREO, FECHA_INGRESO, AREA_ACTUACION) VALUES(SEQ_CLIENTE.NEXTVAL, ?, ?, ?, ?, ?)";
        
        try { 
        
            pst = con.prepareStatement(sql);
        
            pst.setString(1, cli.getNombre());
            pst.setInt(2, cli.getTelefono());
            pst.setString(3, cli.getCorreo());
            pst.setString(4, cli.getFechaIngreso());
            pst.setString(5, cli.getAreaActuacion());
        
            pst.execute();
            pst.close();
        }*/
        //Insert registro usando procedimiento almacenado       
        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL PKG_CLIENTE.SP_CREAR_CLIENTE(?,?,?,?,?)");
            procedimiento.setString(1, cli.getNombre());
            procedimiento.setLong(2, cli.getTelefono());
            procedimiento.setString(3, cli.getCorreo());
            procedimiento.setString(4, cli.getFechaIngreso());
            procedimiento.setString(5, cli.getAreaActuacion());
            procedimiento.execute();
            con.commit();
            con.close();
            mensaje = "Guardado exitoso!";
        } catch (SQLException e) {
            mensaje = "Guardado fallido! \n " + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarCliente(Connection con, Cliente cli) {

        /*
        //Modificación usando sentencia sql
        PreparedStatement pst = null;
        String sql = "UPDATE CLIENTE SET NOMBRE = ?, TELEFONO = ?, CORREO = ?, FECHA_INGRESO = ?, AREA_ACTUACION = ?"
                + "WHERE ID_CLIENTE = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cli.getNombre());
            pst.setInt(2, cli.getTelefono());
            pst.setString(3, cli.getCorreo());
            pst.setString(4, cli.getFechaIngreso());
            pst.setString(5, cli.getAreaActuacion());
            pst.setInt(6, cli.getIdCliente());
            mensaje = "Modificación exitosa";
            pst.execute();
            con.commit();
            pst.close();
        }*/
        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL PKG_CLIENTE.SP_MODIFICAR_CLIENTE(?,?,?,?,?,?)");
            procedimiento.setInt(1, cli.getIdCliente());
            procedimiento.setString(2, cli.getNombre());
            procedimiento.setLong(3, cli.getTelefono());
            procedimiento.setString(4, cli.getCorreo());
            procedimiento.setString(5, cli.getFechaIngreso());
            procedimiento.setString(6, cli.getAreaActuacion());
            procedimiento.execute();
            con.commit();
            procedimiento.close();
            mensaje = "Modificación exitosa!";
        } catch (SQLException e) {
            mensaje = "Modificación fallido! \n " + e.getMessage();
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarCliente(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            mensaje = "Eliminación exitosa!";
            pst.execute();
            con.commit();
            pst.close();

        } catch (SQLException e) {
            mensaje = "Eliminación fallida! \n " + e.getMessage();
        }
        return mensaje;
    }

    //Método listar
    public void listarCliente(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        TableColumnModel columnModel;
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "FONO", "CORREO", "FECHA INGRESO", "AREA ACTUACIÓN"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM CLIENTE ORDER BY ID_CLIENTE";

        String filas[] = new String[6]; //Cantidad de filas de la tabla cliente
        Statement st = null;            //Ejecuta el query sql
        ResultSet rs = null;            //Obtiene el resultado del query

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            th = tabla.getTableHeader();
            th.setFont(font);
            tabla.setFont(font);
            tabla.setRowHeight(24);
            tabla.setModel(model);
            columnModel = tabla.getColumnModel();

            // Configuración de Ancho de columnas
            columnModel.getColumn(0).setPreferredWidth(30);
            columnModel.getColumn(1).setPreferredWidth(120);
            columnModel.getColumn(2).setPreferredWidth(170);
            columnModel.getColumn(3).setPreferredWidth(170);
            columnModel.getColumn(4).setPreferredWidth(170);
            columnModel.getColumn(5).setPreferredWidth(170);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    //Método buscar
    public String[] buscarCliente(Connection con, int id) {

        //Variables
        //Connection con = Conexion.getConnection();
        String[] vector = new String[6];
        String sql = "SELECT * FROM CLIENTE WHERE (ID_CLIENTE = '" + id + "')";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                vector[0] = rs.getString(1);
                vector[1] = rs.getString(2);
                vector[2] = rs.getString(3);
                vector[3] = rs.getString(4);
                vector[4] = rs.getString(5);
                vector[5] = rs.getString(6);
            } else {
                vector[0] = "";
                vector[1] = "";
                vector[2] = "";
                vector[3] = "";
                vector[4] = "";
                vector[5] = "";
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }

    //Metodo listar en combobox
    public void listarClienteCmb(Connection con, JComboBox cmbCliente) {

        String sql = "SELECT ID_CLIENTE, NOMBRE FROM CLIENTE ORDER BY ID_CLIENTE";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            cmbCliente.addItem("Seleccione");
            
            while(rs.next()){
                cmbCliente.addItem(rs.getString("NOMBRE"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible cargar los datos de los clientes!");
        }
    }
}
