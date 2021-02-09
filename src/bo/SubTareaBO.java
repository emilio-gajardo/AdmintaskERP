package bo;

import bd.Conexion;
import dao.SubTareaDAO;
import entity.SubTarea;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Kevin
 */
public class SubTareaBO {

    //Variables
    private String mensaje = "";
    private SubTareaDAO subTareaDao = new SubTareaDAO();

    //Método agregar
    public String agregarSubTarea(SubTarea subTarea) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = subTareaDao.agregarSubTarea(con, subTarea);
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
    public String modificarSubTarea(SubTarea subTarea) {
        Connection con = Conexion.getConnection();

        try {
            mensaje = subTareaDao.modificarSubTarea(con, subTarea);
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
    public String eliminarSubTarea(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = subTareaDao.eliminarSubTarea(conn, id);
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
    public void listarSubTarea(JTable tabla) {
        Connection con = Conexion.getConnection();
        subTareaDao.listarSubTarea(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarSubTarea2(JTable tabla, Integer id) {
        Connection con = Conexion.getConnection();
        subTareaDao.listarSubTarea2(con, tabla, id);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Método buscar    
    public String[] buscarSubTarea(int id, int id_tarea) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[2];

        try {
            vector = subTareaDao.buscarSubTarea(con, id, id_tarea);
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
    
    public String[] buscarPorcentajes(int id_tarea) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[2];

        try {
            vector = subTareaDao.buscarPorcentajes(con, id_tarea);
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

    public void listarSubTareaCmb(JComboBox cmbSubTarea) {
        Connection con = Conexion.getConnection();
        subTareaDao.listarSubTareaCmb(con, cmbSubTarea);

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
