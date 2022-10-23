package model;

public class LoteVencendo {
   private int codigoProduto;
   private String nomeProduto;
   private int codigoLote;
   
   public LoteVencendo() {
      super();
      // TODO Auto-generated constructor stub
   }

   public LoteVencendo(int codigoProduto, String nomeProduto, int codigoLote) {
      super();
      this.codigoProduto = codigoProduto;
      this.nomeProduto = nomeProduto;
      this.codigoLote = codigoLote;
   }

   public int getCodigoProduto() {
      return codigoProduto;
   }

   public void setCodigoProduto(int codigoProduto) {
      this.codigoProduto = codigoProduto;
   }

   public String getNomeProduto() {
      return nomeProduto;
   }

   public void setNomeProduto(String nomeProduto) {
      this.nomeProduto = nomeProduto;
   }

   public int getCodigoLote() {
      return codigoLote;
   }

   public void setCodigoLote(int codigoLote) {
      this.codigoLote = codigoLote;
   }
   
   
}
