package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private String url = "jdbc:mysql://127.0.0.1:3306/inter?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8&characterSetResults=UTF-8";
	
	private String user = "root";
	
	private String password = "root";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public boolean validarUsuario(Usuario usuario) {
		String validar1 = "SELECT id FROM funcionario WHERE cpf=? AND senha=?;";
		String validar2 = "SELECT id FROM administrador WHERE cpf=? AND senha=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst1 = con.prepareStatement(validar1);
			pst1.setString(1, usuario.getCpf());
			pst1.setString(2, usuario.getSenha());
			ResultSet rs = pst1.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) != 0) {
					usuario.setId(rs.getInt(1));
					Usuario.setAcesso("Funcionario");
					con.close();
					return true;
				}
			}
			PreparedStatement pst2 = con.prepareStatement(validar2);
			pst2.setString(1, usuario.getCpf());
			pst2.setString(2, usuario.getSenha());
			rs = pst2.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) != 0) {
					usuario.setId(rs.getInt(1));
					Usuario.setAcesso("Administracao");
					con.close();
					return true;
				}
			}
			con.close();
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}		
	}
	
	public ArrayList<Usuario> listarAdministracao(){
		ArrayList<Usuario> lista  = new ArrayList<>();
		String read = "SELECT * FROM administrador;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String senha = rs.getString(4);
				lista.add(new Usuario(id, cpf, senha, nome));
			} 
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}

	public ArrayList<Usuario> listarFuncionario(){
		ArrayList<Usuario> lista  = new ArrayList<>();
		String read = "SELECT * FROM funcionario";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String senha = rs.getString(4);
				lista.add(new Usuario(id, cpf, senha, nome));
			} 
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void novoProduto(Produto produto) {
		String novoProduto = "INSERT INTO produto(nome_prod, valor, info_Prod) VALUES (?, ?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoProduto);
			pst.setString(1, produto.getNome());
			pst.setDouble(2, produto.getPreco());
			pst.setString(3, produto.getInfo());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int idProduto() {
		String idProduto = "SELECT MAX(cod_Prod) FROM produto;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(idProduto);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				con.close();
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public void novoAdministrador(Usuario usuario) {
		String novoAdministrador = "INSERT INTO administrador(nome_func, cpf, senha) VALUES (?, ?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoAdministrador);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getCpf());
			pst.setString(3, usuario.getSenha());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void novoFuncionario(Usuario usuario) {
		String novoFuncionario = "INSERT INTO funcionario(nome_func, cpf, senha) VALUES (?, ?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoFuncionario);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getCpf());
			pst.setString(3, usuario.getSenha());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void novoFornecedor(Fornecedor fornecedor) {
		String novoFornecedor = "INSERT INTO fornecedor(nome_Forn, contato) VALUES (?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoFornecedor);
			pst.setString(1, fornecedor.getNome());
			pst.setString(2, fornecedor.getContato());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int produtoId(String nome) {
		String produtoId = "SELECT cod_Prod FROM produto WHERE nome_prod = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(produtoId);
			pst.setString(1, nome);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				con.close();
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int fornecedorId(String nome) {
		String fornecedorId = "SELECT cod_Forn FROM fornecedor WHERE nome_Forn = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(fornecedorId);
			pst.setString(1, nome);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				con.close();
				return id;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public void novoLote(Lote lote) {
		String novoLote = "INSERT INTO lote(Cod_Prod, cod_Forn, preco_Lote, quant_Lote, data_fabric, data_vencimento, info_Lote) VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoLote);
			pst.setInt(1, produtoId(lote.getProduto()));
			pst.setInt(2, fornecedorId(lote.getNomeForn()));
			pst.setDouble(3, lote.getPrecoLote());
			pst.setInt(4, lote.getQuantidade());
			pst.setDate(5, new java.sql.Date(lote.getDataFab().getTime()));
			pst.setDate(6, new java.sql.Date(lote.getDataVal().getTime()));
			pst.setString(7, lote.getInfo());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<LoteVencendo> lotesVencendo(){
		ArrayList<LoteVencendo> lista = new ArrayList<>();
		String lotesVencendo = "SELECT produto.cod_Prod, produto.nome_Prod, lote.Cod_Lote FROM produto, lote WHERE (lote.data_vencimento BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 MONTH)) AND produto.cod_Prod = lote.Cod_Prod;";
		try {
		   Connection con = conectar();
		   PreparedStatement pst = con.prepareStatement(lotesVencendo);
		   ResultSet rs = pst.executeQuery();
		   while (rs.next()) {
		      lista.add(new LoteVencendo(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		   }
		   con.close();
		   return lista;
        } catch (Exception e) {
           System.out.println(e);
           return null;
        }
	}
	
	public ArrayList<LoteEstoque> consultarEstoque(){
	   ArrayList<LoteEstoque> lista = new ArrayList<>();
	   String consultarEstoque = "SELECT produto.nome_prod, produto.cod_Prod, lote.quant_Lote, lote.Cod_Lote, lote.data_vencimento FROM produto, lote WHERE produto.cod_Prod = lote.Cod_Prod;";
	   try {
         Connection con = conectar();
         PreparedStatement pst = con.prepareStatement(consultarEstoque);
         ResultSet rs = pst.executeQuery();
         while (rs.next()) {
            lista.add(new LoteEstoque(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5)));
         }
         con.close();
         return lista;
      } catch (Exception e) {
         System.out.println(e);
         return null;
      }
	}
	
	public String usuarioAcesso(Usuario usuario) {
	   String validar1 = "SELECT id FROM funcionario WHERE cpf=?;";
       String validar2 = "SELECT id FROM administrador WHERE cpf=?;";
       try {
           Connection con = conectar();
           PreparedStatement pst1 = con.prepareStatement(validar1);
           pst1.setString(1, usuario.getCpf());
           ResultSet rs = pst1.executeQuery();
           while (rs.next()) {
               if (rs.getInt(1) != 0) {
                   usuario.setId(rs.getInt(1));
                   con.close();
                   return "funcionario";
               }
           }
           PreparedStatement pst2 = con.prepareStatement(validar2);
           pst2.setString(1, usuario.getCpf());
           rs = pst2.executeQuery();
           while (rs.next()) {
               if (rs.getInt(1) != 0) {
                   usuario.setId(rs.getInt(1));
                   con.close();
                   return "administrador";
               }
           }
           con.close();
           return "inválido";
       } catch (Exception e) {
           System.out.println(e);
           return "inválido";
       }   
	}
	
	public void atualizarAdministrador(Usuario usuario) {
	   String atualizar = "UPDATE administrador SET nome_func=?, senha=? WHERE cpf=?;";
	   try {
	      Connection con = conectar();
	      PreparedStatement pst = con.prepareStatement(atualizar);
	      pst.setString(1, usuario.getNome());
	      pst.setString(2, usuario.getSenha());
	      pst.setString(3, usuario.getCpf());
	      pst.executeUpdate();
	      con.close();
	   } catch (Exception e) {
         System.out.println(e);
       }
	}
	
	public void deletarAdministrador(Usuario usuario) {
	   String deletar = "DELETE FROM administrador WHERE cpf=?;";
	   try {
	      Connection con = conectar();
	      PreparedStatement pst = con.prepareStatement(deletar);
	      pst.setString(1, usuario.getCpf());
	      pst.executeUpdate();
	      con.close();
       } catch (Exception e) {
          System.out.println(e);
       }
	}
	   
    public void atualizarFuncionario(Usuario usuario) {
       String atualizar = "UPDATE funcionario SET nome_func=?, senha=? WHERE cpf=?;";
       try {
          Connection con = conectar();
          PreparedStatement pst = con.prepareStatement(atualizar);
          pst.setString(1, usuario.getNome());
          pst.setString(2, usuario.getSenha());
          pst.setString(3, usuario.getCpf());
          pst.executeUpdate();
          con.close();
       } catch (Exception e) {
         System.out.println(e);
       }
    }
    
    public void deletarFuncionario(Usuario usuario) {
       String deletar = "DELETE FROM funcionario WHERE cpf=?;";
       try {
          Connection con = conectar();
          PreparedStatement pst = con.prepareStatement(deletar);
          pst.setString(1, usuario.getCpf());
          pst.executeUpdate();
          con.close();
       } catch (Exception e) {
          System.out.println(e);
       }
    }
}
