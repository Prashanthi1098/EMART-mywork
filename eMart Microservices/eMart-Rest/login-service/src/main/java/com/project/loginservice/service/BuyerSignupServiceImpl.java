package com.project.loginservice.service;

import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.loginservice.dao.BuyerSignupDao;
import com.project.loginservice.entity.BillDetailsEntity;
import com.project.loginservice.entity.BillEntity;
import com.project.loginservice.entity.BuyerSignupEntity;
import com.project.loginservice.entity.CategoryEntity;
import com.project.loginservice.entity.ItemEntity;
import com.project.loginservice.entity.SellerSignupEntity;
import com.project.loginservice.entity.SubCategoryEntity;
import com.project.loginservice.pojo.BillPojo;
import com.project.loginservice.pojo.BillerDetailsPojo;
import com.project.loginservice.pojo.BuyerSignupPojo;
import com.project.loginservice.pojo.CategoryPojo;
import com.project.loginservice.pojo.ItemPojo;
import com.project.loginservice.pojo.SellerSignupPojo;
import com.project.loginservice.pojo.SubCategoryPojo;

@Service
public class BuyerSignupServiceImpl implements BuyerSignupService {
	static Logger LOG = Logger.getLogger(BuyerSignupServiceImpl.class.getClass());

	@Autowired
	BuyerSignupDao buyerDao;

	// Implementation of Buyer validation
	@Override
	public BuyerSignupPojo validateBuyer(BuyerSignupPojo buyerSignupPojo) {
		LOG.info("Enterd validateBuyer()");
		BuyerSignupEntity buyerSignupEntity = buyerDao.findByUsernameAndPassword(buyerSignupPojo.getUsername(),
				buyerSignupPojo.getPassword());
		if (buyerSignupEntity != null) {
			Set<BillEntity> allBills = buyerSignupEntity.getAllBills();
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();
			// Set<BillerDetailsPojo> allBillDetailsPojo = new HashSet<BillerDetailsPojo>();
			for (BillEntity billEntity : allBills) {
				Set<BillerDetailsPojo> allBillDetailsPojo = new HashSet<BillerDetailsPojo>();
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
					ItemEntity itemEntity = billDetailsEntity.getItem();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubCategoryId();
					CategoryEntity categoryEntity = subCategoryEntity.getCategoryId();
					SellerSignupEntity sellerSignupEntity = itemEntity.getSellerId();
					SellerSignupPojo sellersignupPojo = new SellerSignupPojo(sellerSignupEntity.getId(),
							sellerSignupEntity.getUsername(), sellerSignupEntity.getPassword(),
							sellerSignupEntity.getCompany(), sellerSignupEntity.getGst(), sellerSignupEntity.getBrief(),
							sellerSignupEntity.getAddress(), sellerSignupEntity.getEmail(),
							sellerSignupEntity.getWebsite(), sellerSignupEntity.getContact(), null);

					CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getId(), categoryEntity.getName(),
							categoryEntity.getBrief());
					SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getId(),
							subCategoryEntity.getName(), categoryPojo, subCategoryEntity.getBrief(),
							subCategoryEntity.getGstPercent());

					ItemPojo itemPojo = new ItemPojo(itemEntity.getId(), itemEntity.getName(), subCategoryPojo,
							itemEntity.getPrice(), itemEntity.getDescription(), itemEntity.getStock(),
							itemEntity.getRemarks(), itemEntity.getImage(), sellersignupPojo);
					BillerDetailsPojo billDetailsPojo = new BillerDetailsPojo(billDetailsEntity.getId(), null,
							itemPojo);
					allBillDetailsPojo.add(billDetailsPojo);
				}
				BillPojo billPojo = new BillPojo(billEntity.getId(), null, billEntity.getType(), billEntity.getDate(),
						billEntity.getRemarks(), billEntity.getAmount(), allBillDetailsPojo);
				allBillPojo.add(billPojo);
			}
			buyerSignupPojo = new BuyerSignupPojo(buyerSignupEntity.getId(), buyerSignupEntity.getUsername(),
					buyerSignupEntity.getPassword(), buyerSignupEntity.getEmail(), buyerSignupEntity.getMobile(),
					buyerSignupEntity.getDate(), allBillPojo);

		}
		LOG.info("Exited validateBuyer()");

		return buyerSignupPojo;
	}

	// Implementing service to Retrieving Buyer
	@Override
	public BuyerSignupPojo getBuyer(int BuyerId) {
		BuyerSignupPojo buyersignupPojo = null;
		BuyerSignupEntity buyerEntity = buyerDao.findById(BuyerId).get();
		if (buyerEntity != null) {
			Set<BillEntity> allBills = buyerEntity.getAllBills();
			Set<BillPojo> allBillPojo = new HashSet<BillPojo>();

			for (BillEntity billEntity : allBills) {
				Set<BillerDetailsPojo> allBillDetailsPojo = new HashSet<BillerDetailsPojo>();
				Set<BillDetailsEntity> allBillDetailsEntity = billEntity.getAllBillDetails();
				for (BillDetailsEntity billDetailsEntity : allBillDetailsEntity) {
					ItemEntity itemEntity = billDetailsEntity.getItem();
					SubCategoryEntity subCategoryEntity = itemEntity.getSubCategoryId();
					CategoryEntity categoryEntity = subCategoryEntity.getCategoryId();
					SellerSignupEntity sellerSignupEntity = itemEntity.getSellerId();
					SellerSignupPojo sellersignupPojo = new SellerSignupPojo(sellerSignupEntity.getId(),
							sellerSignupEntity.getUsername(), sellerSignupEntity.getPassword(),
							sellerSignupEntity.getCompany(), sellerSignupEntity.getGst(), sellerSignupEntity.getBrief(),
							sellerSignupEntity.getAddress(), sellerSignupEntity.getEmail(),
							sellerSignupEntity.getWebsite(), sellerSignupEntity.getContact(), null);

					CategoryPojo categoryPojo = new CategoryPojo(categoryEntity.getId(), categoryEntity.getName(),
							categoryEntity.getBrief());
					SubCategoryPojo subCategoryPojo = new SubCategoryPojo(subCategoryEntity.getId(),
							subCategoryEntity.getName(), categoryPojo, subCategoryEntity.getBrief(),
							subCategoryEntity.getGstPercent());

					ItemPojo itemPojo = new ItemPojo(itemEntity.getId(), itemEntity.getName(), subCategoryPojo,
							itemEntity.getPrice(), itemEntity.getDescription(), itemEntity.getStock(),
							itemEntity.getRemarks(), itemEntity.getImage(), sellersignupPojo);
					BillerDetailsPojo billDetailsPojo = new BillerDetailsPojo(billDetailsEntity.getId(), null,
							itemPojo);
					allBillDetailsPojo.add(billDetailsPojo);
				}
				BillPojo billPojo = new BillPojo(billEntity.getId(), null, billEntity.getType(), billEntity.getDate(),
						billEntity.getRemarks(), billEntity.getAmount(), allBillDetailsPojo);
				allBillPojo.add(billPojo);
			}
			buyersignupPojo = new BuyerSignupPojo(buyerEntity.getId(), buyerEntity.getUsername(),
					buyerEntity.getPassword(), buyerEntity.getEmail(), buyerEntity.getMobile(), buyerEntity.getDate(),
					allBillPojo);

		}
		BasicConfigurator.configure();

		return buyersignupPojo;
	}

	@Override
	public BuyerSignupPojo addBuyer(BuyerSignupPojo buyerSignupPojo) {
	
		BuyerSignupEntity buyerSignupEntity = new BuyerSignupEntity(buyerSignupPojo.getId(),
				buyerSignupPojo.getUsername(), buyerSignupPojo.getPassword(), buyerSignupPojo.getEmail(),
				buyerSignupPojo.getMobile(), buyerSignupPojo.getDate(), null);
		buyerDao.saveAndFlush(buyerSignupEntity);
		return buyerSignupPojo;

	}
}
