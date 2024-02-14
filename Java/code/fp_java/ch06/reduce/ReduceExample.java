package fp_java.ch06.reduce;

import java.util.ArrayList;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(4);
		numbers.add(5);
		numbers.add(3);
		numbers.add(9);
		
		// 총 합계
		int sumResult = numbers.stream().reduce(0, (sum, item) -> sum + item);
		System.out.println(sumResult);
		
		// 최대값 구하기
		int maxNumber = numbers.stream()
							   .reduce(Integer::max)
							   .orElse(0);
		System.out.println(maxNumber);
		
		// 최소값 구하기
		int minNumber = numbers.stream()
							    .reduce(Integer::min)
							    .orElse(0);
		System.out.println(minNumber);
		
	}
}
