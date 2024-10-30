package Entity;

public class ProductTracking extends Base{

	private product product;
	private Followup followup;
	
	public ProductTracking(Entity.product product, Followup followup) {
		this.product = product;
		this.followup = followup;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public Followup getFollowup() {
		return followup;
	}

	public void setFollowup(Followup followup) {
		this.followup = followup;
	}
	
	
}
