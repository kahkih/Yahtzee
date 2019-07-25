package Yahtzee;

import java.util.ArrayList;
import java.util.Scanner;

class YahtzeeGame {

    private ArrayList<Die> dice = new ArrayList<>();

    private ArrayList<Integer> blockingNumbers = new ArrayList<>();

    private Die rolledDie = new Die();
    Roll roll = new Roll();

    YahtzeeGame() {
        dice.add(new Die());
        dice.add(new Die());
        dice.add(new Die());
        dice.add(new Die());
        dice.add(new Die());
    }

    void play() {

        Scanner userInput = new Scanner(System.in);

        boolean quit = false;

        System.out.println("Welcome to Yahtzee!");

        while (!quit) {
            System.out.println("Press 'r' to roll the dice or 'q' to quit");
            String userAction = userInput.nextLine();
            blockingNumbers.clear();
            rolledDie.storedValues.clear();

            switch (userAction) {
                case ("r"):
                    for (Die ignored : dice) {
                        int dieNumber = rolledDie.rollDie();
                        rolledDie.storedValues.add(dieNumber);
                    }
                    System.out.println(rolledDie.storedValues);
                    keepDieValues();
                    System.out.println(blockingNumbers);

                    System.out.println("Roll again not kept dice");
                    rollNotKeptDice();
                    System.out.println(rolledDie.storedValues);

                    /*
                    Store the stored values in the rolls
                     */
                    System.out.println("Stored this in Roll and scored: bla bla points");
                    roll.rollResult(rolledDie.storedValues);
                    roll.calculatePoints(rolledDie.storedValues);
                    break;
                case ("q"):
                    System.out.println("See ya!");
                    quit = true;
                    break;
                case (""):
                    System.out.println("You pressed enter");
                    break;
            }
        }

    }

    private void rollNotKeptDice() {
        int i = 0;
        for (int blockingNumber : blockingNumbers) {
            if (blockingNumber == 0) {
                rolledDie.storedValues.set(i, rolledDie.rollDie());
            }
            i++;
        }
    }

    private void keepDieValues() {
        System.out.println("Which dice would you like to keep?");

        Scanner userInput = new Scanner(System.in);
        String dieChoice = userInput.next();

        for (int i = 1; i < 6; i++) {
            if (dieChoice.contains(String.valueOf(i))) {
                blockingNumbers.add((i - 1), 1);
            } else {
                blockingNumbers.add((i - 1), 0);
            }
        }
    }
}
