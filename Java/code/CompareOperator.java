package hello_java_world;

public class CompareOperator {
	public static void main(String[] args) {
		
		// 비교연산자의 결과는 항상 boolean(true/false)
		int num1= 10;
		int num2 =5;
		System.out.println(num1==num2);
		
		boolean isEquals = num1 == num2;
		boolean isNum1GreaterThanNum2 = num1 > num2;
		boolean isNum1GreaterOrEqualsThanNum2 = num1 >=num2;
		boolean isNum1LessThanNum2 = num1 < num2;
		boolean isNum1LessOrEqualsThanNum2 = num1 <= num2;
		boolean isNotEquals = num1 != num2;
		
		System.out.println(isEquals);
		System.out.println(isNum1GreaterThanNum2);
		System.out.println(isNum1GreaterOrEqualsThanNum2);
		System.out.println(isNum1LessThanNum2);
		System.out.println(isNum1LessOrEqualsThanNum2);
		System.out.println(isNotEquals);
		
		// 논리 연산자
		// &&(and) 연산자
		boolean and = true && true;
		System.out.println(and);
		
		and = true && false;
		System.out.println(and);

		and = false && true;
		System.out.println(and);
		
		and = false && false;
		System.out.println(and);
		
		// ||(or) 연산자
		boolean or = true || true;
		System.out.println(or);
		
		or = true || false;
		System.out.println(or);
		
		or = false || true;
		System.out.println(or);
		
		or = false || false;
		System.out.println(or);
		
		// !(not) 연산자
		boolean not = !true;
		System.out.println(not);
		
		not = !false;
		System.out.println(not);
		
		
	}

}
