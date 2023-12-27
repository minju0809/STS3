package com.springbook.biz.psd;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PsdVO {
	private int seq;
	private String title;
	private String regdate;
	private MultipartFile uploadFile;
	private String uploadFileStr;
	private int cnt;
}
