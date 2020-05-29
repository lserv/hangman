package io.lenur.hangman.util;

import java.util.Random;

public class StringUtil {
    private static final char STAR = '*';

    public static String getRandomWord(String[] words) {
        int index = (new Random()).nextInt(words.length);
        return words[index];
    }

    public static String replaceToStars(String word) {
        return word.replaceAll("(?s).", String.valueOf(STAR));
    }

    public static String replaceStartToCharacter(String word, String wordStars, String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == input.charAt(0) || wordStars.charAt(i) != STAR) {
                builder.append(word.charAt(i));
            } else {
                builder.append(STAR);
            }
        }

        return builder.toString();
    }
}
