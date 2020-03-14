package com.project.buyeritemservice.entity;

import java.util.List;

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
@Table(name = "subcategory_table")
public class SubCategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subcategory_id")
	int id;

	@Column(name = "subcategory_name")
	String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	CategoryEntity categoryId;

	@OneToMany(mappedBy = "subCategoryId")
	List<ItemEntity> allItems;
	@Column(name = "subcategory_brief")
	String brief;

	@Column(name = "subcategory_gst")
	int gstPercent;

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

	public CategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryEntity categoryId) {
		this.categoryId = categoryId;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public int getGstPercent() {
		return gstPercent;
	}

	public void setGstPercent(int gstPercent) {
		this.gstPercent = gstPercent;
	}

	public SubCategoryEntity(int id, String name, CategoryEntity categoryId, String brief, int gstPercent) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.brief = brief;
		this.gstPercent = gstPercent;
	}

	public SubCategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
