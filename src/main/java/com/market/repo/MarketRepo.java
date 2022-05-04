package com.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Market;

public interface MarketRepo extends JpaRepository<Market, Integer>{

}
