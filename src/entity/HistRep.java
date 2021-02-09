package entity;

/**
 *
 * @author Emilio
 * 22-09-2020
 */
public class HistRep {
    
    //Atributos
    private int idHistRep;
    private String fechaSolicitud;
    private String archivo;
    private int clienteIdCliente;
    private int usuarioIdUsuario;
    
    //Constructores
    public HistRep(){}

    public HistRep(int idHistRep, String fechaSolicitud, String archivo, int clienteIdCliente, int usuarioIdUsuario) {
        this.idHistRep = idHistRep;
        this.fechaSolicitud = fechaSolicitud;
        this.archivo = archivo;
        this.clienteIdCliente = clienteIdCliente;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    
    //Getters y Setters
    public int getIdHistRep() {
        return idHistRep;
    }

    public void setIdHistRep(int idHistRep) {
        this.idHistRep = idHistRep;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    
}
