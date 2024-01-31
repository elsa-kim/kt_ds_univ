package generic_collection;

import java.util.ArrayList;
import java.util.List;

public class ListCollection {
	public static void main(String[] args) {
		List<Integer> scoreList = new ArrayList<>();
		
		// List에 데이터 추가
		scoreList.add(100);
		scoreList.add(90);
		scoreList.add(80);
		scoreList.add(95);
		scoreList.add(85);
		
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// List 데이터 조회
		int score = scoreList.get(0);
		System.out.println(score);
		
		score = scoreList.get(1);
		System.out.println(score);
		
		score = scoreList.get(2);
		System.out.println(score);
		
		score = scoreList.get(3);
		System.out.println(score);
		
		score = scoreList.get(4);
		System.out.println(score);
		
//		score = scoreList.get(5); // IndexOutOfBoundsException
		System.out.println(score);
		
		// List 반복 데이터 조회
		for (int i = 0; i < scoreList.size(); i++) {
			score = scoreList.get(i);
			System.out.println(score);
		}
		
		// List 데이터 삭제
		scoreList.remove(3);
		
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		System.out.println(scoreList.isEmpty());
		
		// List 데이터 모두 삭제
		scoreList.clear();
		
		// List가 비어있는지 확인
		System.out.println(scoreList.isEmpty());
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		scoreList.add(100);
		scoreList.add(90);
		scoreList.add(80);
		scoreList.add(95);
		scoreList.add(85);
		
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// 값 존재 여부 확인
		if ( !scoreList.contains(90)) {
			scoreList.add(90);
		}
		
		if ( !scoreList.contains(50)) {
			scoreList.add(50);
		}
		
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		// 리스트 복사
		List<Integer> scoreList2 = new ArrayList<>();
		scoreList2.addAll(scoreList);
		
		// 객체 고유 값(메모리 주소)
		System.out.println(System.identityHashCode(scoreList));
		System.out.println(scoreList);
		System.out.println(scoreList.size());
		
		System.out.println(System.identityHashCode(scoreList2));
		System.out.println(scoreList2);
		System.out.println(scoreList2.size());
		
		
		
	}

}
