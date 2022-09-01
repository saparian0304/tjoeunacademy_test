package com.spring.jsp2.board;

import java.sql.Timestamp;

import com.spring.jsp2.util.Parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO extends Parameter {

	private int idx;
	private String name;
	private String title;
	private String content;
	private Timestamp postdate;
	private String ofile;
	private String sfile;
	private int downcount;
	private String pass;
	private int visitcount;
	
	
}
