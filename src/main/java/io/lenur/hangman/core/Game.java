package io.lenur.hangman.core;

import io.lenur.hangman.config.Config;
import io.lenur.hangman.input.Inputable;

public class Game {
    private final Analyzer analyzer;
    private final Inputable input;

    public Game(Inputable userInput) {
        analyzer = new Analyzer();
        input = userInput;
    }

    public void start() {
        String greetingMsg = String.format("You have the %d attempts",
                Config.getMaxAttempts());
        System.out.println(greetingMsg);

        while (analyzer.canContinue()) {
            System.out.print("Enter a character: ");
            analyzer.tryGuess(input.getInput());
            if (analyzer.isGuessed()) {
                break;
            }
        }

        String msg;
        if (analyzer.isGuessed()) {
            String wordToGuess = analyzer.getWordToGuess();
            msg = String.format("Congratulation. The word was %s", wordToGuess);
        } else {
            msg = "You lose!";
        }
        System.out.println(msg);

        input.close();
    }
}
