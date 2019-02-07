package ls.NG;

import java.util.Random;

public class NGRandomGuesser extends NGGuesser {
	int guess = 50;
	int lowestGuess = 1;
	int highestGuess = 100;
	int lastGuess = 51;
	Random rand = new Random();
	
	public int nextGuess(int answer) {
		if (answer == 1) {
			lowestGuess = guess;
			if (highestGuess - lowestGuess <= 0) {
				return -1;
			}
			guess = rand.nextInt(highestGuess - lowestGuess) + lowestGuess;
		} else if (answer == 2) {
			highestGuess = guess;
			if (highestGuess - lowestGuess <= 0) {
				return -1;
			}
			guess = rand.nextInt(highestGuess - lowestGuess) + lowestGuess;
		} else {
			return guess;
		}
		
		if (lastGuess == guess) {
			return -1;
		} else {
			lastGuess = guess;
			return guess;			
		}
	}
}
