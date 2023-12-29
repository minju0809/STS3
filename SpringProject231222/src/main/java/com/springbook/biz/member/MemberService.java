package com.springbook.biz.member;

import java.util.List;

public interface MemberService {
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	int getMemberId();
	
	void insert(MemberVO vo);
	void delete(MemberVO vo);
	void update(MemberVO vo);
}
