package ohren.nguyen;

import java.util.ArrayList;
import java.util.Collections;

public class Wordlist {
	private String name;
	private ArrayList<Word> list;
	
	
	Wordlist(String s) {
		name = s;
		list = new ArrayList<>();
	}
	
	
	Wordlist() {
		list = new ArrayList<>();
	}
	
	
	// *** START OF METHODS *** \\
	
	
	public String getName() {
		return name;
	}
	
	
	public int getLength() {
		return list.size();
	}
	
	
	public Word getWord(int n) {
		return list.get(n);
	}
	
	
	public void setName(String n) {
		name = n;
	}
	
	
	public void setWord(Word w) {
		list.add(w);
	}
	
	
	@Override
	public String toString() {
		/* STYLE ONE
		String output = name + ": ";
		for (int x = 0; x < list.size(); x++) {
			output += "\n" + list.get(x);
		}
		return output;
		*/
		return name + " " + list;
	}
	
	public void sort() {
		Collections.sort(list);
	}
	
	
	// *** END OF METHODS *** \\
}
