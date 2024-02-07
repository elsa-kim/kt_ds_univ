package fp_java.ch04.mapping;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream.map 내부에서 새로운 Stream 반환할 때 사용
 */
public class FlatMapExample {
	public static void main(String[] args) {
		
		//word.txt 파일 읽어서 List로 반환하기
		File file = new File("C:\\Java Exam","word.txt");
		
		List<String> wordList = null;
		try {
			wordList = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		System.out.println(wordList);
//		
//		for (String line : wordList) {
//			String[] letterArray = line.split("");
//			
//			for (String letter:letterArray) {
//				System.out.println(letter);
//			}
//		}
		
		String joinedLetter = wordList.stream() //Stream<String>
//									 	.peek(line -> System.out.println("Line : "+line))
									  .map(line -> line.split("")) //Stream<String[]>
//										.peek(letterArray -> {
//											System.out.println("Array : "+letterArray);
//											for (String letter : letterArray) {
//												System.out.println("Letter"+letter);
//											}
//										})
									  // map 내부에서 stream을 반환시키는 중일 때
									  // flatMap을 사용하게 되면 반환 된 Stream이 원본 Stream을 대체한다.
									  .flatMap(letterArray -> Arrays.stream(letterArray))
//										.peek(letter -> System.out.println("Peek : "+letter))
									  .distinct() // 증복제거
//									  .forEach(letter -> System.out.println(">"+letter));
									  .collect(Collectors.joining()); // 한 글자씩 떨어진 글자들을 하나의 스트링을 모아준다.
					
		System.out.println(joinedLetter);
				
		
	}
	

}
