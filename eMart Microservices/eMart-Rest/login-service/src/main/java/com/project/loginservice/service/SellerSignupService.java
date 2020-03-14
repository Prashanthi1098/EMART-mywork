package com.project.loginservice.service;

import java.util.List;

import com.project.loginservice.pojo.BuyerSignupPojo;
import com.project.loginservice.pojo.ItemPojo;
import com.project.loginservice.pojo.SellerSignupPojo;

public interface SellerSignupService {

	SellerSignupPojo validateSeller(SellerSignupPojo sellerSignupPojo);
	SellerSignupPojo allItems(int sellerId);
	SellerSignupPojo addSeller(SellerSignupPojo sellerSignupPojo);
}
