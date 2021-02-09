package test;

import com.itextpdf.text.pdf.codec.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Emilio
 */
public class HashAES {

    //AES solo admite tamaños de clave de 16, 24 o 32 bytes.
    private static String ENCRYPT_KEY = "clave-compartida-no-reveloar-nun";

    public static void main(String[] args) throws Exception {
        
        String encriptado = encript(ENCRYPT_KEY);
        String desencriptado = decrypt(encriptado);
        
        System.out.println("Original: " + ENCRYPT_KEY);
        System.out.println("encriptado: " + encriptado);
        System.out.println("desencriptado: " + desencriptado);
    }

    public static String encript(String text) throws Exception {
        Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);

        byte[] encrypted = cipher.doFinal(text.getBytes());

        return Base64.encodeBytes(encrypted);
    }

    public static String decrypt(String encrypted) throws Exception {
        byte[] encryptedBytes = Base64.decode(encrypted.replace("\n", ""));

        Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);

        String decrypted = new String(cipher.doFinal(encryptedBytes));

        return decrypted;
    }
}
