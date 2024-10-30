package Entity;

public class category extends Base{
	

	private String name;
	private String description;
	private String type_category;
	
	public category(String name, String description, String type_category) {
		
		this.name = name;
		this.description = description;
		this.type_category = type_category;
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
	
	
	
	
	
	
	
	

}
