package test;

// 25-10-2020
// CLASE (MiHash) DEPRECADA
// SE REEMPLAZADA POR LIBRERIA:
// import org.apache.commons.codec.digest.DigestUtils;


//Librerías para la encriptación md5
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Emilio
 */
public class MiHash {

    // Método para encriptar MD5
    public String encode(String secretKey, String cadena) {

        String encriptacion = "";

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");//instancia de clase MD5
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));//conversion en arregla de byte la llave
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);

        } catch (Exception e) {
            mostrarMensaje("Error de encriptación: \n" + e);
        }
        return encriptacion;
    }

    // Método para desencriptar MD5
    public String decode(String secretKey, String cadenaEncriptada) {

        String desencriptacion = "";

        try {

            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] textoPlano = cifrado.doFinal(message);
            desencriptacion = new String(textoPlano, "utf-8");

        } catch (Exception e) {
            mostrarMensaje("Error de desencriptación: \n" + e);
        }

        return desencriptacion;
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
