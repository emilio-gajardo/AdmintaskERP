package dao;

import entity.Unidad;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Emilio
 */
public class UnidadDAO {

    private String mensaje = "";

    //Método agregar
    public String agregarUnidad(Connection con, Unidad unidad) {

        PreparedStatement pst = null;
        String sql = "INSERT INTO UNIDAD (ID_UNIDAD, NOMBRE_DEPARTAMENTO, CLIENTE_ID_CLIENTE) VALUES (SEQ_UNIDAD.NEXTVAL, ?, ?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, unidad.getNombreDepartamento());
            pst.setInt(2, unidad.getClienteIdCliente());
            pst.execute();
            pst.close();
            mensaje = "Guardado exitoso!";
        } catch (SQLException e) {
            mensaje = "Guardado fallido! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarUnidad(Connection con, Unidad unidad) {
        PreparedStatement pst = null;
        String sql = "UPDATE UNIDAD SET NOMBRE_DEPARTAMENTO = ?, CLIENTE_ID_CLIENTE = ?" + "WHERE ID_UNIDAD = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, unidad.getNombreDepartamento());
            pst.setInt(2, unidad.getClienteIdCliente());
            pst.setInt(3, unidad.getIdUnidad());
            mensaje = "Modificación exitosa!";
            pst.execute();
            con.commit();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Modificación fallida en UnidadDAO! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarUnidad(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM UNIDAD WHERE ID_UNIDAD = ?";

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
    public void listarUnidad(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);

        DefaultTableModel model;
        JButton btn1 = new JButton("Modificar");
        JButton btn2 = new JButton("Eliminar");

        String[] columnas = {"ID", "DEPARTAMENTO", "CLIENTE"};

        model = new DefaultTableModel(null, columnas);
        String sql = "select u.id_unidad, u.nombre_departamento,c.nombre from unidad u  join cliente c on u.cliente_id_cliente = c.id_cliente order by u.id_unidad";

        Object filas[] = new String[3];
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
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
    public String[] buscarUnidad(Connection con, int id) {
        String[] vector = new String[3];
        String sql = "SELECT * FROM UNIDAD WHERE (ID_UNIDAD = '" + id + "')";
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
        } catch (Exception e) {
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }

    /*
    // Deprecated by Kevin
    public Vector<Unidad> listarUnidadCmb(Connection con) {

        Vector<Unidad> datos = new Vector<Unidad>();
        Unidad est = null;

        String sql = "SELECT * FROM UNIDAD";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            est = new Unidad();
            est.setIdUnidad(0);
            est.setNombreDepartamento("Seleccione");
            datos.add(est);

            while (rs.next()) {
                est.setIdUnidad(rs.getInt("ID_UNIDAD"));
                est.setNombreDepartamento(rs.getString("NOMBRE_DEPARTAMENTO"));
                datos.add(est);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
        return datos;
    }
    */

    /**
     * 03-12-2020
     *
     * @author Thomas
     * @throws Método listarUsuario en combobox
     */
    public void listarUnidadCmb(Connection con, JComboBox cmbUnidad) {

        String sql = "SELECT * FROM UNIDAD ORDER BY ID_UNIDAD";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbUnidad.addItem("Seleccione");

            while (rs.next()) {
                cmbUnidad.addItem(rs.getString("NOMBRE_DEPARTAMENTO"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }
}
