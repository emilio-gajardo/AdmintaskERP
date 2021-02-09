package dao;

import entity.SubTarea;
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
 * @author Kevin
 */
public class SubTareaDAO {

    private String mensaje = "";

    //Método agregar
    public String agregarSubTarea(Connection con, SubTarea subTarea) {

        PreparedStatement pst = null;
        String sql = "INSERT INTO SUBTAREA (ID_SUBTAREA, NOMBRE, FINALIZADO, TAREA_ID_TAREA) VALUES (SEQ_SUBTAREA.NEXTVAL, ?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, subTarea.getNombre());
            pst.setString(2, subTarea.getFinalizado());
            pst.setInt(3, subTarea.getTareaIdTarea());
            pst.execute();
            pst.close();
            mensaje = "Guardado exitoso!";
        } catch (SQLException e) {
            mensaje = "Guardado fallido! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método modificar
    public String modificarSubTarea(Connection con, SubTarea subTarea) {
        PreparedStatement pst = null;
        String sql = "UPDATE SUBTAREA SET NOMBRE = ?, FINALIZADO = ?, TAREA_ID_TAREA = ? WHERE ID_SUBTAREA = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, subTarea.getNombre());
            pst.setString(2, subTarea.getFinalizado());
            pst.setInt(3, subTarea.getTareaIdTarea());
            pst.setInt(4, subTarea.getIdSubTarea());
            
            mensaje = "Modificación exitosa!";
            pst.execute();
            con.commit();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Modificación fallida en SubTareaDAO! \n" + e.getMessage();
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarSubTarea(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM SUBTAREA WHERE ID_SUBTAREA = ?";

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
    public void listarSubTarea(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "ESTADO"};

        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM SUBTAREA ORDER BY ID_SUBTAREA";

        String filas[] = new String[3];
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    /*if (i == 2){
                        rs.getString(i + 1)
                        filas[i] = 
                    }
                    else{*/
                        filas[i] = rs.getString(i + 1);
                    //}
                    
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
    
    public void listarSubTarea2(Connection con, JTable tabla, Integer id) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);

        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "ESTADO"};

        model = new DefaultTableModel(null, columnas);
        String sql = "select * from subtarea where tarea_id_tarea = "+ id;

        String filas[] = new String[3];
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    if (i == 2){
                        filas[i] = rs.getString(i + 1);
                        if (filas[i].equals("1")){
                            filas[i] = "Finalizado";
                        }else {
                            filas[i] = "En Curso";
                        }                        
                    }
                    else{
                        filas[i] = rs.getString(i + 1);
                    }                    
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
    public String[] buscarSubTarea(Connection con, int id, int id_tarea) {
        String[] vector = new String[3];
        String sql = "SELECT * FROM SUBTAREA WHERE (ID_SUBTAREA = '" + id + "') and tarea_id_tarea = " + id_tarea;
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
               System.out.println("No encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }
    
    public String[] buscarPorcentajes(Connection con, int id_tarea) {
        String[] vector = new String[2];
        String sql = "SELECT count(*), round(nvl((sum(TO_NUMBER(finalizado))/count(*)) * 100,0),2) from subtarea where tarea_id_tarea = " + id_tarea;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                vector[0] = rs.getString(1);
                vector[1] = rs.getString(2);
            } else {
               JOptionPane.showMessageDialog(null, "No se encontró registro asociado a la Tarea!");
            }
        } catch (Exception e) {
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }

    public void listarSubTareaCmb(Connection con, JComboBox cmbSubTarea) {

        String sql = "SELECT * FROM SUBTAREA ORDER BY ID_SUBTAREA";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbSubTarea.addItem("Seleccione");

            while (rs.next()) {
                cmbSubTarea.addItem(rs.getString("DESCRIPCION"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }
}
