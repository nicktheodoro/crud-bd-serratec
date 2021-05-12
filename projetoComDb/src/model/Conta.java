package model;

public class Conta {
	private int numConta;
	private String titular;
	private double saldo;

	public Conta(int numConta, String titular, double saldo) {
		super();
		this.numConta = numConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Número da Conta: " + numConta + ", Titular: " + titular + ", Saldo: R$" + saldo + "\n";
	}

}
