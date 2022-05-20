package chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Properties 파일 읽어오기
			Properties pr = new Properties();
			FileInputStream reader = new FileInputStream(
					"D:/kdigital_a/Java/workspace/tjoeunacademy_test/src/chapter13" + "/config.properties");
			// Properties 객체에 로드
			pr.load(reader);
			System.out.println(pr);
			System.out.println("이름 : " + pr.get("name"));
			
			// property에 키, 값으로 추가
			pr.put("subject", " 자바");
			System.out.println(pr);
			
			// properties 파일로 출력 (저장)
			pr.store(new FileOutputStream("D:/kdigital_a/Java/workspace/tjoeunacademy_test/src/chapter13/"
						+ "test.properties"), "#save");
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

}
