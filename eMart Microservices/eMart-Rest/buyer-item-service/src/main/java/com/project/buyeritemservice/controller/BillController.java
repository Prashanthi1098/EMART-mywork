package com.project.buyeritemservice.controller;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.buyeritemservice.pojo.BillPojo;
import com.project.buyeritemservice.service.BillService;
import com.project.buyeritemservice.controller.BillController;

@RestController
@CrossOrigin
@RequestMapping("emart")
public class BillController {
	static Logger LOG = Logger.getLogger(BillController.class.getClass());

	@Autowired
	BillService billService;

	// EndPoint to addBill
	@PostMapping("/addBill")
	BillPojo addBill(@RequestBody BillPojo billPojo) {
		LOG.info("Entered the end point \'emart/bitem\'");
		LOG.info("exited end point \'emart/bitem\'");
		return billService.addBill(billPojo);
	}
}
