package org.zerock.domain;

import lombok.Data;

@Data
public class SampleDTO {
	private String name;
	private int age;
	
	// lombok이 setter가 있는 것은 만들지 않는다.
	public void setName(String name) {
		this.name = name + "님";
	}
}

