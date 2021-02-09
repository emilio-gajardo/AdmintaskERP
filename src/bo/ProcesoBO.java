package bo;

import dao.ProcesoDAO;
import bd.Conexion;
import entity.FunProc;
import entity.Proceso;

//Librerías para la conexión con BD
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 * 01-11-2020
 *
 * @author Kevin
 */
public class ProcesoBO {

    //Vairables
    private String mensaje = "";
    private ProcesoDAO procenteDao = new ProcesoDAO();
    FunProc funProc;

    //Método agregar
    public String agregarProceso(Proceso proc) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = procenteDao.agregarProceso(con, proc);
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
    
    public String agregarFunProc( int idFuncion, int idProceso) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = procenteDao.agregarFunProc(con,  idFuncion, idProceso);
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
    public String modificarProceso(Proceso proc) {
        
        Connection con = Conexion.getConnection();

        try {
            mensaje = procenteDao.modificarProceso(con, proc);
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
    public String eliminarProceso(int id) {        
        Connection con = Conexion.getConnection();
        try {
            mensaje = procenteDao.eliminarProceso(con, id);
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
    public String eliminarFunProc(int idFuncion,int idProceso) {        
        Connection con = Conexion.getConnection();
        try {
            mensaje = procenteDao.eliminarFunProc(con, idFuncion,idProceso);
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
    public void listarProceso(JTable tabla) {        
        Connection con = Conexion.getConnection();
        procenteDao.listarProceso(con, tabla);        
        
        try {
            con.close();            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    public void listarFuncionProceso(JTable tabla, int idTarea) {        
        Connection con = Conexion.getConnection();
        procenteDao.listarFuncionProceso(con, tabla,idTarea);        
        
        try {
            con.close();            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
    //Método buscar    
    public String[] buscarProceso(int id){
        
        Connection con = Conexion.getConnection();
        String[] vector = new String[4];
        
        try{
            vector = procenteDao.buscarProceso(con, id);
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
    
    public String[] buscarProcesoFuncion(int idFuncion, int idProceso){
        
        Connection con = Conexion.getConnection();
        String[] vector = new String[4];
        
        try{
            vector = procenteDao.buscarProcesoFuncion(con, idFuncion, idProceso);
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
    public String[] buscarFuncionSola(int id){
        
        Connection con = Conexion.getConnection();
        String[] vector = new String[4];
        
        try{
            vector = procenteDao.buscarFuncionSola(con, id);
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
    
    public String agregarFunProc(FunProc funProc) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = procenteDao.agregarFunProc(con, funProc);
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
}
