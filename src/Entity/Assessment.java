package Entity;

public class Assessment extends Base{

	private int score;
	private Order order;
	
	public Assessment(int score, Order order) {
		this.score = score;
		this.order = order;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
}
