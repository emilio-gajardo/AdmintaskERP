package bo;

import dao.TareaDAO;
import bd.Conexion;
import entity.Tarea;

//Librerías para la conexión con BD
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 * 01-11-2020
 *
 * @author Kevin
 */
public class TareaBO {

    //Vairables
    private String mensaje = "";
    private TareaDAO tareaDao = new TareaDAO();

    //Método agregar
    public String agregarTarea(Tarea tar) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = tareaDao.agregarTarea(con, tar);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    //Método modificar
    public String modificarTarea(Tarea tar) {
        
        Connection con = Conexion.getConnection();

        try {
            mensaje = tareaDao.modificarTarea(con, tar);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    //Método eliminar
    public String eliminarTarea(int id) {        
        Connection con = Conexion.getConnection();
        try {
            mensaje = tareaDao.eliminarTarea(con, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    //Método listar
    public void listarTarea(JTable tabla) {        
        Connection con = Conexion.getConnection();
        tareaDao.listarTarea(con, tabla);        
        
        try {
            con.close();            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
    //Método buscar    
    public String[] buscarTarea(int id){
        
        Connection con = Conexion.getConnection();
        String[] vector = new String[8];
        
        try{
            vector = tareaDao.buscarTarea(con, id);
            //con.close();
        } catch (Exception e){
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null){
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return vector;
    }
}
