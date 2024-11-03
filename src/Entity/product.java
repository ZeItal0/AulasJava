package Entity;

import java.util.ArrayList;
import java.util.List;

public class Product extends Base{
	
	private String name;
	private float price;
	private Restaurant restaurant;
	private List<ProductOrder> ProductOrder =  new ArrayList<>();
	
	public Product(String name, float price, Restaurant restaurant, List<Entity.ProductOrder> productOrder) {
		this.name = name;
		this.price = price;
		this.restaurant = restaurant;
		ProductOrder = productOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<ProductOrder> getProductOrder() {
		return ProductOrder;
	}

	public void setProductOrder(List<ProductOrder> productOrder) {
		ProductOrder = productOrder;
	}
	
	
	
	

}
