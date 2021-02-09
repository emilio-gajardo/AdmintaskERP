package entity;

/**
 *
 * @author Emilio 
 * 21-09-2020
 */
public class Cliente {

    //Atributos
    private int idCliente;
    private String nombre;
    private long telefono;
    private String correo;
    private String fechaIngreso;
    private String areaActuacion;

    //Constructores
    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, long telefono, String correo, String fechaIngreso, String areaActuacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.areaActuacion = areaActuacion;
    }

    //Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAreaActuacion() {
        return areaActuacion;
    }

    public void setAreaActuacion(String areaActuacion) {
        this.areaActuacion = areaActuacion;
    }
    
}
