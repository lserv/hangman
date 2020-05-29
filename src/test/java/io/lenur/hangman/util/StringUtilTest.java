package io.lenur.hangman.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringUtilTest {
    @Test
    public void getRandomWord() {
        String[] words = {"java", "spring"};
        String word = StringUtil.getRandomWord(words);

        List<String> list = Arrays.asList(words);
        Assert.assertTrue(list.contains(word));
    }

    @Test
    public void replaceToStars() {
        String word = "java";
        String wordStars = StringUtil.replaceToStars(word);

        Assert.assertNotEquals(word, wordStars);
        Assert.assertEquals(4, wordStars.length());

        String replaced = wordStars.replaceAll("\\*", "");
        Assert.assertTrue(replaced.isEmpty());
    }

    @Test
    public void replaceStartToCharacterFind() {
        String word = "java";
        String wordStars = "****";
        String input = "a";

        String result = StringUtil.replaceStartToCharacter(word, wordStars, input);

        Assert.assertNotEquals(result, wordStars);
        Assert.assertEquals(4, result.length());
        Assert.assertEquals("*a*a", result);
    }

    @Test
    public void replaceStartToCharacterNotFind() {
        String word = "java";
        String wordStars = "****";
        String input = "b";

        String result = StringUtil.replaceStartToCharacter(word, wordStars, input);

        Assert.assertEquals(result, wordStars);
        Assert.assertEquals(4, result.length());
    }
}
