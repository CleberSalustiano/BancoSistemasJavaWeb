package model;

public class Caixa {

	private int notas10 = 2;
	private int notas20 = 1;
	private int notas50 = 2;
	private int notas100 = 3;
	private int total;
	
	public int getNotas10() {
		return notas10;
	}
	public void setNotas10(int notas10) {
		this.notas10 = notas10;
	}
	public int getNotas20() {
		return notas20;
	}
	public void setNotas20(int notas20) {
		this.notas20 = notas20;
	}
	public int getNotas50() {
		return notas50;
	}
	public void setNotas50(int notas50) {
		this.notas50 = notas50;
	}
	public int getNotas100() {
		return notas100;
	}
	public void setNotas100(int notas100) {
		this.notas100 = notas100;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		this.total = notas10*10 + notas20*20 + notas50*50 + notas100*100;
	}
	public Caixa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Caixa(int notas10, int notas20, int notas50, int notas100) {
		super();
		this.notas10 = notas10;
		this.notas20 = notas20;
		this.notas50 = notas50;
		this.notas100 = notas100;
	}
	
	
}
