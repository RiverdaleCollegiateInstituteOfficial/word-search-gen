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
		
		
		//ArrayList<Wordlist> words_list = new ArrayList<>();
		
		
		/** doesn't take second wordlist
		File file = new File("list_file.txt");
		Scanner in = new Scanner(file);
		String f = "";
		
		ArrayList<String> words = new ArrayList<>();
		
		while (in.hasNext()) {
			String line = in.nextLine();
			if (line.length() == 0) {
				System.out.println(words);
				words.clear();
			}
			else {
				words.add(line);
			}
		}
		in.close();	
		**/
		
		
		
		
		// MENU INTERFACE
		/**
		System.out.println("WORD SEARCH GENERATOR");
		System.out.println("---------------------");
		**/
		
		
		Wordlist words = new Wordlist();
		
		Scanner in2 = new Scanner(System.in);
		
		// change x-value
		for (int x = 0; x < 3; x++) {
			String w = "";
			w = in2.nextLine();
			Word word = new Word(w);
			words.setWord(word);
		}
		
		words.getList();
	}
}
