package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Restaurant extends Base{

	private String name;
	private String telephone;
	private Timer opening_hours;
	private Adress adress;
	private Category category;
	private boolean is_withdraw;
	private float minimum_delivery_value;
	private List<Product> product = new ArrayList<>();
	
	public Restaurant(String name, String telephone, Timer opening_hours, Adress adress, Category category,
			boolean is_withdraw, float minimum_delivery_value, List<Product> product) {
		this.name = name;
		this.telephone = telephone;
		this.opening_hours = opening_hours;
		this.adress = adress;
		this.category = category;
		this.is_withdraw = is_withdraw;
		this.minimum_delivery_value = minimum_delivery_value;
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Timer getOpening_hours() {
		return opening_hours;
	}

	public void setOpening_hours(Timer opening_hours) {
		this.opening_hours = opening_hours;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isIs_withdraw() {
		return is_withdraw;
	}

	public void setIs_withdraw(boolean is_withdraw) {
		this.is_withdraw = is_withdraw;
	}

	public float getMinimum_delivery_value() {
		return minimum_delivery_value;
	}

	public void setMinimum_delivery_value(float minimum_delivery_value) {
		this.minimum_delivery_value = minimum_delivery_value;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
	
	
}
