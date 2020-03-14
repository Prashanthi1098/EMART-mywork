package com.project.buyeritemservice.pojo;

import com.project.buyeritemservice.pojo.CategoryPojo;

public class SubCategoryPojo {
	private int id;
	private String name;
	private CategoryPojo categoryId;
	private String brief;
	private int gstPercent;

	public SubCategoryPojo(int id, String name, CategoryPojo categoryId, String brief, int gstPercent) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.brief = brief;
		this.gstPercent = gstPercent;
	}

	public SubCategoryPojo() {
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

	public CategoryPojo getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryPojo categoryId) {
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

	@Override
	public String toString() {
		return "SubCategoryPojo [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", brief=" + brief
				+ ", gstPercent=" + gstPercent + "]";
	}
}
