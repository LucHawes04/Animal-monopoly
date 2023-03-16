// Animonopoly

package com.company;

// Imports
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

// Changing user coins


public class Main {
    public static void main(String[] args) throws InterruptedException { // Main Method

        // Variables
        int currentPlayer = 0; // current player
        int[] symbols = {1, 1, 1, 1}; // available symbols
        String[] name = {"", "", "", ""}; // names for each player
        String[] playerSymbols = {"", "", "", ""}; // symbols for each player

        startGame(symbols, name, playerSymbols); // sets up player names and symbols
        HashMap<Integer, Animals> animalLocation = new HashMap<Integer, Animals>(); // hashmap to pair animals with a key (easy access)


        // Creating Objects
        // Players
        Player firstPlayer = new Player(name[0], playerSymbols[0]);
        Player secondPlayer = new Player(name[1], playerSymbols[1]);
        Player thirdPlayer = new Player(name[2], playerSymbols[2]);
        Player fourthPlayer = new Player(name[3], playerSymbols[3]);
        // Animals
        Animals pig = new Animals("Pig", 200, 1);
        Animals sheep = new Animals("Sheep", 250, 2);
        Animals cow = new Animals("Cow", 300, 3);
        Animals cat = new Animals("Cat", 300, 4);
        Animals dog = new Animals("Dog", 400, 5);
        Animals squirrel = new Animals("Squirrel", 450, 6);
        Animals rabbit = new Animals("Rabbit", 450, 7);
        Animals hedgehog = new Animals("Hedgehog", 550, 8);
        Animals otter = new Animals("Otter", 600, 9);
        Animals armadillo = new Animals("Armadillo", 650, 10);
        Animals zebra = new Animals("Zebra", 800, 11);
        Animals panda = new Animals("Panda", 850, 12);
        Animals penguin = new Animals("Penguin", 925, 14);
        Animals giraffe = new Animals("Giraffe", 1050, 15);
        Animals hyena = new Animals("Hyena", 1050, 16);
        Animals panther = new Animals("Panther", 1300, 17);
        Animals honeybadger = new Animals("Honey badger", 1400, 18);
        Animals elephant = new Animals("Elephant", 1550, 19);
        Animals rhino = new Animals("Rhino", 1675, 20);
        Animals cheetah = new Animals("Cheetah", 1700, 21);
        Animals tiger = new Animals("Tiger", 1850, 22);
        Animals lion = new Animals("Lion", 1925, 23);
        Animals hippo = new Animals("Hippo", 2000, 24);
        Animals gorilla = new Animals("Gorilla", 2000, 25);

        // assigning key/value pairs to the animal hashmap
        animalLocation.put(1, pig);
        animalLocation.put(2, sheep);
        animalLocation.put(3, cow);
        animalLocation.put(4, cat);
        animalLocation.put(5, dog);
        animalLocation.put(6, squirrel);
        animalLocation.put(7, rabbit);
        animalLocation.put(8, hedgehog);
        animalLocation.put(9, otter);
        animalLocation.put(10, armadillo);
        animalLocation.put(11, zebra);
        animalLocation.put(12, panda);
        animalLocation.put(14, penguin);
        animalLocation.put(15, giraffe);
        animalLocation.put(16, hyena);
        animalLocation.put(17, panther);
        animalLocation.put(18, honeybadger);
        animalLocation.put(19, elephant);
        animalLocation.put(20, rhino);
        animalLocation.put(21, cheetah);
        animalLocation.put(22, tiger);
        animalLocation.put(23, lion);
        animalLocation.put(24, hippo);
        animalLocation.put(25, gorilla);



        // Main program
        line(); // Creates a break
        System.out.println("Welcome to Animonopoly!");
        line();
        for (int x = 0; x < 4; x++) { // Prints each player's symbol
            System.out.println(name[x] + " is playing as: " + playerSymbols[x]);
        }

        Cards card = new Cards(); // instantiates new card object

        while (!finishCheck(firstPlayer, secondPlayer, thirdPlayer, fourthPlayer)) { // checks if only one player has coins -> ends game when only one player has coins

            if (currentPlayer == 0) { // P1's turn

                if (firstPlayer.getMissTurn()) { // checks if the player misses a turn
                    firstPlayer.setMissFalse(); // sets the missed turn to false
                    currentPlayer++; // moves to next player's turn
                }
                else {
                    firstTurn(firstPlayer, animalLocation, secondPlayer, thirdPlayer, fourthPlayer, card); // runs through P1's turn
                    currentPlayer++; // moves to the next player's turn when P1's turn has finished
                }
            }

            else if (currentPlayer == 1) { // P2's turn

                if (secondPlayer.getMissTurn()) {
                    secondPlayer.setMissFalse();
                    currentPlayer++;
                }
                else {
                    secondTurn(secondPlayer, animalLocation, firstPlayer, thirdPlayer, fourthPlayer, card);
                    currentPlayer++;
                }
            }

            else if (currentPlayer == 2) { // P3's turn

                if (thirdPlayer.getMissTurn()) {
                    thirdPlayer.setMissFalse();
                    currentPlayer++;
                }
                else {
                    thirdTurn(thirdPlayer, animalLocation, firstPlayer, secondPlayer, fourthPlayer, card);
                    currentPlayer++;
                }
            }

            else { // P4's turn

                if (fourthPlayer.getMissTurn()) {
                    fourthPlayer.setMissFalse();
                    currentPlayer = 0;
                }
                else {
                    fourthTurn(fourthPlayer, animalLocation, firstPlayer, secondPlayer, thirdPlayer, card);
                    currentPlayer = 0; // cycles back to P1
                }
            }
        }

    }


    /////////////////
    // Subroutines //
    /////////////////

    // Takes input from the players for name and symbols
    public static void startGame(int[] symbols, String[] name, String[] playerSymbols) {
        Scanner input = new Scanner(System.in);
        String tempName = "";

        System.out.println("What is player 1's name?"); // Asks for player 1's name
        tempName = input.nextLine(); // Takes input
        if (tempName.equals("") || (tempName.equals("none")) ) { // Checks if input is valid
            System.out.println("Invalid name -> Name will be Player 1");
            name[0] = "Player 1"; // assigns a default name if the name is invalid
        }
        else{
            name[0] = tempName; // Assigns input to name array
        }

        System.out.println("What is player 2's name?"); // Asks for player 2's name
        tempName = input.nextLine();
        if (tempName.equals("") || (tempName.equals("none")) ) { // Checks if input is valid
            System.out.println("Invalid name -> Name will be Player 2");
            name[1] = "Player 2";
        }
        else if (tempName.equals(name[0])) { // Checks if name is already taken
            System.out.println("Name already taken");
        }
        else{
            name[1] = tempName; // Assigns input to name array
        }

        System.out.println("What is player 3's name?"); // Asks for player 3's name
        tempName = input.nextLine();
        if (tempName.equals("") || (tempName.equals("none")) ) { // Checks if input is valid
            System.out.println("Invalid name -> Name will be Player 3");
            name[2] = "Player 3";
        }
        else if (tempName.equals(name[0]) || tempName.equals(name[1])) { // Checks if name is already taken
            System.out.println("Name already taken");
        }
        else{
            name[2] = tempName; // Assigns input to name array
        }

        System.out.println("What is player 4's name?"); // Asks for player 4's name
        tempName = input.nextLine();
        if (tempName.equals("") || (tempName.equals("none")) ) { // Checks if input is valid
            System.out.println("Invalid name -> Name will be Player 4");
            name[3] = "Player 4";
        }
        else if (tempName.equals(name[0]) || tempName.equals(name[1]) || tempName.equals(name[2])) { // Checks if name is already taken
            System.out.println("Name already taken");
        }
        else{
            name[3] = tempName; // Assigns input to name array
        }



        // For choosing pieces
        for (int x = 0; x < 4; x++) {
            int a = 1;
            while (a == 1) {
                System.out.println("Pick a symbol for " + name[x] + ": ");

                for (int z = 0; z < 4; z++) { // For printing out the remaining pieces
                    if (symbols[z] == 1) {
                        if (z == 0) {
                            System.out.printf("1 - &\t");
                        }
                        if (z == 1) {
                            System.out.printf("2 - *\t");
                        }
                        if (z == 2) {
                            System.out.printf("3 - @\t");
                        }
                        if (z == 3) {
                            System.out.printf("4 - ?\t");
                        }
                        System.out.println();
                    }
                }
                int num = input.nextInt(); // Takes input for number relating to piece
                if (num == 1 && symbols[0] == 1) { // Checks if symbols already chosen and if not will put it as chosen
                    symbols[0] = 0;
                    a = 0;
                    playerSymbols[x] = "&";
                } else if (num == 2 && symbols[1] == 1) {
                    symbols[1] = 0;
                    a = 0;
                    playerSymbols[x] = "*";
                } else if (num == 3 && symbols[2] == 1) {
                    symbols[2] = 0;
                    a = 0;
                    playerSymbols[x] = "@";
                } else if (num == 4 && symbols[3] == 1) {
                    symbols[3] = 0;
                    a = 0;
                    playerSymbols[x] = "?";
                } else {
                    System.out.println("Incorrect input...");
                }
            }
        }
    }

    // Checks if only one player has coins
    public static boolean finishCheck(Player firstPlayer, Player secondPlayer, Player thirdPlayer, Player fourthPlayer) {
        int count = 0;

        if (firstPlayer.checkCoins()) {
            count++;
        }
        if (secondPlayer.checkCoins()) {
            count++;
        }
        if (thirdPlayer.checkCoins()) {
            count++;
        }
        if (fourthPlayer.checkCoins()) {
            count++;
        }

        if (count <= 1) { // If less than one player has coins, the game ends
            return true;
        } else {
            return false;
        }
    }

    public static void firstTurn(Player firstPlayer, HashMap<Integer, Animals> animalLocation, Player secondPlayer, Player thirdPlayer, Player fourthPlayer, Cards card) throws InterruptedException { // P1's turn
        Dice dice = new Dice();
        line();
        System.out.println("It is " + firstPlayer.getName() + "'s turn! (" + firstPlayer.getSymbol() + ")\nCoins: " + firstPlayer.getCoins()); // Prints out the player's name and symbol
        Thread.sleep(400);
        System.out.println("Press enter to roll the dice...");
        dice.roll(); // Rolls the dice
        Scanner input = new Scanner(System.in);
        input.nextLine(); // Waits for enter to be pressed
        System.out.println(firstPlayer.getName() + " rolled: " + dice.getFirstRoll() + " and " + dice.getSecondRoll()); // Prints out the rolls
        System.out.println("Total = " + dice.getTotal()); // Prints out the total
        firstPlayer.checkPassStart(dice.getTotal()); // Checks if the player has passed start
        firstPlayer.changeLocation(dice.getTotal()); // Changes the player's location
        System.out.println("You landed on space: " + firstPlayer.getLocation()); // Prints out the player's location
        if (dice.isDouble()) { // Checks if the player rolled a double
            System.out.println("You rolled a double...\tPick up a card.");
            Thread.sleep(400);
            card.chooseCard(firstPlayer); // Picks up a card
            System.out.println("Press enter to continue...");
            input.nextLine(); // Waits for enter to be pressed
        }
        if (firstPlayer.getLocation() == 0) { // Checks if the player landed on start

        }
        else if (firstPlayer.getLocation() == 13) { // add miss a turn flag here
        }
        else {
            Animals landedAnimal = animalLocation.get(firstPlayer.getLocation()); // gets the animal tied to that location from the hashmap
            landedAnimal.printAnimal(); // prints out the animal's stats
            landedAnimal.landedOn(firstPlayer, secondPlayer, thirdPlayer, fourthPlayer);// Asks the player if they want to buy the property
        }
    }

    public static void secondTurn(Player secondPlayer, HashMap<Integer, Animals> animalLocation, Player firstPlayer, Player thirdPlayer, Player fourthPlayer, Cards card) throws InterruptedException { // P2's turn
        Dice dice = new Dice();
        line();
        System.out.println("It is " + secondPlayer.getName() + "'s turn! (" + secondPlayer.getSymbol() + ")\nCoins: "  + secondPlayer.getCoins());
        Thread.sleep(400);
        System.out.println("Press enter to roll the dice...");
        dice.roll();
        Scanner input = new Scanner(System.in);
        input.nextLine(); // Waits for enter to be pressed
        System.out.println(secondPlayer.getName() + " rolled: " + dice.getFirstRoll() + " and " + dice.getSecondRoll());
        System.out.println("Total = " + dice.getTotal());
        secondPlayer.checkPassStart(dice.getTotal());
        secondPlayer.changeLocation(dice.getTotal());
        System.out.println("You landed on space: " + secondPlayer.getLocation()); // Prints out the player's location
        if (dice.isDouble()) {
            System.out.println("You rolled a double...\tPick up a card.");
            Thread.sleep(400);
            card.chooseCard(secondPlayer);
            System.out.println("Press enter to continue...");
            input.nextLine(); // Waits for enter to be pressed
        }
        if (secondPlayer.getLocation() == 0) {
        }
        else if (secondPlayer.getLocation() == 13) { // add miss a turn flag here
        }
        else {
            Animals landedAnimal = animalLocation.get(secondPlayer.getLocation()); // gets the animal tied to that location from the hashmap
            landedAnimal.printAnimal(); // prints out the animal's stats
            landedAnimal.landedOn(secondPlayer, firstPlayer, thirdPlayer, fourthPlayer);// Asks the player if they want to buy the property

        }
    }

    public static void thirdTurn(Player thirdPlayer, HashMap<Integer, Animals> animalLocation, Player firstPlayer, Player secondPlayer, Player fourthPlayer, Cards card) throws InterruptedException { // P3's turn
        Dice dice = new Dice();
        line();
        System.out.println("It is " + thirdPlayer.getName() + "'s turn! (" + thirdPlayer.getSymbol() + ")\nCoins: "  + thirdPlayer.getCoins());
        Thread.sleep(400);
        System.out.println("Press enter to roll the dice...");
        dice.roll();
        Scanner input = new Scanner(System.in);
        input.nextLine(); // Waits for enter to be pressed
        System.out.println(thirdPlayer.getName() + " rolled: " + dice.getFirstRoll() + " and " + dice.getSecondRoll());
        System.out.println("Total = " + dice.getTotal());
        thirdPlayer.checkPassStart(dice.getTotal());
        thirdPlayer.changeLocation(dice.getTotal());
        System.out.println("You landed on space: " + thirdPlayer.getLocation()); // Prints out the player's location
        if (dice.isDouble()) {
            System.out.println("You rolled a double...\tPick up a card.");
            Thread.sleep(400);
            card.chooseCard(thirdPlayer);
            System.out.println("Press enter to continue...");
            input.nextLine(); // Waits for enter to be pressed
            //pick up card
        }
        if (thirdPlayer.getLocation() == 0) {

        }
        else if (thirdPlayer.getLocation() == 13) { // add miss a turn flag here

        }
        else {
            Animals landedAnimal = animalLocation.get(thirdPlayer.getLocation()); // gets the animal tied to that location from the hashmap
            landedAnimal.printAnimal(); // prints out the animal's stats
            landedAnimal.landedOn(thirdPlayer, firstPlayer, secondPlayer, fourthPlayer);// Asks the player if they want to buy the property
        }
    }

    public static void fourthTurn(Player fourthPlayer, HashMap<Integer, Animals> animalLocation, Player firstPlayer, Player secondPlayer, Player thirdPlayer, Cards card) throws InterruptedException { // P4's turn
        Dice dice = new Dice();
        line();
        System.out.println("It is " + fourthPlayer.getName() + "'s turn! (" + fourthPlayer.getSymbol() + ")\nCoins: "  + fourthPlayer.getCoins());
        Thread.sleep(400);
        System.out.println("Press enter to roll the dice...");
        dice.roll();
        Scanner input = new Scanner(System.in);
        input.nextLine(); // Waits for enter to be pressed
        System.out.println(fourthPlayer.getName() + " rolled: " + dice.getFirstRoll() + " and " + dice.getSecondRoll());
        System.out.println("Total = " + dice.getTotal());
        fourthPlayer.checkPassStart(dice.getTotal());
        fourthPlayer.changeLocation(dice.getTotal());
        System.out.println("You landed on space: " + fourthPlayer.getLocation()); // Prints out the player's location
        if (dice.isDouble()) { // roll double == pick up a card
            System.out.println("You rolled a double...\tPick up a card.");
            Thread.sleep(400);
            card.chooseCard(fourthPlayer); // chooses a card from the deck
            System.out.println("Press enter to continue...");
            input.nextLine(); // Waits for enter to be pressed
            //pick up card
        }
        if (fourthPlayer.getLocation() == 0) {
        }
        else if (fourthPlayer.getLocation() == 13) { // add miss a turn flag here

        } else {
            Animals landedAnimal = animalLocation.get(fourthPlayer.getLocation()); // gets the animal tied to that location from the hashmap
            landedAnimal.printAnimal(); // prints out the animal's stats
            landedAnimal.landedOn(fourthPlayer, firstPlayer, secondPlayer, thirdPlayer);// Asks the player if they want to buy the property

        }
    }

    // Prints a break line
    public static void line(){
        System.out.println("-------------------------");
    }
}


