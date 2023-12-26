package com.springbook.biz.board;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int cnt;
	
	private String ch1;
	private String ch2;
}
