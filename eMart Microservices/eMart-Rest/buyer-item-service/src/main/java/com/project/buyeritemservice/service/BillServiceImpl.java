package com.project.buyeritemservice.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.buyeritemservice.dao.BillDao;
import com.project.buyeritemservice.dao.BillDetails;
import com.project.buyeritemservice.entity.BillDetailsEntity;
import com.project.buyeritemservice.entity.BillEntity;
import com.project.buyeritemservice.entity.BuyerSignupEntity;
import com.project.buyeritemservice.entity.CategoryEntity;
import com.project.buyeritemservice.entity.ItemEntity;
import com.project.buyeritemservice.entity.SellerSignupEntity;
import com.project.buyeritemservice.entity.SubCategoryEntity;
import com.project.buyeritemservice.pojo.BillPojo;
import com.project.buyeritemservice.pojo.BillerDetailsPojo;
import com.project.buyeritemservice.pojo.BuyerSignupPojo;
import com.project.buyeritemservice.pojo.CategoryPojo;
import com.project.buyeritemservice.pojo.ItemPojo;
import com.project.buyeritemservice.pojo.SellerSignupPojo;
import com.project.buyeritemservice.pojo.SubCategoryPojo;
import com.project.buyeritemservice.service.BillServiceImpl;

@Service
public class BillServiceImpl implements BillService {
	static Logger LOG = Logger.getLogger(BillServiceImpl.class.getClass());

	@Autowired
	BillDao billDao;
	@Autowired
	BillDetails billDetailsDao;

	// Implementing addBill function
	@Override
	public BillPojo addBill(BillPojo billPojo) {
		LOG.info("Enterd addBill()");
		BuyerSignupPojo buyerPojo = billPojo.getBuyerId();
		BuyerSignupEntity buyerEntity = new BuyerSignupEntity(buyerPojo.getId(), buyerPojo.getUsername(),
				buyerPojo.getPassword(), buyerPojo.getEmail(), buyerPojo.getMobile(), buyerPojo.getDate(), null);

		BillEntity billEntity = new BillEntity();
		billEntity.setId(0);
		billEntity.setAmount(billPojo.getAmount());
		billEntity.setRemarks(billPojo.getRemarks());
		billEntity.setType(billPojo.getType());
		billEntity.setDate(billPojo.getDate());
		billEntity.setBuyer(buyerEntity);

		billEntity = billDao.saveAndFlush(billEntity);
		billPojo.setId(billEntity.getId());

		BillEntity setBillEntity = billDao.findById(billEntity.getId()).get();

		Set<BillDetailsEntity> allBillDetails = new HashSet<BillDetailsEntity>();
		Set<BillerDetailsPojo> allBillDetailsPojo = billPojo.getAllBillDetails();
		for (BillerDetailsPojo billDetailsPojo : allBillDetailsPojo) {
			ItemPojo itemPojo = billDetailsPojo.getItemId();
			SubCategoryPojo subcategoryPojo = itemPojo.getSubCategoryId();
			CategoryPojo categoryPojo = subcategoryPojo.getCategoryId();
			SellerSignupPojo sellerPojo = itemPojo.getSeller_id();
			SellerSignupEntity sellerSignupEntity = new SellerSignupEntity(sellerPojo.getId(), sellerPojo.getUsername(),
					sellerPojo.getPassword(), sellerPojo.getCompany(), sellerPojo.getGst(), sellerPojo.getBrief(),
					sellerPojo.getAddress(), sellerPojo.getEmail(), sellerPojo.getWebsite(), sellerPojo.getContact());
			CategoryEntity categoryEntity = new CategoryEntity(categoryPojo.getId(), categoryPojo.getName(),
					categoryPojo.getBrief());
			SubCategoryEntity subCategoryEntity = new SubCategoryEntity(subcategoryPojo.getId(),
					subcategoryPojo.getName(), categoryEntity, subcategoryPojo.getBrief(),
					subcategoryPojo.getGstPercent());

			ItemEntity itemEntity = new ItemEntity(itemPojo.getId(), itemPojo.getName(), subCategoryEntity,
					itemPojo.getPrice(), itemPojo.getDescription(), itemPojo.getStock(), itemPojo.getRemarks(),
					itemPojo.getImage(), sellerSignupEntity);
			BillDetailsEntity billDetailsEntity = new BillDetailsEntity(billDetailsPojo.getId(), setBillEntity,
					itemEntity);

			billDetailsDao.save(billDetailsEntity);

		}
		BasicConfigurator.configure();
		LOG.info("Exited addBill()");

		return billPojo;
	}
}
