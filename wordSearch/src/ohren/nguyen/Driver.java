package ohren.nguyen;


import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


public class Driver {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		// Creates a Letter object of each alphabet letter (uppercase)
		for (int n = 65; n < 91; n++) {
			Letter l = new Letter((char)n);
			System.out.println(l);
		}
		*/
		
		/**
		// the array list with all of the different word lists
		ArrayList<Wordlist> words_list = new ArrayList<>();
		
		// the file containing all the word lists
		File file = new File("list_file.txt");
		Scanner in = new Scanner(file);
		
		// all the words in one wordlist + the name from the file / one section
		ArrayList<String> tempWords = new ArrayList<>();
		
		
		// while there still is a line in the file to read
		while (in.hasNext()) {
			String line = in.nextLine();
			// if the line is an empty line, we have finished reading one wordlist in the file
			if (line.equals("")) {
				System.out.println(tempWords);
				Wordlist w = new Wordlist(tempWords.get(0));
				tempWords.remove(0);
				tempWords.clear();
			}
			else {
				tempWords.add(line);
			}
		}
		System.out.println(tempWords);
		in.close();	
		
		*/
		
		// MENU INTERFACE
		/**
		System.out.println("WORD SEARCH GENERATOR");
		System.out.println("---------------------");
		**/
		
		
		
		Wordlist words = new Wordlist();
		Grid grid = new Grid(15);
		
		Scanner in2 = new Scanner(System.in);
		
		// change x-value
		for (int x = 0; x < 3; x++) {
			String w = "";
			w = in2.nextLine();
			Word word = new Word(w);
			words.setWord(word);
		}
		
		words.getList();
		
		grid.placeWords(words);
		grid.fill();
		
		System.out.println(grid);
		System.out.println(grid.getDidNotFit());
		
	}
}
