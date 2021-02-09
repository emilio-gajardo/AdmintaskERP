package dao;

import entity.Estado;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Emilio
 */
public class EstadoDAO {

    private String mensaje = "";

    //Método agregar
    public String agregarEstado(Connection con, Estado estado) {

        PreparedStatement pst = null;
        String sql = "INSERT INTO ESTADO (ID_ESTADO, DESCRIPCION) VALUES (SEQ_ESTADO.NEXTVAL, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, estado.getDescripcion());
            pst.execute();
            pst.close();
            mensaje = "Guardado exitoso!";
        } catch (SQLException e) {
            mensaje = "Guardado fallido! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarEstado(Connection con, Estado estado) {
        PreparedStatement pst = null;
        String sql = "UPDATE ESTADO SET DESCRIPCION = ?" + "WHERE ID_ESTADO = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, estado.getDescripcion());
            pst.setInt(2, estado.getIdEstado());
            mensaje = "Modificación exitosa!";
            pst.execute();
            con.commit();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Modificación fallida en EstadoDAO! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarEstado(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM ESTADO WHERE ID_ESTADO = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje = "Eliminación exitosa!";
            pst.execute();
            con.commit();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Eliminacion fallida! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método listar
    public void listarEstado(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);

        DefaultTableModel model;
        String[] columnas = {"ID", "DESCRIPCIÓN"};

        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM ESTADO ORDER BY ID_ESTADO";

        String filas[] = new String[2];
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 2; i++) {
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

    //Método buscar
    public String[] buscarEstado(Connection con, int id) {
        String[] vector = new String[2];
        String sql = "SELECT * FROM ESTADO WHERE (ID_ESTADO = '" + id + "')";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                vector[0] = rs.getString(1);
                vector[1] = rs.getString(2);
            } else {
                vector[0] = "";
                vector[1] = "";
            }
        } catch (Exception e) {
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }

    /**
     * 04-12-2020
     *
     * @author Thomas
<<<<<<< HEAD
     * @throws Metodo listar en combobox
=======
     * @throws Metodo listar estado en combobox
>>>>>>> td001
     */
    public void listarEstadoCmb(Connection con, JComboBox cmbEstado) {

        String sql = "SELECT * FROM ESTADO ORDER BY ID_ESTADO";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbEstado.addItem("Seleccione");

            while (rs.next()) {
                cmbEstado.addItem(rs.getString("DESCRIPCION"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }
}
