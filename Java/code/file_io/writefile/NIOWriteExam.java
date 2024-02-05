package file_io.writefile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NIOWriteExam {
	
	public static void main(String[] args) {
		
		boolean append = true;
		
		File file = new File("C:\\outputs2", "java_output2.txt");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		if (!append) {
			int index = 2;
			while (file.exists()) {
				file = new File(file.getParent(),"java_output2 ("+(index++)+").txt");
			}
		}
		
		//파일에 쓸 내용
		List<String> fileDesc = new ArrayList<>();
		fileDesc.add("파일을 씁니다1.");
		fileDesc.add("파일을 씁니다2.");
		fileDesc.add("파일을 씁니다3.");
	
		//파일을 쓴다
		try{
			
//			Set<StandardOpenOption> defaultOption = Set.of(StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
			
			if(!append) {
				Files.write(file.toPath(), fileDesc, Charset.forName("UTF-8"));
			}
			else {
				Files.write(file.toPath(), fileDesc, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
				
			}
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println(file.getAbsolutePath());
	}

}
