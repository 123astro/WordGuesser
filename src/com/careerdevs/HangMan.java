package com.careerdevs;


import jdk.swing.interop.SwingInterOpUtils;

public class HangMan {

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

    public static void promptUser() {
        int num = (int) (Math.random() * (7 - 1) + 1);

        // System.out.println(playableWords[num -1 ]);
        String word = playableWords[num - 1];
        char[] letters = word.toCharArray();
        //System.out.println(word);
        String usersGuess = UI.readString("Please enter a letter");
        char guessedLetter = usersGuess.charAt(0);
        // System.out.println(guessedLetter);
        System.out.println(letters.length);
        for (int i = 0; 0 < letters.length; i++) {
            System.out.print(letters[i] + " ");
        }

    }
}

