package com.salestaxes.domain;

import java.math.BigDecimal;

import com.salestaxes.tax.Tax;
import com.salestaxes.tax.TaxCalculator;

/**
 * Represent the definition of an imported item
 * @author mzuffada
 *
 */
public enum Imported implements TaxCalculator {
	
	YES (new BigDecimal("0.05"), "imported"), NO (BigDecimal.ZERO, "");
	
	Imported(BigDecimal inputTax, String description){
		this.taxRate = inputTax;
		this.description = description;
	}
	
	/**
	 * Tax rate to apply for the category
	 */
	protected BigDecimal taxRate;
	/**
	 * {@link String} representation of imported
	 */
	protected String description;
	
	/**
	 * 
	 * @return a {@link String} containing the object description
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tax calculateTax(BigDecimal price) {
		return new Tax(price, this.taxRate);
	}
	
}
