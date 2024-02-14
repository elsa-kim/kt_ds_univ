package fp_java.ch08.generatestream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateExample {

	public static void main(String[] args) {
		
		// 배열로 스트림 만들기 1
		int[] numbers = {2, 3, 5, 7, 11, 13};
		Arrays.asList(numbers) //List<int[]>
			  .stream() //Stream<int[]>
			  .flatMapToInt(intArray -> Arrays.stream(intArray)) //IntStream
			  .boxed() //Stream<Integer>
			  .forEach(System.out::println);
		
		// 배열로 스트림 만들기 2
		Arrays.stream(numbers) //IntStream
			  .boxed() //Stream<Integer>
			  .forEach(System.out::println);
		
		String[] chars = {"A", "B", "C"};
		Arrays.asList(chars) //List<String>
			  .stream() //Stream<String>
			  .forEach(System.out::println);
		
		Arrays.stream(chars) //Stream<String>
			  .forEach(System.out::println);
		
		
		File textFile = new File("C:\\Java Exam", "Java Exam.txt");
		// 파일로 스트림 만들기 1
		List<String> lines = null;
		try {
			lines = Files.readAllLines(textFile.toPath(), Charset.defaultCharset());
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		if(lines != null) {
			lines.stream() //Stream<List>
				 .forEach(System.out::println);
		}
		
		// 파일로 스트림 만들기 2
		// Auto closable Try ~ catch
		try (Stream<String> streamLines = Files.lines(textFile.toPath(), Charset.defaultCharset())){
			streamLines.forEach(System.out::println);
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		// 리스트로 스트림 만들기
		List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numberList.stream() //Stream<Integer>
				  .map(number -> number *2)
				  .forEach(System.out::println);
		
		// Map Data --> List Data 변경
		Map<String, String> menuMap = new HashMap<>();
		menuMap.put("빅맥1", "16000");
		menuMap.put("빅맥2", "26000");
		menuMap.put("빅맥3", "36000");
		menuMap.put("빅맥4", "46000");
		menuMap.put("빅맥5", "56000");
		menuMap.put("빅맥6", "66000");
		menuMap.put("빅맥7", "76000");
		
		//menuMap의 key로 구성된 List 만들어보기
		//Map을 Stream으로 변경 하려면 sntrySet 이용해야함
		List<String> menuName = menuMap.entrySet() //Set<Entry<Key, Value>> --> Set<Entry<String, String>>
									   .stream() //Stream<Entry<Key, Value>>  --< Stream<Entry<String, String>
									   .map(entry -> entry.getKey()) //Stream<String>
									   .collect(Collectors.toList()); //List<String>
		menuName.forEach(System.out::println);
		
	}
}
