package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Promotion extends Base{

	private String name;
	private String code;
	private float value;
	private Date validity;
	private String type;
	private List<Order> order =  new ArrayList<>();
	
	public Promotion(String name, String code, float value, Date validity, String type, List<Order> order) {
		this.name = name;
		this.code = code;
		this.value = value;
		this.validity = validity;
		this.type = type;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Date getValidity() {
		return validity;
	}

	public void setValidity(Date validity) {
		this.validity = validity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	
	
	
}
