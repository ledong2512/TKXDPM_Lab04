package com.oms.bean;

import java.util.*;

public class Order {
	private String id;
	private String code;
	private String customerName;
	private String customerPhoneNumber;
	private String customerAddress;
	private ArrayList<OrderLine> orderLines;
	private float totalCost;
	
	public Order() {
		orderLines = new ArrayList<OrderLine>();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getTotalCost() {
		float res = 0;
		float weight=0;
		float shipCost = 0;
		if (orderLines!= null) {
			Iterator<OrderLine> iter = orderLines.iterator();
			while (iter.hasNext()) {
				OrderLine ol = iter.next();
				
				float productCost =  ol.getProductCost() * ol.getProductQuantity();
				weight+=ol.getWeight() * ol.getProductQuantity();
				res += productCost;
			}
			if(res < 500000) {
				if(getCustomerAddress().toLowerCase().contains("hà nội") || getCustomerAddress().toLowerCase().contains("hồ chí minh") || getCustomerAddress().toLowerCase().contains("hn") || getCustomerAddress().toLowerCase().contains("hcm") ) {
					if(weight <= 3) {
						shipCost = 22000;
					}else shipCost = (float) (22000 + Math.ceil(((weight-3)/0.5))*2500);
				}else {
					if(weight <= 0.5) {
						shipCost = 30000;	
					}else shipCost = (float) (30000 + Math.ceil(((weight-0.5)/0.5))*2500);
				}
			}else {
				shipCost = 0;
			}
			res+=shipCost;
		}
		return res;
	}
	
	
	
	public void addOrderLine(OrderLine orderLine) {
		boolean existed = false;
		for (OrderLine ol: orderLines) {
			if (ol.getProductId().equals(orderLine.getProductId())) {
				ol.setProductQuantity(ol.getProductQuantity() + orderLine.getProductQuantity());
				existed = true;
				break;
			}
		}
		
		if (!existed) {
			orderLines.add(orderLine);
		}
	}

	public boolean search(Order order) {
		if (this.id != null && !this.id.equals("") && !this.id.contains(order.id)) {
			return false;
		}
		if (this.code != null && !this.code.equals("") && !this.code.contains(order.code)) {
			return false;
		}
		if (this.customerName != null && !this.customerName.equals("") && !this.customerName.contains(order.customerName)) {
			return false;
		}
		if (this.totalCost != 0 && this.totalCost != order.totalCost) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			return this.code.equals(((Order) obj).code);
		}
		return false;
	}
}