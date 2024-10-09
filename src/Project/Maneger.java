package Project;

public class Maneger extends Member {

	private String department;
	
	public Maneger(int id, String name, String function, String email, String telephone, String department) {
		super(id, name, function, email, telephone);
        this.department = department;
	}
	
	public String ManagerInfo() {
        String info = String.format("ID: %d, Name: %s, function: %s, email: %s, Telephone: %s, department: %s",
                getId(), getName(), getFunction(), getEmail(), getTelephone(), department);
        System.out.println(info);
		return info;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
	
	
	
	
	
	
}
