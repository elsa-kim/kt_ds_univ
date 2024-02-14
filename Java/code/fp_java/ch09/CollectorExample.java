package fp_java.ch09.collectors;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fp_java.ch02.stream.vo.Dish;
import fp_java.ch02.stream.vo.DishData;

public class CollectorExample {
	
	public static void main(String[] args) {
		
		Map<String, String> menuMap = new HashMap<>();
		menuMap.put("빅맥1", "16000");
		menuMap.put("빅맥2", "26000");
		menuMap.put("빅맥3", "36000");
		menuMap.put("빅맥4", "46000");
		menuMap.put("빅맥5", "56000");
		menuMap.put("빅맥6", "66000");
		menuMap.put("빅맥7", "76000");
		
		
		List<String> menuName = menuMap.entrySet() //Set<Entry<Key, Value>> --> Set<Entry<String, String>>
				   .stream() //Stream<Entry<Key, Value>>  --> Stream<Entry<String, String>>
				   .map(entry -> entry.getKey()) //Stream<String>
				   .collect(Collectors.toList()); //List<String>
		menuName.forEach(System.out::println);
		
		List<Dish> menu = DishData.menu;
		
		//모든 집계(개수, 함계, 최소값, 최대값, 평균) 구하기
		IntSummaryStatistics intSummaryStatistics = 
				menu.stream()
					.collect(Collectors.summarizingInt(Dish::getCalories));
		
		System.out.println(intSummaryStatistics);
		
	
		// 문자열 연결하기
		//1. Stream 사용하지 않고 하기
//		menu <-- List<Dish>
//		메뉴명, 메뉴명, 메뉴명, 메뉴명
		String menuNames = "";
		for (Dish item : menu) {
			menuNames += (item.getName() + ", ");
		}
		menuNames = menuNames.trim();
		menuNames = menuNames.substring(0, menuNames.length() -1);
		System.out.println(menuNames);
		
		//2. Stream 이용하기
		String menuNames2 = menu.stream()
								.map(Dish::getName)
								.collect(Collectors.joining(", "));
		System.out.println(menuNames2);
		
		
		// 그룹핑하기
		// 메뉴의 타입으로 그룹핑
		Map<Dish.Type, List<Dish>> dishesByType = 
				menu.stream() //Stream<Dish>
					.collect(Collectors.groupingBy(Dish::getType)); //Map<Type, List<Dish>>
		System.out.println(dishesByType);
		System.out.println(dishesByType.get(Dish.Type.FISH));
		System.out.println(dishesByType.get(Dish.Type.MEAT));
		System.out.println(dishesByType.get(Dish.Type.OTHER));
		
		// 채식메뉴와 일반메뉴를 그룹핑
		Map<Boolean, List<Dish>> dishesByVegeterian = 
				menu.stream()
					.collect(Collectors.groupingBy(Dish::isVegetarian)); //Map<Boolean, List<Dish>>
		System.out.println(dishesByVegeterian);
		System.out.println(dishesByVegeterian.get(true));
		System.out.println(dishesByVegeterian.get(false));
		
		// 커스텀 그룹핑
		Map<String, List<Dish>> dishesByCustom =
				menu.stream()
					// Map<String, List<Dish>>
					.collect(Collectors.groupingBy(dish -> {
						if (dish.getCalories() <= 400) {
							return "DIET"; //그룹핑 기준
						}
						else if (dish.getCalories() <= 700) {
							return "NORMAL"; //그룹핑 기준
						}
						else {
							return "FAT"; //그룹핑 기준
						}
					}));
		System.out.println(dishesByCustom);
		
			
	}
}
