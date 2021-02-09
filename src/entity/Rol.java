
package entity;

/**
 *
 * @author Emilio
 * 21-09-2020
 */
public class Rol {
    
    //Atributos
    private int idRol;
    private String descripcion;
    
    //Constructores
    public Rol() {
    }

    public Rol(int idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }
    
    //Getters y Setters

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
