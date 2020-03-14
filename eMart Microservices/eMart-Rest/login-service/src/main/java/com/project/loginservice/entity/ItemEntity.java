package com.project.loginservice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item_table")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	Integer id;

	@Column(name = "item_name")
	String name;

	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	SubCategoryEntity subCategoryId;

	@Column(name = "item_price")
	int price;

	@Column(name = "item_description")
	String description;

	@Column(name = "item_stock")
	int stock;

	@Column(name = "item_remarks")
	String remarks;

	@Column(name = "item_image")
	String image;

//	@Column(name="seller_id")
//	int  sellerId;

	@ManyToOne
	@JoinColumn(name = "seller_id")
	SellerSignupEntity sellerId;

	public ItemEntity(int id, String name, SubCategoryEntity subCategoryId, int price, String description, int stock,
			String remarks, String image, SellerSignupEntity seller_id) {
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

	public ItemEntity() {
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

	public SubCategoryEntity getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(SubCategoryEntity subCategoryId) {
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

	public SellerSignupEntity getSellerId() {
		return sellerId;
	}

	public void setSeller_id(SellerSignupEntity sellerId) {
		this.sellerId = sellerId;
	}

}
