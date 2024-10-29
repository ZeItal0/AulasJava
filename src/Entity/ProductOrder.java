package Entity;

public class ProductOrder {

	private int id;
	private Order order;
	private product product;
	private int amount;
	
	public ProductOrder(int id, Order order, Entity.product product, int amount) {
		this.id = id;
		this.order = order;
		this.product = product;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	
	
}
