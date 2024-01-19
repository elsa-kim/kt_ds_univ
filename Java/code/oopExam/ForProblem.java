

public class ForProblem {
	
	/**
	 * 1 부터 n 까지의 합을 구해 출력
	 * @param n 
	 */
	public static void sum(int n) {
		int total = 0;
		for (int i = 1; i < n+1; i++) {
			total+=i;
		}
		System.out.println("1 부터 "+n+"까지의 합 : "+total);
	}
	
	/**
	 * 1 부터 n 중 홀수의 합을 구해 출력
	 * @param n
	 */
	public static void oddSum(int n) {
		int total = 0;
		for (int i = 1; i < n+1; i++) {
			if(i%2==1) {
				total+=i;
			}
		}
		System.out.println("1 부터 "+n+" 중 홀수의 합 : "+total);
		
	}
	
	/**
	 * 1 부터 n 중 3, 5, 6의 배수만 출력
	 * @param n
	 */
	public static void printCommonMultiple(int n) {
		System.out.print(n+"까지의 수 중 3, 5, 6의 배수는 : ");
		for (int i = 1; i < n+1; i++) {
			if (i % 3 == 0 
			 && i % 5 == 0 
			 && i % 6 == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	
	/**
	 * 콘솔에 별찍기
	 * @param n
	 */
	public static void printStar(int n) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		sum(200);
		oddSum(150);
		printCommonMultiple(200);
		printStar(8);
		
	}

}
