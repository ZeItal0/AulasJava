package Entity;

public class PaymentMethod {

	private int id;
	private String shape;
	
	public PaymentMethod(int id, String shape) {
		this.id = id;
		this.shape = shape;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
	
}
