package application;

public class RegisteredAdress {
	private static RegisteredAdress instance;
	private String registeredAdress;

	public static RegisteredAdress getInstance() {
        if (instance == null) {
            instance = new RegisteredAdress();
        }
        return instance;
    }
	
	public RegisteredAdress() {
		this.registeredAdress = "";
	}

	public String getRegisteredAdress() {
		return registeredAdress;
	}

	public void setRegisteredAdress(String registeredAdress) {
		this.registeredAdress = registeredAdress;
	}

	
}
