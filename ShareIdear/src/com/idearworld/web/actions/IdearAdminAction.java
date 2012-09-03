package com.idearworld.web.actions;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.idearworld.model.Idears;
import com.idearworld.service.IdearService;



@Controller
public class IdearAdminAction extends BaseAction{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private IdearService idearService;
	
	private String idearId;
	private String title;
	private String problem;
	private String solution;

	private String jsonMsg;
	
	private JSONArray idearArray;
	
	private JSONObject idearDetails;
	@Autowired
	public void setIdearService(IdearService idearService) {
		this.idearService = idearService;
	}
	
	public String browseIdear(){
		
		List<Idears> list=this.idearService.browseIdear();
		
		idearArray=JSONArray.fromObject(list);
		
		return SUCCESS;
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

	public String openIdear(){
		System.out.println("idearId= "+idearId);
		this.putToSession("IdearID", this.idearId);
		return SUCCESS;
	}
	
	public String loadIdear(){
		
		String id=(String)this.getFromSession("IdearID");
		System.out.println("id="+id);
		if(id==null){
			return ERROR;
		}
		Idears idear=this.idearService.getIdearById(Integer.valueOf(id));
		this.idearDetails=JSONObject.fromObject(idear);
		return SUCCESS;
	}
	
	public JSONArray getIdearArray() {
		return idearArray;
	}

	public void setIdearArray(JSONArray idearArray) {
		this.idearArray = idearArray;
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

	public JSONObject getIdearDetails() {
		return idearDetails;
	}

	public void setIdearDetails(JSONObject idearDetails) {
		this.idearDetails = idearDetails;
	}

	public String getIdearId() {
		return idearId;
	}

	public void setIdearId(String idearId) {
		this.idearId = idearId;
	}
	
	
	
}
