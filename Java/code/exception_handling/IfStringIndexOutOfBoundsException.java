
public class IfStringIndexOutOfBoundsException {

	public static void main(String[] args) {
		
		String logoFilePath = "C:\\images\\logo.png";
		/*
		 * logoFilePath 인스턴스에서 logo.png만 출력해보세요.
		 */
		
		// substring + indexOf + lastIndexOf
		int lastIndexOfBackslash = logoFilePath.lastIndexOf("\\") + 1;
//		System.out.println(lastIndexOfBackslash);
		String filename = logoFilePath.substring(lastIndexOfBackslash);
		System.out.println(filename);
		
		/*
		 * logoFilePath 인스턴스에서 "images"만 추출해보세요.
		 */
		int indexOf = logoFilePath.indexOf("images");
		filename = logoFilePath.substring(indexOf, lastIndexOfBackslash-1);
		System.out.println(filename);
		
		/*
		 * logoFilePath 인스턴스에서 "user_images"만 추출해보세요.
		 */
		// 없는 것의 위치 찾으려하면 -1 리턴 => -1에서 찾으려하니 예외발생
		String findWord = "user_images";
		int wordlength = findWord.length();
		if (logoFilePath.contains(findWord)){
			int findIndex = logoFilePath.indexOf(findWord);
			System.out.println(logoFilePath.substring(findIndex, findIndex + wordlength));
		}
		

		/*
		 * logoFilePath 인스턴스에서 확장자("png")만 추출해보세요.
		 */
		lastIndexOfBackslash = logoFilePath.lastIndexOf(".") + 1;
		filename = logoFilePath.substring(lastIndexOfBackslash);
		System.out.println(filename);
		
		
		String downloadFilePath = "C:\\images\\logo";
		/*
		 * downloadFilePath 인스턴스에서 파일의 확장자를 추출해 출력해보세요.
		 */
		if (downloadFilePath.contains(".")) {
			indexOf = downloadFilePath.indexOf(".") + 1;
			System.out.println(downloadFilePath.substring(indexOf));
		}
	}
}
