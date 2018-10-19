package com.bandana.models;

public class Purchase {
	private String customerName;
	private String type;
	private int quantity;
	private float cost;
	private int id;
	
	public Purchase() {
		this("","",0,0.0f);
	}
	
	public Purchase(String customerName, String type, int quantity, float cost) {
		super();
		this.customerName = customerName;
		this.type = type;
		this.quantity = quantity;
		this.cost = cost;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Purchase [customerName=" + customerName + ", type=" + type + ", quantity=" + quantity + ", cost=" + cost
				+ "]";
	}

	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	

}
