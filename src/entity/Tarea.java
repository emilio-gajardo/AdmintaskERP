package entity;

/**
 *
 * @author Emilio
 * 22-09-2020
 */
public class Tarea {
    
    //Atributos
    private int idTarea;
    private String nombre;
    private String fechaInicio;
    private String fechaTermino;
    private int estadoIdEstado;
    private int funcionIdFuncion;
    private String descripcion;
    private int encargado;
    
    //Constructores
    public Tarea(){}

    public Tarea(int idTarea, String nombre, String fechaInicio, String fechaTermino, int estadoIdEstado, int funcionIdFuncion, String descripcion, int encargado) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.estadoIdEstado = estadoIdEstado;
        this.funcionIdFuncion = funcionIdFuncion;
        this.descripcion = descripcion;
        this.encargado = encargado;
    }
    
    //Getters y Setters
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
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

    public int getEstadoIdEstado() {
        return estadoIdEstado;
    }

    public void setEstadoIdEstado(int estadoIdEstado) {
        this.estadoIdEstado = estadoIdEstado;
    }

    public int getFuncionIdFuncion() {
        return funcionIdFuncion;
    }

    public void setFuncionIdFuncion(int funcionIdFuncion) {
        this.funcionIdFuncion = funcionIdFuncion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEncargado() {
        return encargado;
    }

    public void setEncargado(int encargado) {
        this.encargado = encargado;
    }
   
}
