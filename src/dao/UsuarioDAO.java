package dao;

import entity.Usuario;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import view.FrmPanelGeneral;

/**
 * 06-10-2020
 *
 * @author Emilio
 */
public class UsuarioDAO {

    private String mensaje = "";

    //Método agregar
    public String agregarUsuario(Connection con, Usuario usuario) {

        PreparedStatement pst = null;

        try {

            // Usando sql puro
//            String sql = "INSERT INTO USUARIO VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SEQ_LOGIN.NEXTVAL, ?)";
//            pst = con.prepareStatement(sql);            
//            pst.setString(1, usuario.getNombre());
//            pst.setString(2, usuario.getApellidoMaterno());
//            pst.setString(3, usuario.getApellidoPaterno());
//            pst.setInt(4, usuario.getRut());
//            pst.setString(5, usuario.getDigv());
//            pst.setString(6, usuario.getCorreo());
//            pst.setInt(7, usuario.getTelefono());
//            pst.setString(8, usuario.getActivo());
//            pst.setInt(9, usuario.getLoginIdLogin());
//            pst.setInt(10, usuario.getRolIdRol());            
//            pst.execute();
//            pst.close();
            // Usando procedimiento
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL PKG_USUARIO.SP_CREAR_USUARIO(?,?,?,?,?,?,?,?,?,?)");
            procedimiento.setString(1, usuario.getNombre());
            procedimiento.setString(2, usuario.getApellidoMaterno());
            procedimiento.setString(3, usuario.getApellidoPaterno());
            procedimiento.setInt(4, usuario.getRut());
            procedimiento.setString(5, usuario.getDigv());
            procedimiento.setString(6, usuario.getCorreo());
            procedimiento.setLong(7, usuario.getTelefono());
            procedimiento.setInt(8, usuario.getActivo());
            procedimiento.setInt(9, usuario.getRolIdRol());
            procedimiento.setString(10, usuario.getClave());
            procedimiento.execute();
            con.commit();
            con.close();
            mensaje = "Guardado exitoso!";
        } catch (Exception e) {
            mensaje = "Guardado fallido! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Cambiar clave
    public String cambiarClave(Connection con, int id, String clave) {
        PreparedStatement pst = null;
        String sql = "UPDATE USUARIO SET CLAVE=?" + "WHERE ID_USUARIO = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, clave);
            pst.setInt(2, id);
            pst.execute();
            con.commit();
            mensaje = "Modificación exitosa";
            pst.close();
        } catch (SQLException e) {
            mensaje = "modificación fallida! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarUsuario(Connection con, Usuario usuario) {

        //Usando sql puro
        PreparedStatement pst = null;
        String sql = "UPDATE USUARIO SET NOMBRE=?, APELLIDO_MATERNO=?, APELLIDO_PATERNO=?, RUT=?, DIGV=?, CORREO=?, TELEFONO=?, ACTIVO=?, ROL_ID_ROL=?, CLAVE=?" + "WHERE ID_USUARIO = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getNombre());
            pst.setString(2, usuario.getApellidoMaterno());
            pst.setString(3, usuario.getApellidoPaterno());
            pst.setInt(4, usuario.getRut());
            pst.setString(5, usuario.getDigv());
            pst.setString(6, usuario.getCorreo());
            pst.setLong(7, usuario.getTelefono());
            pst.setInt(8, usuario.getActivo());
            pst.setInt(9, usuario.getRolIdRol());
            pst.setString(10, usuario.getClave());
            pst.setInt(11, usuario.getIdUsuario());
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
    public String eliminarUsuario(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";

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
    public void listarUsuario(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        TableColumnModel columnModel;
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();

        DefaultTableModel model;
        //String[] columnas = {"ID", "NOMBRE", "APELLIDO MATERNO", "APELLIDO PATERNO", "RUT", "DIGV", "CORREO", "TELEFONO", "ID ESTADO", "ID ROL", "CLAVE"};
        //String[] columnas = {"ID", "NOMBRE", "APELLIDO MATERNO", "APELLIDO PATERNO", "RUT", "DIGV", "CORREO", "TELEFONO", "ID ESTADO", "ID ROL"};
        String[] columnas = {"ID", "NOMBRE", "RUT", "DIGV", "CORREO", "FONO", "ESTADO", "ROL"};

        model = new DefaultTableModel(null, columnas);

        //String sql = "SELECT * FROM USUARIO ORDER BY ID_USUARIO";
        //String sql = "SELECT ID_USUARIO, NOMBRE, APELLIDO_MATERNO, APELLIDO_PATERNO, RUT, DIGV, CORREO, TELEFONO, ACTIVO, ROL_ID_ROL FROM USUARIO ORDER BY ID_USUARIO";
        String sql = "";

        sql = "SELECT U.ID_USUARIO, (U.NOMBRE || ' ' || U.APELLIDO_PATERNO|| ' ' || U.APELLIDO_MATERNO) AS NOMBRE, U.RUT, U.DIGV, U.CORREO, U.TELEFONO, (CASE WHEN U.ACTIVO = 0 THEN 'Inactivo' WHEN U.ACTIVO = 1 THEN 'Activo' END) AS ESTADO, R.DESCRIPCION AS ROL FROM USUARIO U JOIN ROL R ON U.ROL_ID_ROL = R.ID_ROL ORDER BY U.ID_USUARIO";

        //String filas[] = new String[11]; //Cantidad de filas de la tabla USUARIO
        //String filas[] = new String[10]; //Cantidad de filas de la tabla USUARIO
        String filas[] = new String[8]; //Cantidad de filas de la tabla USUARIO
        Statement st = null;            //Ejecuta el query sql
        ResultSet rs = null;            //Obtiene el resultado del query

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                //for (int i = 0; i < 11; i++) {
                for (int i = 0; i < 8; i++) {
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
            columnModel.getColumn(0).setPreferredWidth(30);     // ID
            columnModel.getColumn(1).setPreferredWidth(200);    // NOMBRE
            columnModel.getColumn(2).setPreferredWidth(100);     // RUT
            columnModel.getColumn(3).setPreferredWidth(40);     // DIGV
            columnModel.getColumn(4).setPreferredWidth(150);    // CORREO
            columnModel.getColumn(5).setPreferredWidth(100);     // FONO
            columnModel.getColumn(6).setPreferredWidth(70);     // ESTADO
            columnModel.getColumn(7).setPreferredWidth(200);    // ROL
            //columnModel.getColumn(8).setPreferredWidth(100);
            //columnModel.getColumn(9).setPreferredWidth(90);
            //columnModel.getColumn(10).setPreferredWidth(90); //clave

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    //Método buscar
    public String[] buscarUsuario(Connection con, int id) {

        //Variables
        //Connection con = Conexion.getConnection();
        String[] vector = new String[11];
        String sql = "SELECT * FROM USUARIO WHERE (ID_USUARIO = '" + id + "')";
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
                vector[7] = rs.getString(8);
                vector[8] = rs.getString(9);
                vector[9] = rs.getString(10);
                vector[10] = rs.getString(11);
            } else {
                vector[0] = "";
                vector[1] = "";
                vector[2] = "";
                vector[3] = "";
                vector[4] = "";
                vector[5] = "";
                vector[6] = "";
                vector[7] = "";
                vector[8] = "";
                vector[9] = "";
                vector[10] = "";
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }

    //Meotodo para verificar la existencia de un registro
    public boolean buscarRutUsuario(Connection con, int rut) {

        boolean res = false;
        String sql = "SELECT RUT FROM USUARIO WHERE RUT = " + rut;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                res = true;
                pst.close();
            }
        } catch (SQLException e) {
            System.err.print("Ha ocurrido un error: \n" + e.getMessage());
        } finally {
            pst = null;
        }
        return res;
    }

    /**
     * 19-10-2020 Método de validación de ingreso de usuario
     *
     * @param id_rol = 1 = Administrador
     */
    public boolean login(Connection con, int rut, String digv, String clave) {

        boolean respuesta = false;
        int id_rol = 1;
        Statement st = null; //Ejecuta el query sql        
        ResultSet rs = null; //Obtiene el resultado del query

        //String sql = "SELECT * FROM USUARIO WHERE ROL_ID_ROL = 1 AND RUT = '" + rut + "' AND CLAVE = '" + clave + "'";
        String sql = "SELECT * FROM USUARIO WHERE ROL_ID_ROL = 1 AND RUT = '" + rut + "' AND DIGV = '" + digv + "' AND CLAVE = '" + clave + "'";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (Exception e) {
            System.out.println("Error de ingreso: \n" + e.getMessage());
        }
        return respuesta;
    }

    /**
     * 04-12-2020
     *
     * @author Thomas
     * @throws Metodo listar usuario en combobox
     */
    public void listarUsuarioCmb(Connection con, JComboBox cmbUsuario) {

        String sql = "SELECT * FROM USUARIO ORDER BY ID_USUARIO";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbUsuario.addItem("Seleccione");

            while (rs.next()) {
                cmbUsuario.addItem(rs.getString("NOMBRE"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    /**
     * 
     * 16-12-2020
     * @author Emilio
     * @return el nombre completo del usuario
     */
    public String[] buscarUsuarioPorRut(Connection con, String rut) {

        String[] vector = new String[3];
        String sql = "SELECT NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO FROM USUARIO WHERE (RUT = '" + rut + "')";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                vector[0] = rs.getString(1);
                vector[1] = rs.getString(2);
                vector[2] = rs.getString(3);
            } else {
                vector[0] = "";
                vector[1] = "";
                vector[2] = "";
            }
        } catch (SQLException e) {
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }
}
