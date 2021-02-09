package bo;

import dao.ClienteDAO;
import bd.Conexion;
import entity.Cliente;

//Librerías para la conexión con BD
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 * 01-10-2020
 *
 * @author Emilio
 */
public class ClienteBO {

    //Vairables
    private String mensaje = "";
    private ClienteDAO clienteDao = new ClienteDAO();

    //Método agregar
    public String agregarCliente(Cliente cli) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = clienteDao.agregarCliente(con, cli);
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
    public String modificarCliente(Cliente cli) {
        
        Connection con = Conexion.getConnection();

        try {
            mensaje = clienteDao.modificarCliente(con, cli);
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
    public String eliminarCliente(int id) {        
        Connection con = Conexion.getConnection();
        try {
            mensaje = clienteDao.eliminarCliente(con, id);
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
    public void listarCliente(JTable tabla) {        
        Connection con = Conexion.getConnection();
        clienteDao.listarCliente(con, tabla);        
        
        try {
            con.close();            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
    
    //Método buscar    
    public String[] buscarCliente(int id){
        
        Connection con = Conexion.getConnection();
        String[] vector = new String[6];
        
        try{
            vector = clienteDao.buscarCliente(con, id);
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
    
    
    //Metodo listar en combobox
    public void listarClienteCmb(JComboBox cmbCliente){
        
        Connection con = Conexion.getConnection();
        clienteDao.listarClienteCmb(con, cmbCliente);
        
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
