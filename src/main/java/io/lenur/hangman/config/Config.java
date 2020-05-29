package io.lenur.hangman.config;

import io.lenur.configuration.Configuration;

public class Config {
    private static final String KEY_WORDS = "words";
    private static final String KEY_MAX_ATTEMPTS = "max.attempts";

    private static final Configuration configuration;

    static {
        configuration = new Configuration("application.properties");
    }

    public static String[] getWords() {
        return configuration.getAsStringArray(KEY_WORDS);
    }

    public static int getMaxAttempts() {
        String attempts = configuration.get(KEY_MAX_ATTEMPTS);
        return Integer.parseInt(attempts);
    }
}
