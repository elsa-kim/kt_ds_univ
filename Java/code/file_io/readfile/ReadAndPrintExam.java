package file_io.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Java 1.8버전 미만
 */
public class ReadAndPrintExam {
	
	public static List<String> getAllLines(File file){

		if (file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			try {
				reader = new FileReader(file, Charset.forName("UTF-8"));
				bufferedReader = new BufferedReader(reader);
				
				List<String> lineList = new ArrayList<>();
				
				String line = null;
				while((line = bufferedReader.readLine()) != null) {
					lineList.add(line+"\n");
				}
				return lineList;
			}
			catch(IOException ioe){
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
			finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					}
					catch(IOException ioe) {}
				}
				if (reader != null) {
					try {
						reader.close();
					}
					catch(IOException ioe) {}
				}
			}
			
			
		}
		//텅 빈 리스트 반환
		return new ArrayList<>();
	
	}

	public static void main(String[] args) {
		
		File file = new File("C:\\Java Exam", "Java Exam.txt");
		if (file.exists() && file.isFile()) {
			FileReader reader = null;
			BufferedReader bufferedReader = null;
			try {
				// 파일을 바이트 단위로 읽어오는 FileReader 선언
				reader = new FileReader(file, Charset.forName("UTF-8"));
				// 파일을 라인 단위로 읽어오는 BufferedReader 선언
				bufferedReader = new BufferedReader(reader);
				// 파일을 라인 단위로 읽어와 할당하기 위한 String 변수 선언
				String line = null;
				// 파일 끝날때까지 반복하며 line 변수에 한줄씩 읽어오기
				while((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			}
			catch(IOException ioe){
				// 파일 읽다가 예외 발생 시 예외 메세지만 출력
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
			finally {
				// 파일 끝까지 읽었거나 예외 발생한 경우 BufferedReader 닫아줌
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					}
					catch(IOException ioe) {}
				}
				// 파일 끝까지 읽었거나 예외 발생한 경우 FileReader 닫아줌
				if (reader != null) {
					try {
						reader.close();
					}
					catch(IOException ioe) {}
				}
			}
			
			
		}
	}
}
