package hello_java_world;

public class IfExam1 {
	public static void main(String[] args) {
		// if else
		int number = 7;
		if (number == 5) {
			System.out.println("숫자가 5와 같습니다.");
		}
		else if (number== 7) {
			System.out.println("숫자가 7과 같습니다.");
		}
		else {
			System.out.println("숫자가 5, 7이 아닙니다.");
		}
		
		if (number == 5) {
			int number2 = 1;
			System.out.println(number);
			System.out.println(number2);
		}
		else {
			int number2 = 2;
			System.out.println(number);
			System.out.println(number2);
		}
		
		System.out.println(number);
//		System.out.println(number2);
		
		
		// System.out.println(Math.random());
		double randomNumber = Math.random();
		
		// double 타입의 난수를 정수로 변환 0~99
		int answer = (int) (randomNumber*100);
		int value = 60;
		
		if (answer == value) {
			System.out.println("정답입니다!");
		}
		else if (answer > value) {
			System.out.println("UP!");
		}
		else if (answer < value) {
			System.out.println("DOWN!");
		}
		
		System.out.println("정답은 "+answer+"입니다.");
	}

}
