package file_io.fileinfo;

import java.io.File;
import java.util.Date;

public class FileInfo {

	public static void main(String[] args) {
		
//		File file = new File("C:\\Java Exam", "Java Exam.txt");
//		File file = new File("C:\\Java Exam", "Java Exam1.txt");
//		File file = new File("C:\\Java Exam");
//		File file = new File("C:\\");
		File file = new File("C:\\dev_program");
		
		//파일 존재하면 true, 아니면 false
		boolean isFileExists = file.exists();
		System.out.println("isFileExists > "+ isFileExists);
		
		//읽어온 File 인스턴스가 파일이라면 true, 폴더라면 false
		boolean isFile = file.isFile();
		System.out.println("isFile > "+ isFile);
		
		//읽어온 file 인스턴스가 폴더(디렉토리)라면 true, 파일이라면 false
		boolean isDirectory = file.isDirectory();
		System.out.println("isDirectory > "+ isDirectory);
		
		//File 인스턴스가 가리키고 있는 폴더 또는 파일의 전체경로
		String fileAbsolutePath = file.getAbsolutePath();
		System.out.println("fileAbsolutePath > "+ fileAbsolutePath);
		
		//File 인스턴스가 가리키고 있는것이 폴더라면 폴더의 이름
		// 파일이라면 확장자를 포함한 파일의 이름
		String fileName = file.getName();
		System.out.println("fileName > "+ fileName);
		
		//File 인스턴스가 가리키고 있는 파일의 크기(byte)
		// 1byte ==> 1
		// 1kb ==> 1024(windows 기준)(windows가 아닐 경우 1000)
		// 1mb ==> 1024 * 1024
		// 1gb ==> 1024 * 1024 * 1024
		// 1tb ==> 1024 * 1024 * 1024 * 1024
		// 1pb ==> 1024 * 1024 * 1024 * 1024 * 1024
		long length = file.length();
		System.out.println("length > "+ length);
		
		// 파일이 마지막으로 수정된 날짜와 시간
		//컴퓨터의 시간기준 ==> 1970-01-01 09:00:00(한국시간기준;+9h이므로) 이때부터 흘러간 초 * 1000
		long lastModifiedTime = file.lastModified();
		System.out.println("lastModifiedTime > "+ lastModifiedTime);
		// long 타입의 날짜와 시간을 문자로 된 날짜와 시간으로 변환
		Date date = new Date(lastModifiedTime);
		System.out.println("lastModifiedTime(Date) > " + date);
		
		//현재 파일이 존재하는 부모(상위) 폴더의 새로운 File 인스턴스
		String parentPath = file.getParent();
		System.out.println("parentPath > "+ parentPath);
		
		//현재 파일이 존재하는 부모(상위) 폴더의 새로운 File 인스턴스
		File parentFile = file.getParentFile();
		System.out.println("parentFile > "+ parentFile);
		System.out.println("parentFileAbsolutePath > " + parentFile.getAbsolutePath());
		
		//File 인스턴스가 폴더일 때, 폴더 내부에 존재하는 모든 폴더와 파일목록 반환
		// 파일일때나 없을땐 null, C드라이브도 보안상 막혀있어 null
		File[] listFileArray = file.listFiles();
		for (File item: listFileArray) {
			System.out.println("listFileArray > "+ item.getAbsolutePath());
		}
	}
}
