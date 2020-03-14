package com.project.buyeritemservice.service;

import java.util.List;

import com.project.buyeritemservice.pojo.ItemPojo;

public interface ItemService {

	List<ItemPojo> getAllItems();
	ItemPojo getItem(int ItemId);	
	
}
