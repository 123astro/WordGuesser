package com.careerdevs;

import java.util.ArrayList;
import java.util.Locale;

public class HangMan {

    public static ArrayList<Character> correctChars = new ArrayList<>();
    public static ArrayList<Character> allCharsPicked = new ArrayList<>();

    public static boolean end = true;
    public static char[] theWord;
    public static int count;

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
        getWord();
        promptUser();
    }

    public static void getWord() {
        count = 0;
        int num = (int) (Math.random() * (7 - 1) + 1);
        String word = playableWords[num - 1];
        theWord = word.toCharArray();
        System.out.println(theWord);
    }

    public static void promptUser() {
        while (end) {
            System.out.println("\nWord Guesser\n" + "STATS:\n" + "Incorrect Guesses Made: " + count + "/7");
            String usersGuess = UI.readString("\nPlease enter a letter");
            char guessedLetter = usersGuess.toLowerCase(Locale.ROOT).charAt(0);
            for (int i = 0; i < allCharsPicked.size(); ++i) {
                if (guessedLetter == allCharsPicked.get(i)) {
                    System.out.println("\nPlease pick a letter that hasn't been used already.");
                    promptUser();
                }
            }
            allCharsPicked.add(guessedLetter);
            System.out.println("********** Picked letters: " + allCharsPicked + " *************");
            boolean hasLetter = false;
            if (correctChars.size() > 0) {
                for (int j = 0; j < theWord.length; ++j) {
                    if (theWord[j] == guessedLetter) {
                        hasLetter = true;
                        correctChars.set(j, guessedLetter);
                    }
                }
            }
            if (correctChars.size() == 0) {
                for (int j = 0; j < theWord.length; ++j) {
                    if (theWord[j] == guessedLetter) {
                        hasLetter = true;
                        correctChars.add(j, guessedLetter);
                    } else {
                        correctChars.add(j, '_');
                    }
                }
            }
            checkForWinner();
            if (!hasLetter) {
                count++;
                if (count == 7) {
                    System.out.println("You have reached the max number of incorrect guesses. Thanks for playing you " +
                            "loser.");
                    startMenu();
                }
            }
            System.out.println("\nCorrect letters that have been picked: \n" + correctChars);
        }
    }

    public static int checkForWinner() {
        if (correctChars.size() > 0) {
            for (Character correctChar : correctChars) {
                if (correctChar.equals('_')) {
                    return -1;
                }
            }
            System.out.println("****************You Win!**********************");
            startMenu();
        }
        return -1;
    }
}


