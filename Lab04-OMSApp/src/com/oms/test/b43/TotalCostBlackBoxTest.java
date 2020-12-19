package com.oms.test.b43;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.oms.bean.Order;
import com.oms.bean.OrderLine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@RunWith(Parameterized.class)
public class TotalCostBlackBoxTest {
	private float expected;
	private String address;
	private float productCost;
	private float weight;
	
	
	
	
	public TotalCostBlackBoxTest(float expected,String address, float productCost,float weight) {
		super();
		this.expected=expected;
		this.address = address;
		this.productCost = productCost;
		this.weight = weight;
	}
	

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { 
			{500000.0f, "hn",500000.0f,4.0f },
			{427000.0f, "hn",400000.0f,4.0f },
			{500000.0f, "hn",500000.0f,1.0f },
			{422000.0f, "hn",400000.0f,1.0f },
			{600000.0f, "Cà mau",600000.0f,5.0f },
			{450000.0f, "Hải dương",400000.0f,4.5f },
			{500000.0f, "Điện biên",500000.0f,0.5f },
			{430000.0f, "Lai châu",400000.0f,0.5f }
		});
	}
	
	
	@Test
	public void testTotalCost() {
		
		
		Order order=new Order();
		order.addOrderLine(new OrderLine("01","OK",1,productCost,weight));
		order.setCustomerAddress(address);
		assertEquals( expected,order.getTotalCost(), 0.0);
	}
}