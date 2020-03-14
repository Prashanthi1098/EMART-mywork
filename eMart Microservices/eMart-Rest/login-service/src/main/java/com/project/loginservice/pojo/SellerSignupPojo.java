package com.project.loginservice.pojo;

import java.util.Set;

import com.project.loginservice.entity.SellerSignupEntity;

public class SellerSignupPojo {
	private int id;
	private String username;
	private String password;
	private String company;
	private int gst;
	private String brief;
	private String address;
	private String email;
	private String website;
	private int contact;
	Set<ItemPojo> allItems;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public Set<ItemPojo> getAllItems() {
		return allItems;
	}
	public void setAllItems(Set<ItemPojo> allItems) {
		this.allItems = allItems;
	}
	public SellerSignupPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellerSignupPojo(int id, String username, String password, String company, int gst, String brief,
			String address, String email, String website, int contact, Set<ItemPojo> allItems) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.company = company;
		this.gst = gst;
		this.brief = brief;
		this.address = address;
		this.email = email;
		this.website = website;
		this.contact = contact;
		this.allItems = allItems;
	}
	@Override
	public String toString() {
		return "SellerSignupPojo [id=" + id + ", username=" + username + ", password=" + password + ", company="
				+ company + ", gst=" + gst + ", brief=" + brief + ", address=" + address + ", email=" + email
				+ ", website=" + website + ", contact=" + contact + ", allItems=" + allItems + "]";
	}
	
	

}
