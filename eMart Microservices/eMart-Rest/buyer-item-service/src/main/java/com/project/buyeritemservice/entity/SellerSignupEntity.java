package com.project.buyeritemservice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seller_signup_table")
public class SellerSignupEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_id")
	int id;

	@Column(name = "username")
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "company")
	String company;

	@Column(name = "gst")
	int gst;

	@Column(name = "brief")
	String brief;

	@Column(name = "address")
	String address;

	@Column(name = "email")
	String email;

	@Column(name = "website")
	String website;

	@Column(name = "contact")
	int contact;

	public SellerSignupEntity(int id, String username, String password, String company, int gst, String brief,
			String address, String email, String website, int contact) {
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
	}

	public SellerSignupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "SellerSignupEntity [id=" + id + ", username=" + username + ", password=" + password + ", company="
				+ company + ", gst=" + gst + ", brief=" + brief + ", address=" + address + ", email=" + email
				+ ", website=" + website + ", contact=" + contact + "]";
	}

// 	@OneToMany(mappedBy = "sellerId")
// 	Set<ItemEntity> allSellers;

}
