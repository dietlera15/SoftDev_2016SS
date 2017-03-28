package at.fhj.swd;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class swd_20160422 {

	private static void addItems(List<String> items){
		for(int i = 0; i < 10; i++) {
			items.add("Number " + i);
		}
	}
	
	public static void main(String[] args) {
		List<String> items = new LinkedList<String>();
		items = new ArrayList<String>(items);
		items.add("Item 1");
		addItems(items);
		for(String curItem : items) {
			System.out.println(curItem);
		}
		
	}

}
