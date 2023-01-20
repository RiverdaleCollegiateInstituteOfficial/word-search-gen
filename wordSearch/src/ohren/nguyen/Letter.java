package ohren.nguyen;

import java.util.Random;

//took out: setChar method, equals method <-- leave in
public class Letter {
	private char character;
	
	
	// TODO: typecast inside constructor instead?
	public Letter(char c) {
		character = c;
	}
	
	
	// TODO: ask
	public Letter(String s) {
		character = s.charAt(0);
	}
	
	
	public Letter() {
		// ASCII upper case letters are 65 to 90
		// Get a random number within that range and type cast into char
		Random rand = new Random();
		char c = (char) rand.nextInt(65, 91);
		character = c;
	}
	
	
	// *** START OF METHODS *** \\
	
	
	public char getChar() {
		return character;
	}
	
	
	@Override
	public String toString() {
		return Character.toString(character);
	}
	
	
	// *** END OF METHODS *** \\
}