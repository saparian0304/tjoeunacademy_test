package com.example.sns.member;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class MemberVO {

	private int no;
	private String name;
	private String id;
	@JsonIgnore
	private String pwd;
	private LocalDateTime reg_date;
}
