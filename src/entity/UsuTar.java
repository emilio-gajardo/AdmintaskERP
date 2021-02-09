package entity;

/**
 *
 * @author Emilio
 * 22-09-2020
 */
public class UsuTar {
    
    //Atributos
    private int idUsuTar;
    private int tareaIdTarea;
    private int usuarioIdUsuario;
    
    //Constructores
    public UsuTar(){}

    public UsuTar(int idUsuTar, int tareaIdTarea, int usuarioIdUsuario) {
        this.idUsuTar = idUsuTar;
        this.tareaIdTarea = tareaIdTarea;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    
    
    //Getters y Setters
    public int getIdUsuTar() {
        return idUsuTar;
    }

    public void setIdUsuTar(int idUsuTar) {
        this.idUsuTar = idUsuTar;
    }

    public int getTareaIdTarea() {
        return tareaIdTarea;
    }

    public void setTareaIdTarea(int tareaIdTarea) {
        this.tareaIdTarea = tareaIdTarea;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    
}
