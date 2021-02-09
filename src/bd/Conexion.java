package bd;

//Librerías de para la conexión con BD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Librería para mostrar mensajes de alerta
import javax.swing.JOptionPane;

/**
 * 30-09-2020
 *
 * @author Emilio
 */
public class Conexion {

    //Variables
    //(static) = Usadas solo por la clase Conexion
    private static Connection conn = null;

    // Parametros de Conexion con la (BD ORACLE v12) del servicio RDS de AWS 
    private static String login = "admintask";
    private static String clave = "admintask";
    private static String endPoint = "localhost";
    private static String puerto = "1521";
    private static String sid = "xe";   
    private static String url = "jdbc:oracle:thin:@" + endPoint + ":" + puerto + ":" + sid;
   

    //Método de conexión
    public static Connection getConnection() {
        try {

            //Driver de interpretacion de conexion con oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if (conn != null) {

                //System.out.println("Conexión exitosa con: Amazon Web Services RDS Database");
                //System.out.println("Conexión exitosa con la BD");

            } else {
                System.out.println("Conexión fallida!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexión fallida! : " + e.getMessage());
        }
        return conn;
    }

    //Método de desconexion
    public void desconexion() {

        try {
            //Cerrando la conexión
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar! : " + e.getMessage());
        }
    }

    //TESTING: Método de prueba de conexión
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }
}
