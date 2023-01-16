package ohren.nguyen;

import java.util.ArrayList;
import java.lang.Math;
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
	 * @param words the arraylist of Words+
	 */
	public void placeWords(ArrayList<Word> words) {
		Collections.sort(words);
		
		for (Word word : words) {
			while (!place(word)) {
				
			}
	}
}


	private boolean place(Word word) {
		Random rand = new Random();
		
		boolean isVertical = rand.nextBoolean(); // false is horizontal, true is vertical
		
		ArrayList<Integer> options = findEmpty(word, isVertical);
		
		for 
		
		return false;
	}


	private ArrayList<Integer> findEmpty(Word word, boolean isVertical) {
		ArrayList<Integer> options = new ArrayList<>();
		int count = 0;
		int count2 = 0;
		int maxSpace = 0;
		
		if (isVertical) {
			for (int x=0; x<letters.length; x++) {
				count = 0;
				count2 = 0;
				for (int y=0; y<letters[0].length; y++) {
					if (letters[x][y] == null) {
						count++;
					}
					
					else {
						if (count > count2) {
							count2 = count;
							count = 0;
						}
						
						else {
							count = 0;
						}
					}
				}
				
				maxSpace = Math.max(count, count2);
				
				if (maxSpace >= word.getLength()) {
					options.add(x);
				}
			}
		}
		
		else {
			for (int y=0; y<letters.length; y++) {
				count = 0;
				count2 = 0;
				for (int x=0; x<letters[0].length; x++) {
					if (letters[x][y] == null) {
						count++;
					}
					
					else {
						if (count > count2) {
							count2 = count;
							count = 0;
						}
						
						else {
							count = 0;
						}
					}
				}
				
				maxSpace = Math.max(count, count2);
				
				if (maxSpace >= word.getLength()) {
					options.add(y);
				}
			}
		}
		
		return options;
		
	}
}