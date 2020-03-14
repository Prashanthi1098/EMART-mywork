package com.project.loginservice.pojo;

import java.util.Date;
import java.util.Set;

import com.project.loginservice.entity.BillEntity;

public class BillPojo {

	private int id;
	private BuyerSignupPojo buyerId;
	private String type;
	private Date date;
	private String remarks;
	private int amount;
	Set<BillerDetailsPojo> allBillDetails;

	public BillPojo(int id, BuyerSignupPojo buyerId, String type, Date date, String remarks, int amount,
			Set<BillerDetailsPojo> allBillDetails) {
		super();
		this.id = id;
		this.buyerId = buyerId;
		this.type = type;
		this.date = date;
		this.remarks = remarks;
		this.amount = amount;
		this.allBillDetails = allBillDetails;
	}

	public BillPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BuyerSignupPojo getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(BuyerSignupPojo buyerId) {
		this.buyerId = buyerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Set<BillerDetailsPojo> getAllBillDetails() {
		return allBillDetails;
	}

	public void setAllBillDetails(Set<BillerDetailsPojo> allBillDetails) {
		this.allBillDetails = allBillDetails;
	}

	@Override
	public String toString() {
		return "BillPojo [id=" + id + ", buyerId=" + buyerId + ", type=" + type + ", date=" + date + ", remarks="
				+ remarks + ", amount=" + amount + ", allBillDetails=" + allBillDetails + "]";
	}

}
