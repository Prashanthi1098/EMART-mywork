package com.project.buyeritemservice.pojo;

import com.project.buyeritemservice.pojo.SellerSignupPojo;
import com.project.buyeritemservice.pojo.SubCategoryPojo;

public class ItemPojo {
	private int id;
	private String name;
	private SubCategoryPojo subCategoryId;
	private int price;
	private String description;
	private int stock;
	private String remarks;
	private String image;
	private SellerSignupPojo sellerId;

	public ItemPojo(int id, String name, SubCategoryPojo subCategoryId, int price, String description, int stock,
			String remarks, String image, SellerSignupPojo sellerId) {
		super();
		this.id = id;
		this.name = name;
		this.subCategoryId = subCategoryId;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.remarks = remarks;
		this.image = image;
		this.sellerId = sellerId;
	}

	public ItemPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubCategoryPojo getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategoryPojo subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SellerSignupPojo getSeller_id() {
		return sellerId;
	}

	public void setSeller_id(SellerSignupPojo sellerId) {
		this.sellerId = sellerId;
	}

	@Override
	public String toString() {
		return "ItemPojo [id=" + id + ", name=" + name + ", subCategoryId=" + subCategoryId + ", price=" + price
				+ ", description=" + description + ", stock=" + stock + ", remarks=" + remarks + ", image=" + image
				+ ", sellerId=" + sellerId + "]";
	}

}
