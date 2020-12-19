package com.oms.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.oms.bean.Order;
import com.oms.bean.OrderLine;

class getTotalCostTest {
	Order order=new Order();
	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@Test
	void test() {
		order.addOrderLine(new OrderLine("01","OK",1,400000.0f,4.5f));
		order.setCustomerAddress("Hải dương");
		assertEquals( 450000.0f,order.getTotalCost());
	}

}
