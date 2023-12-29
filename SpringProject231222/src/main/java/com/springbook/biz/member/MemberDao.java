package com.springbook.biz.member;

import java.util.List;

public interface MemberDao {
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	int getMemberId();
	MemberVO getMemberLogin(MemberVO vo);
	
	void insert(MemberVO vo);
	void delete(MemberVO vo);
	void update(MemberVO vo);
}
