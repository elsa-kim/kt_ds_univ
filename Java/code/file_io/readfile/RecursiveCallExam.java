package file_io.readfile;

import java.io.File;

/**
 * 메소드 재귀호출 예제
 */
public class RecursiveCallExam {	
	
	public static File findFile(String fileName, File from) {
		if (from == null) {
			from = new File("C:\\");
		}
		
		if (from.exists() && from.isDirectory()) {
			File[] itemInDir = from.listFiles();
			
			
			if (itemInDir != null) {
				for (File item : itemInDir) {
					if (item.isDirectory()) {
						File result = findFile(fileName, item);
						if (result != null) {
							return result;
						}
					}
					else if(item.getName().equals(fileName)) {
						return item;
					}
				}
			}
			
					
		}
		else if (from.getName().equals(fileName)) {
			return from;
		}
		return null;
	}
	
	/**
	 * dir 아래에 있는 모든 항목들을 출력한다.(하위 폴더 포함)
	 * @param dir 탐색을 시작할 경로(폴더)
	 */
	public static void printAllItems(File dir) {
		if (dir.exists() && dir.isDirectory()) {
			File[] itemInDir = dir.listFiles();
			
			System.out.println(dir.getAbsolutePath());
			
			if (itemInDir != null) {
				for (File item : itemInDir) {
					if (item.isDirectory()) {
						printAllItems(item);
					}
					else {
						System.out.println(item.getAbsolutePath());
					}
				}
			}
					
		}
		else if (dir.isFile()) {
			System.out.println(dir.getAbsolutePath());
		}
	}
	
	public static String join(String startStr, String joinStr) {
		if (startStr.length() >=100) {
			return startStr;
		}
		startStr+=joinStr;
		System.out.println(startStr);
		return join(startStr, startStr);
	}
	
	public static void infinityCall(int value) {
		if(value == 3) {
			return;
		}
		System.out.println("infinityCall 호출됨" + value);
		
		// 재귀호출(메소드가 자기 자신을 다시 실행함)
		infinityCall(++value);
	}
	
	public static void main(String[] args) {
		
		//while 무한반복
//		while(true) {
//			infinityCall();
//		}
		
		// 재귀호출
//		infinityCall(0);
		
//		String resultString = join("A", "");
//		System.out.println(resultString);
		
		printAllItems(new File("C:\\Program Files"));
		
		File file = findFile("goods.csv", null);
		System.out.println(file.getAbsolutePath());
		
	}
	
}
