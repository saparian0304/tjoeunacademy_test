package chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEx {

	public static void main(String[] args) {

//		FileReader fr = null;
//		BufferedReader br = null;

		// try-with-resources 구문
		try (
			FileReader fr = new FileReader("../src/chapter17/ThreadEx11.java");
			BufferedReader br = new BufferedReader(fr);
		// 아래처럼 사용하기도 함
//			BufferedReader br = new BufferedReader(new FileReader("../src/chapter17/ThreadEx10.java"));
		) {
			String txt = null;
			while ((txt = br.readLine()) != null) {
				System.out.println(txt);
			}
		} catch (IOException e) {
//			System.out.println(e.getMessage());
			System.out.println(e);
		} 

	}

}
