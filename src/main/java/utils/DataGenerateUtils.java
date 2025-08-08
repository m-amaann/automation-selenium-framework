package utils;

import java.math.BigInteger;
import java.nio.file.attribute.FileAttribute;
import java.security.SecureRandom;
import java.util.UUID;

public class DataGenerateUtils {

    // Private constructor
    private DataGenerateUtils() {
        super();
    }


    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom random = new SecureRandom();


    /**
     * Generates a random alphanumeric string of specified length.
     */
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(random.nextInt(AB.length())));
        }
        return sb.toString();
    }


    public static String randomStringHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); // Hexadecimal encoding
    }

    public static String randomStringUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static int randomNumberIntFromTo(int from, int to) {
        int random_int = (int) Math.floor(Math.random() * (to - from + 1) + from);
        return random_int;
    }

    public static String randomFullName() {
        return getFaker().name().fullName();
    }

    public static String randomPhoneNumber() {
        return getFaker().phoneNumber().phoneNumber();
    }

    public static String randomCountry() {
        return getFaker().address().country();
    }


}
