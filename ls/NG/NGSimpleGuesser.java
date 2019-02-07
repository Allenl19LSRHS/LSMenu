package ls.NG;

public class NGSimpleGuesser extends NGGuesser {

	int lastGuess = 50;
	
	public int nextGuess(int answer) {
		if (answer == 1) {
			lastGuess -= 1;
			return lastGuess;
		} else if (answer == 2) {
			lastGuess += 1;
			return lastGuess;
		} else {
			return lastGuess;
		}
	}
}
