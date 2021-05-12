package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conta;

public class ContaDao {

	private Connection connection;

	public void inserir(Conta conta) {
		String sql = "insert into conta values (?,?,?)";
		try {
			connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, conta.getNumConta());
			stmt.setString(2, conta.getTitular());
			stmt.setDouble(3, conta.getSaldo());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public void saqueDeposito(Conta conta) {
		String sql = "update conta set saldo =? where numero_conta=?";
		try {
			connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, conta.getNumConta());
			stmt.setString(2, conta.getTitular());
			stmt.setDouble(3, conta.getSaldo());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public void apagar(Conta conta) {
		String sql = "delete from conta where numero_conta=?";
		try {
			connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, conta.getNumConta());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public List<Conta> listarContas() {
		String sql = "select * from conta;";
		try {
			connection = new ConnectionFactory().getConnection();
			List<Conta> lista = new ArrayList<Conta>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Conta conta = new Conta(rs.getInt("numero_conta"), rs.getString("titular"), rs.getDouble("saldo"));
				lista.add(conta);
			}
			stmt.close();
			rs.close();
			connection.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public Conta buscarConta(int numConta) {
		String sql = "select * from conta where numero_conta=?";
		try {
			connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, numConta);
			Conta conta;
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				conta = new Conta(rs.getInt("numero_conta"), rs.getString("titular"), rs.getDouble("saldo"));
			} else {
				conta = null;
			}
			stmt.close();
			rs.close();
			connection.close();
			return conta;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
