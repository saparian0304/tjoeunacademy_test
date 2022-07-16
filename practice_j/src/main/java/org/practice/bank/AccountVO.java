package org.practice.bank;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountVO {

	private int accountNum;		// 계좌번호
	private String holder;			// 계좌주인
	private int age;				// 나이
	private String gender;			// 성별

	private int idx;
	private int balance;			// 계좌 잔고
	private int deposit;			// 입금
	private int withdraw;			// 출금
	
	private Timestamp regidate;		// 계좌생성일
	private Timestamp updatedate;	// 최종거래일자
	
	private String msg;			// 전달할 메세지
	private String go;			// 이동할 페이지정보
	
}