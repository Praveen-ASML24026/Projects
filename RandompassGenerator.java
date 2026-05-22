package projects;

import java.util.Random;

public class RandompassGenerator {
    static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    static final String DIGITS = "0123456789";
    static final String SYMBOLS = "!@#$%&*?/";

    public static String Random(int length) {
        String word = UPPER + LOWER + DIGITS + SYMBOLS;
        Random idk = new Random();
        StringBuilder str = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int ran = idk.nextInt(word.length());
            str.append(word.charAt(ran));
        }

        return str.toString();
    }
}


