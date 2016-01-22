package com.salestaxes.tax;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class TaxTest {
	
//	Test the calculation of the tax on a price
//  The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains
//	(np/100 rounded up to the nearest 0.05) amount of sales tax.
	
	@Test
	public void CalculateTaxTest(){

//Given
//Setup a Tax having price 10.00 and rate 10%
//When
//Tax import is calculate within the constructor		

		Tax tax = new Tax(new BigDecimal("10.00"), new BigDecimal("0.10"));
//Then
		Assert.assertTrue(tax.getValue().equals(new BigDecimal("1.00")));
		
	}
}