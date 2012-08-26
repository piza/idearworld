package com.idearworld.web.actions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.idearworld.model.Idears;
import com.idearworld.service.IdearService;



@Controller
public class IdearAdminAction extends BaseAction{

	
	
	private IdearService idearService;
	
	
	private String title;
	private String problem;
	private String solution;

	private String jsonMsg;
	
	@Autowired
	public void setIdearService(IdearService idearService) {
		this.idearService = idearService;
	}
	
	public String createIdear(){
		Idears idear=new Idears();
		idear.setTitle(title);
		idear.setProblem(problem);
		idear.setSolution(solution);
		idear.setCreateDate(new Date());
		int res=this.idearService.createIdear(idear);
		this.jsonMsg=res+"";
		return SUCCESS;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getJsonMsg() {
		return jsonMsg;
	}

	public void setJsonMsg(String jsonMsg) {
		this.jsonMsg = jsonMsg;
	}
	
	
	
}
