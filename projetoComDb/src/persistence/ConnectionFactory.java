package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String urlConexao = "jdbc:mysql://localhost:3306/exercicios";
	String usuario = "root";
	String senha = "";
	Connection connection;

	public Connection getConnection() {
		System.out.println("Conectando ao Banco");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(urlConexao, usuario, senha);
			if (connection != null) {
				System.out.println("Conectado ao Banco");
			} else {
				System.out.println("Nao foi possivel conectar ao banco");
			}
		} catch (SQLException e) {
			System.out.println("Erro de conexao");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver nao encontrado");
		}
		return connection;
	}
}