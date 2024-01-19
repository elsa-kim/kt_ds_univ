package oop_exam;

public class Hello {
	
	// public static void 메소드이름(보통 동사로 시작, 반드시 소문자로 시작)
	/**
	 * "안녕하세요" 출력하는 메소드(정의)
	 */
	public static void sayHello() {
		System.out.println("안녕하세요");
	}
	
	/**
	 * 이름을 파라미터로 전달하면, "이름씨, 안녕하세요"를 출력한다.
	 * @param name 출력하고 싶은 이름
	 */
	public static void printHello(String name) {
		System.out.println(name+"씨, 안녕하세요?");
	}
	
	/**
	 * 클래스파일 실행시키는 메소드
	 * @param args (파라미터)
	 */
	public static void main(String[] args) {
		// 코드복제 : ctrl + Alt + 방향키(위,아래)
		sayHello(); // 메소드 호출
		System.out.println("반갑습니다.");
		sayHello();
		
		printHello("스타크");
		printHello("헐크");
		printHello("그루트");
		printHello("김소현");
	}

}
