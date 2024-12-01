package application;

public abstract class Base {
	
	protected int id;
	private Status status_user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Status isStatus_user() {
		return status_user;
	}

	public void setStatus_user(Status status_user) {
		this.status_user = status_user;
	}

	public class Status {
		public static final String Preparation = "Active";
		public static final String ItWentOut = "Inactive";
		
	}
	

}
