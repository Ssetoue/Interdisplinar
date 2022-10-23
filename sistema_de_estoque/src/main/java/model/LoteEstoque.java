package model;
import java.util.Date;

public class LoteEstoque {
   private String produtoNome;
   private int produtoCodigo;
   private int quantidade;
   private int loteCodigo;
   private Date dataVencimento;
   
   public LoteEstoque() {
      super();
      // TODO Auto-generated constructor stub
   }

   public LoteEstoque(String produtoNome, int produtoCodigo, int quantidade, int loteCodigo, Date dataVencimento) {
      super();
      this.produtoNome = produtoNome;
      this.produtoCodigo = produtoCodigo;
      this.quantidade = quantidade;
      this.loteCodigo = loteCodigo;
      this.dataVencimento = dataVencimento;
   }

   public String getProdutoNome() {
      return produtoNome;
   }

   public void setProdutoNome(String produtoNome) {
      this.produtoNome = produtoNome;
   }

   public int getProdutoCodigo() {
      return produtoCodigo;
   }

   public void setProdutoCodigo(int produtoCodigo) {
      this.produtoCodigo = produtoCodigo;
   }

   public int getQuantidade() {
      return quantidade;
   }

   public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
   }

   public int getLoteCodigo() {
      return loteCodigo;
   }

   public void setLoteCodigo(int loteCodigo) {
      this.loteCodigo = loteCodigo;
   }

   public Date getDataVencimento() {
      return dataVencimento;
   }

   public void setDataVencimento(Date dataVencimento) {
      this.dataVencimento = dataVencimento;
   }
   
   
}
