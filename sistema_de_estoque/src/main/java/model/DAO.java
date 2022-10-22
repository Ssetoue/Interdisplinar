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
		String validar1 = "SELECT id FROM funcionario WHERE cpf=? AND senha=?";
		String validar2 = "SELECT id FROM administrador WHERE cpf=? AND senha=?";
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
		String read = "SELECT * FROM administrador";
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
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return lista;	
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
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return lista;
	}
	
	public void novoProduto(Produto produto) {
		String novoProduto = "INSERT INTO produto(nome_prod, valor, info_Prod) VALUES (?, ?, ?)";
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
	
	public int novoIdProduto() {
		String novoIdProduto = "SELECT MAX(cod_Prod) FROM produto;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoIdProduto);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int novoId = rs.getInt(1);
				con.close();
				return novoId + 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public void novoAdministrador(Usuario usuario) {
		String novoProduto = "INSERT INTO administrador(nome_func, cpf, senha) VALUES (?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoProduto);
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
		String novoProduto = "INSERT INTO funcionario(nome_func, cpf, senha) VALUES (?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(novoProduto);
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
		String novoFornecedor = "INSERT INTO fornecedor(nome_Forn, contato) VALUES (?, ?)";
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
	
	public ArrayList<Lote> lotesVencendo(){
		ArrayList<Lote> lista = new ArrayList<>();
		return lista;
	}
}
