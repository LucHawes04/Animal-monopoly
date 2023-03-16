package com.company;
import java.util.Random;
public class Dice {
    int dice1;
    int dice2;
    int total;
    public void roll() { // rolls the dice
        dice1 = randomNum();
        dice2 = randomNum();
        total = (dice1 + dice2); // sets the total of the two dice
    }
    public int getFirstRoll(){ // returns the value of the first dice
        return dice1;
    }
    public int getSecondRoll(){ // returns the value of the second dice
        return dice2;
    }
    public int getTotal(){ // returns the total of the two dice
        return dice1 + dice2;
    }
    public int randomNum(){ // returns a random number between 1 and 6
        Random rand = new Random();
        return rand.nextInt(5)+1;
    }
    public boolean isDouble(){ // returns true if the two dice are the same
        if (dice1 == dice2){
            return true;
        }
        return false;
    }
}


