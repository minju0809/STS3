package com.springbook.biz.board;

import java.sql.Date;

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
}
