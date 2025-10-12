import java.security.*;
import javax.crypto.Cipher;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
        byte[] encrypted = cipher.doFinal("Secure Message".getBytes());

        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted: " + new String(decrypted));
    }
}
