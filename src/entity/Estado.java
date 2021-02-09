package entity;

/**
 *
 * @author Emilio 
 * 21-09-2020
 */
public class Estado {

    //Atributos
    private int idEstado;
    private String descripcion;

    //Constructores
    public Estado() {
    }

    public Estado(int idEstado, String descripcion) {
        this.idEstado = idEstado;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
}
