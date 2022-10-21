package model;

public class Produto {
	private int codigo;
	private String nome;
	private double preco;
	private String info;

	public Produto() {
		super();
	}
	
	public Produto(String nome, double preco, int codigo, String info) {
		this.preco = preco;
		this.nome = nome;
		this.codigo = codigo;
		this.info = info;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	@Override
	public String toString() {
		return "\nCodigo:" + this.codigo + "\nNome: " + nome + "\npreco: " + preco;
	}
}