package com.springbook.biz.guestbook;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GuestbookVO {
	private int guestbook_idx;
	private String guestbook_name;
	private String guestbook_memo;
	private String guestbook_today;
	
	private String ch1;
	private String ch2;
	
	private int start;
	private int pageSize;
	private int end;
}
