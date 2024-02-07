package fp_java.ch01.lambda;

public class Main {
	public static void main(String[] args) {
		
		// 람다 작성법
		//( ) -> code
		//param -> code
		
		// 익명클래스
		Computable computer1 = new Computable() {
			@Override
			public int add(int num1, int num2) {
				return num1 + num2;
			}
		};
		int addResult = computer1.add(10, 20);
		System.out.println(addResult);
		
		// 람다 (정석)
		Computable lambdaComputer = (int num1, int num2) -> num1 + num2;
		int lambdaResult = lambdaComputer.add(10, 20);
		System.out.println(lambdaResult);
		
		// 람다 (실무)
		Computable lambdaComputer2 = (num1, num2) -> num1 + num2;
		int lambdaResult2 = lambdaComputer2.add(30, 10);
		System.out.println(lambdaResult2);
		
		// 람다 (여러줄 코딩)
		Computable lambdaComputer3 = (num1, num2) -> {
			System.out.println("> " + num1);
			System.out.println("> " + num2);
			return num1+num2;
		};
		int lambdaResult3 = lambdaComputer3.add(4, 2);
		System.out.println(lambdaResult3);
		
		lambdaComputer3.printMessage();
		
		//익명클래스
		Printable printer = new Printable() {
			@Override
			public void print() {
				System.out.println("출력합니다.");
			}
		};
		printer.print();
		
		//람다
		Printable printer2 = () -> System.out.println("출력합니다.");
		printer2.print();
		
		Printable printer3 = () -> {
			System.out.println("출력합니다.");
		};
		printer3.print();
		
		//익명클래스
		RandomExtractable random = new RandomExtractable() {
			@Override
			public double getRandom() {
				return Math.random();
			}
		};
		double randomNumber = random.getRandom();
		System.out.println(randomNumber);
		
		//람다
		RandomExtractable random2 = () -> Math.random();
		double randomNumber2 = random2.getRandom();
		System.out.println(randomNumber2);
		
	}

}
