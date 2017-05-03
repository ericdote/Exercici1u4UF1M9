package activitat1u4;

/**
 *
 * @author Eric
 */
public class Test4 {

    
    public static void main(String[] args) {
        xifratRSAEmissor xre = new xifratRSAEmissor();
        xifratRSAReceptor xrr = new xifratRSAReceptor();        
        xrr.generaClaus();
        xre.xifraDadesEmissor("ola k ase", xrr.getClauPublica());
        System.out.println(new String(xre.getMissatgeXifrat()));
        xrr.desxifraDadesReceptor(xre.getMissatgeXifrat());
        System.out.println(new String(xrr.getTextDesxifrat()));
    }
    
}
