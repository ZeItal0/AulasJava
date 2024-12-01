package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FollowUpDAO {
private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public List<FollowUp> getalladicional(int item) {
		String sql = "SELECT * FROM acompanhamento";
		List<FollowUp> Listadeadicionais = new ArrayList<>();
		
		try (Connection connection = dbManeger.openConnection();
				Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
			
				while (rs.next()) {
					FollowUp adicional = new FollowUp(null,null, 0);
					adicional.setName(rs.getString("nome"));
					Listadeadicionais.add(adicional);
				}
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return Listadeadicionais;
	}

}
