package fp_java.ch05.matching;

import java.util.List;

import fp_java.ch02.stream.vo.Dish;
import fp_java.ch02.stream.vo.DishData;

public class MatchExample {

	public static void main(String[] args) {
		
		List<Dish> menu = DishData.menu;
		
		// 중간함수 (Stream 반환)
			// filter
			// map, flatMap
			// distinct
			// skip, limit
			// peek
		// 최종함수 (Stream 반환시키지 않는 것)
			// forEach : void
			// collect : T
			// anyMatch : boolean
		
		// Stream 내부에 채식 요리가 한개라도 있으면 true
		boolean isVegeterian = menu.stream() //Stream<Dish>
									.anyMatch(dish -> dish.isVegetarian());
		long vegeterianCount = menu.stream()
							    	.filter(dish -> dish.isVegetarian())
									.count(); // 최종함수
		if (vegeterianCount > 0) {
			System.out.println("채식주의자를 위한 요리가 준비되어있습니다!2");
		}
		if (isVegeterian) {
			System.out.println("채식주의자를 위한 요리가 준비되어있습니다!");
		}
		
		// Stream 내부의 요리가 모두 1000kcal 미만이면 true
		boolean isHealthy = menu.stream()
								 .allMatch(dish -> dish.getCalories() < 1000);
		if (isHealthy) {
			System.out.println("우리 식당은 모두 다이어트 식단을 제공합니다!");
		}
		
		// Stream 내부의 요리 중 1000kcal 초과하는 요리가 없다면 true
		// allMatch와 반대
		isHealthy = menu.stream()
			.noneMatch(dish -> dish.getCalories() > 1000);
		if (isHealthy) {
			System.out.println("우리 식당은 모두 다이어트 식단을 제공합니다!2");
		}
		
	}
}
