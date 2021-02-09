
package entity;

/**
 *
 * @author Emilio
 */
public class SubTarea {
    
    //Atributos
    private int idSubTarea;
    private String nombre;
    private String finalizado;
    private int tareaIdTarea;
    
    //Constructores
    public SubTarea() {}

    public SubTarea(int idSubTarea, String nombre, String finalizado, int tareaIdTarea) {
        this.idSubTarea = idSubTarea;
        this.nombre = nombre;
        this.finalizado = finalizado;
        this.tareaIdTarea = tareaIdTarea;
    }
    
    //Getters y Setters
    public int getIdSubTarea() {
        return idSubTarea;
    }

    public void setIdSubTarea(int idSubTarea) {
        this.idSubTarea = idSubTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    public int getTareaIdTarea() {
        return tareaIdTarea;
    }

    public void setTareaIdTarea(int tareaIdTarea) {
        this.tareaIdTarea = tareaIdTarea;
    }
    
}
