package com.project.loginservice.pojo;

public class BillerDetailsPojo {
	private int id;
	private BillPojo billId;
	private ItemPojo itemId;

	public BillerDetailsPojo(int id, BillPojo billId, ItemPojo itemId) {
		super();
		this.id = id;
		this.billId = billId;
		this.itemId = itemId;
	}

	public BillerDetailsPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BillPojo getBillId() {
		return billId;
	}

	public void setBillId(BillPojo billId) {
		this.billId = billId;
	}

	public ItemPojo getItemId() {
		return itemId;
	}

	@Override
	public String toString() {
		return "BillerDetailsPojo [id=" + id + ", billId=" + billId + ", itemId=" + itemId + "]";
	}

	public void setItemId(ItemPojo itemId) {
		this.itemId = itemId;
	}

}
