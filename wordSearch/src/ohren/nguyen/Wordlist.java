package ohren.nguyen;

import java.util.ArrayList;

public class Wordlist {
	private String name;
	private ArrayList<String> list;
	
	
	/**
	 * Constructor for a Wordlist
	 * @param s is the name of the Wordlist
	 */
	Wordlist(String s) {
		list = new ArrayList<String>();
		name = s;
	}
	
	
	/**
	 * adds word to Wordlist
	 * @param w is the Word
	 */
	public void getWord(String w) {
		list.add(w);
	}
	
	
	/**
	 * i'll add the rest
	 */
	@Override
	public String toString() {
		return name + "\n" + list;
	}
	
	
}
