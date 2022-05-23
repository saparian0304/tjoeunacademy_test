package chapter18;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedEx2 {

	public static void main(String[] args) throws IOException {
		
		// 보조스트림을 사용 / 미사용 차이
		long start = 0;
		long end = 0;
		
		// 보조스트림 미사용
//		FileInputStream fis = new FileInputStream("C:\\Users\\tjouen-jr\\Downloads\\mysql-installer-community-8.0.29.0.msi");
//		start = System.currentTimeMillis();
//		while (fis.read() != -1) {
//			
//		}
//		end = System.currentTimeMillis();
//		System.out.println("보조스트림 미사용 소요시간 : " + (end - start)); // 1164506초

		// 보조스트림 사용
		FileInputStream fis = new FileInputStream("C:\\Users\\tjouen-jr\\Downloads\\mysql-installer-community-8.0.29.0.msi");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		
		start = System.currentTimeMillis();
		while (bis.read() != -1) {
			
		}
		end = System.currentTimeMillis();
		System.out.println("보조스트림 사용 소요시간 : " + (end - start)); // 6808초 
				
	}

}
