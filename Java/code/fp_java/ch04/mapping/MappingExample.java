package fp_java.ch04.mapping;

import java.util.Arrays;
import java.util.List;

public class MappingExample {
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
		words.stream() //Stream<String>
			 .map((String str) -> str.length()) // Stream<Integer>
			 .forEach((Integer length) -> System.out.println(length));
		
	}

}
