package com.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int bno;
	private String title,content,writer;
	private String regDate,updateDate;
}
