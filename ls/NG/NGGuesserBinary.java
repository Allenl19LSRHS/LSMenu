package ls.NG;

public class NGGuesserBinary extends NGGuesser {

	int guess = 50;
	int prevGuess = 51;
	int highestGuess = 101;
	int lowestGuess = 1;
	
	public int nextGuess(int answer) {
		if (answer == 1) {
			highestGuess = guess;
			guess = (highestGuess+lowestGuess)/2;
		} else if (answer == 2) {
			lowestGuess = guess;
			guess = (highestGuess+lowestGuess)/2;
		} else {
			return guess;
		}
		
		if (guess == prevGuess) {
			return (-1);
		} else {
			prevGuess = guess;
			return guess;
		}
	}
}
