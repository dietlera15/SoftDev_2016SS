package at.fhj.swd;

public class OrderItem {
	private String articleNumber;
	private String name;
	private float price;
	private int quantity;

	public OrderItem(String articleNumber, String name, float price, int quantity) {
		setArticleNumber(articleNumber);
		setName(name);
		setPrice(price);
		setQuantity(quantity);
	}

	private boolean isBeer() {
		return getArticleNumber().startsWith("B");
	}
	
	public float calcTotal() {
		float totalPrice = getPrice() * getQuantity();
		if(isBeer() && getQuantity() > 10) {
			totalPrice = totalPrice - getPrice() * (getQuantity()/10);
		}
		return totalPrice;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	private void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	private void setPrice(float price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Price must be positive.");
		}

		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	private void setQuantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("Quanitity must be positive");
		}
		this.quantity = quantity;
	}

}
