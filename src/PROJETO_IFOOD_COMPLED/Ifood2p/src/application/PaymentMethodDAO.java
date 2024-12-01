package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodDAO {

private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public List<PaymentMethod> getallpagamentos() {
		String sql = "SELECT * FROM formaPagamento";
		List<PaymentMethod> formasdepagamento = new ArrayList<>();
		try (Connection connection = dbManeger.openConnection();
			Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
			
			while (rs.next()) {
				PaymentMethod payment = new PaymentMethod(null, null, null);
				payment.setId(rs.getInt("id"));
				payment.setShape(rs.getString("forma"));
				formasdepagamento.add(payment);
			}
				
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao achar restaurant",e);
		}
		return formasdepagamento;
	}
}
