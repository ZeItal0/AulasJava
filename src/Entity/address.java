package Entity;

public class address {
	
	private int id;
	private String road;
	private String number;
	private String city;
	private String state;
	private String reference_point;
	private int zip_code;
	private String complement;
	private String address_type;
	
	public address(int id, String road, String number, String city, String state, String reference_point, int zip_code, String complement, String address_type) {
		this.id = id;
		this.road = road;
		this.number = number;
		this.city = city;
		this.state = state;
		this.reference_point = reference_point;
		this.zip_code = zip_code;
		this.complement = complement;
		this.address_type = address_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
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
	
	
	

}