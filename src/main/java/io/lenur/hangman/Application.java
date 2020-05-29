package io.lenur.hangman;

import io.lenur.hangman.core.Game;
import io.lenur.hangman.input.ScannerInput;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new ScannerInput());
        game.start();
    }
}
