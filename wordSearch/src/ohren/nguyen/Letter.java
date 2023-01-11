package ohren.nguyen;

import java.util.Random;

/**
 * Models a letter of the alphabet
 * 
 * @author 345835607
 *
 */
public class Letter {
	private char character; // should be an upper case letter
	
	// TODO make work for lower case letter, will probably need a boolean instance variable,
	//      or possibly a shared one so that the case is consistent
	
	/**
	 * Constructor for a letter
	 * 
	 * @param c the character (should be upper case)
	 */
	public Letter(char c) {
		character = c;

		// TODO: make robust, throw exceptions and stuff
	}

	/**
	 * Constructor for letter that chooses a random upper case character
	 */
	public Letter() {
		// ASCII upper case letters are 65 to 90, get a random number of that length and
		// then type cast to char
		Random rand = new Random();
		char c = (char) rand.nextInt(65, 91);
		character = c;
	}

	/**
	 * getter for character
	 * 
	 * @return the character
	 */
	public char getChar() {
		return character;
	}

	/**
	 * setter for character
	 * 
	 * @param c the character that character is changed to
	 * @return nothing
	 */
	public void setChar(char c) {
		character = c;
		// TODO make robust
	}

	/**
	 * toString function for Letter, 
	 * @return the character as a String **AND NOT A CHARACTER**
	 */
	@Override
	public String toString() {
		return Character.toString(character);
	}

	/**
	 * Compares an object to the Letter
	 * @return is the object was a Letter with the same character
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Letter) {
			Letter l = (Letter) o;

			if (character == l.getChar()) {
				return true;
			}
		}

		return false;

	}

}
