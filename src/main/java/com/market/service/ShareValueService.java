package com.market.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.ShareValue;
import com.market.repo.ShareValueRepo;

@Service
@Transactional
public class ShareValueService {
	@Autowired
	ShareValueRepo sharevaluerepo;
	
	public ShareValue saveShare(ShareValue sharevalue){
		ShareValue sv=sharevaluerepo.save(sharevalue);
		return sv;
	}
	
	public Optional<ShareValue> getShareValuebyID(int id){
		Optional<ShareValue> getbyid=sharevaluerepo.findById(id);
		return getbyid;
	}
	
	public List<ShareValue> getAll(ShareValue s){
		List<ShareValue> all=sharevaluerepo.findAll();
		return all;
	}

}
