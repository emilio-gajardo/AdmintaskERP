package entity;

/**
 *
 * @author Emilio 
 * 21-09-2020
 */
public class FunProc {

    //Atributos
    private int idFunProc;
    private String idFuncion;
    private String idProceso;


    //Contructores
    public FunProc() {
    }

    public FunProc(int idFunProc, String idFuncion, String idProceso) {
        this.idFunProc = idFunProc;
        this.idFuncion = idFuncion;
        this.idProceso = idProceso;
    }


    public int getIdFunProc() {
        return idFunProc;
    }

    public void setIdFunProc(int idFunProc) {
        this.idFunProc = idFunProc;
    }

    public String getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(String idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

   
    
}
