package datetime_handler.newapi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeExam {

	public static void main(String[] args) {
		LocalTime nowTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		String strNowTime = timeFormatter.format(nowTime);
		System.out.println(nowTime);
		System.out.println(strNowTime);
		
		nowTime = LocalTime.of(00, 00, 01);
		nowTime = nowTime.plusHours(10);
		nowTime = nowTime.plusMinutes(5);
		nowTime = nowTime.plusSeconds(55);
		strNowTime = timeFormatter.format(nowTime);
		System.out.println(nowTime);
		System.out.println(strNowTime);
		
	}
}
