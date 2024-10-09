package Project;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Project project = new Project(0, null, null, null, null, null,null);
		Team team = new Team(0, null, null, null,null);
		Member member = new Member(0, null, null, null, null);
		Task task = new Task(0, null, null,null,null, null,null);
		
		Scanner sc = new Scanner(System.in);
		String repeatedAnswer;
		int id_prt=0;
		int id_tsk=0;
		int id_tm=0;
		int id_mb=0;
		
		System.out.println("Bem vindo ao Sistema de gerenciamento de Projetos");
		System.out.println("Escolha um numero para as opcoes abaixo");
		
		do {
			System.out.printf(" 1 -> Adicionar Projeto%n 2 -> Remover Projeto%n 3 -> Listar Projetos%n 4 -> Criar equipe%n "
					+ "5 -> Remover equipe%n 6 -> Adicionar Membro%n 7 -> Remover Membro%n 8 -> Listar Membros%n 9 -> Criar tarefa %n 10 ->"
					+ " Remover tarefa%n 11 -> Listar Tarefas%n 12 -> listar equipe%n 13 -> atualizar projeto%n 14 -> atualizar equipe%n"
					+ " 15 -> atualizar task%n 16 -> atualizar dados de membros%n 17 -> adicionar gerente(membros)%n 18 -> remover Gerente%n YOU -> ");
			
			int repeatedAnswer1 = sc.nextInt();
			
			switch(repeatedAnswer1) {
			case 1:
				
				
				project.setId(id_prt);
				
				project.setStart_Date(LocalDate.now());
				project.setEnd_Date(LocalDate.now().plusDays(10));
				
				System.out.println("Name:");
				String name = sc.next();
				project.setName(name);
				sc.nextLine();
				
				System.out.println("Descricao:");
				String description = sc.nextLine();
				project.setDescription(description);
				
				System.out.println("Status:");
				String status = sc.nextLine();
				project.setStatus(status);
				
				System.out.println("Digite uma equipe para o projeto:");
				String teamproject = sc.nextLine();
				if(team.validateCreationTeam()==false) {
					System.out.println("Nao existe equipes criadas!");
					break;
				}
				
				String foundteam = team.findTeam(teamproject);

                if(foundteam != null) {
                    project.setprojectTeam(foundteam);
                } else {
                    System.out.println("O nome da equipe nao existe!");
                    break;
                }
				
				System.out.println("id:"+project.getId()+ "   name:"+project.getName()+ "   description:"+project.getDescription()+ 
						"   Start date:"+project.getStart_Date()+ "   end date:"+project.getEnd_Date()+ "   Status:"+project.getStatus()+ 
						"   project team:"+project.getprojectTeam());
				
				if(project.validateProject()==true) {
					project.saveProject();
					id_prt+=1;
				}
				break;
				
			case 2:
				
				if(project.validateProject()==true) {
					System.out.println("Digite o Id para remocao:");
					int id_remove = sc.nextInt();
					project.removeProject(id_remove);
				}
				break;
				
			case 3:
				
				if(project.validateProject()==true) {
					project.listProject();
				}
				break;
				
			case 4:
				team.setId(id_tm);
				
				System.out.println("Team name:");
				String nameteam = sc.next();
				team.setName(nameteam);
				sc.nextLine();
				
				System.out.println("Descricao:");
				String descriptionteam = sc.nextLine();
				team.setDescription(descriptionteam);
				
				String savename="";
				for(int controler = 3;controler >= 1; controler--) {
				System.out.println("Quais membros fazem parte da equipe?(limite"+controler+" pessoas)");
				String memberteam = sc.nextLine();
					if(member.findMemberByName(memberteam) !=  null) {
						savename += memberteam+" ";
					}else {
						System.out.println("O nome do membro nao existe!");
					}
				}
				team.setmemberTeam(savename.trim());
				
				System.out.println("Qual o nome do projeto que a equipe faz parte?");
				String projectTeam = sc.nextLine();
				String foundProjectTeam =project.findProject(projectTeam);
                if(foundProjectTeam != null) {
                	team.setProjeto(foundProjectTeam);
                }else {
                	System.out.println("O projeto nao existe(Depois atualize a lista de projetos)!");
                }
				
                System.out.println("id:"+team.getId()+"   team name:"+team.getName()+"   Descricao:"+team.getDescription()+"   Membros:"+team.getmemberTeam()+
                		"   Project:"+team.getProjeto());
                
                if(team.validateCreationTeam()==true) {
					team.addMembers();
					id_tm+=1;
				}
				
				break;
			case 5:
				
				if(team.validateCreationTeam()==true) {
					System.out.println("Digite o Id para remocao:");
					int id_remove = sc.nextInt();
					team.removeTeam(id_remove);
				}
				
				break;
			case 6:
				
				member.setId(id_mb);
			
				System.out.println("Name:");
				String nameMember = sc.next();
				member.setName(nameMember);
				sc.nextLine();
				
				System.out.println("function:");
				String functionMember = sc.nextLine();
				member.setFunction(functionMember);
				
				System.out.println("Email:");
				String EmailMember = sc.nextLine();
				member.setEmail(EmailMember);
				
				System.out.println("Telephone:");
				String TelephoneMember = sc.nextLine();
				member.setTelephone(TelephoneMember);
				
				System.out.println("id:"+member.getId()+ "   name:"+member.getName()+"   function:"+member.getFunction()+
						"   Email:"+member.getEmail()+"   Telephone:"+member.getTelephone());
				
				if(member.validateMember()==true) {
					member.saveMember();
					id_mb+=1;
				}
				break;
				
			case 7:
				
				if(member.validateMember()==true) {
					System.out.println("Digite o Id para remocao:");
					int id_remove = sc.nextInt();
					member.removeMember(id_remove);
				}
				break;
				
			case 8:
				
				if(member.validateMember()==true) {
					member.listMembers();
				}
				break;
				
			case 9:
                
                task.setId(id_tsk);
      
                task.setStart_Date(LocalDate.now());
                task.setEnd_Date(LocalDate.now().plusDays(10));

                System.out.println("Descricao:");
                String descriptiontask = sc.next();
                task.setDescription(descriptiontask);
                sc.nextLine();

                System.out.println("Responsavel:");
                String responsibletask = sc.nextLine();
                String foundMember = member.findMemberByName(responsibletask);

                if(foundMember != null) {
                    task.setResponsible(foundMember);
                } else {
                    System.out.println("O nome do membro nao existe!");
                    break;
                }
                System.out.println("Status:");
                String statustask = sc.nextLine();
                task.setStatus(statustask);
                
                System.out.println("Qual o projeto relacionado a Tarefa:");
                String relatedProject = sc.nextLine();
                String foundProject =project.findProject(relatedProject);
                if(foundProject != null) {
                	task.setProjectTask(foundProject);
                }else {
                	System.out.println("O projeto nao existe!");
                    break;
                }
                
                System.out.println("id:"+task.getId()+"    Description:"+task.getDescription()+"    responsavel:"+task.getResponsible()+"   Status:"+task.getStatus()+
                		"    Project:"+task.getProjectTask()+"Data inicial:"+task.getStart_Date()+"    Data final:"+task.getEnd_Date());
                
                if(task.validatetask()==true) {
					task.saveTask();
					id_tsk+=1;
				}
				break;
			case 10:
				if(task.validatetask()==true) {
					System.out.println("Digite o Id para remocao:");
					int id_remove = sc.nextInt();
					task.removeTask(id_remove);
				}
				break;
			case 11:
				if(task.validatetask()==true) {
					task.listTask();
				}
				break;
			case 12:
				
				if(team.validateCreationTeam()==true) {
					team.listTeam();
				}
				
				break;
			case 13:
				if(project.validateProject()==true) {
					project.listProject();
					System.out.println("Digite o id do projeto para atualizacao:");
					int idUpdate = sc.nextInt();
					project.updateProject(idUpdate);
					project.listProject();
					
				}
				break;
			case 14:
				if(team.validateCreationTeam()==true) {
					team.listTeam();
					System.out.println("Digite o id da equipe para atualizacao:");
					int idUpdate = sc.nextInt();
					team.updateTeam(idUpdate);
					team.listTeam();
				}
				break;
			case 15:
				if(task.validatetask()==true) {
					task.listTask();
					System.out.println("Digite o id da Task para atualizacao:");
					int idUpdate = sc.nextInt();
					task.updateTask(idUpdate);
					task.listTask();
				}
				
				break;
			case 16:
				
				if(member.validateMember()==true) {
					member.listMembers();
					System.out.println("Digite o id do membro para atualizacao:");
					int idUpdate = sc.nextInt();
					member.updateMember(idUpdate);
					member.listMembers();
				}
				
				break;
			case 17:
				System.out.println("insira os detalhes do gerente:");
		        sc.nextLine();
		        System.out.print("Name: ");
		        String namemanager = sc.nextLine();
		        System.out.print("Function: ");
		        String function = sc.nextLine();
		        System.out.print("Email: ");
		        String email = sc.nextLine();
		        System.out.print("Telephone: ");
		        String telephone = sc.nextLine();
		        System.out.print("Department: ");
		        String department = sc.nextLine();
				
		        Maneger manager = new Maneger(id_mb, namemanager, function, email, telephone, department);
		        
				String information = manager.ManagerInfo();
				member.saveMember2(information);
				id_mb+=1;
				break;
				
			
			
			}
			System.out.println("Para Sair digite (S), se deseja continuar digite(C):");
			repeatedAnswer = sc.next();
		}while(repeatedAnswer.equalsIgnoreCase("c") || repeatedAnswer.equalsIgnoreCase("C"));
		
		sc.close();
	}

}

