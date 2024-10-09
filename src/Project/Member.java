package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	Scanner sc = new Scanner(System.in);

	private int id;
	private String name;
	private String function;
	private String email;
	private String telephone;
	ArrayList <String> namesList;
	
	public Member(int id,String name,String function,String email,String telephone) {
		this.id = id;
		this.name =name;
		this.function =function;
		this.email =email;
		this.telephone =telephone;
		this.namesList = new ArrayList<>();
		
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
	
	String getFunction() {
		return function;
	}
	void setFunction(String function) {
		this.function =function;
	}
	
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email =email;
	}
	
	String getTelephone() {
		return telephone;
	}
	void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	void saveMember() {
		String info = String.format("ID: %d, Name: %s, function: %s, email: %s, Telephone: %s",id,name,function,email,telephone);
		namesList.add(info);
	}
	void saveMember2(String info) {
		namesList.add(info);
	}
	void removeMember(int id_remove) {
		 namesList.remove(id_remove);
		
	}
	void listMembers() {
		for(String member : namesList) {
			System.out.println(member);
		}
	}
	String findMemberByName(String membername) {
	    for (String member : namesList) {
	        if (member.toLowerCase().contains(membername.toLowerCase())) {
	            return member;
	        }
	    }
	    return null;
	}
	
	boolean validateMember() {
		if(name == null||function == null||telephone == null||email == null) {
			System.out.println("Os campos de membros sao obrigadorios");
			return false;
		}
		return true;
	}
	void updateMember(int id_update) {
		System.out.println(namesList.get(id_update));
		System.out.println("Digite qual palavra queira atualizar:");
		String oldword = sc.next();
		System.out.println("Digite a nova palavra:");
		String newword = sc.next();
		namesList.set(id_update, namesList.get(id_update).replace(oldword, newword));
	}
	
	
}
