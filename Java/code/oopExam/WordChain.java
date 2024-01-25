package oop_exam;
import java.util.Scanner;

public class WordChain {
	
	public static void main(String[] args) {
		
		String word = "자전거";
		System.out.println(word);
		Scanner scanner = new Scanner(System.in);
		int count = 1;
		String nextword = "";
		
		while (true) {
			nextword = scanner.nextLine();
			nextword= nextword.trim();
			if (nextword.length() < 3) {
				System.out.println(count+"번 딘어를 이어나갔습니다.");
				return;
			}
			if (!word.substring(word.length() - 1).equals(nextword.substring(0, 1))) {
				System.out.println(count+"번 딘어를 이어나갔습니다.");
				return;
				
			}
			word = nextword;
			count++;
		}
		
		
		/*
		// 강사님 코드
		// 장황한 ver
		while (true) {
			nextword = scanner.nextLine();
			nextword= nextword.trim();
			if (nextword.length() >= 3) {
				String lastWord = word.substring(word.length()-1);
				if (nextword.startsWith(lastWord)) {
					word = nextword;
					count++;
					
				}else {
					break;
				}
			}else {
				break;
			}
		}
		System.out.println(count+"번 단어를 이어나갔습니다.");
		
		// 깔끔 ver
		while (true) {
			nextword = scanner.nextLine();
			nextword= nextword.trim();
			if (nextword.length() < 3) {
					break;
			}
			
			String lastWord = word.substring(word.length()-1);
			
			if (nextword.startsWith(lastWord)) {
				word = nextword;
				count++;
			}else {
				break;
			}
		System.out.println(count+"번 단어를 이어나갔습니다.");
		
		 */
		
		}

}
