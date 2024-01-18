package hello_java_world;

public class OperatorExam {
	public static void main(String[] args) {
		int a = 10;
		// 변수 a 값이 10보다 크고 20보다 작은가?
		boolean is11To19 = a > 10 && a < 20;
		System.out.println(is11To19);
		
		int b = 345795;
		// 변수 b는 짝수인가?
		boolean isEven = b % 2 == 0;
		System.out.println(isEven);
		
		int c = -345796;
		// 변수 c는 0보다 큰 짝수인가?
		boolean isEven2 = c > 0 && c % 2 == 0;
		System.out.println(isEven2);
		
		int d = 35;
		// 변수 d의 값은 2 또는 5의 배수인가?
		boolean isMultiple20r5 = d % 2 == 0 || d % 5 == 0;
		System.out.println(isMultiple20r5);
		
		int son = 7;
		int parent = 40;
		// son은 부모님과 함께 12세 이상 관람가의 영화를 볼 수 있나?
		boolean isAvailable = son >= 12 || parent >= 12;
		System.out.println(isAvailable);
		
		int e = 35;
		// 변수 e의 값은 3의 배수가 아닌가?
		boolean isNotMultiple3 = e % 3 != 0;
		System.out.println(isNotMultiple3);
		
		isNotMultiple3 = !(e % 3 == 0);
		System.out.println(isNotMultiple3);
	}

}
