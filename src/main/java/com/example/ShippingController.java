package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

	@Autowired ShippingCostService svc;
	
	/**
	 * Get a specific product:
	 */
	@GetMapping("/shippings/{code}/type/{type}")
	public Item getShippingCosts( @PathVariable String code, @PathVariable String type) {
		Item item = new Item(code,type);
		item.setShippingCost( svc.calculateShippingCosts(item) );
		return item;
	}

}
