package io.lenur.hangman.core;

import io.lenur.hangman.config.Config;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AnalyzerTest {
    @Test
    public void getWordToGuess() {
        Analyzer analyzer = new Analyzer();

        String wordToGuess = analyzer.getWordToGuess();
        Assert.assertNotNull(wordToGuess);

        String[] words = Config.getWords();
        List<String> list = Arrays.asList(words);
        Assert.assertTrue(list.contains(wordToGuess));
    }

    @Test
    public void isGuessed() {
        Analyzer analyzer = new Analyzer();
        Assert.assertFalse(analyzer.isGuessed());
    }

    @Test
    public void canContinue() {
        Analyzer analyzer = new Analyzer();
        Assert.assertTrue(analyzer.canContinue());
    }

    @Test
    public void tryGuess() {
        Analyzer analyzer = new Analyzer();
        Assert.assertFalse(analyzer.isGuessed());
        Assert.assertTrue(analyzer.canContinue());

        String word = analyzer.getWordToGuess();
        char[] wordChars = word.toCharArray();

        for (char ch: wordChars) {
            analyzer.tryGuess(String.valueOf(ch));
        }

        Assert.assertTrue(analyzer.isGuessed());
    }
}
