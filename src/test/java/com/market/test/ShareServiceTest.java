package com.market.test;

import static org.junit.Assert.*;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;

import com.market.model.Share;
import com.market.repo.ShareRepo;
import com.market.service.ShareService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShareServiceTest {

	@InjectMocks
	ShareService shareservice;

	@Mock
	ShareRepo sharerepo;

	@Test
	public void findAllTest() {

		List<Share> shareList = new ArrayList<Share>();

		Share share = new Share();
		share.setId(1);
		share.setMarketCap(1456254);
		share.setMarketType("Nifty");
		share.setName("Tata Motors");
		share.setStockPrice(14554);
		share.setStockToSell(60);
		share.setTotalStocks(100);

		shareList.add(share);

		when(sharerepo.findAll()).thenReturn(shareList);
		assertEquals(1, shareservice.getAll(share).size());
	}
	
	@Test
	public void saveTest(){
		List<Share> l = new ArrayList<>();
		Share s = new Share();
		s.setId(1);
		s.setMarketCap(51111);
		s.setMarketType("ABCD");
		s.setName("efgh");
		s.setStockPrice(5555);
		s.setStockToSell(90);
		s.setTotalStocks(100);
		
		l.add(s);
		shareservice.saveShare(s);
		for (Share share : l) 
			when(sharerepo.save(share)).thenReturn(s);
		    assertEquals(0, shareservice.getAll(s).size());
		
	}

}
