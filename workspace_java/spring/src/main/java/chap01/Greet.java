package chap01;

import lombok.Setter;

@Setter
public class Greet {

	private String format;
	
	public String greet(String name) {
		return String.format(format, name);
	}
}
