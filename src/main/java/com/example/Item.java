package com.example;

import java.math.BigDecimal;

public class Item {

	private String code;
	private String shippingType;
	private BigDecimal weight;
	private BigDecimal shippingCost;
	
	
	public Item() {
		super();
	}
	
	public Item(String code, String shippingType) {
		this();
		this.code = code;
		this.shippingType = shippingType;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShippingType() {
		return shippingType;
	}
	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}
	
}