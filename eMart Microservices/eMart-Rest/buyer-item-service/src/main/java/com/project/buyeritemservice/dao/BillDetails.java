package com.project.buyeritemservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.buyeritemservice.entity.BillDetailsEntity;
@Repository
public interface BillDetails extends JpaRepository<BillDetailsEntity,Integer>{

}
