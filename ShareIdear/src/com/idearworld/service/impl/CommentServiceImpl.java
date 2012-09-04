package com.idearworld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idearworld.dao.CommentMapper;
import com.idearworld.model.Comment;
import com.idearworld.model.CommentExample;
import com.idearworld.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	private CommentMapper commentMapper;
	
	 @Autowired
	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	@Override
	public int addComment(Comment comment) {
		return this.commentMapper.insert(comment);
	}

	@Override
	public List<Comment> loadComments(int idear_id) {
		CommentExample example=new CommentExample();
		example.or().andIdearIdEqualTo(idear_id);
		
		return this.commentMapper.selectByExample(example);
	}

}
