
public class IfNullPointerException { 
	
	public static void main(String[] args) {
		
		String name = null;
		
		if (name != null) {
			System.out.println(name.equals("이름"));
		}
	}

}
