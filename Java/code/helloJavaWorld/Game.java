package hello_java_world;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		// import 단축키 : ctrl + shift + o
		// 키보드의 입력을 변수로 받아올 수 있도록 도와주는 코드
		Scanner keyboard = new Scanner(System.in);
		
		//난수 생성 (0.000000)
		double randomNumber = Math.random();
		
		//난수를 0~99 사이의 정수로 변환
		int answer = (int) (randomNumber * 100);
		
		//사용자가 입력하는 값을 할당받을 변수를 선언
		int value = 0;
		
		while (true) {
			//사용자에게 숫자 입력하라고 알려준다
			System.out.println("숫자를 입력하세요.");
			
			//사용자가 keyboard 변수 이용해 숫자를 입력한 후 엔터 입력하면 value 변수에 값이 할당된다
			value = keyboard.nextInt();
			
			//컴퓨터가 만든 난수와 사용자가 입력한 숫자가 일치하는지 확인하고 일치한다면 "정답입니다" 출력
			if ( answer==value) {
				System.out.println("정답입니다.");
				break; //무한반복 종료
			}
			//컴퓨터가 만든 난수와 사용자가 입력한 숫자 비교했을 때 사용자가 입력한 값이 더 작다면 "Up!"을 출력
			else if (answer > value) {
				System.out.println("Up!");
			}
			//사용자 입력값이 더 크다면(일치하지도 않고 작지도 않은 경우) "Down!" 출력
			else {
				System.out.println("Down!");
			}
			
		}
		
		
	}

}
