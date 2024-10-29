package Entity;

import java.sql.Time;

public class restaurant {
	
	private int id;
	private String name;
	private String telephone;
	private Time opening_hours;
	private address address;
	private category category;
	private boolean is_withdrawn;
	private float minimumdelivery_value;
	
	public restaurant(int id, String name, String telephone, Time opening_hours, Entity.address address,
			Entity.category category, boolean is_withdrawn, float minimumdelivery_value) {
		
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.opening_hours = opening_hours;
		this.address = address;
		this.category = category;
		this.is_withdrawn = is_withdrawn;
		this.minimumdelivery_value = minimumdelivery_value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Time getOpening_hours() {
		return opening_hours;
	}

	public void setOpening_hours(Time opening_hours) {
		this.opening_hours = opening_hours;
	}

	public address getAddress() {
		return address;
	}

	public void setAddress(address address) {
		this.address = address;
	}

	public category getCategory() {
		return category;
	}

	public void setCategory(category category) {
		this.category = category;
	}

	public boolean isIs_withdrawn() {
		return is_withdrawn;
	}

	public void setIs_withdrawn(boolean is_withdrawn) {
		this.is_withdrawn = is_withdrawn;
	}

	public float getMinimumdelivery_value() {
		return minimumdelivery_value;
	}

	public void setMinimumdelivery_value(float minimumdelivery_value) {
		this.minimumdelivery_value = minimumdelivery_value;
	}
	
	
	
	
}
