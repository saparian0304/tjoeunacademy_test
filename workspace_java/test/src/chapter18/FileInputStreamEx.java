package chapter18;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("../src/chapter17/ThreadEx10.java");
			int data = 0;
			byte[] buf = new byte[fis.available()];
			while ((data = fis.read(buf)) != -1) {
//				System.out.print((char) data);
				System.out.print(new String(buf, 0, data));
			}

		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
}
