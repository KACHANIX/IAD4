package ipm.customs.IAD4_BACKEND.Services;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;
import java.util.Random;

public class Encryptor {

    private static Random rand = new Random(5);

    public static String encrypt(String str) {
        Base64.Encoder encoder = Base64.getEncoder();
//        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);

        return encoder.encodeToString(salt) + encoder.encodeToString(str.getBytes());
    }
    public static String decrypt(String encstr) {
        if (encstr.length() > 12) {
            String cipher = encstr.substring(12);
            Base64.Decoder decoder = Base64.getDecoder();
//            BASE64Decoder decoder = new BASE64Decoder();
            try {
                return new String(decoder.decode(cipher));
            } catch (Exception e) {
                //  throw new InvalidImplementationException(
                //Fail
            }
        }
        return null;
    }
}
