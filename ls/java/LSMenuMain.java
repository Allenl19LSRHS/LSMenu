package ls.java;

import ls.java.menu.*;
import ls.NG.*;

public class LSMenuMain {

	public static void main(String[] args) {
		LSLetterMenu myMenu1 = new LSLetterMenu("Just a test...");
		myMenu1.addItem("rock");
		myMenu1.addItem("paper");
		myMenu1.addItem("scissors");
		myMenu1.addItem("spock");
		myMenu1.addItem("police");
		myMenu1.addItem("part");
		int qwer = myMenu1.displayAndChooseSingleLine();
		System.out.println("Choice = " + qwer);
		
		
		// Pretty much copy pasted all NumberGuesser code in, adapted the main to use a couple
		// variations of LSMenu
		boolean run = true;
		
		while (run) {
			System.out.println("Welcome to Number Guesser! Think of a number from 1 to 100");
			System.out.println("Enter + if I need to guess higher, - if I need to guess lower, or = if I guessed your number");
			System.out.println("");
			int answer = 0;
			
			NGGuesser guesser;
			LSLetterMenu myMenu = new LSLetterMenu("Which mode of guessing do you want, simple, random, or binary?  ");
			myMenu.addItem("simple");
			myMenu.addItem("random");
			myMenu.addItem("binary");
			int choice = myMenu.displayAndChooseSingleLine();
			
			if (choice == 1) {
				guesser = new NGSimpleGuesser();
			} else if (choice == 2) {
				guesser = new NGRandomGuesser();
			} else {
				guesser = new NGGuesserBinary();
			}
			
			LSMenu responseMenu = new LSMenu("Do I need to guess higher (+), lower (-) or did I guess it (=)?");
			responseMenu.addItem("-");
			responseMenu.addItem("+");
			responseMenu.addItem("=");
			do {
				int guess = guesser.nextGuess(answer);
				if (guess == -1) {
					System.out.println("This is the only possibility given the answers you returned!");
					break;
				} else {
					System.out.println("My guess is " + guess);
					answer = responseMenu.displayAndChoose();
				}	
				
			} while (answer != 3);
			System.out.println("I guessed it!");
			
			LSLetterMenu replayMenu = new LSLetterMenu("Do you want to play again?  ");
			replayMenu.addItem("y");
			replayMenu.addItem("n");
			int replay = replayMenu.displayAndChooseSingleLine();
			
			if (replay == 2) {
				run = false;
			}
		}
	}
}
