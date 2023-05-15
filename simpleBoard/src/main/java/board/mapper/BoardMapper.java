package board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import board.model.Board;
import member.model.Member;


@Mapper
public interface BoardMapper {

//	public List<Board> getList(Map<String,Object> map);
	public List<Board> getList(@Param("map")Map<String,Object> map);
	
	public Board getListOne(int board_no);
	public int setInsert(Board member);
	public int setDelete(int board_no);
	public int setUpdate(Board member);
	
	public int setViewUP(int board_no);
	public int getTotalRecord();
	
	//사용자에 대한 좋아요 상태 조회
	public int getBoardRecoStatus(@Param("map")Map<String,Object> map);
	//해당 게시물의 좋아요 조회
	public int getTotalBoardReco(int board_no);
	//좋아요 등록
	public void setRecoInsert(@Param("map")Map<String,Object> map);
	public void setRecoDelete(@Param("map")Map<String,Object> map);
	
}
