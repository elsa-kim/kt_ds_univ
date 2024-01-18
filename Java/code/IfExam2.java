package hello_java_world;

public class IfExam2 {
	public static void main(String[] args) {
		int korScore = 90;
		int engScore = 98;
		int mathScore = 70;
		int progScore = 80;
		
		int sum = korScore + engScore + mathScore + progScore;
		int average = sum / 4;
		
		if (average >= 95) {
			System.out.println("A+");
		}
		else if (average >= 90) {
			System.out.println("A");
		}
		else if (average >= 85) {
			System.out.println("B+");
		}
		else if (average >= 80) {
			System.out.println("B");
		}
		else if (average >= 70) {
			System.out.println("C");
		}
		else {
			System.out.println("F");
		}
		
		
		int money = 1_000_000;
		
		int father = 40;
		int mother = 36;
		int daughter = 11;
		
		int adultOneWayFlightFare = 300_000;
		int kidOneWayFlightFare = 120_000;
		
		// 1.
		int totalFare = 0;
		
		if (father >= 19) {
			totalFare += adultOneWayFlightFare;
		}
		else {
			totalFare += kidOneWayFlightFare;
			
		}if (mother >= 19) {
			totalFare += adultOneWayFlightFare;
		}
		else {
			totalFare += kidOneWayFlightFare;
		}
		
		if (daughter >= 19) {
			totalFare += adultOneWayFlightFare;
		}
		else {
			totalFare += kidOneWayFlightFare;
		}
		
		if (totalFare <= money) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자 ㅠㅠ");
		}
		
		// 2. 
		int adult = 0;
		int kid = 0;
		
		if (father >= 19) {
			adult++;
		}
		else {
			kid++;
		}
		if (mother >= 19) {
			adult++;
		}
		else {
			kid++;
		}
		if (daughter >= 19) {
			adult++;
		}
		else {
			kid++;
		}
		
		if(adultOneWayFlightFare*adult+kidOneWayFlightFare*kid<=money) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자 ㅠㅠ");
		}
		
		// 3.삼항연산자
		int flightFare = 0;
		flightFare += father >= 19 ? adultOneWayFlightFare : kidOneWayFlightFare;
		flightFare += mother >= 19 ? adultOneWayFlightFare : kidOneWayFlightFare;
		flightFare += daughter >= 19 ? adultOneWayFlightFare : kidOneWayFlightFare;
		
		if (flightFare <= money) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자 ㅠㅠ");
		}
	}

}
