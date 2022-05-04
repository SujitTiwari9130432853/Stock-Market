package com.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.market.model.Share;
import com.market.model.ShareValue;
import com.market.model.Transactions;
import com.market.repo.MarketRepo;
import com.market.repo.ShareRepo;
import com.market.repo.ShareValueRepo;
import com.market.repo.TransactionRepo;

@Service
@Transactional
public class ShareService {
	@Autowired
	ShareRepo sharerepo;
	
	@Autowired
	TransactionRepo transrepo;
	
	@Autowired
	MarketRepo marketrepo;
	
	@Autowired
	ShareValueRepo sharevaluerepo;
	
	public Share saveShare(Share share){
		Share updateShare=sharerepo.save(share);
		return updateShare;
	}
	
	public Optional<Share> getShareById(int id){
		Optional<Share> share=sharerepo.findById(id);
		return share;
	}
	
	public List<Share> getAll(Share share){
		List<Share> all=sharerepo.findAll();
		return all;
	}

}
