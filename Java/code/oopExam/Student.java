package oopExam;

public class Student {
	// 멤버변수
	int java;
	int python;
	int cpp;
	int csharp;
	
	int sum;
	double average;
	double courseCredit;
	
	/**
	 * 멤버변수를 모두 더해 int 타입으로 변환
	 * @return 멤버변수의 합 
	 */
	public int getSumAllScores() {
		sum = java+python+cpp+csharp;
		return sum;
	}
	
	/**
	 * 합계점수/4를 소수점 2째자리까지 반환 
	 * @return
	 */
	public double getAverage() {
		average = 0.00;
		average = sum / 4;
		return average;
	}
	
	/**
	 * (평균점수-55)/10의 결과를 소수점아래 둘째자리까지 반환 
	 * @return
	 */
	public double getCourseCredit() {
		courseCredit = 0.00;
		courseCredit = (average-55)/10;
		return courseCredit;
	}
	
	public String getABCDF() {
		String grade = "";
		if (courseCredit>=4.1) {
			grade = "A+";
		}else if (courseCredit>=3.6) {
			grade = "A";
		}else if (courseCredit>=3.1) {
			grade = "B+";
		}else if (courseCredit>=2.6) {
			grade = "B";
		}else if (courseCredit>=1.6) {
			grade = "C";
		}else if (courseCredit>=0.6) {
			grade = "D";
		}else {
			grade = "F";
		}
		System.out.println("학점은 : "+grade);
		return grade;
	}

}
