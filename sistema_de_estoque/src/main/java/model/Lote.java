package model;

public class Lote {
	private static int contador;
	private String codigo;
	private Produto produto;
	private double precoLote;
	private int quantidade;
	private Data dataVal, dataFab;

	public Lote(Produto produto, int quantidade, double precoLote, Data dataFab, Data dataVal) {
		++contador;

		this.produto = produto;
		this.precoLote = precoLote;
		this.quantidade = quantidade;
		this.dataFab = dataFab;
		this.dataVal = dataVal;
		codigo = "Lote " + contador;
	}

	public String getCodigo() {
		return codigo;
	}

	public Produto produto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getPrecoLote() {
		return precoLote;
	}

	public void setPrecoLote(double precoLote) {
		this.precoLote = precoLote;
	}

	public Data getDataFab() {
		return dataFab;
	}

	public void setDataFab(Data dataFab) {
		this.dataFab = dataFab;
	}

	public Data getDataVal() {
		return dataVal;
	}

	public void setDataVal(Data dataVal) {
		this.dataVal = dataVal;
	}

	@Override
	public String toString() {
		return "\ncodigo = " + this.codigo + "\nproduto = " + produto + "\nprecoLote = " + precoLote + "\nquantidade = "
				+ quantidade + "\ndataVal= " + dataVal + "\ndataFab= " + dataFab;
	}
}
