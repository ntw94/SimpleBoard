package board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _common.BoardPaging;
import board.mapper.BoardMapper;
import board.model.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public int getTotalRecord(Map<String,Object> map) {
		return mapper.getTotalRecord(map);
	}
	@Override
	public BoardPaging createBoardPaging(int pageSize,int blockSize, int totalRecord,String page) {
		
		return new BoardPaging(pageSize,blockSize,totalRecord,Integer.parseInt(page));
	}
	@Override
	public List<Board> getBoardListAll(Map<String,Object> map){
		return mapper.getList(map);
	}

	@Override
	public Board getListOne(int board_no) {
		return mapper.getListOne(board_no);
	}

	@Override
	public int setInsert(Board member) {
		return mapper.setInsert(member);
	}

	@Override
	public int setDelete(int board_no) {
		return mapper.setDelete(board_no);
	}

	@Override
	public int setUpdate(Board member) {
		return mapper.setUpdate(member);
	}

	@Override
	public int setViewUP(int board_no) {
		return mapper.setViewUP(board_no);
	}

	@Override
	public int getBoardRecoStatus(Map<String, Object> map) {
		return mapper.getBoardRecoStatus(map);
	}

	@Override
	public int getTotalBoardReco(int board_no) {
		return mapper.getTotalBoardReco(board_no);
	}

	@Override
	public void setRecoInsert(Map<String, Object> map) {
		mapper.setRecoInsert(map);
	}

	@Override
	public void setRecoDelete(Map<String, Object> map) {
		mapper.setRecoDelete(map);
	}
}
