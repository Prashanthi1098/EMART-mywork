package com.project.loginservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.GroupSequence;

@Entity
@Table(name = "bill_details_table")
public class BillDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_details_id")
	int id;

	@ManyToOne
	@JoinColumn(name = "bill_id")
	BillEntity bill;

	@ManyToOne
	@JoinColumn(name = "item_id")
	ItemEntity item;

	public BillDetailsEntity(int id, BillEntity bill, ItemEntity item) {
		super();
		this.id = id;
		this.bill = bill;
		this.item = item;
	}

	public BillDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "BillDetailsEntity [id=" + id + ", bill=" + bill + ", item=" + item + "]";
	}

}
