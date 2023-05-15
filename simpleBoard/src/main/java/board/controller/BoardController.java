package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import _common.BoardPaging;
import board.mapper.BoardMapper;
import board.model.Board;
import board.model.BoardReco;
import comment.mapper.CommentMapper;
import comment.model.Comment;
import member.model.Member;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private CommentMapper commentMapper;
	

	
	//게시판 메인페이지
	@RequestMapping("/boardList.do")
	public String boardList(Model model,
			HttpServletRequest request,
			@RequestParam(value="page",required=false,defaultValue="1") String page ,
			@RequestParam(name = "searchMenu",required=false) String searchMenu,
			@RequestParam(name = "searchData",required=false) String searchData
			) {

		System.out.println(searchMenu +" " + searchData);
		
		if(searchMenu == null || searchMenu.equals("")) {
			searchMenu="";
			searchData="";
		}
		if(searchData == null || searchData.equals("")) {
			searchMenu="";
			searchData="";
		}
		
		
		if(page == null || page.equals(""))
			page = "1";
		int totalRecord = mapper.getTotalRecord();
		//좋아요 상태
		
		int pageSize = 5;
		
		BoardPaging boardPage = new BoardPaging(pageSize,10,totalRecord,Integer.parseInt(page));
		
		
		Map<String,Object> map = new HashMap<>();
		map.put("startRecord", boardPage.getStartRecord()-1);
		map.put("lastRecord", boardPage.getLastRecord());
		map.put("pageSize",pageSize);
		map.put("searchMenu",searchMenu);
		map.put("searchData",searchData);
		
		
		List<Board> list = mapper.getList(map);
		model.addAttribute("list", list);
		model.addAttribute("page",page);
		model.addAttribute("boardPage",boardPage);
		model.addAttribute("searchMenu",searchMenu);
		model.addAttribute("searchData",searchData);

		
		return "board/boardList";
	}

	//게시판 글 등록
	@RequestMapping("/boardInsertForm.do")
	public String boardInsertForm() {

		return "board/boardInsertForm";
	}
	
	//게시판 상세보기
	@GetMapping("/boardView.do")
	public String boardView(Model model,@RequestParam("no") int board_no,HttpServletRequest request) {
		

		mapper.setViewUP(board_no);

		int resRecoStatus = 0;
		
		Board boardDTO = mapper.getListOne(board_no);
		model.addAttribute("boardDTO", boardDTO);
		
		List<Comment> commentList = commentMapper.getList(board_no);
		model.addAttribute("commentList",commentList);
		
		int commentCnt = commentMapper.getCommentCount(board_no);
		model.addAttribute("commentCount",commentCnt);
		
		//좋아요 갯수
		int recommendCnt = mapper.getTotalBoardReco(board_no);
		model.addAttribute("recoCnt", recommendCnt);
		

		HttpSession session = request.getSession();
		if(session != null) {
			Member sessionMem = (Member) session.getAttribute("member");	
				if(sessionMem != null) {
				Map<String,Object> recoMap = new HashMap<>();
				recoMap.put("member_id", sessionMem.getMember_id());
				recoMap.put("board_no",board_no);
			
				resRecoStatus= mapper.getBoardRecoStatus(recoMap);
			}
		}
		model.addAttribute("recoStatus",resRecoStatus);
		
		return "board/boardView";
	}

	
	@PostMapping("/boardInsert")
	public String boardInsert(Board board, RedirectAttributes rttr) {

		if (board.getBoard_subject() == null || board.getBoard_subject().equals("") ||
				board.getBoard_content() == null || board.getBoard_content().equals("") ||
				board.getBoard_writer() == null || board.getBoard_writer().equals("")){
			rttr.addFlashAttribute("msgType", "글 등록 오류");
			rttr.addFlashAttribute("msg", "내용을 다시 입력해 주세요");
			
			 return "redirect:/boardInsertForm.do";
		}

		
		  int result = mapper.setInsert(board);
		  if(result == 1) {
			  return "redirect:/boardList.do";
		  }else {
			 rttr.addFlashAttribute("msgType", "글 등록 오류");
			 rttr.addFlashAttribute("msg","글 등록 실패");
			 
			 return "redirect:/boardInsertForm.do";
		  }
	}
	
	@RequestMapping("/boardUpdateForm")
	public String boardUpdateForm(Model model,@RequestParam("no")int board_no) {
		
		Board boardDTO = mapper.getListOne(board_no);
		
		model.addAttribute("boardDTO",boardDTO);
			
		return "/board/boardUpdateForm";
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(Model mode, Board board) {
		
		int result = mapper.setUpdate(board);
		
		return "redirect:/boardView.do?no="+board.getBoard_no();
	}
	
	@PostMapping("/boardDelete")
	public String boardDelete(int board_no) {
		
		int result = mapper.setDelete(board_no);
		
		return "redirect:/boardList.do";
	}

	//좋아요 등록
	@PostMapping("/board/reco/insert")
	public @ResponseBody void boardRecoInsert(BoardReco boardReco) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("board_no", boardReco.getBoard_no());
		map.put("member_id", boardReco.getMember_id());
		map.put("reco_status", boardReco.getReco_status());
		
		
		mapper.setRecoInsert(map);
		
	}
	
	//좋아요 해제
	@PostMapping("/board/reco/delete")
	public  @ResponseBody void boardRecoDelete(BoardReco boardReco) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("board_no", boardReco.getBoard_no());
		map.put("member_id", boardReco.getMember_id());
		
		mapper.setRecoDelete(map);
		
	}
	
}
