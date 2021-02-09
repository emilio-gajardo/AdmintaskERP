package test;

import entity.Cliente;
import bo.ClienteBO;
import bo.UsuarioBO;
import entity.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 01-10-2020
 *
 * @author Emilio Clase para testear los métodos de cada interfaz
 */
public class Test {

    Connection con;

    // Test a clientes
    ClienteBO clienteBO = new ClienteBO();
    Cliente cliente = new Cliente();
    String mensaje = "";

    // Test a Usuarios
    UsuarioBO usuarioBO = new UsuarioBO();
    Usuario usuario = new Usuario();

    //Método insertar nuevo cliente
    public void insertarCliente() {
        cliente.setNombre("Abcdin2");
        cliente.setTelefono(99887766);
        cliente.setCorreo("abcdin2@gmail.com");
        cliente.setFechaIngreso("01-10-2020");
        cliente.setAreaActuacion("Retail");
        mensaje = clienteBO.agregarCliente(cliente);
        System.out.println(mensaje);
    }

    public void insertarUsuario() {
        
        try {

            String nombre = "Aldo";
            String apellidoMaterno = "QWE";
            String apellidoPaterno = "QWE";
            int rut = 123;
            String digv = "1";
            String correo = "QWE";
            int telefono = 123;
            int estado = 1;
            int rol = 1;
            String clave = "QWE";            

            CallableStatement procedimiento;
            procedimiento = con.prepareCall("CALL PKG_USUARIO.SP_CREAR_USUARIO(?,?,?,?,?,?,?,?,?,?)");
            procedimiento.setString(1, nombre);
            procedimiento.setString(2, apellidoMaterno);
            procedimiento.setString(3, apellidoPaterno);
            procedimiento.setInt(4, rut);
            procedimiento.setString(5, digv);
            procedimiento.setString(6, correo);
            procedimiento.setInt(7, telefono);
            procedimiento.setInt(8, estado);
            procedimiento.setInt(9, rol);
            procedimiento.setString(10, clave);
            procedimiento.execute();
            con.commit();
            con.close();
            System.out.println("Guardado exitoso!");
        } catch (SQLException e) {
            System.out.println("Guardado fallido! \n" + e.getMessage());
        }
    }

    //Método modificar cliente
    public void modificarCliente() {
        cliente.setIdCliente(6);
        cliente.setNombre("Pc Factory");
        cliente.setTelefono(99887766);
        cliente.setCorreo("pcfactory@gmail.com");
        cliente.setFechaIngreso("01-10-2020");
        cliente.setAreaActuacion("Retail");
        mensaje = clienteBO.modificarCliente(cliente);
        System.out.println(mensaje);
    }

    //Método eliminar cliente
    public void eliminarCliente() {
        mensaje = clienteBO.eliminarCliente(7);
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Test test = new Test();
        //test.insertarCliente();
        //test.modificarCliente();
        //test.eliminarCliente();

        test.insertarUsuario();
    }

}
