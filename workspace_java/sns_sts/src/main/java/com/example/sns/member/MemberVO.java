package com.example.sns.member;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MemberVO {

	private int no;
	@ApiModelProperty(value = "이름")
	private String name;
	private String id;
	@JsonIgnore
	private String pwd;
	private LocalDateTime reg_date;
}
