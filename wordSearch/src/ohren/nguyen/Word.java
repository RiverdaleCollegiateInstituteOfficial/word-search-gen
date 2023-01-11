package ohren.nguyen;

import java.util.ArrayList;
 
/**
 * Models a word as an ArrayList of Letters 
 * @author 345835607
 *
 */
public class Word {
	private ArrayList<Letter> letters;
	
	/**
	 * Constructor for word
	 * @param s the String to be made into a Word
	 */
	public Word(String s) {
		letters = new ArrayList<>();
		
		// Makes each character into a Letter and then adds to letters
		for (int i=0; i<s.length(); i++) {
			Letter l = new Letter(s.charAt(i));
			
			letters.add(l);
		}
	}
}
