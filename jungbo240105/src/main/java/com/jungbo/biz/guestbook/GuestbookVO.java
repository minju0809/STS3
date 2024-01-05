package com.jungbo.biz.guestbook;

public class GuestbookVO {
	private int guestbook_idx;
	private String guestbook_name;
	private String guestbook_memo;
	private String guestbook_today;
	
	private int ref;
	private int step;
	private int lv;
	
	private String ch1;
	private String ch2;
	
	private int rownum;
	private int rnum;
	
	private int start;
	private int pageSize;
	private int end;
	
	public int getGuestbook_idx() {
		return guestbook_idx;
	}
	public void setGuestbook_idx(int guestbook_idx) {
		this.guestbook_idx = guestbook_idx;
	}
	public String getGuestbook_name() {
		return guestbook_name;
	}
	public void setGuestbook_name(String guestbook_name) {
		this.guestbook_name = guestbook_name;
	}
	public String getGuestbook_memo() {
		return guestbook_memo;
	}
	public void setGuestbook_memo(String guestbook_memo) {
		this.guestbook_memo = guestbook_memo;
	}
	public String getGuestbook_today() {
		return guestbook_today;
	}
	public void setGuestbook_today(String guestbook_today) {
		this.guestbook_today = guestbook_today;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
