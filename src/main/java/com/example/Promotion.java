package com.example;

import java.math.BigDecimal;

public class Promotion {

	private String code;
	private BigDecimal priceDiscount;
	private String shippingDiscount;
	
	
	
	public Promotion() {
		super();
	}
	
	public Promotion(String code) {
		this();
		this.code = code;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPriceDiscount() {
		return priceDiscount;
	}
	public void setPriceDiscount(BigDecimal priceDiscount) {
		this.priceDiscount = priceDiscount;
	}
	public void setPriceDiscountL(Long priceDiscount) {
		setPriceDiscount(new BigDecimal(priceDiscount));
	}
	public void setPriceDiscountI(Integer priceDiscount) {
		setPriceDiscount(new BigDecimal(priceDiscount));
	}
	public String getShippingDiscount() {
		return shippingDiscount;
	}
	public void setShippingDiscount(String shippingDiscount) {
		this.shippingDiscount = shippingDiscount;
	}
	
	
}
