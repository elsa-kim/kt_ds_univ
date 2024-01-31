package generic_collection;

import java.util.HashMap;
import java.util.Map;

public class MapCollection {

	public static void main(String[] args) {
		Map<String, Integer> priceMap = new HashMap<>();
		
		// Map에 데이터 추가
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.put("LG Gram", 1_800_000);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 데이터 조회
		int applePrice = priceMap.get("Apple Macbook Pro");
		System.out.println(applePrice);
		
//		applePrice = priceMap.get("apple macbook pro"); //NullPointerException
		System.out.println(applePrice);
		
		// Map 데이터 삭제
		priceMap.remove("Apple Macbook Pro");
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 데이터 모두 삭제
		priceMap.clear();
		System.out.println(priceMap);
		System.out.println(priceMap.size());

		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);

		// Map 비어있는지 확인
		boolean isEmpty = priceMap.isEmpty();
		System.out.println(isEmpty);
		System.out.println(priceMap);
		System.out.println(priceMap.size());

		priceMap.clear();
		isEmpty = priceMap.isEmpty();
		System.out.println(isEmpty);
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		priceMap.put("Apple Macbook Pro", 3_500_000);
		priceMap.put("Samsung Galaxy Book", 1_500_000);
		priceMap.put("LG Gram", 1_700_000);

		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map에 동일한 key 있는지 확인
		if (!priceMap.containsKey("LG Gram")) {
			priceMap.put("LG Gram", 1_600_000);
		}
		
		System.out.println(priceMap);
		System.out.println(priceMap.size());

		// Map에 동일한 value가 있는지 확인
		if (priceMap.containsValue(1_700_000)) {
			priceMap.put("LG Gram", 1_600_000);
		}
	
		System.out.println(priceMap);
		System.out.println(priceMap.size());
		
		// Map 복사
		Map<String, Integer> priceMap2 = new HashMap<>();
		priceMap2.putAll(priceMap);
		
		System.out.println(System.identityHashCode(priceMap));
		System.out.println(priceMap);
		System.out.println(priceMap.size());

		System.out.println(System.identityHashCode(priceMap2));
		System.out.println(priceMap2);
		System.out.println(priceMap2.size());
	
	}
}
