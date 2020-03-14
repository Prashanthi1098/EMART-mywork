package com.project.loginservice.controller;

import java.util.List;

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
import com.project.loginservice.pojo.ItemPojo;
import com.project.loginservice.pojo.SellerSignupPojo;
import com.project.loginservice.service.SellerSignupService;

@RestController
@CrossOrigin
@RequestMapping("emart")
public class SellerSignupController {

	@Autowired
	SellerSignupService sellerSignupService;
	

	@GetMapping("validateseller")
	
		SellerSignupPojo validateSeller(@RequestHeader("Authorization") String data)
		{
			String token[] = data.split(":");
			SellerSignupPojo sellerSignupPojo = new SellerSignupPojo();
			sellerSignupPojo.setUsername(token[0]);
			sellerSignupPojo.setPassword(token[1]);
			return sellerSignupService.validateSeller(sellerSignupPojo);


		}
	@GetMapping("/selleritems/{sellerId}")
	SellerSignupPojo allItems(@PathVariable("sellerId") Integer sellerId)
	{
		return sellerSignupService.allItems(sellerId);
	}
	
	@PostMapping("/addseller")
	SellerSignupPojo addSeller(@RequestBody SellerSignupPojo sellersignupPojo) {
	return sellerSignupService.addSeller(sellersignupPojo);
	}
}
