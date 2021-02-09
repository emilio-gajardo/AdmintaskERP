package entity;

/**
 *
 * @author Emilio 
 * 21-09-2020
 */
public class Funcion {

    //Atributos
    private int idFuncion;
    private String nombre;
    private String fechaInicio;
    private String fechaTermino;
    private int unidadIdUnidad;
    private int estadoIdEstado;
    private int usuarioIdUsuario;  //DUDAS REVISAR A QUIEN CORRESPONDE
    private int procesoIdProceso;

    //Contructores
    public Funcion() {
    }

    public Funcion(int idFuncion, String nombre, String fechaInicio, String fechaTermino, int unidadIdUnidad, int estadoIdEstado, int usuarioIdUsuario, int procesoIdProceso) {
        this.idFuncion = idFuncion;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.unidadIdUnidad = unidadIdUnidad;
        this.estadoIdEstado = estadoIdEstado;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.procesoIdProceso = procesoIdProceso;
    }

    //Getters y Setters
    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public int getUnidadIdUnidad() {
        return unidadIdUnidad;
    }

    public void setUnidadIdUnidad(int unidadIdUnidad) {
        this.unidadIdUnidad = unidadIdUnidad;
    }

    public int getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(int estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getProcesoIdProceso() {
        return procesoIdProceso;
    }

    public void setProcesoIdProceso(int procesoIdProceso) {
        this.procesoIdProceso = procesoIdProceso;
    }
    
}
