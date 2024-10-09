package Project;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
	Scanner sc =  new Scanner(System.in);
	private int id;
	private String description;
	private String responsible;
	private LocalDate start_date;
	private LocalDate end_date;
	private String status;
	private String projectTask;
	ArrayList <String> TaskList;
	
	public Task(int id, String description, String responsible,LocalDate start_date,LocalDate end_date,String status,String projectTask) {
		this.id =id;
		this.description =description;
		this.responsible =responsible;
		this.start_date =start_date;
		this.end_date =end_date;
		this.status =status;
		this.projectTask = projectTask;
		this.TaskList =new ArrayList<>();
		
	}
	
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id =id;
	}
	
	String getDescription() {
		return description;
	}
	void setDescription(String description) {
		this.description =description;
	}
	
	String getResponsible() {
		return responsible;
	}
	void setResponsible(String responsibletask) {
		this.responsible =responsibletask;
	}
	
	LocalDate getStart_Date() {
		return start_date;
	}
	void setStart_Date(LocalDate start_date) {
		this.start_date =start_date;
	}
	
	LocalDate getEnd_Date() {
		return end_date;
	}
	void setEnd_Date(LocalDate end_date) {
		this.end_date =end_date;
	}
	
	String getStatus() {
		return status;
	}
	void setStatus(String status) {
		this.status =status;
	}
	
	String getProjectTask() {
		return projectTask;
	}
	void setProjectTask(String projectTask) {
		this.projectTask = projectTask;
	}
	
	boolean validatetask() {
		if(description == null||status == null) {
			System.out.println("Os campos de task sao obrigadorios");
			return false;
		}
		return true;
	}
	
	void saveTask() {
		String info = String.format("ID: %d, Description: %s, responsible: %s, Status: %s project: %s",id,description,responsible,status,projectTask);
		TaskList.add(info);
	}
	
	void removeTask(int id_remove) {
		 TaskList.remove(id_remove);
		
	}
	void listTask() {
		for(String task : TaskList) {
			System.out.println(task);
		}
	}
	
	
	void updateTask(int id_update) {
		System.out.println(TaskList.get(id_update));
		System.out.println("Digite qual palavra queira atualizar:");
		String oldword = sc.next();
		System.out.println("Digite a nova palavra:");
		String newword = sc.next();
		TaskList.set(id_update, TaskList.get(id_update).replace(oldword, newword));
	}
	
}