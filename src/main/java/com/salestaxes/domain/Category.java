package com.salestaxes.domain;

import java.math.BigDecimal;

import com.salestaxes.tax.Tax;
import com.salestaxes.tax.TaxCalculator;

/**
 * Represent the items categories
 * 
 * @author mzuffada
 *
 */
public enum Category implements TaxCalculator{
	
	BOOK (BigDecimal.ZERO), 
	GENERIC ((new BigDecimal("0.10"))),
	FOOD (BigDecimal.ZERO),
    MEDICAL (BigDecimal.ZERO);
	
	Category (BigDecimal inputTax){
		this.taxRate = inputTax;
	}
	
	/**
	 * Tax rate to apply for the category
	 */
	protected BigDecimal taxRate;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tax calculateTax(BigDecimal price) {
		return new Tax(price, this.taxRate);
	}

}
