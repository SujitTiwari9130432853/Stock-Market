package com.market.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.market.controller.MarketController;
import com.market.model.Market;
import com.market.repo.MarketRepo;
import com.market.service.MarketService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MarketControllerTest {
	@InjectMocks
	MarketController marketcontroller;
	
	@Mock
	MarketService marketservice;
	
	@Mock
	MarketRepo marketrepo;
	
	@Test
	public void addMarketTest(){
		Market m = new Market();
		m.setId(1);
		m.setName("Nifty");
		m.setValue(54654);
		
		List<Market> ml = new ArrayList<Market>();
		
		ml.add(m);
		for (Market market : ml) {
			Market m1 =marketservice.saveMarket(market);
		
		when(marketcontroller.addMarket(m)).thenReturn(m1);
		assertEquals(1, ml.size());
	}
	}
	
	@Test
	public void getMarketByIdTest(){
		
		List<Market> l = new ArrayList<>();
		Market m = new Market();
		m.setId(1);
		m.setName("Nifty");
		m.setValue(54654);
		l.add(m);
		
		Optional<Market> o = l.stream().findFirst();
		
		when(marketservice.getMarketById(1)).thenReturn(o);
		assertEquals(marketcontroller.getMarket(1), o);
		
	}
	

}
