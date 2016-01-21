package com.salestaxes.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.Validate;

/**
 * Product eligible for being purchased, added into the basket and present on the receipt 
 * 
 * @author mzuffada
 *
 */
public class Item {
	
	final private String name;
	final private BigDecimal price;
	final private Imported imported;
	final private int qty;
	final private Category category;
	
	/**
	 * Constructor with parameters for initialize item
	 * @param name 
	 * @param price
	 * @param imported
	 * @param qty
	 * @param category
	 */
	protected Item(String name, BigDecimal price, Imported imported, int qty, Category category) {
		Validate.notBlank(name, "name not valid");
		Validate.notNull(price, "price not correct");
		this.name = name;
		this.price = price;
		this.imported = imported;
		this.qty = qty;
		this.category = category;
	}

	/**
     * @return the item name
     */
	public String getName() {
		return name;
	}

	/**
     * @return the item price
     */
	public BigDecimal getPrice() {
		return price;
	}

	/**
     * @return the item imported information
     */
	public Imported getImported() {
		return imported;
	}

	/**
     * @return the item quantity
     */
	public int getQty() {
		return qty;
	}
	
	public static Item createItem(String name, BigDecimal price, Imported imported, int qty, Category category){
		return new Item (name, price, imported, qty, category);
	}

	/**
     * @return the tax calculated on the item
     */
	public BigDecimal getTax(){
		return category.calculateTax(price).getValue().add(imported.calculateTax(price).getValue());
	}
	
	/**
     * @return the final price of the item (original price + tax)
     */
	public BigDecimal getFinalPrice() {
	    return price.add(getTax());
	  }

	@Override
	public String toString() {
		return (qty + " " + imported.getDescription() + " " + name + " : " + getFinalPrice());
	}

}
