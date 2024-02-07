package fp_java.ch03.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp_java.ch02.stream.vo.Dish;
import fp_java.ch02.stream.vo.DishData;

public class FilteringExample {

	public static void main(String[] args) {
		
		List<Dish> menu = DishData.menu;
		System.out.println(menu);
		
		for (Dish dish:menu) {
			if (dish.isVegetarian()) {
				System.out.println("이름 : "+dish); //메뉴명
				System.out.println("채식여부 : "+dish.isVegetarian()); //채식여부
				
			}
		}
		
		// List를 Stream으로 변경을 하면
		// Stream의 Generic은 List의 Generic과 같아진다.
		menu.stream() //Stream<Dish>
			// 새로운 Stream<Dish> 만들어짐 = {french fries, rice, season fruit};
			.filter((Dish dish) -> dish.isVegetarian())
			// forEach (Consumer<Dish>)
			.forEach((Dish dish) -> {
				System.out.println("Stream 이름 : "+dish); //메뉴명
				System.out.println("Stream 채식여부 : "+dish.isVegetarian()); //채식여부
			});
		
		
		//짝수만 추려와서 중복 제거하고 나머지를 출력한다
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
		
		//짝수만 보관할 리스트
		List<Integer> evenNumbers = new ArrayList<>();
		for (int number : numbers) {
			if (number % 2 == 0) {
				if (!evenNumbers.contains(number)) {
					evenNumbers.add(number);
				}
			}
		}
		System.out.println(evenNumbers); //[2, 4]
		
		//Stream으로
		numbers.stream() // Stream<Integer>
			   // Stream<Integer> = {2, 2, 4}
			   .filter((Integer n) -> n % 2 == 0) 
			   //Stream<Integer> = {2, 4}
			   .distinct() //중복값 제거
			   .forEach((Integer n)->System.out.println(n));
		
		
		// 메뉴중에서 칼로리가 300보다 큰 것 중 아무거나(정렬 안 된 데이터 앞쪽부터) 3개 가져와서 조회
		
		//메뉴 3개만 넣을 리스트
		List<Dish> dishes = new ArrayList<>();
		for (Dish dish : menu) {
			if (dish.getCalories() > 300) {
				dishes.add(dish);
			}
			if (dishes.size() == 3) {
				break;
			}
		}
		System.out.println(dishes);
		
		//Stream으로 풀어보기
		// .limit(3).forEach();
		menu.stream()
			.filter((Dish dish)-> dish.getCalories() > 300)
			.limit(3)
			.forEach((Dish dish)-> System.out.println(dish));
		
		
	}
}
