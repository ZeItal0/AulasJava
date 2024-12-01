package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AdressDAO {

private final static DatabaseManeger dbManeger = new MySQLDatabaseManeger();
	
	public void enderecoregistro(Adress adress) {
		
		String sql = "INSERT INTO endereco (rua,bairro,numero,cidade,estado,pontoReferencia,complemento,cep,tipo_endereco) VALUES (?,?,?,?,?,?,?,?,?)";
		try (Connection connection = dbManeger.openConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setString(1,adress.getRoad());
				stmt.setString(2,adress.getNeighborhood());
				stmt.setString(3,adress.getNumber());
				stmt.setString(4,adress.getCity());
				stmt.setString(5,adress.getState());
				stmt.setString(6,adress.getReference_point());
				stmt.setString(7,adress.getComplement());
				stmt.setInt(8,adress.getZip_code());
				stmt.setString(9,adress.getAddress_type());
				stmt.executeLargeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("Erro ao salvar endereco");
			}
	}
	
}
