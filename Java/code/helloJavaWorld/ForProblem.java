package hello_java_world;

public class ForProblem {
	public static void main(String[] args) {
		
		//1. 1 부터 100 까지의 합을 구해 출력해보세요.
		int total = 0;
		for (int i = 1; i < 101; i++) {
			total+=i;
		}
		System.out.println("1 부터 100 까지의 합 : "+total);
		
		//2. 1 부터 100 중 홀수의 합을 구해 출력해보세요.
		//n1
		int total2 = 0;
		for (int i = 1; i < 101; i+=2) {
			total2+=i;
		}
		System.out.println("1 부터 100 중 홀수의 합 : "+total2);
		
		//n2
		total2 = 0;
		for (int i = 1; i < 101; i++) {
			if(i%2==1) {
				total2+=i;
			}
		}
		System.out.println("1 부터 100 중 홀수의 합 : "+total2);
		
		//3. 1 부터 100 중 3, 5, 6의 배수만 출력해보세요.
		System.out.print("3, 5, 6의 배수는 : ");
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0 
			 && i % 5 == 0 
			 && i % 6 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		//4. 콘솔에 별찍기
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
