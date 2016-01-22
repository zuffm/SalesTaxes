package com.salestaxes.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represent the sales tax that could be applied to a purchased item
 * 
 * @author mzuffada
 *
 */
public class Tax {

	/**
	 * Represent the object value
	 */
	private final BigDecimal tax;
	
	/**
	 * Constructor with parameters for directly set the tax value 
	 * @param item price
	 * @param taxRate to apply
	 */
	public Tax(BigDecimal price, BigDecimal taxRate){
		this.tax = calculateTax(price, taxRate);
	}
	
	/**
	 * Retrieve the calculated tax
	 * @return BigDecimal
	 */
	public BigDecimal getValue(){
		return this.tax;
	}
	
	/**
	 * Calculate the tax value applying the rounding policy
	 * @param price
	 * @param taxRate
	 * @return BigDecimal
	 */
	private BigDecimal calculateTax(BigDecimal price, BigDecimal taxRate) {
		return applyRound(price.multiply(taxRate));
	}
	
	/**
	 * Apply the rounding rules for sales tax, that are for a tax rate of n%, a price of p contains(np/100 rounded up to the nearest 0.05) amount of sales tax.
	 * @param tax
	 * @return BigDecimal
	 */
    private BigDecimal applyRound(BigDecimal tax){
		tax = tax.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);
	    tax = tax.divide(new BigDecimal("20"), RoundingMode.UP);
	    return tax;
	}
	
}
