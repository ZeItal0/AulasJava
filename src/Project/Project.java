package Project;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Project {
	Scanner sc = new Scanner(System.in);
	
	private int id;
	private String name;
	private String description;
	private LocalDate start_date;
	private LocalDate end_date;
	private String status;
	private String projectTeam;
	ArrayList <String> namesProject;
	
	public Project(int id,String name,String description,LocalDate start_date,LocalDate end_date,String status,String projectTeam){
		this.id =id;
		this.name =name;
		this.description =description;
		this.start_date = start_date;
		this.end_date =end_date;
		this.status =status;
		this.projectTeam =projectTeam;
		this.namesProject = new ArrayList<>();
	}
	
	
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name =name;
	}
	
	String getDescription() {
		return description;
	}
	void setDescription(String description) {
		this.description = description;
	}
	
	LocalDate getStart_Date() {
		return start_date;
	}
	void setStart_Date(LocalDate start_date) {
		this.start_date = start_date;
	}
	
	LocalDate getEnd_Date() {
		return end_date;
	}
	void setEnd_Date(LocalDate end_date) {
		this.end_date = end_date;
	}
	
	String getStatus() {
		return status;
	}
	void setStatus(String status) {
		this.status = status;
	}
	String getprojectTeam() {
		return projectTeam;
	}
	void setprojectTeam(String projectTeam) {
		this.projectTeam =projectTeam;
	}
	
	
	void saveProject() {
		String info = String.format("ID: %d, Name: %s, description: %s, Start date: %s, End date: %s, Status: %s Team: %s",id,name,description,start_date,end_date,status,projectTeam);
		namesProject.add(info);
	}
	void removeProject(int id_remove) {
		 namesProject.remove(id_remove);
		
	}
	void listProject() {
		for(String project : namesProject) {
			System.out.println(project);
		}
	}
	boolean validateProject() {
		if(name == null||description == null||status== null) {
			System.out.println("Voce precisa criar um projeto ou existem campos vazios");
			return false;
		}
		
		return true;
	}
	
	String findProject(String findproject) {
	    for (String project : namesProject) {
	        if (project.toLowerCase().contains(findproject.toLowerCase())) {
	            return project;
	        }
	    }
	    return null;
	}
	
	void updateProject(int id_update) {
		System.out.println(namesProject.get(id_update));
		System.out.println("Digite qual palavra queira atualizar:");
		String oldword = sc.next();
		System.out.println("Digite a nova palavra:");
		String newword = sc.next();
		namesProject.set(id_update, namesProject.get(id_update).replace(oldword, newword));
	}
}

