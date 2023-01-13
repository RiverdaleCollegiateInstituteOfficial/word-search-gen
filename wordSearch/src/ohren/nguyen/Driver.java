package ohren.nguyen;


public class Driver {
	public static void main(String[] args) {
		/*
		System.out.println("hello");
		System.out.println("goodbye");
		System.out.println("happy");
		System.out.println("personal comp");
		*/
		
		
		/* --- TESTING --- 
		
		//** WORKS 13/01/23 **\\
		// Creates a Letter object of each alphabet letter (uppercase)
		for (int n = 65; n < 91; n++) {
			Letter l = new Letter((char)n);
			System.out.println(l);
		}
		
		//** WORKS 13/01/23 **\\
		// Creates random letters
		Letter r = new Letter();
			System.out.println(r);
		Letter r2 = new Letter();
			System.out.println(r2);
		Letter r3 = new Letter();
			System.out.println(r3);
		
		--- TESTING END --- */ 
		
		Letter r = new Letter();
			System.out.println(r);
		
		String name = "zalea";
		String name2 = "ohren";
		char c = r.getChar();
		System.out.println(name + name2);
		System.out.println(name + c);
	}
}
