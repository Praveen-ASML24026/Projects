package projects;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSA_Algoritham {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public void GenerateKeys() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair key2 = generator.generateKeyPair();
        this.privateKey = key2.getPrivate();
        this.publicKey = key2.getPublic();    
    }

    public String encrypte(String plainText) throws Exception {
        Cipher Cypto = Cipher.getInstance("RSA");
        Cypto.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] Encryption = Cypto.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(Encryption);
    }

    public String decrypte(String EncryptText) throws Exception {
        Cipher Cypto = Cipher.getInstance("RSA");
        Cypto.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] Decryption = Cypto.doFinal(Base64.getDecoder().decode(EncryptText));
        return new String(Decryption);
    }
    
    public PrivateKey getPrivatekey() {
        return privateKey;
    }
    
    public PublicKey getPublicKey() {
        return publicKey;
    }
}
