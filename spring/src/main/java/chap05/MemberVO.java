package chap05;

import lombok.Data;

@Data
public class MemberVO {

	private int num;
	private String id;
	private String name;
	private String tel;
	private String[] hobby;
}
