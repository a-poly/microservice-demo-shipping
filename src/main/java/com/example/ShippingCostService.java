package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingCostService {

	@Value("${product.service.url}") String productServiceUrl;
	@Value("${promotion.service.url}") String promotionServiceUrl;
	
	RestTemplate productService = new RestTemplate();
	RestTemplate promotionService = new RestTemplate();
	
	/**
	 * Calculate shipping costs of an individual item.  
	 * 
	 * Cost is based on weight and shipment type (standard / overnight).  
	 * 
	 * You’ll be given the item’s ID and whether it is standard / overnight shipping.
	 */
	public BigDecimal calculateShippingCosts(Item item) {
		
		//  Call the Product service to determine an item’s weight:
		item.setWeight( lookupProductWeight(item.getCode()));

		//	Some products may be eligible for free shipping, regardless of weight.  
		//	Call the promotion service with a specific item ID to check.
		BigDecimal shippingCostPerPound = new BigDecimal(0);
		if ( !lookupFreeShipping(item.getCode())) {
			//	Shipping costs are $1 per pound for overnight shipping, or $0.10 per pound standard shipping.
			if (item.getShippingType().equalsIgnoreCase("OVERNIGHT")) {
				shippingCostPerPound = new BigDecimal(1);
			} else {
				shippingCostPerPound = new BigDecimal(0.10);
			}
		}
		
		return item.getWeight().multiply(shippingCostPerPound).setScale(2, RoundingMode.HALF_UP);
	}

	
	/**
	 * Obtain the product's weight from the product service.
	 */
	public BigDecimal lookupProductWeight(String code) {
		Item item = productService.getForObject(productServiceUrl + "/products/{code}", Item.class, code);
		return item.getWeight();
	}

	
	/**
	 * Some items are subject to free standard shipping.  Check Promotion service.
	 * @return true if product gets free shipping
	 */
	public boolean lookupFreeShipping(String code) {
		Promotion promotion = promotionService.getForObject(promotionServiceUrl + "/promotions/{code}", Promotion.class, code);
		return ShippingDiscount.FREE_STANDARD_SHIPPING.equals(promotion.getShippingDiscount());
	}

	
}
