package dao;

import bd.Conexion;
import entity.FunProc;
import entity.Proceso;
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
 * @author Emilio
 */
public class ProcesoDAO {

    //Variables
    private String mensaje = "";
    FunProc funProc;

    //Método agregar
    public String agregarProceso(Connection con, Proceso proc) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO PROCESO (ID_PROCESO, NOMBRE, DESCRIPCION, DIAS_PRE_INTERVENCION) VALUES(SEQ_PROCESO.NEXTVAL, ?, ?, ?)";
        
        try {           
            //CallableStatement procedimiento;    
            //procedimiento = con.prepareCall("INSERT INTO PROCESO VALUES(SEQ_PROCESO.NEXTVAL, ?, ?, ?)");
            pst = con.prepareStatement(sql);
            pst.setString(1, proc.getNombre());
            pst.setString(2, proc.getDescripcion());
            pst.setInt(3, proc.getDiasPreIntervencion());
            pst.execute();
            con.commit();
            pst.close();
            mensaje = "Guardado exitoso!";
        } catch (SQLException e) {
            mensaje = "Guardado fallido! \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String agregarFunProc(Connection con, int idFuncion, int idProceso) {
   
        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("INSERT INTO Fun_Proc(ID_FUN_PROC, funcion_id_funcion , proceso_id_proceso) VALUES(SEQ_FUN_PROC.NEXTVAL, ?, ?)");
            procedimiento.setInt(1, idFuncion);
            procedimiento.setInt(2, idProceso);
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
    public String modificarProceso(Connection con, Proceso proc) {


        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("update proceso set nombre = ?, descripcion = ?, dias_pre_intervencion = ? where id_proceso = ?");
            procedimiento.setString(1, proc.getNombre());
            procedimiento.setString(2, proc.getDescripcion());
            procedimiento.setInt(3, proc.getDiasPreIntervencion());
            procedimiento.setInt(4, proc.getIdProceso());
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
    public String eliminarProceso(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PROCESO WHERE ID_PROCESO = ?";

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
    public String eliminarFunProc(Connection con, int idFuncion,int idProceso) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM FUN_PROC WHERE funcion_id_funcion = ? and proceso_id_proceso = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idFuncion);
            pst.setInt(2, idProceso);

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
    public void listarProceso(Connection con, JTable tabla) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "DESCRIPCION"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM PROCESO ORDER BY ID_PROCESO";

        String filas[] = new String[6]; //Cantidad de filas de la tabla procente
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

    //Método buscar
    public String[] buscarProceso(Connection con, int id) {

        //Variables
        //Connection con = Conexion.getConnection();
        String[] vector = new String[4];
        String sql = "SELECT * FROM PROCESO WHERE (ID_PROCESO = '" + id + "')";
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
            } else {
                vector[0] = "";
                vector[1] = "";
                vector[2] = "";
                vector[3] = "";
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }
    
    public void listarFuncionProceso(Connection con, JTable tabla, int id) {

        JTableHeader th;
        Font font = new Font("Tahoma", 0, 16);
        DefaultTableModel model;
        String[] columnas = {"ID", "NOMBRE", "FECHA INICIO", "FECHA FIN"};
        model = new DefaultTableModel(null, columnas);

        String sql = "select fun.id_funcion, fun.nombre, fun.fecha_inicio, fun.fecha_termino " +
                        "from funcion fun " +
                        "join fun_proc funpro on funpro.funcion_id_funcion = fun.id_funcion " +
                        "join proceso pro on funpro.proceso_id_proceso = pro.id_proceso " +
                        "where pro.id_proceso = "+ id;

        String filas[] = new String[6]; //Cantidad de filas de la tabla procente
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
    
    public String agregarFunProc(Connection con, FunProc funProc) {
   
        try {
            CallableStatement procedimiento;
            procedimiento = con.prepareCall("insert into fun_proc (ID_FUN_PROC, funcion_id_funcion, proceso_id_proceso) values (SEQ_FUN_PROC, ? ,?)");
            procedimiento.setString(1, funProc.getIdFuncion());
            procedimiento.setString(2, funProc.getIdProceso());
            procedimiento.execute();
            con.commit();
            con.close();
            mensaje = "Guardado exitoso!";
        } catch (SQLException e) {
            mensaje = "Guardado fallido! \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String[] buscarProcesoFuncion(Connection con, int idFuncion, int idProceso) {

        //Variables
        //Connection con = Conexion.getConnection();
        String[] vector = new String[4];
        String sql = "select funcion_ID_Funcion,f.nombre from fun_proc fp " +
                    "join funcion f on fp.funcion_id_funcion = f.id_funcion " +
                    "where fp.funcion_id_funcion = '" + idFuncion + "' and fp.proceso_id_proceso = '"+idProceso +"'";
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
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }
    
    public String[] buscarFuncionSola(Connection con, int id) {

        //Variables
        //Connection con = Conexion.getConnection();
        String[] vector = new String[4];
        String sql = "SELECT F.ID_FUNCION, F.NOMBRE, F.FECHA_INICIO, F.FECHA_TERMINO FROM FUNCION F " +
"where id_funcion not in (select funcion_id_funcion from fun_proc) and f.id_funcion = '" + id + "'";
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
            //JOptionPane.showMessageDialog(null, "No es posible mostrar datos!");
            System.out.println("Error en sentencia SQL: " + e.getMessage());
        }
        return vector;
    }
}
