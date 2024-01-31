package generic_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		List<Integer> lottoArray = new ArrayList();
		
		while (lottoArray.size()<6) {
			Random random = new Random();
			int num = random.nextInt(45)+1;
			
			if (!lottoArray.contains(num)) {
				lottoArray.add(num);
			}
		}
		
		System.out.print("로또번호는 : " + lottoArray);
		
	}

}
