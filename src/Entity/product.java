package Entity;

public class product extends Base{

	
	private String nome;
	private float price;
	private category category;
	private restaurant restaurant;
	
	public product(String nome, float price, Entity.category category, Entity.restaurant restaurant) {
		
		this.nome = nome;
		this.price = price;
		this.category = category;
		this.restaurant = restaurant;
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
