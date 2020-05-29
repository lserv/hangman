package io.lenur.hangman.config;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ConfigTest {
    @Test
    public void getWords() {
        String[] words = Config.getWords();
        Assert.assertEquals(3, words.length);

        List<String> list = Arrays.asList(words);
        Assert.assertTrue(list.contains("java"));
        Assert.assertTrue(list.contains("spring"));
        Assert.assertTrue(list.contains("hibernate"));
    }

    @Test
    public void getMaxAttempts() {
        int maxAttempt = Config.getMaxAttempts();
        Assert.assertEquals(10, maxAttempt);
    }
}
