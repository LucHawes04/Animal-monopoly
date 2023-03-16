package com.company;
import java.util.Random;

public class Cards {
    private int cardValue = 0;
    private int[] arrayOfCards = new int[20];



    public Cards() { // constructor to create a deck of cards with values

        arrayOfCards[0] = -1000;
        arrayOfCards[1] = -750;
        arrayOfCards[2] = -500;
        arrayOfCards[3] = -250;
        arrayOfCards[4] = -200;
        arrayOfCards[5] = -125;
        arrayOfCards[6] = -100;
        arrayOfCards[7] = -75;
        arrayOfCards[8] = -50;
        arrayOfCards[9] = -25;
        arrayOfCards[10] = 1000;
        arrayOfCards[11] = 750;
        arrayOfCards[12] = 500;
        arrayOfCards[13] = 250;
        arrayOfCards[14] = 200;
        arrayOfCards[15] = 125;
        arrayOfCards[16] = 100;
        arrayOfCards[17] = 75;
        arrayOfCards[18] = 50;
        arrayOfCards[19] = 25;

    }

    public int getCardValue(){ // randomises the action card chosen
        int min = 0;
        int max = 19;
        cardValue = (int)(Math.random()*(max-min+1)+min); // randomises the card chosen
        return cardValue;
    }


    public void chooseCard(Player currentPlayer) { // carries out the action on the card
        System.out.println(currentPlayer.getName() + " picked up a card and " + currentPlayer.changeCoins(arrayOfCards[getCardValue()]));
    }
}