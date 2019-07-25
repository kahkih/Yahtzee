package Yahtzee;

import java.util.ArrayList;
import java.util.Random;

public class Die {

    ArrayList<Integer> storedValues = new ArrayList<>();

    protected int rollDie() {
        Random random = new Random();

        return random.nextInt(6)+1;
    }

}
