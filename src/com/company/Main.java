package com.company;//Candice Cobb Guessing Game
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        printGreeting();
        playTheGame();
        System.out.println("Bye - Come back soon!");

    }
    //welcome statements method
    public static void printGreeting() {
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
    //random number generator method
    public static int getRandom() {
        System.out.println("\nI'm thinking of a number from 1 to 100. \nTry to guess it.");
        Random randNum = new Random();
        return randNum.nextInt(100) + 1;
    }
    //get user input method
    public static int getInput() {
        System.out.print("\nEnter Number: ");
        Scanner inputNum = new Scanner(System.in);
        return inputNum.nextInt();
    }
    //validate user's guess is btw 1-100 method
    public static boolean isValid(int userGuess) {
        if (userGuess > 100 || userGuess < 1) {
            System.out.println("Error: Please enter a number between 1 and 100");
            return false;
        }
        else return true;
    }
    //check if user number is correct
    public static boolean isCorrect(int userGuess, int targetNumber) {
        if (userGuess == targetNumber) {
            return true;
        }
        else {
            highLow(userGuess,targetNumber);
            return false;
        }
    }
    //evaluates if guess is too high or too low
    public static void highLow (int userGuess, int targetNumber) {
        if (userGuess > targetNumber) {
            if (userGuess - 10 > targetNumber) {
                System.out.println("Way too high!");
            }
            else System.out.println("Too high!");
        }
        else if (userGuess < targetNumber) {
            if (userGuess + 10 < targetNumber) {
                System.out.println("Way too low!");
            }
            else System.out.println("Too low!");
        }
    }
    //try again method
    public static boolean tryAgain() {
        Scanner input = new Scanner(System.in);
        char x;
        while (true){
            System.out.println("Try again? (y/n):");
            x = input.next().charAt(0);
            if (x == 'y' || x == 'n') {
                break;
            }
            else if (x == ' ') {
                System.out.println("This entry is required. Try again. ");
            }
            else {
                System.out.println("Error! Entry much be 'y' or 'n'. Try again. ");
            }
        }

        return x == 'y';
    }
    public static void playTheGame() {
        int targetNumber = getRandom();
        int userGuess;
        int numberOfGuesses = 0;
        do {
            do {
                userGuess = getInput();
            }
            while (!isValid(userGuess));
            numberOfGuesses++;
        } while (!isCorrect(userGuess, targetNumber));
        //user has guessed correctly
        System.out.println("You got it in " + numberOfGuesses + " tries.");
        if (numberOfGuesses <= 3) {
            System.out.println("Great work! You are a guessing wizard.");
        }
        else if (numberOfGuesses > 3 && numberOfGuesses <= 7) {
            System.out.println("Not too bad! You've got some potentional.");
        }
        else {
            System.out.println("What took so long? Maybe you should take some lessons.");
        }
        if (tryAgain()) {
            playTheGame();
        }
    }
}

