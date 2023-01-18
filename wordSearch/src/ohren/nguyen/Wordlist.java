package ohren.nguyen;

import java.util.ArrayList;

public class Wordlist {
	private String name;
	private ArrayList<Word> list;
	
	
	/**
	 * Constructor for a Wordlist
	 * @param s is the name of the Wordlist
	 */
	Wordlist(String s) {
		list = new ArrayList<>();
		name = s;
	}
	
	/**
	 * 
	 * @param s
	 */
	Wordlist() {
		list = new ArrayList<>();
	}
	
	
	//take out later
	public void getList() {
		System.out.println(list);
	}
	
	
	public void setWord(Word w) {
		list.add(w);
	}
	
	
	public Word getWord(int i) {
		return list.get(i);
	}
	
	
	
	/**
	 * i'll add the rest
	@Override
	public String toString() {
		return name + "\n" + list;
	}
	**/
	
	
}
