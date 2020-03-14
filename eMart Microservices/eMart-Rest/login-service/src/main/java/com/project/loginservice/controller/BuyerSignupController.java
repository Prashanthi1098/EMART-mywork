package com.project.loginservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.loginservice.pojo.BuyerSignupPojo;
import com.project.loginservice.service.BuyerSignupService;

@RestController
@CrossOrigin
@RequestMapping("emart")
public class BuyerSignupController {
	static Logger LOG = Logger.getLogger(BuyerSignupController.class.getClass());
	@Autowired
	BuyerSignupService buyerSignupService;

	// EndPoint to validate Buyer
	@GetMapping("validate")
	BuyerSignupPojo validateBuyer(@RequestHeader("Authorization") String data) {
		LOG.info("Entered the end point \'emart/validate\'");
		LOG.info("exited end point \'emart/validate\'");
		String token[] = data.split(":");
		BuyerSignupPojo buyerSignupPojo = new BuyerSignupPojo();
		buyerSignupPojo.setUsername(token[0]);
		buyerSignupPojo.setPassword(token[1]);
		return buyerSignupService.validateBuyer(buyerSignupPojo);

	}

	// EndPoint to Retrieve BuyerData
	@GetMapping("/buyer/{buyerId}")
	BuyerSignupPojo getBuyer(@PathVariable("buyerId") Integer buyerId) {
		LOG.info("entered end point \'emart/buyer/{buyerId\'");
		LOG.info("exited end point \'emart/buyer/{buyerId\'");

		return buyerSignupService.getBuyer(buyerId);

	}
	
	@PostMapping("/addbuyer")
	BuyerSignupPojo addBuyer(@RequestBody BuyerSignupPojo buyersignupPojo) {
	LOG.info("Entered end point \'emart/addbuyer\' ");
	LOG.info("Exited end point \'emart/addbuyer \' ");
	return buyerSignupService.addBuyer(buyersignupPojo);
	}
}
