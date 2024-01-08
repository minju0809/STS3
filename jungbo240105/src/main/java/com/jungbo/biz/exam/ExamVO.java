package com.jungbo.biz.exam;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExamVO {
	private String sno;
	private String sname;
	private int kor;
	private int eng;
	private int math;
	private int hist;
	private int sum;
	private double avg;
	private String grade;
}
