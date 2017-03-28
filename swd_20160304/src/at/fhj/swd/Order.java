package at.fhj.swd;

import java.util.ArrayList;

public class Order {
	private int orderID;
	private Customer customer;
	private ArrayList <OrderItem> orderItem;
	private static final int SHIPPING_COST = 6;
	private static final int FREE_SHIPPING = 100;
	
	public Order (int orderID, Customer customer, ArrayList<OrderItem> item) {
		this.orderID = orderID;
		this.customer = customer;
		this.orderItem = item;
	}
	
	public float getTotalSum() {
		float total = 0;
		for (OrderItem item : orderItem) {
			total = total + item.calcTotal();
		}
		if (total < FREE_SHIPPING) {
			total = total + SHIPPING_COST;
		}
		return total;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ArrayList<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public void setCustomer(Customer customer) {
		if(customer == null) {
			throw new IllegalArgumentException("Customer must not be null");
		}
		this.customer = customer;
	}

	public void setOrderItem(ArrayList<OrderItem> orderItem) {
		if(orderItem == null || orderItem.isEmpty())
		this.orderItem = orderItem;
	}
}
