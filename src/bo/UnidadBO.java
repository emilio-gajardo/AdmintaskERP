package bo;

import bd.Conexion;
import dao.UnidadDAO;
import entity.Unidad;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 * 19-11-2020
 *
 * @author Kevin
 */
public class UnidadBO {

    //Variables
    private String mensaje = "";
    private UnidadDAO unidadDao = new UnidadDAO();

    //Método agregar
    public String agregarUnidad(Unidad unidad) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = unidadDao.agregarUnidad(con, unidad);
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
    public String modificarUnidad(Unidad unidad) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = unidadDao.modificarUnidad(con, unidad);
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
    public String eliminarUnidad(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = unidadDao.eliminarUnidad(conn, id);
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
    public void listarUnidad(JTable tabla) {
        Connection con = Conexion.getConnection();
        unidadDao.listarUnidad(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Método buscar    
    public String[] buscarUnidad(int id) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[3];

        try {
            vector = unidadDao.buscarUnidad(con, id);
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
    
    /*
    // Deprecated by Kevin
    public Vector<Unidad> listarUnidadCmb(){
        Connection con = Conexion.getConnection();
        Vector<Unidad> datos = unidadDao.listarUnidadCmb(con);        
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }         
        return datos;
    }*/
    
    /**
     * 03-12-2020
     *
     * @author Thomas
     * @throws Metodo listar en combobox
     */
    public void listarUnidadCmb(JComboBox cmbUnidad){
        Connection con = Conexion.getConnection();
        unidadDao.listarUnidadCmb(con, cmbUnidad);
        
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }            
    }
}
