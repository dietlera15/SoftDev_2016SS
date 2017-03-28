package swd_20160304;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import at.fhj.swd.Customer;
import at.fhj.swd.Order;
import at.fhj.swd.OrderItem;

public class OrderPriceTest {

	@Test
	public void test() {
		Customer customer = new Customer ("Andreas", "Dietler", "Somewhere", "over the Rainbow", "666", "Austr(al)ia");
		ArrayList<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem("B123", "Bier", 1.5f, 4));
		Order order = new Order(1000001, customer, items);
		
		float price = order.getTotalSum();
		assertEquals(7.5, price, 0.0001);
		fail("Not yet implemented");
	}

}
