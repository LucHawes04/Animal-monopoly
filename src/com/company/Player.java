package com.company;

public class Player {

    private double coins;
    private int location;
    private String name;
    private String symbol;
    private boolean missTurn = false;


    public Player(String name, String identifier) {
        this.coins = 2500; // players start with 2500 coins
        this.location = 0; // 0 location = start
        this.name = name;
        this.symbol = identifier; // player symbol e.g. @, !, *
    }

    public boolean checkCoins() {
        if (this.coins > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public String changeCoins(double amount) { // sets the number of coins for a player
        this.coins += amount;
        if(amount >= 0){
            return "gained " + amount + " coins";
        }
        else {
            amount = -amount;
            return "lost " + amount + " coins";
        }
    }

    public double getCoins() { // returns the number of coins
        return this.coins;
    }

    public void changeLocation(int total) { // sets the location of the player to the total of the 2 dice rolls
        if (this.location + total > 25) {
            this.location += total - 25;
        }
        else {
            this.location += total;
        }
    }

    public void checkPassStart(int total) { // method adds money if a player has passed start
        if (26 - (total + this.location) == 0) { // checks if a player's next roll will land on start
            System.out.println("You landed on start!");
            changeCoins(1000);
        }
        else if (this.location + total > 25) { // checks if next roll means that they will pass start
            System.out.println("You passed start!");
            changeCoins(500);
        }
    }
    public void setMissTrue() {
        this.missTurn = true;
    }

    public void setMissFalse() {
        this.missTurn = false;
    }

    public boolean getMissTurn() {
        return missTurn;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }
}


