package com.careerdevs;


public class HangMan {

    String[] playableWords = new String[] {
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

    public static void startGame(){

    }

    public static void promptUser(){



        }
    }


}
