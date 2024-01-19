package hello_java_world;

public class ForExam {
	public static void main(String[] args) {
		/*
		 * for 문법
		 * for ( 초기값; 반복조건; 증감식) {
		 * 	반복할 코드
		 * }
		 */
		for (int i=1; i < 11; i++) {
			System.out.println(i);
		}
		
		// 구구단 2~9 반복
		for (int i = 2; i < 10; i++) {
			
			//구구단 배수 사용위해 반복 
			//1~9까지
			for(int j = 1; j < 10; j++) {
				
				// 2 X 1 = 2
				// 2 X 2 = 4
				System.out.println(i + " X " + j + " = " + (i * j));
			}
		}
	}

}
