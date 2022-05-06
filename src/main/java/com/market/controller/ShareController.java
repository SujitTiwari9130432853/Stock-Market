package com.market.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Share;
import com.market.service.ShareService;

@RestController
@RequestMapping
public class ShareController {
	@Autowired
	ShareService shareservice;
	@PostMapping("/share/save")
	public Share addShare(@RequestBody Share share){
		Share addedshare=shareservice.saveShare(share);
		return addedshare;
	}
	
	@GetMapping("/share/{id}")
	public Optional<Share> getShare(@PathVariable int id){
		Optional<Share> getShare=shareservice.getShareById(id);
		return getShare;
	}
	
	@GetMapping("/share/all")
	public List<Share> allShare(@RequestBody Share share){
		List<Share> allshare=shareservice.getAll(share);
		return allshare;
	}
	
	@DeleteMapping("/share/{id}")
	public String deleteById(@PathVariable int id){
		String l = shareservice.deleteById(id);
		return l;
	}
	
	@DeleteMapping("/share/deleteAll")
	public String deleteAll(@RequestBody Share share1){
		String l = shareservice.deleteAll();
		return l;
 	}
	
}
