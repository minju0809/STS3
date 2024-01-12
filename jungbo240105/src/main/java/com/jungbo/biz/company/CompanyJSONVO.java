package com.jungbo.biz.company;

import lombok.Data;

@Data
public class CompanyJSONVO {
	private String festvNm; // 축제명
	private String festvSumm; // 축제 요약
	private String festvTpic; // 축제 주제
	private String festvPrid; // 축제 기간
	private String festvPlcNm; // 축제장소 명
	private String festvHostNm; // 축제 주최 명

	private String svorgnNm; // 주관기관 명
	private String festvZip; // 축제 우편번호
	private String festvAddr; // 축제 주소
	private String festvDtlAddr; // 축제 상세 주소
	private String refadNo; // 문의처 번호
	private String hmpgAddr; // 홈페이지 주소
}
