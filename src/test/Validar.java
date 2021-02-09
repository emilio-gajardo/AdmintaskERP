package test;

/**
 * 05-10-2020
 *
 * @author Emilio Clase usada para la validación de los campos de los
 * formularios
 */
public class Validar {

    public static boolean campoVacio(String campo) {
        return !(campo.trim().isEmpty());
    }

    public static boolean numeroEntero(String campo) {
        try {
            Long.parseLong(campo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean numeroDouble(String campo) {
        try {
            Double.parseDouble(campo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean rango(String campo, double inf, double sup) {
        try {
            double valor = Double.parseDouble(campo);
            if (valor >= inf && valor <= sup) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean digv(String campo) {

        if (campo.equals("k") || campo.equals("K")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numeroInt(String campo) {
        try {
            Integer.parseInt(campo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean largoTelefono(String fono) {

        if (fono.length() < 12) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comparacionDeClaves(String clave1, String clave2) {

        if (clave1.equals(clave2)) {
            return true;
        } else {
            return false;
        }
    }

}
