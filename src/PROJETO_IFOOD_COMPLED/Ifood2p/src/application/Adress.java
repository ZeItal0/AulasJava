package application;

import java.util.ArrayList;
import java.util.List;

public class Adress extends Base{

	private String road;
	private String number;
	private String city;
	private String state;
	private String reference_point;
	private int zip_code;
	private String complement;
	private String address_type;
	private String neighborhood;
	private List<Restaurant> restaurant = new ArrayList<>();
	private List<Order> order =  new ArrayList<>();
	
	public Adress(String road, String number, String city, String state, String reference_point, int zip_code,
			String complement, String address_type, String neighborhood, List<Restaurant> restaurant, List<Order> order) {

		this.road = road;
		this.number = number;
		this.city = city;
		this.state = state;
		this.reference_point = reference_point;
		this.zip_code = zip_code;
		this.complement = complement;
		this.address_type = address_type;
		this.neighborhood = neighborhood;
		this.restaurant = restaurant;
		this.order = order;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReference_point() {
		return reference_point;
	}

	public void setReference_point(String reference_point) {
		this.reference_point = reference_point;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int cep) {
		this.zip_code = cep;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getAddress_type() {
		return address_type;
	}

	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	
	
	
	
	
	
	
	
}
