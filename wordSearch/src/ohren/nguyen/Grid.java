package ohren.nguyen;

import java.util.ArrayList;
import java.util.HashMap;
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
		ArrayList<Word> didNotFit = new ArrayList<>();
		
		for (Word word : words) {
			boolean worked = place(word);
			
			if (!worked) {
				didNotFit.add(word);
			}
	}
}


	private boolean place(Word word) {
		Random rand = new Random();
		
		boolean isVertical = rand.nextBoolean(); // false is horizontal, true is vertical
		
		// get the possible indices for placing the word and choose one randomly
		HashMap<Integer, Integer> options = findEmpty(word, isVertical);
		ArrayList<Integer> keysAsArray = new ArrayList<Integer>(options.keySet());
		int choice = keysAsArray.get(rand.nextInt(keysAsArray.size()));
		

		// place each letter in the word
		int letterIndex = 0;
		for (int i=options.get(choice); i<word.getLength(); i++) {
			if (isVertical) {
				letters[choice][i] = word.getLetter(letterIndex);
			}
			
			else {
				letters[i][choice] = word.getLetter(letterIndex);
			}
			
			letterIndex++;
		}
	
		
		return false;
	}


	/**
	 * finds the row or columns that have enough empty spaces to place the words
	 * @param word the Word to be placed
	 * @param isVertical if the word should be placed horizontally or vertically
	 * @return 
	 * @return a HashMap of possible indices 
	 */
	private HashMap<Integer, Integer> findEmpty(Word word, boolean isVertical) {
		HashMap<Integer, Integer> options = new HashMap<>();
		int startingIndex = 0;
		int tempStartingIndex = 0;
		int count = 0;
		int tempMax = 0;
		int maxSpace = 0;
		
		// if the word is to be placed vertically find the columns with enough space for the word
		if (isVertical) {
			for (int x=0; x<letters.length; x++) {
				count = 0; // the current number of empty spaces in a row
				tempMax = 0; // the longest length of blank spaces so far
				for (int y=0; y<letters[0].length; y++) {
					if (letters[x][y] == null) {
						count++; // if there is not a letter there yet, increase the count
					}
					
					// if there is a letter then make sure tempMax is the longest so far, and count is empty
					else {
						if (count > tempMax) {
							tempMax = count;
							count = 0;
							startingIndex = tempStartingIndex;
							tempStartingIndex = y + 1;
						}
						
						else {
							count = 0;
							tempStartingIndex = y + 1;
						}
					}
				}
				
				maxSpace = Math.max(count, tempMax); // the longest contiguous stretch of empty squares
				
				if (maxSpace >= word.getLength()) {
					options.put(x, startingIndex); // add to the possible indices
				}
			}
		}
		
		// everything above, but for horizontal words
		else {
			for (int y=0; y<letters.length; y++) {
				count = 0;
				tempMax = 0;
				for (int x=0; x<letters[0].length; x++) {
					if (letters[x][y] == null) {
						count++;
					}
					
					else {
						if (count > tempMax) {
							tempMax = count;
							count = 0;
							startingIndex = tempStartingIndex;
							tempStartingIndex = x + 1;
						}
						
						else {
							count = 0;
							tempStartingIndex = x + 1;
						}
					}
				}
				
				maxSpace = Math.max(count, tempMax);
				
				if (maxSpace >= word.getLength()) {
					options.put(y, startingIndex);
				}
			}
		}
		
		return options;
		
	}
}