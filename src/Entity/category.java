package Entity;

import java.util.ArrayList;
import java.util.List;

public class Category extends Base{

	private String name;
	private String description;
	private String type_category;
	private List<Restaurant> restaurant = new ArrayList<>();
	
	public Category(String name, String description, String type_category, List<Restaurant> restaurant) {
		this.name = name;
		this.description = description;
		this.type_category = type_category;
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType_category() {
		return type_category;
	}

	public void setType_category(String type_category) {
		this.type_category = type_category;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	
	
	
	
}
