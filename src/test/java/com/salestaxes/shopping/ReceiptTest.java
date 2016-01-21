package com.salestaxes.shopping;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.salestaxes.domain.Category;
import com.salestaxes.domain.Imported;
import com.salestaxes.domain.Item;

public class ReceiptTest {
	
	@Test
	public void PrintReceiptTest(){

//Scenario 1
//Given
//1 book at 12.49, 1 music CD at 14.99, 1 chocolate bar at 0.85
		
		Item input1Item1 = Item.createItem("book", new BigDecimal("12.49"), Imported.NO, 1, Category.BOOK);
		Item input1Item2 = Item.createItem("music CD", new BigDecimal("14.99"), Imported.NO, 1, Category.GENERIC);
        Item input1Item3 = Item.createItem("chocolate bar", new BigDecimal("0.85"), Imported.NO, 1, Category.FOOD);
		
//When
//items are added in the Basket 
        
        final Basket input1Basket = new Basket();
		input1Basket.add(input1Item1);
		input1Basket.add(input1Item2);
		input1Basket.add(input1Item3);
		
//Then
//Print Receipt
//		1 book : 12.49
//		1 music CD: 16.49
//		1 chocolate bar: 0.85
//		Sales Taxes: 1.50
//		Total: 29.83
		
		Receipt input1Receipt = input1Basket.checkout();
		Assert.assertTrue(input1Receipt.getTotalAmount().equals(new BigDecimal("29.83")));
		Assert.assertTrue(input1Receipt.getTotalSalesTaxes().equals(new BigDecimal("1.50")));
		System.out.println(input1Receipt);
		
//Scenario 2
//Given
//1 imported box of chocolates at 10.00, 1 imported bottle of perfume at 47.50
		
		Item input2Item1 = Item.createItem("box of chocolates", new BigDecimal("10.00"), Imported.YES, 1, Category.FOOD);
		Item input2Item2 = Item.createItem("bottle of perfume", new BigDecimal("47.50"), Imported.YES, 1, Category.GENERIC);

//When
//items are added in the Basket
		
		final Basket input2Basket = new Basket();
		input2Basket.add(input2Item1);
		input2Basket.add(input2Item2);
		
//Then
//Print Receipt
//		1 imported box of chocolates: 10.50
//		1 imported bottle of perfume: 54.65
//		Sales Taxes: 7.65
//		Total: 65.15
		
		Receipt input2Receipt = input2Basket.checkout();
		Assert.assertTrue(input2Receipt.getTotalAmount().equals(new BigDecimal("65.15")));
		Assert.assertTrue(input2Receipt.getTotalSalesTaxes().equals(new BigDecimal("7.65")));
		System.out.println(input2Receipt);

//Scenario 3
//Given		
//1 imported bottle of perfume at 27.99, 1 bottle of perfume at 18.99, 
//1 packet of headache pills at 9.75, 1 box of imported chocolates at 11.25
		
		Item input3Item1 = Item.createItem("bottle of perfume", new BigDecimal("27.99"), Imported.YES, 1, Category.GENERIC);
		Item input3Item2 = Item.createItem("bottle of perfume", new BigDecimal("18.99"), Imported.NO, 1, Category.GENERIC);
        Item input3Item3 = Item.createItem("packet of headache pills", new BigDecimal("9.75"), Imported.NO, 1, Category.MEDICAL);
        Item input3Item4 = Item.createItem("box of chocolates", new BigDecimal("11.25"), Imported.YES, 1, Category.FOOD);
		
//When
//items are added in the Basket
        
		final Basket input3Basket = new Basket();
		input3Basket.add(input3Item1);
		input3Basket.add(input3Item2);
		input3Basket.add(input3Item3);
		input3Basket.add(input3Item4);
		
//Then
//Print Receipt
//		1 imported bottle of perfume: 32.19
//		1 bottle of perfume: 20.89
//		1 packet of headache pills: 9.75
//		1 imported box of chocolates: 11.85
//		Sales Taxes: 6.70
//		Total: 74.68

		Receipt input3Receipt = input3Basket.checkout();
		Assert.assertTrue(input3Receipt.getTotalAmount().equals(new BigDecimal("74.68")));
		Assert.assertTrue(input3Receipt.getTotalSalesTaxes().equals(new BigDecimal("6.70")));
		System.out.println(input3Receipt);
	}

}
