package persistence;

import java.sql.Connection;

import model.Conta;

public class TestaConexao {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		
		Conta conta = new Conta(1, "Ana", 10000);
		
		ContaDao teste = new ContaDao();
		
		//teste.inserir(conta);
		//teste.apagar(conta);
		
		//conta.setSaldo(2000);
		//System.out.println(conta.getSaldo());
		//conta.setSaldo(100000);
		//System.out.println(conta.getSaldo());
		teste.saqueDeposito(conta);
		//System.out.println(teste.buscarConta(5));
		System.out.println(teste.listarContas());
		
	}

}
