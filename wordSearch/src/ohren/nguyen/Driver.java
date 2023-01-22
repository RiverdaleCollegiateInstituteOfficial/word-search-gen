package ohren.nguyen;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

// TODO:
// make proper docstrings, comments, implement grid feature
public class Driver {
	
	
	// SPACE
	public static void space() {
		System.out.println("");
	}
	
	
	// To avoid immediately going back to menu
	public static void pause(Scanner in) {
		String choice = "";
		System.out.println("Are you done?");
		System.out.print("Type 'y' if you are: ");
		while (!(choice.equals("y"))) {
			choice = in.nextLine();
		}
	}
	
	
	// MAIN METHOD
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String choice = "";
		while (!(choice.equals("4"))) {
			System.out.println("WORD SEARCH GENERATOR");
			System.out.println("---------------------");
			System.out.println("Enter 1 to view the wordlists.");
			System.out.println("Enter 2 to create a new wordlist.");
			System.out.println("Enter 3 to generate a word search.");
			System.out.println("Enter 4 to quit.");
			System.out.print("CHOICE: ");
			choice = in.nextLine();
			if (choice.equals("1")) {
				viewWordlists(in);
				pause(in);
			}
			else if (choice.equals("2")) {
				newWordlist(in);	
			}
			else if (choice.equals("3")) {
				generate(in);
				pause(in);
			}
			else if (choice.equals("4")) {
				in.close();
			}
			else {
				System.out.println("That was not an option. Choose again.");
			}
			space();
			space();
			space();
		}	
	}
	
	
	// *** START OF METHODS *** \\
	
	
	// MENU OPTION - 1
	/**
	 * Views all of the available stored word lists in the File
	 * @param in is the Scanner object
	 * @throws FileNotFoundException 
	 */
	public static void viewWordlists(Scanner in) throws FileNotFoundException {
		ArrayList<Wordlist> lists = getLists();
		space();
		for (int x = 0; x < lists.size(); x++) {
			System.out.println((x + 1) + ": " + lists.get(x));
		}
		space();
	}
	
	
	/**
	 * Reads all the word lists in the File and stores it as a Wordlist object in an ArrayList<Wordlist>
	 * @return a list containing all of the Wordlists
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Wordlist> getLists() throws FileNotFoundException {
		ArrayList<Wordlist> lists = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		
		File file = new File("file.txt");
		Scanner inFile = new Scanner(file);
		
		while (inFile.hasNext()) {
			String line = inFile.nextLine();
			if (line.equals("")) {
				Wordlist wordlist = new Wordlist(temp.get(0));
				temp.remove(0);
				for (String w: temp) {
					Word word = new Word(w);
					wordlist.setWord(word);
				}
				temp.clear();
				lists.add(wordlist);
			}
			else {
				temp.add(line);
			}
		}
		inFile.close();
		return lists;
	}
	
	
	// MENU OPTION - 2
	/**
	 * @param in is the Scanner object
	 * @throws IOException 
	 */
	public static void newWordlist(Scanner in) throws IOException {
		space();
		ArrayList<Wordlist> lists = getLists();
		Wordlist newSet = createWordlist(in);
		String input = "";
		for (Wordlist w: lists) {
			input += w.getName() + "\n";
			for (int x = 0; x < w.getLength(); x++) {
				input += w.getWord(x) + "\n";
			}
			input += "\n";
		}
		input += newSet.getName() + ":\n";
		for (int x = 0; x < newSet.getLength(); x++) {
			input += newSet.getWord(x) + "\n";
		}
		
		input += "\n---";
		//System.out.println(input);
		overwrite(input);
	}
	
	
	// Creates a new Wordlist using user input
	/**
	 * 
	 * @param in
	 * @return
	 */
	public static Wordlist createWordlist(Scanner in) {
		Wordlist tempWordlist = new Wordlist();
		System.out.println("Let's create a new wordlist.");
		System.out.print("What is the name of this list? : ");
		String name = in.nextLine();
		tempWordlist.setName(name);
		space();
		System.out.print("How many words do you want? Enter an integer: ");
		int n = in.nextInt(); 

		// TODO: could try making integer input more robust
		in.nextLine();
		for (int x = 0; x < n; x++) {
			System.out.print("WORD #" + (x + 1) + ": ");
			Word word = new Word(in.nextLine());
			tempWordlist.setWord(word);
		}
		return tempWordlist;
	}
	
	
	// Write in File
	/**
	 * 
	 * @param str
	 * @throws IOException
	 */
	public static void overwrite(String str) throws IOException {
		File result = new File("file.txt");
		FileWriter fw = new FileWriter(result);
			fw.write(str);
		fw.flush();
		fw.close();
	}
	
	
	// MENU OPTION - 3
	/**
	 * @param in is the Scanner object
	 * @throws FileNotFoundException 
	 */
	public static void generate(Scanner in) throws FileNotFoundException {
		String wordlistChoice = "";
		space();
		System.out.println("Would you like to use a created wordlist or "
				+ "enter new words right now?");
		System.out.println("Enter 1 for a created wordlist.");
		System.out.println("Enter 2 for new words right now.");
		System.out.print("CHOICE: ");
		
		while (!(wordlistChoice.equals("1")) && !(wordlistChoice.equals("2"))) {
			wordlistChoice = in.nextLine();
			if (wordlistChoice.equals("1")) {
				viewWordlists(in);
				ArrayList<Wordlist> lists = getLists();
				System.out.println("Enter the number of the wordlist you would like: ");
				int n = in.nextInt() - 1; // TODO: make integer input robust
				in.nextLine();
				/*
				System.out.println("TESTING: " + lists.size());
				System.out.println("TESTING: " + n + " ");
				*/
				// TODO: fixing this LATER
				while (n > lists.size() - 1|| n < 0) {
					System.out.println("This is not a valid number. Enter again.");
					n = in.nextInt() - 1;
					in.nextLine();
				}
				// TODO: make grid with "lists.get(n)"
				makeGrid(lists.get(n));
			}
			else if (wordlistChoice.equals("2")) {
				// TODO: take new words and make grid
				// TODO: make grid with "createWordlist(in)"
				makeGrid(createWordlist(in));
			}
			else {
				System.out.println("That was not an option. Choose again.");
			}
		}
	}
	
	
	/**
	 * Creates a word search grid using a Wordlist object
	 * @param w
	 */
	public static void makeGrid(Wordlist w){
		space();
		
		// sort wordlist to find longest word and set the grid size to the length of the longest word plus 2
		w.sort();
		
		Grid grid = new Grid(w.getWord(0).getLength()+2);
		grid.placeWords(w);
		grid.fill();
		System.out.println(grid);
		
		System.out.println(w); // for testing
		System.out.println(grid.getDidNotFit()); // see what didn't fit, might want to label later
		space();
	}
	
	
	// *** END OF METHODS *** \\
}