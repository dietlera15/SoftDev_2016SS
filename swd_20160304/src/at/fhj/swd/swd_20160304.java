package at.fhj.swd;

import java.util.ArrayList;

public class swd_20160304 {
	
	private static Order createDummyOrders() {
		Customer customer = new Customer ("Andreas", "Dietler", "Somewhere", "over the Rainbow", "666", "Austr(al)ia");
		ArrayList<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem("B123", "Bier", 1.5f, 4));
		Order order = new Order(1000001, customer, items);
		return order;
	}
	
	public static void main(String[] args) {
		Order order = createDummyOrders();
		float total = order.getTotalSum();
		System.out.println("Total price: " + total);
	}

}
