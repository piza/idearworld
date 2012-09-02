package com.idearworld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idearworld.dao.IdearsMapper;
import com.idearworld.model.Idears;
import com.idearworld.model.IdearsExample;
import com.idearworld.service.IdearService;


@Service("idearService")
public class IdearServiceImpl implements IdearService{
	
	private IdearsMapper idearsMapper;
	
    @Autowired	
	public void setIdearsMapper(IdearsMapper idearsMapper) {
		this.idearsMapper = idearsMapper;
	}



	@Override
	public int createIdear(Idears idear) {
		
		return idearsMapper.insert(idear);
	}



	@Override
	public List<Idears> browseIdear() {
	    IdearsExample example=new IdearsExample();
	    
	    example.or().andIdearIdGreaterThan(1);
		return this.idearsMapper.selectByExample(example);
	}



	@Override
	public Idears getIdearById(Integer id) {
		this.idearsMapper.selectByPrimaryKey(id);
		return null;
	}

	
}
