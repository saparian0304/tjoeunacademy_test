package kr.co.project.news;

import java.sql.Date;

import lombok.Data;

@Data
public class NewsVO {

	public int no;
	public String title;
	public String content;
	public String writer;
	public Date postdate;
	public int viewcount;
	
	public String SearchType;
	public String SearchWord;
	
	
}
