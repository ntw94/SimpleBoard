package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.mapper.MemberMapper;
import member.model.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public Member getListOne(String member_id) {
		// TODO Auto-generated method stub
		return mapper.getListOne(member_id);
	}

	@Override
	public void setInsert(Member member) {
		// TODO Auto-generated method stub
		mapper.setInsert(member);
	}

	@Override
	public void setDelete(int member_no) {
		mapper.setDelete(member_no);
	}

	@Override
	public void setUpdate(Member member) {
		mapper.setUpdate(member);
	}

	@Override
	public Member setLogin(Member member) {
		// TODO Auto-generated method stub
		return mapper.setLogin(member);
	}

}
