package Entity;

public class category {
	
	private int id;
	private String name;
	private String description;
	private String type_category;
	
	public category(int id, String name, String description, String type_category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type_category = type_category;
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
