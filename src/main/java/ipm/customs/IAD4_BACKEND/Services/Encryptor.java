package ipm.customs.IAD4_BACKEND.Services;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Random;

public class Encryptor {

    private static Random rand = new Random(5);

    public static String encrypt(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);
        return encoder.encode(salt) + encoder.encode(str.getBytes());
    }
    public static String decrypt(String encstr) {
        if (encstr.length() > 12) {
            String cipher = encstr.substring(12);
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                return new String(decoder.decodeBuffer(cipher));
            } catch (IOException e) {
                //  throw new InvalidImplementationException(
                //Fail
            }
        }
        return null;
    }
}
