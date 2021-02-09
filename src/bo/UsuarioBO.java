package bo;

import dao.UsuarioDAO;
import bd.Conexion;
import entity.Usuario;

//Librerías para la conexión con BD
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 * 06-10-2020
 *
 * @author Emilio
 */
public class UsuarioBO {

    private String mensaje = "";
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    //Método agregar
    public String agregarUsuario(Usuario usuario) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = usuarioDao.agregarUsuario(conn, usuario);
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

    //Cambiar clave
    public String cambiarClave(int id, String clave) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = usuarioDao.cambiarClave(conn, id, clave);
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

    //Método modificar
    public String modificarUsuario(Usuario usuario) {

        Connection conn = Conexion.getConnection();

        try {
            mensaje = usuarioDao.modificarUsuario(conn, usuario);
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

    //Método eliminar
    public String eliminarUsuario(int id) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = usuarioDao.eliminarUsuario(con, id);
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
    public void listarUsuario(JTable tabla) {
        Connection con = Conexion.getConnection();
        usuarioDao.listarUsuario(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Método buscar
    public String[] buscarUsuario(int id) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[11];

        try {
            vector = usuarioDao.buscarUsuario(con, id);
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

    //Método para buscar la existencia del rut del usuario
    public boolean buscarRutUsuario(int rut) {

        Connection con = Conexion.getConnection();
        boolean res = usuarioDao.buscarRutUsuario(con, rut);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    /**
     * 19-10-2020 Validar acceso
     */
    public boolean login(int rut, String digv, String clave) {

        Connection con = Conexion.getConnection();
        boolean respuesta = usuarioDao.login(con, rut, digv, clave);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return respuesta;
    }

    /**
     * 04-12-2020
     *
     * @author Thomas
     * @throws Metodo listar en combobox
     */
    public void listarUsuarioCmb(JComboBox cmbUsuario) {
        Connection con = Conexion.getConnection();
        usuarioDao.listarUsuarioCmb(con, cmbUsuario);

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[] buscarUsuarioPorRut(String rut) {
        Connection con = Conexion.getConnection();
        String[] vector = new String[2];

        try {
            vector = usuarioDao.buscarUsuarioPorRut(con, rut);
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
