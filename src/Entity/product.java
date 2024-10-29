package Entity;

public class product {

	private int id;
	private String nome;
	private float price;
	private category category;
	private restaurant restaurant;
	
	public product(int id, String nome, float price, Entity.category category, Entity.restaurant restaurant) {
		this.id = id;
		this.nome = nome;
		this.price = price;
		this.category = category;
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}

	public restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
