package Entity;

public class ProductOrder extends Base{

	
	private Order order;
	private product product;
	private int amount;
	
	public ProductOrder(Order order, Entity.product product, int amount) {
		
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
