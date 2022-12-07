package com.example.sns.post;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostVO {

	private int no;
	private int member_no;
	private String contents;
	private LocalDateTime reg_date;
}
