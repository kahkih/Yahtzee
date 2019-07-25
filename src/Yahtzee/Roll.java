package Yahtzee;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;

public class Roll {
    int[] rolls = new int[5];

    void rollResult(ArrayList<Integer> storedValues) {
        int i = 0;
        for (int storedValue : storedValues) {
            rolls[i] = storedValue;
            i++;
        }
        for (int j=0 ; j < 5 ; j++) {
            System.out.println(rolls[j]);
        }

    }

    void calculatePoints(ArrayList<Integer> storedValues) {
        int bigStraight = 23456;
        int smallStraight = 1234;
        int fullHouse = 12345;
        String threeOfAKind = "Three of a kind";
        String fourOfAKind = "Four of a kind";
        String yahtzee = "Yahtzee";
        int points;
        if((rolls[0] == rolls[1]) && (rolls[1]==rolls[2]) && (rolls[2] == rolls[3]) && (rolls[3] == rolls[4]) && (rolls[4] == rolls [5])) {
            points = 50;
            System.out.println("Yahtzee!");
            System.out.println("You have scored: " + points);
            // if sort stream and all numbers are same
        } else if (storedValues.contains(bigStraight)) {
            System.out.println("Big Straight");
            //sort stream and have 5 different numbers
        } else if (storedValues.contains(smallStraight)) {
            System.out.println("Small Straight");
            // sort stream and have 4 different numbers
        } else if (storedValues.contains(threeOfAKind)) {
            System.out.println("Three of a kind");
        } else if (storedValues.contains(fourOfAKind)) {
            System.out.println("Four of a kind");
        }
    }


}

/*
add the numbers and points together
Drie gelijke (three of a kind): De score is het totaal van alle ogen, als er minstens 3 dobbelstenen met hetzelfde aantal ogen zijn.
Voorbeeld: Dice-3.pngDice-5.pngDice-2.pngDice-5.pngDice-5.png = 3+5+2+5+5 = 20 punten

Vier gelijke (carré): De score is het totaal van alle ogen, als er minstens 4 dobbelstenen met hetzelfde aantal ogen zijn.
Voorbeeld: Dice-3.pngDice-3.pngDice-3.pngDice-5.pngDice-3.png = 3+3+3+5+3 = 17 punten

Full House: 25 punten voor 3 gelijke en één paar. (5 gelijke telt niet als Full House, tenzij het vak Yahtzee reeds ingevuld is).
Voorbeeld: Dice-2.pngDice-2.pngDice-6.pngDice-2.pngDice-6.png = 25 punten

Kans: De score is het totaal aantal ogen van alle dobbelstenen.
Voorbeeld: Dice-2.pngDice-4.pngDice-1.pngDice-6.pngDice-4.png = 2+4+1+6+4 = 17 punten
 */