package ohren.nguyen;

import java.util.ArrayList;

public class Wordlist {
	private String name;
	private ArrayList<Word> list;
	
	
	/**
	 * Constructor for a Wordlist
	 * @param s is the name of the Wordlist
	 */
	Wordlist() {
		list = new ArrayList<>();
		//name = s;
	}
	
	
	//take out later
	public void getList() {
		System.out.println(list);
	}
	
	
	public void setWord(Word w) {
		list.add(w);
	}
	
	
	public Word getWord(int i) {
		return list.get(0);
	}
	
	
	
	/**
	 * i'll add the rest
	@Override
	public String toString() {
		return name + "\n" + list;
	}
	**/
	
	
}
