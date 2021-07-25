import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Authentication {
    String[]moves;
    public Authentication(String[] args){
        moves= args;
    }
     public SecretKey keyGen() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom=new SecureRandom();
        int keyBitSize =128;
        keyGen.init(keyBitSize,secureRandom);
        SecretKey key = keyGen.generateKey();
        return key;
    }
     public StringBuilder hmacGen(SecretKey key,int mi) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac mac= Mac.getInstance("HmacSHA256");
        mac.init(key);
        int rng=mi;
        byte[] move=moves[rng].getBytes("UTF-8");
        byte[] BHMac=mac.doFinal(move);
        StringBuilder HMac = new StringBuilder(BHMac.length * 2);
        for(byte b: BHMac)
            HMac.append(String.format("%02x", b));
        return HMac;
    }
    public void printHMac(StringBuilder HMac){
        System.out.println("HMAC: "+HMac);
    }
    public  void printKey(SecretKey key){
        byte[] bk=key.getEncoded();
        StringBuilder pkey = new StringBuilder(bk.length * 2);
        for(byte b: bk)
            pkey.append(String.format("%02x", b));
        System.out.println("HMAC key: "+pkey+"\n----------------------------------------");
    }
}
