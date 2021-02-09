package dao;

import entity.Rol;
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
 * 06-10-2020
 *
 * @author Emilio
 */
public class RolDAO {

    private String mensaje = "";

    //Método agregar
    public String agregarRol(Connection con, Rol rol) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO ROL (ID_ROL, DESCRIPCION) VALUES (SEQ_ROL.NEXTVAL, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, rol.getDescripcion());
            pst.execute();
            pst.close();
            mensaje = "Guardado exitoso!";
        } catch (Exception e) {
            mensaje = "Guardado fallido! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarRol(Connection con, Rol rol) {
        PreparedStatement pst = null;
        String sql = "UPDATE ROL SET DESCRIPCION = ?" + "WHERE ID_ROL = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, rol.getDescripcion());
            pst.setInt(2, rol.getIdRol());
            mensaje = "Modificación exitosa!";
            pst.execute();
            con.commit();
            pst.close();
        } catch (Exception e) {
            mensaje = "Modifición fallida en DAO! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarRol(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM ROL WHERE ID_ROL = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje = "Eliminación exitosa!";
            pst.execute();
            con.commit();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Eliminación fallida! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método listar
    public void listarRol(Connection con, JTable tabla) {
        
        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        
        DefaultTableModel model;
        String[] columnas = {"ID", "DESCRIPCIÓN"};

        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM ROL ORDER BY ID_ROL";

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
    
    //Método listarRol en combobox
    public void listarRolCmb(Connection con, JComboBox cmbRol){
        
        String sql = "SELECT * FROM ROL ORDER BY ID_ROL";
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            cmbRol.addItem("Seleccione");
            
            while (rs.next()) {
                cmbRol.addItem(rs.getString("DESCRIPCION"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    //Método buscar
    public String[] buscarRol(Connection con, int id) {
        String[] vector = new String[2];
        String sql = "SELECT * FROM ROL WHERE (ID_ROL = '" + id + "')";
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
}
