package activitat1u4;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
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
public class xifratRSAEmissor {

    //Atribut global per tenir el missatgeXifrat
    private byte[] missatgeXifrat;

    /**
     * Metode que li arriba una cadena de String i una clau publica. Un cop li
     * arriba el String el passa a bytes i el xifra en forma asimetrica
     *
     * @param missatge_text
     * @param pub
     */
    public void xifraDadesEmissor(String missatge_text, PublicKey pub) {
        try {
            byte[] buffer = missatge_text.getBytes("UTF-8");
            Cipher ci = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            ci.init(Cipher.ENCRYPT_MODE, pub);
            missatgeXifrat = ci.doFinal(buffer);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(xifratRSAEmissor.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**
     * Metode que torna el missatge xifrat.
     *
     * @return
     */
    public byte[] getMissatgeXifrat() {
        return missatgeXifrat;
    }

}
