package entity;

/**
 *
 * @author Emilio
 * 22-09-2020
 */
public class HistTar {
    
    //Atributos
    private int idHistTar;
    private String estadoInicial;
    private String estadoFinal;
    private int tareaIdTarea;
    private String nota;
    
    //Constructores
    public HistTar(){}

    public HistTar(int idHistTar, String estadoInicial, String estadoFinal, int tareaIdTarea, String nota) {
        this.idHistTar = idHistTar;
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
        this.tareaIdTarea = tareaIdTarea;
        this.nota = nota;
    }
    
    //Getters y Setters
    public int getIdHistTar() {
        return idHistTar;
    }

    public void setIdHistTar(int idHistTar) {
        this.idHistTar = idHistTar;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public int getTareaIdTarea() {
        return tareaIdTarea;
    }

    public void setTareaIdTarea(int tareaIdTarea) {
        this.tareaIdTarea = tareaIdTarea;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
   
}
