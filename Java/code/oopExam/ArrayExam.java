package oop_exam;

/**
 * 배열 실습
 */
public class ArrayExam {

	public static void main(String[] args) {
		int[] scoreArray = new int[7];
		scoreArray[0] = 1;
		scoreArray[1] = 2;
		scoreArray[2] = 3;
		scoreArray[3] = 4;
		scoreArray[4] = 5;
		scoreArray[5] = 6;
		scoreArray[6] = 7;
		
		System.out.println(scoreArray);  //[I@1f32e575
		System.out.println(scoreArray.length); //7
		System.out.println(scoreArray[5]); //6
//		System.out.println(scoreArray[-1]); //ArrayIndexOutOfBoundsException: 
											// Index -1 out of bounds for length 7
		
		int score = scoreArray[4];
		System.out.println(score); //5
		
		// for(초기값; 반복조건체크; 증감식){...}
		// 인덱스 번호가 필요할 때
		int sum = 0;
		for (int i = 0; i < scoreArray.length; i++) {
			System.out.println(scoreArray[i]);
			sum += scoreArray[i];
			System.out.println(sum);
		}
		System.out.println(sum);
		
		//for-each (향상된 for)
		// for (아이템타입 아이템변수명 : 배열){...}
		// 인덱스 번호 필요없을 때
		for (int score2 : scoreArray) {
			System.out.println("for-each : "+ score2);
		}
		
		
		String[] names = new String[3];
		names[0] = "김소현";
		names[1] = "리모컨";
		
		System.out.println(names); //[Ljava.lang.String;@279f2327
		String name = names[1];
		System.out.println(name); //리모컨

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		//for-each
		for(String name2 : names) {
			System.out.println("for-each : " + name2);
		}
	
	}
}
