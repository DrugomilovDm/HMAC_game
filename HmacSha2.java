import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacSha2   {
    public static void main (String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Check check=new Check(args);
        if(check.repeatCheck()||check.evenCheck()||check.sizeCheck()){
            check.invalidInput();
            return;
        }
        Game game=new Game(args);
        Authentication aut=new Authentication(args);
        while(true) {
            SecretKey key = aut.keyGen();
            aut.printHMac(aut.hmacGen(key, game.getComputerMove()));
            if(!game.menu())
                return;
            game.result();
            aut.printKey(key);
        }
    }
}
