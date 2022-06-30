package chap04;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	private int num;
	private String title;
	private String content;
	private String id;
	private Timestamp postdate;
	private int visitcount;
	private String sfile;
	private String ofile;
	
	private String searchField;	
	private String searchWord;
	private String searchDate;
	private String[] nums;
	
	// 이름이 다른 경우(컬럼명은 title, 필드명은 subject)
	private String subject;
}
