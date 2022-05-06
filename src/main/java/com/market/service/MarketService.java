package com.market.service;

import java.util.ArrayList;
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
	
	public String deleteById(int id){
		List<Market> l = new ArrayList<Market>();
		List<Market> all = marketrepo.findAll();
		for (Market market : all) {
			if (market.getId()==id) {
				marketrepo.delete(market);
			} else {
				l.add(market);
			}
		}
		System.out.println(l);
		return "THE ELEMENT IS DELETED";
	}
	
	public String deleteAll(){
		List<Market> all = marketrepo.findAll();
		marketrepo.deleteAll(all);
		return "ALL ELEMETS DELETED!!! IT'S EMPTY NOW";
	}
	

}
