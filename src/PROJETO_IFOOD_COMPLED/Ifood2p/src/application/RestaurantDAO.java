package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {
	
	private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public List<Restaurant> getallrestaurantNames() {
		String sql = "SELECT * FROM restaurante";
		List<Restaurant> restaurantesNames = new ArrayList<>();
		try (Connection connection = dbManeger.openConnection();
			Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				Restaurant restaurante = new Restaurant(null, null, null, null, null, false, 0, null);
				restaurante.setId(rs.getInt("id"));
				restaurante.setName(rs.getString("nome"));
				restaurantesNames.add(restaurante);
			}
				
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return restaurantesNames;
	}
	
}
