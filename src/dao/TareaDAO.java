package dao;

import bd.Conexion;
import entity.Tarea;
import java.awt.Font;

// Librerías de para la conexión con BD
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

//Librería para gestionar tabla de la vista
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//Librería para mostrar mensajes de alerta
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 * 01-10-2020
 *
 * @author Kevin
 */
public class TareaDAO {

    //Variables
    private String mensaje = "";

    //Método agregar
    public String agregarTarea(Connection con, Tarea tar) {
     
        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("INSERT INTO TAREA(ID_TAREA, NOMBRE, FECHA_INICIO, FECHA_TERMINO, ESTADO_ID_ESTADO, FUNCION_ID_FUNCION, DESCRIPCION, ENCARGADO) VALUES(SEQ_TAREA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
            procedimiento.setString(1, tar.getNombre());
            procedimiento.setString(2, tar.getFechaInicio());
            procedimiento.setString(3, tar.getFechaTermino());
            procedimiento.setInt(4, tar.getEstadoIdEstado());
            procedimiento.setInt(5, tar.getFuncionIdFuncion());
            procedimiento.setString(6, tar.getDescripcion());
            procedimiento.setInt(7, tar.getEncargado());
   
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
    public String modificarTarea(Connection con, Tarea tar) {

        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL SP_UPDATE_TAREA(?,?,?,?,?,?,?,?,?)");
            procedimiento.setInt(1, tar.getIdTarea());
            procedimiento.setString(2, tar.getNombre());
            procedimiento.setString(3, tar.getFechaInicio());
            procedimiento.setString(4, tar.getFechaTermino());
            procedimiento.setInt(5, tar.getEstadoIdEstado());
            procedimiento.setInt(6, tar.getFuncionIdFuncion());
            procedimiento.setString(7, tar.getDescripcion());
            procedimiento.setInt(8, tar.getEncargado());            
            procedimiento.setInt(9, 1);            
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
    public String eliminarTarea(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "delete from subtarea where tarea_id_tarea = "+ id;
        String sql2 = "DELETE FROM TAREA WHERE ID_TAREA = "+ id;

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            pst = con.prepareStatement(sql2);
            pst.execute();
            con.commit();
            pst.close();
            mensaje = "Eliminación exitosa!";
        } catch (SQLException e) {
            mensaje = "Eliminación fallida! \n " + e.getMessage();
        }
        return mensaje;
    }

    //Método listar
    public void listarTarea(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "FECHA INICIO", "FECHA FIN", " ESTADO", "FUNCIÓN", "DESCRIPCIÓN", "ENCARGADO"};
        model = new DefaultTableModel(null, columnas);

        //String sql = "SELECT * FROM TAREA ORDER BY ID_TAREA";
        String sql = "SELECT t.id_tarea,t.nombre,t.fecha_inicio,t.fecha_termino,es.descripcion estado ,fun.nombre funcion,t.descripcion, usu.nombre encargado " +
"FROM TAREA t join estado es on es.Id_estado = t.estado_id_estado join funcion fun on fun.id_funcion = t.funcion_id_funcion join usuario usu on usu.id_usuario  = t.encargado ORDER BY ID_TAREA";
        
        String filas[] = new String[8]; //Cantidad de filas de la tabla tarente
        Statement st = null;            //Ejecuta el query sql
        ResultSet rs = null;            //Obtiene el resultado del query

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
        }
    }

    //Método buscar
    public String[] buscarTarea(Connection con, int id) {

        String[] vector = new String[8];
        String sql = "SELECT * FROM TAREA WHERE (ID_TAREA = '" + id + "')";
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
            } else {
                vector[0] = "";
                vector[1] = "";
                vector[2] = "";
                vector[3] = "";
                vector[4] = "";
                vector[5] = "";
                vector[6] = "";
                vector[7] = "";
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }
}
