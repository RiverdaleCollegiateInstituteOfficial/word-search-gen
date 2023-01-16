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
		
		File file = new File("list_file.txt");
		Scanner in = new Scanner(file);

		ArrayList<String> words = new ArrayList<>();
		/**
		while (in.hasNext()) {
			System.out.println(in.nextLine());
		}
		**/
		
		
		System.out.println("WORD SEARCH GENERATOR");
		System.out.println("---------------------");
		System.out.println("How ");
	}
}
