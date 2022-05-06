package com.market.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Market;
import com.market.repo.MarketRepo;
import com.market.service.MarketService;

@RestController
@RequestMapping
public class MarketController {
	@Autowired
	MarketService marketservice;
	@Autowired
	MarketRepo marketrepo;
	
	ArrayList<Market> al = new ArrayList<>();
	
	@PostMapping("/market/save")
	public Market addMarket(@RequestBody Market market){
		Market addedMarket=marketservice.saveMarket(market);
		return addedMarket;
	}
	
	@GetMapping("/market/{id}")
	public Optional<Market> getMarket(@PathVariable int id){
		Optional<Market> getmarket=marketservice.getMarketById(id);
		return getmarket;
	}
	
	@GetMapping("/market/all")
	public List<Market> allMarket(@RequestBody Market m){
		List<Market> allmarket=marketservice.getAll(m);
		return allmarket;
	}
	
	@DeleteMapping("/market/{id}")
	public String deleteById(@PathVariable int id){
		String l = marketservice.deleteById(id);
		return l;
		
	}
	
	@DeleteMapping("/market/deleteAll")
	public String deleteAll(@RequestBody Market m1){
		String l = marketservice.deleteAll();
		return l;
	}
	

}
