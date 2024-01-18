package hello_java_world;

public class ArtithmaticProblem {
	public static void main(String[] args) {
    //Q1
		int minutes = 5;
		int seconds = 50;
		int time = 0;
		
		// n1.minutes 변수가 활용이 된다면 해당 변수 값을 고치면 문제 될 수 있음
		//	minutes *= 60;
		//	time = minutes + seconds;
		
		// n2.
		time = minutes*60 + seconds;
		
		System.out.println(time);

    int processTime = 145;
		int minutes = 0;
		int seconds = 0;

    //Q2
		minutes = processTime / 60;
		seconds = processTime % 60;
		
		System.out.println(minutes+"분"+seconds+"초");

    //Q3
    int celsius = 30;
		int fahrenheit = 0;
		
		fahrenheit = (celsius * 9 / 5) + 32;
		
		System.out.println(fahrenheit);
		
	}

}
