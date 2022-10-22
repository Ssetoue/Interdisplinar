package model;

public class Fornecedor {
	private String nome;
	private String contato;
	private int idFornecedor;

	public Fornecedor() {
		super();
	}
	
	public Fornecedor(String nome, String contato, int idFornecedor) {
		this.nome = nome;
		this.contato = contato;
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	@Override
	public String toString() {
		return "Nome = " + nome + "\ncontato = " + contato
				+ "\nidFornecedor = " + idFornecedor;

	}
}
