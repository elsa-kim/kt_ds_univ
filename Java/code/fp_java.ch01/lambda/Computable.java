package fp_java.ch01.lambda;

public interface Computable {
	
	public int add(int num1, int num2);
	
	/**
	 * 인터페이스의 printMessagw 기본 코드를 작성
	 * default 키워드를 가장 앞에 붙이면 인터페이스도 기능 구현 가능
	 * implementable class에서 overriding 가능하다
	 * overriding 해주지 않으면 기본 코드 동작
	 */
	default public void printMessage() {
		System.out.println("기본 메세지입니다.");
	}

}
