package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.mapper.MemberMapper;
import member.model.Member;
import member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberMapper mapper;

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/*")
	public String index(Model model) {
		
		
		return "index";
	}
	
	@RequestMapping("/memberRegisterForm.do")
	public String memberRegisterForm() {
		
		return "member/memberRegisterForm";
	}
	
	@PostMapping("/memberInsert")
	public String memberInsert(Member member , HttpSession session, RedirectAttributes rttr) throws IOException {
		
		boolean isPass = true;
		if(member.getMember_id() == null || member.getMember_id().equals("")) {
			isPass = false;
		}
		if(member.getMember_pwd() == null || member.getMember_pwd().equals("")) {
			isPass = false;
		}
		if(member.getMember_name() == null || member.getMember_name().equals("")) {
			isPass = false;
		}
		if(member.getMember_email()== null || member.getMember_email().equals("")) {
			isPass = false;
		}
		
	
		if(isPass) {
			memberService.setInsert(member);
			session.setAttribute("member", member);
			return "redirect:/index";
		}else {
			rttr.addFlashAttribute("msgType", "글 등록 오류");
			rttr.addFlashAttribute("msg", "내용을 다시 입력해 주세요");
			return "redirect:/memberRegisterForm.do";
		}
	}
	

	@RequestMapping("/memberUpdateForm.do")
	public String memberUpdateForm(HttpServletRequest request,Model model) throws Exception {
		
		HttpSession session = request.getSession();
		if(session == null) {
			return "index";
		}
		Member memberId = (Member) session.getAttribute("member");
		
		Member resMember = memberService.getListOne(memberId.getMember_id());
		model.addAttribute("memberDTO", resMember);
		
		return "member/memberUpdateForm";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(Member member) {
		
		memberService.setUpdate(member);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session == null) {
			return "index";
		}
		Member memberId = (Member) session.getAttribute("member");
		Member resMember = memberService.getListOne(memberId.getMember_id());
		
		mapper.setDelete(resMember.getMember_no());
		
		return "redirect:/memberLogout.do";
	}
	
	
	
	@RequestMapping("/memberIdCheck.do")
	public @ResponseBody int memberIdCheck(@RequestParam("member_id") String member_id){
		
		System.out.println(member_id);
		Member member= memberService.getListOne(member_id);
		
		if(member != null || member_id.equals("")) {
			return 0;
		}
		return 1;
	}
	
	//로그인
	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		
		
		return "member/memberLoginForm";
	}
	
	@RequestMapping("/memberLogin.do")
	public String memberLogin(Member member , HttpSession session) {
		Member m = memberService.setLogin(member);
		
		if(m != null) {
			session.setAttribute("member", m);
			return "redirect:/";
		}
		
		return "redirect:/memberLoginForm.do";
	}
	
	@RequestMapping("/memberLogout.do")
	public String memLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
