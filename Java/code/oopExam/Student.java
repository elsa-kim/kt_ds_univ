package oopExam;

public class Student {
	// 멤버변수
	int java;
	int python;
	int cpp;
	int csharp;
	
	
	/**
	 * 점수를 모두 더해 반환
	 * @return 멤버변수의 합 
	 */
	public int getSumAllScores() {
		return java+python+cpp+csharp;
	}
	
	/**
	 * 합계점수/4를 소수점 2째자리까지 반환 
	 * @return
	 */
	public double getAverage() {
		int average = (int) (getSumAllScores() / 4.0 * 100);
		return average / 100;
	}
	
	/**
	 * (평균점수-55)/10의 결과를 소수점아래 둘째자리까지 반환 
	 * @return
	 */
	public double getCourseCredit() {
		int courseCredit = (int) ((getAverage() - 55) / 10.0 * 100);
		return courseCredit/100;
	}
	
	public String getABCDF() {
		double courseCredit = getCourseCredit(); // 학점
		
		if (courseCredit>=4.1) {
			// String 변수 만들어 반환하는 것보다 바로 반환하는 것이 깔끔
			return "A+";
		}else if (courseCredit>=3.6) {
			return "A";
		}else if (courseCredit>=3.1) {
			return "B+";
		}else if (courseCredit>=2.6) {
			return "B";
		}else if (courseCredit>=1.6) {
			return "C";
		}else if (courseCredit>=0.6) {
			return "D";
		}else {
			return "F";
		}
	}

}
