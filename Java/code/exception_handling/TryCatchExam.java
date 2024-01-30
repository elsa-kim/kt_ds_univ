
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import exception_handling.exceptions.ReadFailException;

public class TryCatchExam {
	
	public static List<String> readFile(File path) throws IOException{
		return Files.readAllLines(path.toPath());
	}
	
	public static List<String> readFile2(File path){
		try {
			return Files.readAllLines(path.toPath());
		}
		catch(IOException ioe) {
			throw new ReadFailException("파일을 읽을 수 없습니다.", ioe);
		}
	}
	
	public static int convertToInt(String str) throws Exception{
		
		try {
			int number = Integer.parseInt(str);
			return number;
		}
		catch(NumberFormatException nfe) {
			
			Exception exception = new Exception(str + "는 숫자로 변환할 수 없습니다.", nfe);
			throw exception; //예외를 던지고 메소드 종료시킨다 (아래에 코드 넣으면 dead code)
		}
		finally {
			System.out.println("변환이 완료되었습니다.");
		}
		
//		return 0;
	}

	public static void main(String[] args) {
		
		// 시스템 드라이브에서 특정 경로에 있는 파일 또는 폴더를 읽어온다.
		File imageFile = new File("c:\\sadflkhsdalkfd");

//		readFile(imageFile); // try-catch 해야되는 코드
		readFile2(imageFile);  // 런타임예외 던짐
		
		try {
			int num = convertToInt("AAA");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage()); // AAA는 숫자로 변환할 수 없습니다.
		}
		
		try {
			Files.readAllLines(imageFile.toPath());
		}
		catch(IOException ioe) {
			String message = ioe.getMessage();
			System.out.println(message);
			
			ioe.printStackTrace();
		}
		finally {
			System.out.println("File을 읽고 finally가 실행되었습니다.");
		}
		
		
		try {
			Class.forName("IfArrayIndexOutOfBoundsException2");
			Files.readAllLines(imageFile.toPath());
		}
		catch(ClassNotFoundException | IOException cnfe) {
			String message = cnfe.getMessage();
			System.out.println(message);
			
			// 아주 상세한 예외 목록 (호출 스택)
			// 실무에서 사용x => 보안에 취약(민감정보), CPU 많이 사용 => 코드 짤 때만 사용하고 배포할땐 없애기
			cnfe.printStackTrace();
		}
//		catch(IOException ioe) {
//			String message = ioe.getMessage();
//			System.out.println(message);
//			
//			// 아주 상세한 예외 목록 (호출 스택)
//			ioe.printStackTrace();
//		}
	}
}
