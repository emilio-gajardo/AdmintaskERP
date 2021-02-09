package entity;

/**
 *
 * @author Emilio 
 * 22-09-2020
 */
public class Proceso {

    //Atributos
    private int idProceso;
    private String nombre;
    private String descripcion;
    private int diasPreIntervencion;

    public int getDiasPreIntervencion() {
        return diasPreIntervencion;
    }

    public void setDiasPreIntervencion(int diasPreIntervencion) {
        this.diasPreIntervencion = diasPreIntervencion;
    }

    //Constructores
    public Proceso() {
    }

    public Proceso(int idProceso, String nombre, String descripcion, int diasPreIntervencion) {
        this.idProceso = idProceso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.diasPreIntervencion = diasPreIntervencion;
    }

    //Getters y Setters
    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
