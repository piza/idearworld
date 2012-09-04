package com.idearworld.web.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.idearworld.service.CommentService;

@Controller
public class CommentAdminAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CommentService commentService;
    private String idearId;
	private String commentId;
	private String commentType;
	private String comment;
	public String addComment(){
		
		return SUCCESS;
	}
	
	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public String getIdearId() {
		return idearId;
	}

	public void setIdearId(String idearId) {
		this.idearId = idearId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	

}
