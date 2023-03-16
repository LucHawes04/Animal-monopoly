package com.company;

import java.util.Scanner;


public class Animals extends Spaces {
    String name;
    int level;
    int price;
    int location;
    String owner;
    double[] upgradeCost = {0,0,0,0}; // array of prices for each level. 0 = level 1, 1 = level 2, 2 = level 3


    public Animals(String name, int price, int location) {

        this.name = name;
        this.level = 0;
        this.price = price;
        this.owner = "";
        this.location = location;

        // sets the upgrade cost for each level
        this.upgradeCost[1] = price * 0.2;
        this.upgradeCost[2] = price * 0.4;
        this.upgradeCost[3] = price * 0.6;
    }

    public void incrementLevel() { // increments the level of the animal
        this.level++;
    }

    public void setOwner(String player) { // sets the owner of the animal
        this.owner = player;
    }

    // get methods
    public int getLocation(){ // returns the location of the animal
        return location;
    }

    public String getName() { // returns the name of the animal
        return name;
    }

    public int getLevel() { // returns the level of the animal
        return level;
    }

    public int getPrice() { // returns the price of the animal
        return price;
    }

    public String getOwner() { // returns the owner of the animal
        return owner;
    }

    public Player getOwnerPlayer(Player firstPlayer, Player secondPlayer, Player thirdPlayer, Player fourthPlayer){ // returns the player object of the owner
        if (getOwner().equals(firstPlayer.getName())){ // checks if the owner is the first player
            return firstPlayer;
        }
        else if(getOwner().equals(secondPlayer.getName())){ // checks if the owner is the second player
            return secondPlayer;
        }
        else if(getOwner().equals(thirdPlayer.getName())){ // checks if the owner is the third player
            return thirdPlayer;
        }
        else if(getOwner().equals(fourthPlayer.getName())){ // checks if the owner is the fourth player
            return fourthPlayer;
        }
        else{
            return null;
        }
    }

    public void printAnimal() { // prints the animal's name, level, price, and owner
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Price: " + price);
        if (owner.equals("")) {
            System.out.println("Owner: none");
        }
        else {
            System.out.println("Owner: " + owner);
        }
    }

    public void landedOn(Player currentPlayer, Player firstOther, Player secondOther, Player thirdOther) {
        int lvl = getLevel();
        // level 0 *0.1
        // level 1 *0.15
        // level 2 *0.25
        // level 3 *0.4
        Scanner input = new Scanner(System.in);
         if (!getOwner().equals("")) { // if the space is owned
             if (currentPlayer.getName().equals(getOwner())){ // checks if landed on own space
                 System.out.println("You landed on your own animal...");
                 System.out.println("Do you want to upgrade your " + name + "? (y/n)");
                 String answer = input.nextLine(); {
                     if (answer.equals("y")) {
                         upgrade(currentPlayer);
                     }
                     else if (answer.equals("n")) {
                         System.out.println();
                     }
                     else {
                         System.out.println("Sorry, I couldn't understand your input");
                     }
                 }
             }
             else { // landed on someone else's space
                 if (lvl == 0) { // if the animal is level 0
                     System.out.println("You landed on " + owner + "'s " + name); // prints the owner and name of the animal
                     System.out.println(currentPlayer.getName() + " " + currentPlayer.changeCoins(-price * 0.1)); // removes money from the current player
                     Player ownerPlayer = getOwnerPlayer(currentPlayer, firstOther, secondOther, thirdOther); // gets the player object of the owner
                     System.out.println(this.getOwner() + " " + ownerPlayer.changeCoins(price * 0.1)); // gives money to the owner
                 }
                 if (lvl == 1) { // if the animal is level 1
                     System.out.println("You landed on " + owner + "'s " + name); // prints the owner and name of the animal
                     System.out.println(currentPlayer.getName() + " " + currentPlayer.changeCoins(-price * 0.15));
                     Player ownerPlayer = getOwnerPlayer(currentPlayer, firstOther, secondOther, thirdOther); // gets the player object of the owner
                     System.out.println(this.getOwner() + " " + ownerPlayer.changeCoins(price * 0.15)); // gives money to the owner
                 }
                 if (lvl == 2) { // if the animal is level 2
                     System.out.println("You landed on " + owner + "'s " + name); // prints the owner and name of the animal
                     System.out.println(currentPlayer.getName() + " " + currentPlayer.changeCoins(-price * 0.25));
                     Player ownerPlayer = getOwnerPlayer(currentPlayer, firstOther, secondOther, thirdOther); // gets the player object of the owner
                     System.out.println(this.getOwner() + " " + ownerPlayer.changeCoins(price * 0.25)); // gives money to the owner
                 }
                 if (lvl == 3) { // if the animal is level 3
                     System.out.println("You landed on " + owner + "'s " + name); // prints the owner and name of the animal
                     System.out.println(currentPlayer.getName() + " " + currentPlayer.changeCoins(-price * 0.4));
                     Player ownerPlayer = getOwnerPlayer(currentPlayer, firstOther, secondOther, thirdOther); // gets the player object of the owner
                     System.out.println(this.getOwner() + " " + ownerPlayer.changeCoins(price * 0.4)); // gives money to the owner
                 }
             }
        }
        else {

            // allows the user to buy an empty space
            System.out.println("You landed on an empty space!"); // if the space is not owned
            System.out.println("Would you like to buy " + this.name + " for " + this.price + "? (y/n)");
            String choice = input.nextLine();

            if (choice.equals("y")) {

                if (currentPlayer.getCoins() >= this.price) {
                currentPlayer.changeCoins(-this.price); // removes money from the current player
                System.out.println("Successfully bought " + this.name + " for " + this.price + "!");
                setOwner(currentPlayer.getName()); // sets the owner of the animal to the current player if purchased
                }

                else {
                    System.out.println("You do not have enough coins to purchase this animal");
                }
            }
        }
    }

    public void upgrade(Player currentPlayer){
        System.out.println("Your " + name + " is level " + level + "."); // prints the level of the animal
        System.out.println("Upgrade costs...");
        // level 0 *0.1
        // level 1 *0.2
        // level 2 *0.4
        // level 3 *0.6
        for(int x = level; x < 4; x++){
            System.out.println("Level" + x + " = " + upgradeCost[x]); // prints the cost of each level
        }
        System.out.println("How many levels do you want to upgrade?"); // asks how many levels to upgrade
        Scanner input = new Scanner(System.in);
        int numUpgrades = input.nextInt(); // stores the number of levels to upgrade
        int totalCost = 0;


        // level 0 is level 0
        // upgrade cost, 0 is level 1, 1 is level 2, 2 is level 3
        for(int x = level + 1; x <= (level + 1 + numUpgrades); x++){ // adds the cost of each level to the total cost
            totalCost += upgradeCost[x];
        }
        if (currentPlayer.getCoins() < totalCost){ // checks if the player has enough coins
            System.out.println("You don't have enough coins to upgrade your " + name + "!");
            upgrade(currentPlayer);
        }
        System.out.println(currentPlayer.getName() + " " + currentPlayer.changeCoins(-totalCost));
        System.out.println("You upgraded your " + name + " to level " + (level + numUpgrades)+"!");
        incrementLevel();
    }
}