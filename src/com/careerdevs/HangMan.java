package com.careerdevs;

import java.util.ArrayList;
import java.util.Locale;

public class HangMan {

    public static ArrayList<Character> correctChars;
    public static ArrayList<Character> allCharsPicked;

    public static boolean end = true;
    public static char[] theWord;
    public static String word;
    public static int count;

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
        correctChars = new ArrayList<>(); // needed a new arraylist to reset on every new start
        allCharsPicked = new ArrayList<>();
        getWord();
        promptUser();
    }

    public static void getWord() {
        count = 0;
        int num = (int) (Math.random() * (PlayableWords.playableWords.length) + 1);
        word = PlayableWords.playableWords[num - 1];
        theWord = word.toCharArray();
        System.out.println("\nThe New Word Size: " + theWord.length);
        //System.out.println(theWord);
    }

    public static void promptUser() {
        while (end) {
            System.out.println("\n******Word Guesser******\n" + "Incorrect Guesses Made: " + count + "/7");
            String usersGuess = UI.readString("\nPlease enter a letter");
            char guessedLetter = usersGuess.toLowerCase(Locale.ROOT).charAt(0);
            for (Character character : allCharsPicked) {
                if (guessedLetter == character) {
                    System.out.println("\nPlease pick a letter that hasn't been used already.");
                    for (char characterA : correctChars){
                        System.out.print(characterA);
                    }
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
                    System.out.println("You have reached the max number of incorrect guesses. You lose.  Thanks for " +
                            "playing!! ");
                    System.out.println("The word was: " + word);
                    startMenu();
                }
            }
            System.out.println("\nBelow are the correct letter(s) that have been picked in there proper location(s): " +
                    "\n");
            for (char character : correctChars){
                System.out.print(character);
            }
        }
    }

    public static void checkForWinner() {
        if (correctChars.size() > 0) {
            for (Character correctChar : correctChars) {
                if (correctChar.equals('_')) {
                    return;
                }
            }
            for (char character : correctChars){
                System.out.print(character);
            }
            System.out.println("\n****************You Win!**********************");

            startMenu();
        }
    }
}


