/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import bd.Conexion;
import dao.FuncionDAO;
import entity.Funcion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Sosicky
 */
public class FuncionBO {

    private String mensaje = "";
    private FuncionDAO funcionDao = new FuncionDAO();

    //Método agregar
    public String agregarFuncion(Funcion funcion) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = funcionDao.agregarFuncion(conn, funcion);
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
    public String modificarFuncion(Funcion funcion) {

        Connection conn = Conexion.getConnection();

        try {
            mensaje = funcionDao.modificarFuncion(conn, funcion);
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
    public String eliminarFuncion(int id) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = funcionDao.eliminarFuncion(con, id);
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
    public void listarFuncion(JTable tabla) {
        Connection con = Conexion.getConnection();
        funcionDao.listarFuncion(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Método buscar
    public String[] buscarFuncion(int id) {

        Connection con = Conexion.getConnection();
        String[] vector = new String[11];

        try {
            vector = funcionDao.buscarFuncion(con, id);
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

    /* (Deprecated) (16-12-2020) (Kevin)
    public Vector<Funcion> listarFuncionCmb(){
        Connection con = Conexion.getConnection();
        Vector<Funcion> datos = funcionDao.listarFuncionCmb(con);
        
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
        return datos;
    }*/
    // @author Kevin
    public void listarFuncionCmb(JComboBox cmbUsuario) {
        Connection con = Conexion.getConnection();
        funcionDao.listarFuncionCmb(con, cmbUsuario);

        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarFuncionSinProceso(JTable tabla) {
        Connection con = Conexion.getConnection();
        funcionDao.listarFuncionSinProceso(con, tabla);

        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
