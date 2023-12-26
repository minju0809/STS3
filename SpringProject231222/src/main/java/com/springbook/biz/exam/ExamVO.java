package com.springbook.biz.exam;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExamVO {
	private int sno;
	private String sname;
	private int kor;
	private int eng;
	private int math;
	private int hist;
	
	private String ch1;
	private String ch2;
}
