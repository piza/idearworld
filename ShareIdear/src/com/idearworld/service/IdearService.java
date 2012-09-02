package com.idearworld.service;

import java.util.List;

import com.idearworld.model.Idears;


public interface IdearService {

	
	public int createIdear(Idears idear);
	
	public List<Idears> browseIdear();
	
	public Idears getIdearById(Integer id);
}
