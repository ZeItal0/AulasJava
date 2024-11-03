package Entity;

public abstract class Base {
	
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public class Status {
		public static final String Preparation = "Preparation";
		public static final String ItWentOut = "ItWentOut";
		public static final String Delivered = "Delivered";
	}
	

}
