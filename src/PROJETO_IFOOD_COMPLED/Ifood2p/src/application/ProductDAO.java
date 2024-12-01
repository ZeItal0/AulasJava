package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public List<Product> getallprodutos(int item) {
		String sql = "SELECT * FROM produtos WHERE id_restaurante = ?";
		List<Product> Listadeprodutos = new ArrayList<>();
		
		try (Connection connection = dbManeger.openConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, item);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Product product = new Product(null, 0, null, null);
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("nome"));
					Listadeprodutos.add(product);
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return Listadeprodutos;
	}

}
