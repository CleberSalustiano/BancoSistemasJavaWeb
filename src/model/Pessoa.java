package model;

public class Pessoa {
	private int id;
	private String nome;
	private String conta;
	private String senha;
	private int saldo;
	private int libera10,libera20,libera50, libera100;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLibera10() {
		return libera10;
	}
	public void setLibera10(int libera10) {
		this.libera10 = libera10;
	}
	public int getLibera20() {
		return libera20;
	}
	public void setLibera20(int libera20) {
		this.libera20 = libera20;
	}
	public int getLibera50() {
		return libera50;
	}
	public void setLibera50(int libera50) {
		this.libera50 = libera50;
	}
	public int getLibera100() {
		return libera100;
	}
	public void setLibera100(int libera100) {
		this.libera100 = libera100;
	}
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
