package application;

import java.sql.Connection;

public interface DatabaseManeger {

	Connection openConnection();
	void closeConnection(Connection connection);
	
	
	
}
