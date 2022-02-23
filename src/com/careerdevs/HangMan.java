package com.careerdevs;


import java.util.ArrayList;

public class HangMan {

    //Array;

    public static String[] playableWords = new String[]{
            "guessing", "these", "words",
            "is", "very", "easy"
    };


    public static void startMenu() {
        boolean on = true;
        while (on) {

            System.out.println("\n1) Start Game" + "\n2) Exit"
            );

            int input = UI.readInt("Please enter a selection", 1, 2);
            switch (input) {
                case 1 -> startGame();
                case 2 -> on = false;
            }
        }
    }

    public static void startGame() {
        promptUser();
    }

    public static char[] getWord() {
        int num = (int) (Math.random() * (7 - 1) + 1);
        String word = playableWords[num - 1];
        char[] letters = word.toCharArray();
        return letters;
    }

    public static void promptUser() {
        char[] theWord = getWord();
        System.out.println(theWord);
        boolean end = true;
        while (end) {
            int count = 10;
            String usersGuess = UI.readString("Please enter a letter");
            char guessedLetter = usersGuess.charAt(0);
            // System.out.println(getWord());
            for (char letter : theWord) {
                if (letter == guessedLetter) {
                    System.out.println(guessedLetter);
                }
            }
        }
    }
}