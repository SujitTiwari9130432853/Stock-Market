package com.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Share;

public interface ShareRepo extends JpaRepository<Share, Integer>{

}
