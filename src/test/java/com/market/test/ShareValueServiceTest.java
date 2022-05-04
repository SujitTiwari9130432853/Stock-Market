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

import com.market.model.ShareValue;
import com.market.repo.ShareValueRepo;
import com.market.service.ShareValueService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ShareValueServiceTest {

	@InjectMocks
	ShareValueService sharevalueservice;

	@Mock
	ShareValueRepo sharevaluerepo;

	@Test
	public void findAllTest() {
		List<ShareValue> l = new ArrayList<ShareValue>();

		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(2);
		sv.setCurrent_value(15635);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());

		l.add(sv);

		when(sharevaluerepo.findAll()).thenReturn(l);
		assertEquals(1, sharevalueservice.getAll(sv).size());
	}
	
	@Test
	public void saveTest(){
		List<ShareValue> l = new ArrayList<>();
		
		ShareValue sv = new ShareValue();
		sv.setId(1);
		sv.setShare_id(1);
		sv.setCurrent_value(511515);
		sv.setDate(sv.getDate());
		sv.setTime(sv.getTime());
		
		l.add(sv);
		
		for (ShareValue shareValue : l) {
			when(sharevaluerepo.save(shareValue)).thenReturn(sv);
		}
	}

}
