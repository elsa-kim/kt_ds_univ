package oopExam;

public class ClassRoom {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.java = 100;
		student1.python = 90;
		student1.cpp = 80;
		student1.csharp = 85;
		
		student1.getSumAllScores();
		student1.getAverage();
		student1.getCourseCredit();
		student1.getABCDF();
	}

}
