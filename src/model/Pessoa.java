package model;

public class Pessoa {
	
	private String nome;
	private String conta;
	private String senha;
	private int saldo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public Pessoa() {
		super();
	}
	public Pessoa(String nome, String conta, String senha, int saldo) {
		super();
		this.nome = nome;
		this.conta = conta;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	
}
