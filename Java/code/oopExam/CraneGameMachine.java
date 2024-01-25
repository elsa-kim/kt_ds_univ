package oop_exam;

//import java.util.Random;

public class CraneGameMachine {

	boolean isInsertCoin;
	int dolls;
	int total;
	
	public void insertCoin() {
		if (dolls <= 0) {
			System.out.println("인형이 없습니다.");
			return;
		}
		isInsertCoin = true;
	}
	
	public int doGame() {
		if (!isInsertCoin) {
			System.out.println("코인을 넣어주세요");
			return -1;
		}
		int result = (int) (Math.random()*2);
		//	Random random = new Random();
		//	int result = random.nextInt(2);
		
		if (result == 1) {
			dolls --;
			total ++;
			System.out.println("인형을 뽑았습니다!");
			System.out.println("남은인형 : "+dolls+"개");
			System.out.println("뽑은인형 : "+total+"개");
		} else {
			System.out.println("인형을 뽑지 못했습니다..");
			System.out.println("남은인형 : "+dolls+"개");
			System.out.println("뽑은인형 : "+total+"개");
		}
		isInsertCoin = false;
		return result;
	}
}
