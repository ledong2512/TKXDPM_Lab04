package com.oms.test.b44;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.oms.bean.Dimension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@RunWith(Parameterized.class)
public class TestDimension{
	private float w;
	private String expected;
	private float h;
	private float d;
	
	
	
	
	public TestDimension(float w,float h,float d,String expected) {
		super();
		this.w=w;
		this.h=h;
		this.d=d;
		this.expected=expected;
	}
	

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { 
			{3.0f, 4.0f,5.0f, "3.0cm x 4.0cm x 5.0cm" },
			{2.0f, 4.0f,5.0f, "2.0cm x 4.0cm x 5.0cm" },
			{1.0f, 4.0f,5.0f, "1.0cm x 4.0cm x 5.0cm" },
			{3.0f, 5.0f,5.0f, "3.0cm x 5.0cm x 5.0cm" },
			{3.0f, 6.0f,5.0f, "3.0cm x 6.0cm x 5.0cm" },
			{3.0f, 2.0f,5.0f, "3.0cm x 2.0cm x 5.0cm" },
			{3.0f, 4.0f,7.0f, "3.0cm x 4.0cm x 7.0cm" },
			{3.0f, 4.0f,9.0f, "3.0cm x 4.0cm x 9.0cm" },
			{3.0f, 34.0f,5.0f, "3.0cm x 34.0cm x 5.0cm" },
		});
	}
	
	
	@Test
	public void testDimension() {
		
		
		Dimension a=new Dimension(w,h,d);
		assertEquals( expected,a.toString());
	}
}