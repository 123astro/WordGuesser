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
        int count = 0;
        while (end) {

            System.out.println("Word Guesser\n" + "STATS:\n" + "Incorrect Guesses Made: " + count + "/7");
            for(int i = 0; i < theWord.length; ++i){
                System.out.print("_" + " ");
            }
            String usersGuess = UI.readString("\nPlease enter a letter");
            char guessedLetter = usersGuess.charAt(0);
            boolean hasLetter = false;
            for (char letter : theWord) {
                if (letter == guessedLetter) {
                    hasLetter = true;
                }
            }
            if (!hasLetter) {
                count++;
            }
        }
    }
}
