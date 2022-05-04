package com.market.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Market;

import com.market.repo.MarketRepo;
import com.market.repo.TransactionRepo;

@Service
@Transactional
public class MarketService {
	@Autowired
	MarketRepo marketrepo;
	
	@Autowired
	TransactionRepo transactionrepo;
	
	public Market saveMarket(Market market){
		Market updateMarket=marketrepo.save(market);
		return updateMarket;	
	}
	
	public Optional<Market> getMarketById(int id){
		Optional<Market> market=marketrepo.findById(id);
		return market;
	}
	
	public List<Market> getAll(Market market){
		List<Market> all=marketrepo.findAll();
		return all;
	}
	

}
