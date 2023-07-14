package br.com.souowendy;

import java.util.Scanner;

/**
 * @author souowendy
 */
public class GuessingGame {
	private final int NUMBER_OF_TRIES;
	private final int SECRET_NUMBER;
	
	private boolean isGuessCorrect;
	private Scanner scanner;
	
	public GuessingGame() {
		NUMBER_OF_TRIES = 5;
		SECRET_NUMBER = (int) (Math.random() * 100);
		isGuessCorrect = false;
	}
	
	public void play() {
		int triesCounter = 0;
		scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Number Guessing Game!");
		System.out.println("The number is between 1 and 100");
		System.out.println("You have " + NUMBER_OF_TRIES + " tries.");
		System.out.println("Good luck!\n");
		
		while (!isGuessCorrect && triesCounter < 5) {
			int playerGuess = getGuessFromPlayer();
			checkGuess(playerGuess);
			triesCounter++;
		}
		
		scanner.close();
		
		finishGame();
	}
	
	private int getGuessFromPlayer() {
		int guess;
		
		System.out.print("Your guess: ");
		guess = scanner.nextInt();
		
		return guess;
	}
	
	private void checkGuess(int guess) {
		if (guess == SECRET_NUMBER) {
			isGuessCorrect = true;
			System.out.println("You guessed correctly!");
		} else if (guess > SECRET_NUMBER) {
			System.out.println("Too high!");
		} else {
			System.out.println("Too low!");
		}
	}
	
	private void finishGame() {
		if(isGuessCorrect) {
			System.out.println("\nCongratulations! You win!");
		} else {
			System.out.println("\nYou failed!");
			System.out.println("The number is: " + SECRET_NUMBER);
		}
	}
}

