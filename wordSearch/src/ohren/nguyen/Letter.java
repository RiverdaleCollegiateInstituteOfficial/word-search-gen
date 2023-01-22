package ohren.nguyen;

import java.util.Random;

// ask what we use first 2 constructors for
public class Letter {
	private char character;
	
	
	// TODO: typecast inside constructor instead?
	/**
	 * Creates
	 * @param c is the char type of the letter
	 */
	public Letter(char c) {
		character = c;
	}
	
	
	/**
	 * 
	 * @param s is the String type of the letter
	 */
	public Letter(String s) {
		character = s.charAt(0);
	}
	
	
	/**
	 * Constructor for creating a Letter object of a random letter 
	 */
	public Letter() {
		// ASCII upper case letters are 65 to 90
		// Get a random number within that range and type cast into char
		Random rand = new Random();
		char c = (char) rand.nextInt(65, 91);
		character = c;
	}
	
	
	// *** START OF METHODS *** \\
	
	
	/**
	 * Returns the char type of the letter
	 * @return
	 */
	public char getChar() {
		return character;
	}
	
	
	/**
	 * Returns the string of the letter
	 */
	@Override
	public String toString() {
		return Character.toString(character);
	}
	
	
	// *** END OF METHODS *** \\
}