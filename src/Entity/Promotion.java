package Entity;

import java.util.Date;

public class Promotion extends Base{


	private String name;
	private String code;
	private float value;
	private Date validity;
	private String type;
	
	public Promotion(String name, String code, float value, Date validity, String type) {
		
		this.name = name;
		this.code = code;
		this.value = value;
		this.validity = validity;
		this.type = type;
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
	
	
	
}
