package entity;

/**
 *
 * @author Emilio 
 * 21-09-2020
 */
public class Usuario {

    //Atributos
    private int idUsuario;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private int rut;
    private String digv;
    private String correo;
    private long telefono;
    private int activo;
    private int rolIdRol;
    private String clave;

    //Contructores
    public Usuario() {}

    public Usuario(int idUsuario, String nombre, String apellidoMaterno, String apellidoPaterno, int rut, String digv, String correo, long telefono, int activo, int rolIdRol, String clave) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.rut = rut;
        this.digv = digv;
        this.correo = correo;
        this.telefono = telefono;
        this.activo = activo;
        this.rolIdRol = rolIdRol;
        this.clave = clave;
    }

    //Getter y Setter

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDigv() {
        return digv;
    }

    public void setDigv(String digv) {
        this.digv = digv;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
   
    
    
}
