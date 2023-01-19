package ohren.nguyen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.Math;
import java.util.Collections;
import java.util.Random;

public class Grid {
	Letter[][] letters;
	ArrayList<Word> didNotFit;
	
	/**
	 * Constructor for the Grid
	 * @param d the side of the square Grid
	 */
	public Grid(int d) {
		letters = new Letter[d][d]; // TODO change to be full of spaces instead of null
		didNotFit = new ArrayList<>();
	}
	
	
	/**
	 * Places a letter in a particular spot
	 * @param l
	 * @param x
	 * @param y
	 */
	public void placeLetter(Letter l, int x, int y) {
		// consider making this private
		letters[x][y] = l; // haven't used this, might delete
	}
	
	
	/**
	 * getter for the x dimension
	 * @return the length of the array of arrays
	 */
	public int getSideLength() {
		return letters.length;
	}
	
	
	/**
	 * Makes a string of words that did not fit in the grid
	 * @return
	 */
	public String getDidNotFit() {
		String didNotFitStr = "";
		for (Word word : didNotFit) {
			didNotFitStr += word.toString() + "\n";
		}
		
		return didNotFitStr;
	}
	
	
	/**
	 * @return the grid as a String
	 */
	@Override
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
	public void placeWords(Wordlist words) {
		//Collections.sort(words);
		int tries;
		boolean worked;
		
		for (int i = 0; i < 3; i++) {
			tries = 0;
			Word word = words.getWord(i);
			
			worked = place(word);
			
			while (!worked) {
				if (tries < 5) {
					worked = place(word);
					tries++;
				}
				
				else {
					didNotFit.add(word);
					System.out.println(word);
					worked = true; // this isn't really true, but we need to get out of the loop
				}
		}
	}
}


	private boolean place(Word word) {
		Random rand = new Random();
		boolean isVertical = rand.nextBoolean(); // false is horizontal, true is vertical
		// copy letters array, in a way that makes another array, not a reference
		// use this array to attempt to place words, only update the actual array if it works
		// this should probably be its own method
		
		// get the possible indices for placing the word and choose one randomly
		HashMap<Integer, Integer> options = findEmpty(word, isVertical);
		ArrayList<Integer> keysAsArray = new ArrayList<Integer>(options.keySet());
		
		if (keysAsArray.size() == 0) {
			return false;
		}
		
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
			
			if (letterIndex == word.getLength()) {
				System.out.println("worked");
				return true;
			}
		}
	
		// TODO undo changes if did not work
		
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
		int count = 0; // the current number of empty spaces in a row
		int tempMax = 0; // the longest length of blank spaces so far
		int maxSpace = 0;
		
		// if the word is to be placed vertically find the columns with enough space for the word
		if (isVertical) {
			for (int x=0; x<letters.length; x++) {
				count = 0; 
				tempMax = 0; 
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
				
				//maxSpace = Math.max(count, tempMax); // the longest contiguous stretch of empty squares
				
				if (count > tempMax) {
					maxSpace = count;
					startingIndex = tempStartingIndex;
				}
				
				else {
					maxSpace = tempMax;
				}
				
				System.out.format("%s: max: %d column: %d starting: %d\n", word, maxSpace, x, startingIndex);
				
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
				
				if (count > tempMax) {
					maxSpace = count;
					startingIndex = tempStartingIndex;
				}
				
				else {
					maxSpace = tempMax;
				}
				
				System.out.format("%s: max: %d row: %d starting: %d\n", word, maxSpace, y, startingIndex);
				
				if (maxSpace >= word.getLength()) {
					options.put(y, startingIndex);
				}
			}
		}
		
		return options;
		
	}
}