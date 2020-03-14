package com.project.loginservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.loginservice.dao.SellerSignupDao;
import com.project.loginservice.entity.BuyerSignupEntity;
import com.project.loginservice.entity.CategoryEntity;
import com.project.loginservice.entity.ItemEntity;
import com.project.loginservice.entity.SellerSignupEntity;
import com.project.loginservice.entity.SubCategoryEntity;
import com.project.loginservice.pojo.CategoryPojo;
import com.project.loginservice.pojo.ItemPojo;
import com.project.loginservice.pojo.SellerSignupPojo;
import com.project.loginservice.pojo.SubCategoryPojo;

@Service
public class SellerSignupServiceImpl implements SellerSignupService {

	@Autowired
	SellerSignupDao sellerSignupDao;
	
	@Override
	public SellerSignupPojo validateSeller(SellerSignupPojo sellerSignupPojo) {
		SellerSignupEntity sellerSignupEntity= sellerSignupDao.findByUsernameAndPassword(sellerSignupPojo.getUsername(),sellerSignupPojo.getPassword()	);
		if(sellerSignupEntity!=null) 
		{
			Set<ItemEntity> allItemsEntity = sellerSignupEntity.getAllItems();
			Set<ItemPojo> allItems= new HashSet<ItemPojo>();
			for(ItemEntity itemEntity : allItemsEntity)
			{
				SubCategoryEntity subCategoryEntity = itemEntity.getSubCategoryId();
				CategoryEntity categoryEntity = subCategoryEntity.getCategoryId();
				CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getId(), categoryEntity.getName(),
						categoryEntity.getBrief());
				SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getId(),
						subCategoryEntity.getName(), categoryPojo, subCategoryEntity.getBrief(),
						subCategoryEntity.getGstPercent());
				ItemPojo itemPojo = new ItemPojo(itemEntity.getId(), itemEntity.getName(), subCategoryPojo,
						itemEntity.getPrice(), itemEntity.getDescription(), itemEntity.getStock(),
						itemEntity.getRemarks(), itemEntity.getImage(), null);
				allItems.add(itemPojo);
			} 
			sellerSignupPojo = new SellerSignupPojo(sellerSignupEntity.getId(),
					sellerSignupEntity.getUsername(), sellerSignupEntity.getPassword(),
					sellerSignupEntity.getCompany(), sellerSignupEntity.getGst(),sellerSignupEntity.getBrief(), 
					sellerSignupEntity.getAddress(), sellerSignupEntity.getEmail(),
					sellerSignupEntity.getWebsite(), sellerSignupEntity.getContact(),allItems);
			
		}
		return sellerSignupPojo;
	}

	@Override
	public SellerSignupPojo allItems(int sellerId) {
		SellerSignupPojo sellerSignupPojo = null;
		SellerSignupEntity sellerSignupEntity= sellerSignupDao.findById(sellerId).get();
		if(sellerSignupEntity!=null) 
		{
			Set<ItemEntity> allItemsEntity = sellerSignupEntity.getAllItems();
			Set<ItemPojo> allItems= new HashSet<ItemPojo>();
			for(ItemEntity itemEntity : allItemsEntity)
			{
				SubCategoryEntity subCategoryEntity = itemEntity.getSubCategoryId();
				CategoryEntity categoryEntity = subCategoryEntity.getCategoryId();
				CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getId(), categoryEntity.getName(),
						categoryEntity.getBrief());
				SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getId(),
						subCategoryEntity.getName(), categoryPojo, subCategoryEntity.getBrief(),
						subCategoryEntity.getGstPercent());
				ItemPojo itemPojo = new ItemPojo(itemEntity.getId(), itemEntity.getName(), subCategoryPojo,
						itemEntity.getPrice(), itemEntity.getDescription(), itemEntity.getStock(),
						itemEntity.getRemarks(), itemEntity.getImage(), null);
				allItems.add(itemPojo);
			} 
			sellerSignupPojo = new SellerSignupPojo(sellerSignupEntity.getId(),
					sellerSignupEntity.getUsername(), sellerSignupEntity.getPassword(),
					sellerSignupEntity.getCompany(), sellerSignupEntity.getGst(),sellerSignupEntity.getBrief(), 
					sellerSignupEntity.getAddress(), sellerSignupEntity.getEmail(),
					sellerSignupEntity.getWebsite(), sellerSignupEntity.getContact(),allItems);
			
		}
		return sellerSignupPojo;
		
	}

	@Override
	public SellerSignupPojo addSeller(SellerSignupPojo sellerSignupPojo) {
		SellerSignupEntity sellerSignupEntity = new SellerSignupEntity(sellerSignupPojo.getId(),sellerSignupPojo.getUsername(),sellerSignupPojo.getPassword(),sellerSignupPojo.getCompany(),sellerSignupPojo.getGst(),sellerSignupPojo.getBrief(),sellerSignupPojo.getAddress(),sellerSignupPojo.getEmail(),sellerSignupPojo.getWebsite(),sellerSignupPojo.getContact(),null);
		sellerSignupDao.saveAndFlush(sellerSignupEntity);
		
		
		return sellerSignupPojo;
		
	}

}
