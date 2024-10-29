package Entity;

public class Followup {
	
	private int id;
	private String nome;
	private String description;
	private float value;
	
	public Followup(int id, String nome, String description, float value) {
		this.id = id;
		this.nome = nome;
		this.description = description;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	
	
	

}
