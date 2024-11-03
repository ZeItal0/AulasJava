package Entity;

public class ProductOrder extends Base{

	private Order order;
	private Product product;
	private int amount;
	
	public ProductOrder(Order order, Product product, int amount) {
		this.order = order;
		this.product = product;
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
}
