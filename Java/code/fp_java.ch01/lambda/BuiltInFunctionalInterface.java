package fp_java.ch01.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BuiltInFunctionalInterface {
	public static void main(String[] args) {
		
		Predicate<Integer> pp =new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t >= 19;
			}
		};
		boolean isAdult = pp.test(20);
		System.out.println(isAdult);
		
		Predicate<Integer> p = (t) -> t >= 19;
		boolean isAdult2 = p.test(15);
		System.out.println(isAdult2);
		
		Consumer<String> c = t -> System.out.println(t);
		c.accept("반갑습니다");
		
		Function<Boolean, String> f = t -> t ? "yes" : "no";
		String result = f.apply(true);
		String result2 = f.apply(false);
		
		System.out.println(result);
		System.out.println(result2);
		
	}

}
