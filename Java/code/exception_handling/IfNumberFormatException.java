
public class IfNumberFormatException {

	public static void main(String[] args) {
		
		String numString = "123";
		if (numString.matches("^[0-9]+$")) {
			int num = Integer.parseInt(numString);
			System.out.println(num);
		}
		
		numString = "ABC";
		if (numString.matches("^[0-9]+$")) {
			int num = Integer.parseInt(numString);
			System.out.println(num);
		}
	
	}

}
