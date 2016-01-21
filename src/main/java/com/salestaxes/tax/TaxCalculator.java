package com.salestaxes.tax;

import java.math.BigDecimal;

/**
 * Calculate the tax cost
 * 
 * @author mzuffada
 *
 */
public interface TaxCalculator {

	/**
	 * Calculate the tax on the price provided in input
	 * @param price - price on which apply the tax calculation
	 * @return Tax
	 */
	public Tax calculateTax(BigDecimal price);
	
}
