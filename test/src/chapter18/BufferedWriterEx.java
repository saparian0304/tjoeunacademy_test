package chapter18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterEx {

	public static void main(String[] args) {

		try {
			FileWriter fw =
					new FileWriter("test4.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			//문자 하나 출력
			bw.write('A');
			// 문자 배열 출력
			char[] buf = {'B', 'C', 'D'};
			bw.write(buf);
			// 문자 배열 off부터 len개수만큼 출력
			bw.write(buf,1,2);
			
			//문자열 출력
			bw.write("저는 홍길동 입니다.");
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
