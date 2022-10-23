package model;
import java.util.Date;

public class Lote {
	private int codigo;
	private String produto;
	private int produtoCodigo;
	private double precoLote;
	private int quantidade;
	private Date dataVal, dataFab;
	private String info, nomeForn;

	public Lote() {
		super();
	}
	
	public Lote(String produto, int quantidade, double precoLote, Date dataFab, Date dataVal, int codigo, String info, String nomeForn) {
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

	public Date getDataFab() {
		return dataFab;
	}

	public void setDataFab(Date dataFab) {
		this.dataFab = dataFab;
	}

	public Date getDataVal() {
		return dataVal;
	}

	public void setDataVal(Date dataVal) {
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
	
	public int getProdutoCodigo() {
      return produtoCodigo;
   }

   public void setProdutoCodigo(int produtoCodigo) {
      this.produtoCodigo = produtoCodigo;
   }

   @Override
	public String toString() {
		return "\ncodigo = " + this.codigo + "\nproduto = " + produto + "\nprecoLote = " + precoLote + "\nquantidade = "
				+ quantidade + "\ndataVal= " + dataVal + "\ndataFab= " + dataFab;
	}
}
