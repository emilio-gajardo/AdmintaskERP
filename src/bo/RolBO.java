package bo;

import bd.Conexion;
import dao.RolDAO;
import entity.Rol;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 * 06-10-2020
 *
 * @author Emilio
 */
public class RolBO {

    //Variables
    private String mensaje = "";
    private RolDAO rolDao = new RolDAO();

    //Método agregar
    public String agregarRol(Rol rol) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = rolDao.agregarRol(con, rol);
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
    public String modificarRol(Rol rol) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = rolDao.modificarRol(con, rol);
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
    public String eliminarRol(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = rolDao.eliminarRol(conn, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    //Método listar
    public void listarRol(JTable tabla) {
        Connection con = Conexion.getConnection();
        rolDao.listarRol(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Metodo listar en combobox
    public void listarRolCmb(JComboBox cmbRol){
        Connection con = Conexion.getConnection();
        rolDao.listarRolCmb(con, cmbRol);
        
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }            
    }

    //Método buscar    
    public String[] buscarRol(int id) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[2];

        try {
            vector = rolDao.buscarRol(con, id);
            //con.close();
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
        return vector;
    }
}
