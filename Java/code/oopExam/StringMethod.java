package oop_exam;

public class StringMethod {

	public static void main(String[] args) {
		
		String address = "서울특별시 서초구 효령로 176";
		boolean isSeoul = address.contains("서울");
		System.out.println(isSeoul);
		
		isSeoul = address.endsWith("176");
		System.out.println(isSeoul);
		
		String name = "ktdsuniversity";
		boolean isEqual = name.equals("ktdsUniversity");
		System.out.println(isEqual);
		
		isEqual = name.equalsIgnoreCase("ktdsUniversity");
		System.out.println(isEqual);
		
		String alphabets = "abcdefg";
		int letterCIndex = alphabets.indexOf('c');
		System.out.println(letterCIndex);

		letterCIndex = alphabets.indexOf('C');
		System.out.println(letterCIndex);
		
		int letterDEFIndex = alphabets.indexOf("def");
		System.out.println(letterDEFIndex);
		
		String message = "abcdefgaijkb";
		int letterALastIndex = message.lastIndexOf("a");
		System.out.println(letterALastIndex);

		int letterJJLastIndex = message.lastIndexOf("jj");
		System.out.println(letterJJLastIndex);
		
		int length = message.length();
		System.out.println(length);
		
		String phone = "01012341234";
		boolean isNumber = phone.matches("^[0-9]+$");
		System.out.println(isNumber);
		
		message = "안녕하세요, 홍길동님, 안녕히 가세요, 홍길동님.";
		message = message.replace("홍길동", "ktds");
		System.out.println(message);
		
		phone = "010-1234-1234";
		phone = phone.replaceAll("[^0-9]", "");
		System.out.println(phone);
		
		phone = "010-1234-1234";
		String[] phoneArea = phone.split("-");
		System.out.println(phoneArea[0]);
		System.out.println(phoneArea[1]);
		System.out.println(phoneArea[2]);
		
		phone = "+82-010-1234-1234";
		boolean isKoreaNum = phone.startsWith("+82");
		System.out.println(isKoreaNum);
		
		String datetime = "2023-05-02 14:56:13";
		String year = datetime.substring(0,4);
		System.out.println(year);
		
		String hour = datetime.substring(11,13);
		System.out.println(hour);
		
		String time = datetime.substring(11);
		System.out.println(time);
		
		datetime = "  2023-05-02 14:56:13  ";
		System.out.println(datetime.length());
		System.out.println(datetime);
		datetime = datetime.trim();
		System.out.println(datetime.length());
		System.out.println(datetime);
		
		
	}
}
