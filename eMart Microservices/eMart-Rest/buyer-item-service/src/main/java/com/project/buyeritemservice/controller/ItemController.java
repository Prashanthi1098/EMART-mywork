package com.project.buyeritemservice.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.buyeritemservice.controller.ItemController;
import com.project.buyeritemservice.pojo.ItemPojo;
import com.project.buyeritemservice.service.ItemService;


@RestController
@RequestMapping("emart")
@CrossOrigin
public class ItemController {
	static Logger LOG = Logger.getLogger(ItemController.class.getClass());

	@Autowired
	ItemService itemService;

	//EndPoint to Retrieve AllItems
	@GetMapping("item/all")
	List<ItemPojo> getAllItems() {
		LOG.info("Entered the end point \'emart/item/all\'");
		LOG.info("exited end point \'emart/item/all'");

		return itemService.getAllItems();
	}

	//EndPoints to Retrieve Particular Item
	@GetMapping("/item/{itemId}")
	ItemPojo getItem(@PathVariable("itemId") Integer itemId) {
		LOG.info("Entered the end point \'emart/item/{itemId}\'");
		LOG.info("exited end point \'emart/item/{itemId}\'");

		return itemService.getItem(itemId);
	}

}  
