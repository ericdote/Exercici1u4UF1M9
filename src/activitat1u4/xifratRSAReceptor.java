package activitat1u4;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Eric
 */
public class xifratRSAReceptor {

    //Atribut global per la key
    private KeyPair key = null;
    //Atribut global que contindra el missatge un cop desxifrat
    private byte[] missatge;

    /**
     * Metode que genera claus amb el tipus RSA en 2048 bytes.
     */
    public void generaClaus() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            key = keyGen.genKeyPair();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(xifratRSAReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metode que rep el missatge en array de bytes (xifrat) i el desxifra
     * gracies al Cipher i la clau privada.
     *
     * @param data
     */
    public void desxifraDadesReceptor(byte[] data) {
        try {
            Cipher ci = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            ci.init(Cipher.DECRYPT_MODE, key.getPrivate());
            missatge = ci.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(xifratRSAReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metode que retorna la clau publica.
     *
     * @return
     */
    public PublicKey getClauPublica() {
        return key.getPublic();
    }

    /**
     * Metode que retorna el text desxifrat.
     *
     * @return
     */
    public byte[] getTextDesxifrat() {
        return missatge;
    }

}
