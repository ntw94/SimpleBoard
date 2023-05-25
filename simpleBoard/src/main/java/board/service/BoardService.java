package board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import _common.BoardPaging;
import board.model.Board;

public interface BoardService {
	public int getTotalRecord(Map<String,Object> map);
	public BoardPaging createBoardPaging(int pageSize,int blockSize, int totalRecord,String page);
	public List<Board> getBoardListAll(Map<String,Object> map);

	public Board getListOne(int board_no);
	public int setInsert(Board member);
	public int setDelete(int board_no);
	public int setUpdate(Board member);
	
	public int setViewUP(int board_no);
	
	//사용자에 대한 좋아요 상태 조회
	public int getBoardRecoStatus(Map<String,Object> map);
	//해당 게시물의 좋아요 조회
	public int getTotalBoardReco(int board_no);
	//좋아요 등록
	public void setRecoInsert(Map<String,Object> map);
	public void setRecoDelete(Map<String,Object> map);
}
