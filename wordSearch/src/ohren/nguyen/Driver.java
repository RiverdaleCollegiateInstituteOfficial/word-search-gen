package ohren.nguyen;

public class Driver {

	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println("goodbye");
		System.out.println("happy");
		System.out.println("personal comp");
		
		// Creates a Letter object of each alphabet letter (uppercase)
		for (int n = 65; n < 91; n++) {
			Letter l = new Letter((char)n);
			System.out.println(l);
		}
	}

}
