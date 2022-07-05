package com.spring.jsp2.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parameter {
	// 검색
	private String searchField;
	private String searchWord;
	
	// 페이징
	private int start;
	private int end;
	private int pageNum;
	
	private int pageSize;
	private int blockSize;
	
	public Parameter() {
		this.pageSize = 10;
		this.blockSize = 5;
		this.pageNum = 1;
	}
	
	public int getStart() {
		return (pageNum -1) * pageSize + 1;
	}
	
	public int getEnd() {
		return pageNum * pageSize;
	}
}
