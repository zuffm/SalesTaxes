package com.salestaxes.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.salestaxes.domain.Item;

/**
 * Basket contains items ready to be purchased
 * 
 * @author mzuffada
 *
 */
public class Basket {
	
	private List<Item> items = new ArrayList<>();
	
	/**
	 * Add an item to the basket
	 * @param item
	 */
	public void add(Item item){
		Validate.notNull(item, "item not valid");
		items.add(item);
	}
	
	/**
	 * Retrieve the list of items from basket
	 * @return List<Item>
	 */
	public List<Item> getItems()
	{
		return items;
	}
	
	/**
	 * Perform the checkout of the basket and provide a receipt
	 * @return Receipt
	 */
	public Receipt checkout(){
		Receipt receipt = new Receipt();
		BigDecimal totalAmount = BigDecimal.ZERO;
		BigDecimal totalTaxes = BigDecimal.ZERO;
		receipt.setItems(this.getItems());
		
		for (Item item : receipt.getItems()){
			totalTaxes = totalTaxes.add(item.getTax());
			totalAmount =totalAmount.add(item.getFinalPrice());
		}
		
		receipt.setTotalSalesTaxes(totalTaxes);
		receipt.setTotalAmount(totalAmount);
		
		return receipt;
	}

}