package com.careerdevs;


import java.util.ArrayList;

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

    public static char[] getWord() {
        count = 0;
        int num = (int) (Math.random() * (7 - 1) + 1);
        String word = playableWords[num - 1];
        theWord = word.toCharArray();
        System.out.println(theWord);
        return theWord;
    }

    public static void promptUser() {
        while (end) {
            System.out.println("Word Guesser\n" + "STATS:\n" + "Incorrect Guesses Made: " + count + "/7");
            for (int i = 0; i < theWord.length; ++i) {
                System.out.print("_" + " ");
            }
            String usersGuess = UI.readString("\nPlease enter a letter");
            char guessedLetter = usersGuess.charAt(0);
            for (int i = 0; i < allCharsPicked.size(); ++i) {
                if (guessedLetter == allCharsPicked.get(i)) {
                    System.out.println("\nPlease pick a letter that hasn't been used already.");
                    promptUser();
                }
            }
                allCharsPicked.add(guessedLetter);
                System.out.println("All picked letters: " + allCharsPicked);
                boolean hasLetter = false;
                for (int j = 0; j < theWord.length; ++j) {
                    if (theWord[j] == guessedLetter) {
                        correctChars.add(theWord[j]);
                        hasLetter = true;
                    }
                }
                if (!hasLetter) {
                    count++;
                    if (count == 7) {
                        System.out.println("You have reached the max number of incorrect guesses. Thanks for playing you " +
                                "loser.");
                        startMenu();
                    }
                }
                System.out.println("Correct letters that have been picked: " + correctChars);
        }
    }
}
