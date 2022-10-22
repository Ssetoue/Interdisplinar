package model;

public class Lote {
	private int codigo;
	private String produto;
	private double precoLote;
	private int quantidade;
	private String dataVal, dataFab, info, nomeForn;

	public Lote() {
		super();
	}
	
	public Lote(String produto, int quantidade, double precoLote, String dataFab, String dataVal, int codigo, String info, String nomeForn) {
		this.produto = produto;
		this.precoLote = precoLote;
		this.quantidade = quantidade;
		this.dataFab = dataFab;
		this.dataVal = dataVal;
		this.codigo = codigo;
		this.info = info;
		this.nomeForn = nomeForn;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String produto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getPrecoLote() {
		return precoLote;
	}

	public void setPrecoLote(double precoLote) {
		this.precoLote = precoLote;
	}

	public String getDataFab() {
		return dataFab;
	}

	public void setDataFab(String dataFab) {
		this.dataFab = dataFab;
	}

	public String getDataVal() {
		return dataVal;
	}

	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getNomeForn() {
		return nomeForn;
	}

	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}

	public String getProduto() {
		return produto;
	}

	@Override
	public String toString() {
		return "\ncodigo = " + this.codigo + "\nproduto = " + produto + "\nprecoLote = " + precoLote + "\nquantidade = "
				+ quantidade + "\ndataVal= " + dataVal + "\ndataFab= " + dataFab;
	}
}
