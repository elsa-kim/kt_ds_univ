package hello_java_world;

public class HelloJava {
	/*
	 * Document (주석)
	 * 주석 : 코드의 설명을 위한 영역
	 */
	public static void main(String[] args) {
		System.out.println("Hello, Java World");
		// int형 number 변수 정의
		// double number;
		
		//number변수에 값 할당
		// number=3.14;
		
		//int number=20;
		
		// 실습
		byte byteNumber = 1;
		byteNumber = 2;
		System.out.println(byteNumber);
		
		short shortNumber = 10;
		shortNumber=11;
		System.out.println(shortNumber);
		
		int intNumber = 20;
		intNumber = 21;
		System.out.println(intNumber);
		
		long longNumber = 30L;
		longNumber=31L;
		System.out.println(longNumber);
		
		float floatNumber = 10.55f;
		System.out.println(floatNumber);
		
		double doubleNumber = 11.556;
		System.out.println(doubleNumber);
		
		char letter = 'A';
		System.out.println(letter);
		System.out.println(letter+1);
		
		letter = 'B';
		System.out.println(letter);
		System.out.println(letter+1);
		
		letter = '1';
		System.out.println(letter);
		System.out.println(letter+1);
		
		boolean areYouStudent = true;
		System.out.println(areYouStudent);
		
		boolean areYouDesigner = false;
		System.out.println(areYouDesigner);
		
		final int SPEED_OF_LIGHT = 299_792_458;
		System.out.println(SPEED_OF_LIGHT);
		
		// SPEED_OF_LIGHT = 10;
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
//		int normalNumber = Integer.MAX_VALUE;
//		long bigNumber = normalNumber;
//		System.out.println(normalNumber);
//		System.out.println(bigNumber);
		
		long bigNumber = Integer.MAX_VALUE + 1L;
		int normalNumber = (int) bigNumber;
		System.out.println(bigNumber);
		System.out.println(normalNumber);
		
		bigNumber = Integer.MAX_VALUE + 2L;
		normalNumber = (int) bigNumber;
		System.out.println(bigNumber);
		System.out.println(normalNumber);
		
		/*
		// 정수->부동소수점 형변환
		int num = 10;
		float fnum = num;
		double dnum = num;
		
		System.out.println(num);
		System.out.println(fnum);
		System.out.println(dnum);
		
		// 부동소수점->정수 형변환
		float fnum2 = 10.9f;
		int num2 = (int) fnum2;
		System.out.println(fnum2);
		System.out.println(num2);
		
		double dnum2 = 11.15;
		num2 = (int) dnum2;
		System.out.println(dnum2);
		System.out.println(num2);
		*/
		
		double dnum = 29.37;
		double dnum2 = dnum*10;
		System.out.println(dnum2);
		
		dnum2 = Math.round(dnum2);
		System.out.println(dnum2);
		
		double dnum3 = dnum2/10;
		System.out.println(dnum3);
		
		int number= 10;
		int addedNumber = number+2;
		System.out.println(addedNumber);
		
		int subtractedNumber = number-3;
		System.out.println(subtractedNumber);
		
		int multipliedNumber = number*3;
		System.out.println(multipliedNumber);
		
		int devidedNumber = number/3;
		System.out.println(devidedNumber);

		double devidedNumber2 = number/3.0;
		System.out.println(devidedNumber2);
		
		int devideRemainNumber = number%3;
		System.out.println(devideRemainNumber);
		
		
		
		
	}

}
