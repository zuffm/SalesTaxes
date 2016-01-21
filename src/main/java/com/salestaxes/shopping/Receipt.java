package com.salestaxes.shopping;

import java.math.BigDecimal;
import java.util.List;

import com.salestaxes.domain.Item;

/**
 * Representation of items purchased, their taxed cost, the total amount and the total sales taxes applied. 
 * 
 * @author mzuffada
 *
 */
public class Receipt {

	private List<Item> items;
	private BigDecimal totalAmount;
	private BigDecimal totalSalesTaxes;
	
	/**
	 * Retrieve the list of the purchased items
	 * @return List<Item>
	 */
	public List<Item> getItems() {
		return items;
	}
	
	/**
	 * Set the list of the purchased items
	 * @param items
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	/**
	 * Retrieve the total amount of the purchase
	 * @return BigDecimal
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	/**
	 * Set the total amount of the purchase
	 * @param totalSalesTaxes
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	/**
	 * Get the total sales taxes applied to the purchased items
	 * @return BigDecimal
	 */
	public BigDecimal getTotalSalesTaxes() {
		return totalSalesTaxes;
	}
	
	/**
	 * Set the total sales taxes applied to the purchased items
	 * @param totalSalesTaxes
	 */
	public void setTotalSalesTaxes(BigDecimal totalSalesTaxes) {
		this.totalSalesTaxes = totalSalesTaxes;
	}
	
	@Override
	public String toString() {
		
		StringBuilder receipt = new StringBuilder();
		
		for(Item item: items)
		{
			receipt.append(item.toString() + "\n");
		}
		
		receipt.append("Sales Taxes: " + totalSalesTaxes + "\n");
		receipt.append("Total: " + totalAmount + "\n");
		return receipt.toString();
	}
	
}
