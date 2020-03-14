package com.project.loginservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.loginservice.entity.BuyerSignupEntity;

@Repository
public interface BuyerSignupDao extends JpaRepository<BuyerSignupEntity,Integer> {
	BuyerSignupEntity findByUsernameAndPassword(String username, String password);
}
