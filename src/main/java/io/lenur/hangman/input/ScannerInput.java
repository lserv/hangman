package io.lenur.hangman.input;

import java.util.Scanner;

public class ScannerInput implements Inputable {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
