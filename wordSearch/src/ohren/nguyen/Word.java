package ohren.nguyen;

import java.util.ArrayList;
 
/**
 * Models a word as an ArrayList of Letters 
 *
 */
public class Word implements Comparable<Word>{
	private ArrayList<Letter> letters;	// all the letters as Letter objects in the word
	private String word;				// String of the word
	
	
	/**
	 * Constructor for word
	 * @param s the String to be made into a Word
	 */
	public Word(String s) {
		word = s.toUpperCase();
		word = s;
		letters = new ArrayList<>();
		
		// Makes each character into a Letter and then adds to letters
		for (int i=0; i<s.length(); i++) {
			Letter l = new Letter(s.charAt(i));
			
			letters.add(l);
		}
	}
	
	
	/**
	 * Gets the length of the word
	 * @return the length of the word
	 */
	public int getLength() {
		return letters.size();
	}
	
	
	/**
	 * @param n the letters<ArrayList> index of the Letter wanted
	 * @return the Letter at index n
	 */
	public Letter getLetter(int n) {
		return letters.get(n);
	}
	
	
	/**
	 * @return word as a String
	 */
	public String toString() {
		return word;
	}


	@Override
	public int compareTo(Word w) {
		if (word.length() > w.getLength()) {
			return -1;
		}
		else if (word.length() < w.getLength()) {
			return 1;
		}
		return 0;
	}
}

