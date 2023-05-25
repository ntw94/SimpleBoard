package member.service;

import java.util.List;

import member.model.Member;

public interface MemberService {
	public List<Member> getList();
	public Member getListOne(String member_id);
	public void setInsert(Member member);
	public void setDelete(int member_no);
	public void setUpdate(Member member);
	
	//로그인 처리
	public Member setLogin(Member member);
}
