package bo;

import bd.Conexion;
import dao.EstadoDAO;
import entity.Estado;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 * 05-10-2020
 *
 * @author Emilio
 */
public class EstadoBO {

    //Variables
    private String mensaje = "";
    private EstadoDAO estadoDao = new EstadoDAO();

    //Método agregar
    public String agregarEstado(Estado estado) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = estadoDao.agregarEstado(con, estado);
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
    public String modificarEstado(Estado estado) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = estadoDao.modificarEstado(con, estado);
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
    public String eliminarEstado(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = estadoDao.eliminarEstado(conn, id);
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
    public void listarEstado(JTable tabla) {
        Connection con = Conexion.getConnection();
        estadoDao.listarEstado(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Método buscar    
    public String[] buscarEstado(int id) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[2];

        try {
            vector = estadoDao.buscarEstado(con, id);
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

    /**
     * 04-12-2020
     *
     * @author Thomas
     * @throws Metodo listar estado en combobox
     */
    public void listarEstadoCmb(JComboBox cmbEstado) {
        Connection con = Conexion.getConnection();
        estadoDao.listarEstadoCmb(con, cmbEstado);

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
