package entity;

/**
 *
 * @author Emilio
 * 22-09-2020
 */
public class Unidad {
    
    //Atributos
    private int idUnidad;
    private String nombreDepartamento;
    private int clienteIdCliente;
    
    //Constructores
    public Unidad(){}

    public Unidad(int idUnidad, String nombreDepartamento, int clienteIdCliente) {
        this.idUnidad = idUnidad;
        this.nombreDepartamento = nombreDepartamento;
        this.clienteIdCliente = clienteIdCliente;
    }
    
    //Getters y Setters
    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }
   
    
}
