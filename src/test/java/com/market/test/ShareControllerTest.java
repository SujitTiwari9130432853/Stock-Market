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

import com.market.controller.ShareController;
import com.market.model.Share;
import com.market.repo.ShareRepo;
import com.market.service.ShareService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShareControllerTest {
	@InjectMocks
	ShareController sharecontroller;
	
	@Mock
	ShareService shareservice;
	
	@Mock
	ShareRepo sharerepo;
	
	@Test
	public void addShareTest(){
		Share s = new Share();
		s.setId(1);
		s.setMarketCap(565465);
		s.setMarketType("Nifty");
		s.setName("ABCD");
		s.setStockPrice(81115);
		s.setStockToSell(60);
		s.setTotalStocks(100);
		
		List<Share> l = new ArrayList<Share>();
		l.add(s);
		
		for (Share share : l) {
			Share s1 = shareservice.saveShare(share);
			
			when(sharecontroller.addShare(s)).thenReturn(s1);
			assertEquals(1, l.size());
		}
	}
	
	@Test
	public void getShareByIdTest(){
		List<Share> l = new ArrayList<>();
		Share s = new Share();
		s.setId(1);
		s.setMarketCap(565465);
		s.setMarketType("Nifty");
		s.setName("ABCD");
		s.setStockPrice(81115);
		s.setStockToSell(60);
		s.setTotalStocks(100);
		
		l.add(s);
		
		Optional<Share> o = l.stream().findFirst();
		
		when(shareservice.getShareById(1)).thenReturn(o);
		assertEquals(sharecontroller.getShare(1), o);
	}

}
