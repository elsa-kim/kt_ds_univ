

import java.util.Scanner;

import exception_handling.exceptions.AlreadyUseUserIdException;
import exception_handling.exceptions.InvalidUserIdException;
import exception_handling.exceptions.UserIdLengthException;

public class MemberJoin {

	public void join() {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("ID를 입력하세요.");
		String id = keyboard.nextLine();
		
		if (id != null && (id.equals("system") || id.equals("root") || id.equals("admin"))) {
			throw new InvalidUserIdException(id + "는 사용할 수 없습니다.");
		}
		else if (id != null && id.equals("ktds")) {
			throw new AlreadyUseUserIdException(id + "는 이미 사용중입니다.");
		}
		else if (id != null && id.length() < 8) {
			throw new UserIdLengthException("ID는 최소 8글자 이상 입력하세요.");
		}
		else if (id == null) {
			throw new InvalidUserIdException("ID는 필수 입력값입니다.");
		}
		else {
			System.out.println(id + "로 가입을 완료했습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		MemberJoin memberJoin = new MemberJoin();
		memberJoin.join();
	}
}
