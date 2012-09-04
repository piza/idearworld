package com.idearworld.service;

import java.util.List;

import com.idearworld.model.Comment;

public interface CommentService {

	public int addComment(Comment comment);
	public List<Comment> loadComments(int idear_id);
}
