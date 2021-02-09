/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Funcion;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Sosicky
 */
public class FuncionDAO {

    private String mensaje = "";

    //Método agregar
    public String agregarFuncion(Connection con, Funcion funcion) {

        PreparedStatement pst = null;

        try {

            // Usando procedimiento
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL SP_AGREGAR_FUNCION(?,?,?,?,?,?,?)");
            procedimiento.setString(1, funcion.getNombre());
            procedimiento.setString(2, funcion.getFechaInicio());
            procedimiento.setString(3, funcion.getFechaTermino());
            procedimiento.setInt(4, funcion.getUnidadIdUnidad());
            procedimiento.setInt(5, funcion.getEstadoIdEstado());
            procedimiento.setInt(6, funcion.getUsuarioIdUsuario());
            procedimiento.setInt(7, funcion.getProcesoIdProceso());
            procedimiento.execute();
            con.commit();
            con.close();
            mensaje = "Guardado exitoso!";
        } catch (Exception e) {
            mensaje = "Guardado fallido! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarFuncion(Connection con, Funcion funcion) {

        //Usando sql puro
        PreparedStatement pst = null;
        //String sql = "UPDATE FUNCION SET NOMBRE=?, FECHA_INICIO=?, FECHA_TERMINO=?, UNIDAD_ID_UNIDAD=?, ESTADO_ID_ESTADO=?, USUARIO_ID_USUARIO=?, PROCESO_ID_PROCESO=?" + "WHERE ID_FUNCION = ?";
        String sql = "UPDATE FUNCION SET NOMBRE=?, FECHA_INICIO=?, FECHA_TERMINO=?, UNIDAD_ID_UNIDAD=?, ESTADO_ID_ESTADO=?, USUARIO_ID_USUARIO=?" + "WHERE ID_FUNCION = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcion.getNombre());
            pst.setString(2, funcion.getFechaInicio());
            pst.setString(3, funcion.getFechaTermino());
            pst.setInt(4, funcion.getUnidadIdUnidad());
            pst.setInt(5, funcion.getEstadoIdEstado());
            pst.setInt(6, funcion.getUsuarioIdUsuario());
            //pst.setInt(7, funcion.getProcesoIdProceso());
            pst.setInt(7, funcion.getIdFuncion());

            pst.execute();
            con.commit();
            mensaje = "Modificación exitosa";
            pst.close();

            //<editor-fold defaultstate="collapsed" desc="PROCEDIMIENTO DEPRECADO">
            /*procedimiento deprecado
            try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL PKG_USUARIO.SP_MODIFICAR_USUARIO(?,?,?,?,?,?,?,?,?)");
            //procedimiento.setInt(1, usuario.getIdUsuario());
            procedimiento.setString(2, usuario.getNombre());
            procedimiento.setString(3, usuario.getApellidoMaterno());
            procedimiento.setString(4, usuario.getApellidoPaterno());
            procedimiento.setInt(5, usuario.getRut());
            procedimiento.setString(6, usuario.getDigv());
            procedimiento.setString(7, usuario.getCorreo());
            procedimiento.setInt(8, usuario.getTelefono());
            procedimiento.setInt(9, usuario.getActivo());
            procedimiento.setInt(10, usuario.getRolIdRol());
            procedimiento.setString(11, usuario.getClave());
            procedimiento.execute();
            con.commit();
            con.close();
            mensaje = "modificación exitosa!";
             */
            //</editor-fold>
        } catch (SQLException e) {
            mensaje = "modificación fallida! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarFuncion(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM FUNCION WHERE ID_FUNCION = ?";

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
    public void listarFuncion(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        TableColumnModel columnModel;
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();

        DefaultTableModel model;
        //String[] columnas = {"ID", "NOMBRE", "APELLIDO MATERNO", "APELLIDO PATERNO", "RUT", "DIGV", "CORREO", "TELEFONO", "ID ESTADO", "ID ROL", "CLAVE"};
        String[] columnas = {"ID", "NOMBRE", "FECHA INICIO", "FECHA TERMINO", "UNIDAD", "ESTADO", "USUARIO"};

        model = new DefaultTableModel(null, columnas);

        //String sql = "SELECT * FROM USUARIO ORDER BY ID_USUARIO";
        String sql = "SELECT F.ID_FUNCION, F.NOMBRE, F.FECHA_INICIO, F.FECHA_TERMINO, UNI.NOMBRE_DEPARTAMENTO, E.DESCRIPCION,"
                + " USU.NOMBRE FROM FUNCION F JOIN UNIDAD UNI ON F.UNIDAD_ID_UNIDAD = UNI.ID_UNIDAD JOIN ESTADO E "
                + "ON F.ESTADO_ID_ESTADO = E.ID_ESTADO JOIN USUARIO USU ON F.USUARIO_ID_USUARIO = USU.ID_USUARIO ORDER BY ID_FUNCION";

        //String filas[] = new String[11]; //Cantidad de filas de la tabla FUNCION
        String filas[] = new String[7]; //Cantidad de filas de la tabla FUNCION
        Statement st = null;            //Ejecuta el query sql
        ResultSet rs = null;            //Obtiene el resultado del query

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //for (int i = 0; i < 11; i++) {
                for (int i = 0; i < 7; i++) {
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
            columnModel.getColumn(1).setPreferredWidth(100);
            columnModel.getColumn(2).setPreferredWidth(170);
            columnModel.getColumn(3).setPreferredWidth(170);
            columnModel.getColumn(4).setPreferredWidth(100);
            columnModel.getColumn(5).setPreferredWidth(50);
            columnModel.getColumn(6).setPreferredWidth(150);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    //Método buscar
    public String[] buscarFuncion(Connection con, int id) {

        //Variables
        //Connection con = Conexion.getConnection();
        //String[] vector = new String[8];
        String[] vector = new String[7];
        String sql = "SELECT * FROM FUNCION WHERE (ID_FUNCION = '" + id + "')";
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
                vector[6] = rs.getString(7);
                //vector[7] = rs.getString(8);

            } else {
                vector[0] = "";
                vector[1] = "";
                vector[2] = "";
                vector[3] = "";
                vector[4] = "";
                vector[5] = "";
                vector[6] = "";
                //vector[7] = "";

            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }

    /* (Deprecated) (16-12-2020) (Kevin)
    public Vector<Funcion> listarFuncionCmb(Connection con){
        
        Vector<Funcion> datos = new Vector<Funcion>();
        Funcion fun = null;
        
        String sql = "SELECT * FROM FUNCION";
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            fun = new Funcion();
            fun.setIdFuncion(0);
            fun.setNombre("Seleccione");
            
            while (rs.next()) {
                fun = new Funcion();
                fun.setIdFuncion(rs.getInt("ID_FUNCION"));
                fun.setNombre(rs.getString("NOMBRE"));
                datos.add(fun);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
        return datos;
    }*/
    /**
     * @throws listar registros de funciones en cmb
     * @author Kevin
     * @param con
     * @param cmbFuncion
     */
    public void listarFuncionCmb(Connection con, JComboBox cmbFuncion) {

        String sql = "SELECT * FROM FUNCION";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbFuncion.addItem("Seleccione");

            while (rs.next()) {
                cmbFuncion.addItem(rs.getString("NOMBRE"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    public void listarFuncionSinProceso(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        TableColumnModel columnModel;
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "FECHA INICIO", "FECHA TERMINO"};

        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT F.ID_FUNCION, F.NOMBRE, F.FECHA_INICIO, F.FECHA_TERMINO FROM FUNCION F where id_funcion not in (select funcion_id_funcion from fun_proc)";

        String filas[] = new String[4]; //Cantidad de filas de la tabla FUNCION
        Statement st = null;            //Ejecuta el query sql
        ResultSet rs = null;            //Obtiene el resultado del query

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }

            th = tabla.getTableHeader();
            th.setFont(font);
            tabla.setFont(font);
            tabla.setRowHeight(24);
            tabla.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

}
