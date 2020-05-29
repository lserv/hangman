package io.lenur.hangman.core;

import io.lenur.hangman.config.Config;
import io.lenur.hangman.util.StringUtil;

import java.util.Objects;

public class Analyzer {
    private String wordStars;
    private int attempt = 0;
    private final String word;
    private final int maxAttempts;

    public Analyzer() {
        maxAttempts = Config.getMaxAttempts();
        String[] words = Config.getWords();
        word = StringUtil.getRandomWord(words);
        wordStars = StringUtil.replaceToStars(word);
    }

    public void tryGuess(String input) {
        if (word.contains(input)) {
            wordStars = StringUtil.replaceStartToCharacter(word, wordStars, input);
        }

        String progress = String.format("Attempt %d. Word %s ", ++attempt, wordStars);
        System.out.println(progress);
    }

    public String getWordToGuess() {
        return word;
    }

    public boolean canContinue() {
        return attempt < maxAttempts && !isGuessed();
    }

    public boolean isGuessed() {
        return Objects.equals(wordStars, word);
    }
}
