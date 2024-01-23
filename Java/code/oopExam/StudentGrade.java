package oopExam;

public class StudentGrade {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.java = 100;
		student1.python = 97;
		student1.cpp = 81;
		student1.csharp = 99;
		
		int sum = student1.getSumAllScores();
		double average = student1.getAverage();
		double courseCredit = student1.getCourseCredit();
		String grade = student1.getABCDF();
		
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+average);
		System.out.println("학점 : "+courseCredit);
		System.out.println("등급 : "+grade);
	}
}
