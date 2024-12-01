package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryHistoryDAO {

private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public void setallprodutoshistorico(Order order) {
		String sql = "INSERT INTO historicoDeEntregas (detalhes) values (?)";
		try (Connection connection = dbManeger.openConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			for (DeliveryHistory delivery : order.getDeliveryHistory()) {
				String pedidoCarrinho = delivery.getOrder().getObservation();
				stmt.setString(1,pedidoCarrinho);
				stmt.executeUpdate();
			}		
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
	}
	public List<DeliveryHistory> getallprodutoshistorico() {
		String sql = "SELECT * FROM historicoDeEntregas";
		List<DeliveryHistory> historicoDeEntregas = new ArrayList<>();
		try (Connection connection = dbManeger.openConnection();
			Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				DeliveryHistory deliveryHistory = new DeliveryHistory(null, null);
				deliveryHistory.setDetails(rs.getString("detalhes"));
				historicoDeEntregas.add(deliveryHistory);
			}
				
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return historicoDeEntregas;
	}
	
}