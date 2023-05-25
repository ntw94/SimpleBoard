package comment.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.mapper.CommentMapper;
import comment.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper mapper;

	@Override
	public List<Comment> getList(int comment_no) {
		// TODO Auto-generated method stub
		return mapper.getList(comment_no);
	}

	@Override
	public Comment getListOne(int comment_no) {
		// TODO Auto-generated method stub
		return mapper.getListOne(comment_no);
	}

	@Override
	public int setInsert(Comment comment) {
		// TODO Auto-generated method stub
		return mapper.setInsert(comment);
	}

	@Override
	public int setDelete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.setDelete(map);
	}

	@Override
	public int setUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.setUpdate(map);
	}

	@Override
	public int getCommentCount(int board_no) {
		// TODO Auto-generated method stub
		return mapper.getCommentCount(board_no);
	}
	
	
}
