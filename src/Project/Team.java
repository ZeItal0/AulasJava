package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
	Scanner sc = new Scanner(System.in);

	private int id;
	private String name;
	private String description;
	private String projeto;
	private String memberTeam;
	ArrayList <String> teamList;
	
	public Team(int id,String name,String description,String projeto,String memberTeam) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.projeto = projeto;
		this.memberTeam =memberTeam;
		this.teamList = new ArrayList<>();
	}
	
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id =id;
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
		this.description =description;
	}
	
	String getProjeto() {
		return projeto;
	}
	void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	
	String getmemberTeam() {
		return memberTeam;
	}
	void setmemberTeam(String memberTeam) {
		this.memberTeam =memberTeam;
	}
	
	void addMembers() {
		String info = String.format("ID: %d, Team Name: %s, description: %s, project: %s members:%s",id,name,description,projeto,memberTeam);
		teamList.add(info);
	}
	
	void removeTeam(int id_remove) {
		 teamList.remove(id_remove);
		
	}
	void listTeam() {
		for(String team : teamList) {
			System.out.println(team);
		}
	}
	
	
	boolean validateCreationTeam() {
		if(name == null||description == null|| memberTeam ==null) {
			System.out.println("existem campos nao preenchidos ou voce pulou alguma etapa!!!");
			return false;
		}
		return true;
	}
	
	String findTeam(String findteam) {
	    for (String team : teamList) {
	        if (team.toLowerCase().contains(findteam.toLowerCase())) {
	            return team;
	        }
	    }
	    return null;
	}
	void updateTeam(int id_update) {
		System.out.println(teamList.get(id_update));
		System.out.println("Digite qual palavra queira atualizar:");
		String oldword = sc.next();
		System.out.println("Digite a nova palavra:");
		String newword = sc.next();
		teamList.set(id_update, teamList.get(id_update).replace(oldword, newword));
	}
	
}