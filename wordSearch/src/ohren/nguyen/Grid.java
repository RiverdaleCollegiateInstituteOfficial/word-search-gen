package ohren.nguyen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Grid {
	Letter[][] letters;
	
	/**
	 * Constructor for the Grid
	 * @param d the side of the square Grid
	 */
	public Grid(int d) {
		letters = new Letter[d][d];
	}
	
	
	/**
	 * Places a letter in a particular spot
	 * @param l
	 * @param x
	 * @param y
	 */
	public void placeLetter(Letter l, int x, int y) {
		// consider making this private
		letters[x][y] = l;
	}
	
	
	/**
	 * getter for the x dimension
	 * @return the length of the array of arrays
	 */
	public int getSideLength() {
		return letters.length;
	}
	
	
	/**
	 * @return the grid as a String
	 */
	public String toString() {
	
		//add something to check if full before trying to return a string, and throw exception if empty
		
		String s = "";
		
		for (int y=0; y<letters[0].length; y++) {
			for (int x=0; x<letters.length; x++) {
				s += letters[x][y] + " ";
			}
			s += "\n";
		}
		
		return s;
	}
	
	
	/**
	 * fills in all of the empty spots in letters
	 */
	public void fill() {
		for (int y=0; y<letters[0].length; y++) {
			for (int x=0; x<letters.length; x++) {
				if (letters[x][y] == null) {
					letters[x][y] = new Letter();
				}
			}
		}
	}
	
	/**
	 * places all of the words in an arraylist of words
	 * @param words the arraylist of Words
	 */
	public void placeWords(ArrayList<Word> words) {
		Collections.sort(words);
		
		boolean orientation;
		int limiting; // this could be x or y, if the word is horizontal than this is x
		int unlimiting; // this is the other direction
		Random rand = new Random();
		
		for (Word word : words) {
			
			limiting = rand.nextInt(0, letters.length - word.getLength());
			unlimiting = rand.nextInt(0, letters.length);
			
			
		}
	}
}
