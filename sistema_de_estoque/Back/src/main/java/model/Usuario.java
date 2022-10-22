package model;

public class Usuario {
	private static String acesso = "";
	private int id;
	private String cpf;
	private String senha;
	private String nome;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String cpf, String senha, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static String getAcesso() {
		return acesso;
	}

	public static void setAcesso(String acesso) {
		Usuario.acesso = acesso;
	}
	
	
}
