package Entity;

public class OrderProductTracking {

	private ProductOrder productOrder;
	private Followup follorup;
	
	public OrderProductTracking(ProductOrder productOrder, Followup follorup) {
		this.productOrder = productOrder;
		this.follorup = follorup;
	}

	public ProductOrder getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}

	public Followup getFollorup() {
		return follorup;
	}

	public void setFollorup(Followup follorup) {
		this.follorup = follorup;
	}
	
	
}
