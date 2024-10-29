package Entity;

public class Assessment {

	private int id;
	private int score;
	private Order order;
	
	public Assessment(int id, int score, Order order) {
		this.id = id;
		this.score = score;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
