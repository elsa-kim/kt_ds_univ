package hello_java_world;

public class ArithmaticOperator {
	public static void main(String[] args) {
		/*
		int number1 = 10;
		number1 = number1 + 2;
		System.out.println(number1);
		
		int number2 = 10;
		number2 = number2 - 2;
		System.out.println(number2);
		
		int number3 = 10;
		number3 = number3 * 2;
		System.out.println(number3);
		
		int number4 = 10;
		number4 = number4 / 4;
		System.out.println(number4);
		
		int number5 = 10;
		number5 = number5 % 4;
		System.out.println(number5);
		*/
		
		// 단항연산자
		int number1 = 10;
		number1 += 2;
		System.out.println(number1);
		
		int number2 = 10;
		number2 -= 2;
		System.out.println(number2);
		
		int number3 = 10;
		number3 *= 2;
		System.out.println(number3);
		
		int number4 = 10;
		number4 /= 4;
		System.out.println(number4);
		
		int number5 = 10;
		number5 %= 4;
		System.out.println(number5);
		
		int num1 = 10;
		int num2 = 20;
		
		// num1++;
		// num2++;
		
		System.out.println(num1);
		System.out.println(num2);
		
		System.out.println(num1++);
		System.out.println(num2++);
		
		System.out.println(++num1);
		System.out.println(++num2);
		
	}

}
