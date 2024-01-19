package hello_java_world;

public class IfExam3 {
	public static void main(String[] args) {
		/*
		 * 1. 만약, 나이가 15세 이상이고, 19세 미만이면
		 * "엔드게임" 영화를 관람할 수 있다.
		 */
		int age = 10;
		
		if (age >=15 && age <19) {
			System.out.println("엔드게임 관람 가능");
		}
		
		/*
		 * 2. 만약, 지금 시간이 오후 1시(13시)가 지났고
		 * 	내 체크카드에 8000원보다 많은 돈이 있다면
		 * 식당에서 점심식사를 할 수 있다.
		 * 그렇지 않다면 편의점에서 라면을 사 먹을 수 있다.
		 */
		int hour = 13;
		int creditCard = 6000;
		
		if (hour>=13 && creditCard > 8000) {
			System.out.println("식당에서 점심식사!");
		}
		else {
			System.out.println("편의점에서 라면");
		}
		
		/*
		 * 3. 만약, 나이가 19세 이상이면 "범죄도시1" 영화를 관람할 수 있고
		 * 나이가 15세 이상이고 19세 미만이면 "엔드게임" 영화를 관람할 수 있고
		 * 나이가 12세 이상이고 15세 미만이면 "해리포터" 영화를 관람할 수 있고
		 * 그렇지 않다면 "뽀로로 극장판 공룡섬 대모험"을 관람할 수 있다.
		 */
		int age2 = 14;
		String movie;
		if (age2 >= 19) {
			movie="범죄도시1";
		}
		else if (age2>=15) {
			movie = "엔드게임";
		}
		else if (age2>=12) {
			movie = "해리포터";
		}
		else {
			movie="뽀로로 극장판 공룡섬 대모험";
		}
		System.out.println(movie + " 관람 가능");
	}

}
