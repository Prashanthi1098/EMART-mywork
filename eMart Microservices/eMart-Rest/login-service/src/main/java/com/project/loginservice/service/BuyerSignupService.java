package com.project.loginservice.service;

import com.project.loginservice.pojo.BuyerSignupPojo;

public interface BuyerSignupService {

	BuyerSignupPojo validateBuyer(BuyerSignupPojo buyerSignupPojo);

	BuyerSignupPojo getBuyer(int buyerId);

	BuyerSignupPojo addBuyer(BuyerSignupPojo buyerSignupPojo);

}
