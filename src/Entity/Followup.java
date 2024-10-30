package Entity;

public class Followup extends Base{
	
	
	private String nome;
	private String description;
	private float value;
	
	public Followup(String nome, String description, float value) {
		
		this.nome = nome;
		this.description = description;
		this.value = value;
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
