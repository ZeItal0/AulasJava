package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public void setallprodutoscarrinho(Order order) {
		String sql = "INSERT INTO pedido (id_restaurante,observacoes) values (?,?)";
		try (Connection connection = dbManeger.openConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			for (ProductOrder productOrder : order.getProductOrder()) {
				String pedidoCarrinho = productOrder.getProduct().getName();
				int idrestaurante = order.getId();
				stmt.setInt(1, idrestaurante );
				stmt.setString(2,pedidoCarrinho);
				stmt.executeUpdate();
			}		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
	}
	
	public List<Order> getallprodutoscarrinho() {
		String sql = "SELECT * FROM pedido";
		List<Order> pedidocarrinho = new ArrayList<>();
		try (Connection connection = dbManeger.openConnection();
			Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				Order order = new Order(null, 0, 0, null, null, null, 0, null, null, null, null, null);
				order.setObservation(rs.getString("observacoes"));
				order.setId(rs.getInt("id"));
				pedidocarrinho.add(order);
			}
				
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return pedidocarrinho;
	}
	
	public List<Order> deletecarrinho() {
		String sql = "DELETE FROM pedido";
		List<Order> pedidocarrinho = new ArrayList<>();
		try (Connection connection = dbManeger.openConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.executeUpdate();
				
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return pedidocarrinho;
	}
	
	
}
