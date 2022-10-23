package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.Usuario;
import model.Lote;
import model.Produto;
import model.Fornecedor;
import model.LoteVencendo;
import model.LoteEstoque;
/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/inicio", "/login", "/usuario", "/sair", "/home", "/novoProduto", "/novoUsuario", "/novoFornecedor", "/cadastroProduto", "/novoLote", "/consultarEstoque", "/atualizarUsuario", "/atualizarEstoque"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	Usuario usuario = new Usuario();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/inicio")) {
			response.sendRedirect("Login.jsp");
		} else if (action.equals("/login")) {
			validarUsuario(request, response);
		} else if (action.equals("/usuario")){
			if (Usuario.getAcesso().equals("Administracao")) {
				listarUsuarios(request, response);
			} else if (Usuario.getAcesso().equals("Funcionario")) { 
				response.sendRedirect("home");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equals("/sair")){
			Usuario.setAcesso("");
			response.sendRedirect("Login.jsp");
		} else if (action.equals("/novoProduto")) {
			if (Usuario.getAcesso().equals("Administracao")) {
				novoProduto(request, response);
			} else if (Usuario.getAcesso().equals("Funcionario")) { 
				response.sendRedirect("home");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equals("/novoUsuario")){
			if (Usuario.getAcesso().equals("Administracao")) {
				novoUsuario(request, response);
			} else if (Usuario.getAcesso().equals("Funcionario")) { 
				response.sendRedirect("home");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equals("/home")){
			if (Usuario.getAcesso().equals("Administracao") || Usuario.getAcesso().equals("Funcionario")) {
	            lotesVencendo(request, response);
	        } else {
	            response.sendRedirect("Login.jsp");
	        }
		} else if (action.equals("/novoFornecedor")){
			if (Usuario.getAcesso().equals("Administracao")) {
				novoFornecedor(request, response);
			} else if (Usuario.getAcesso().equals("Funcionario")) { 
				response.sendRedirect("home");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equals("/cadastroProduto")){
			if (Usuario.getAcesso().equals("Administracao")) {
				response.sendRedirect("cadastroProduto.jsp");
			} else if (Usuario.getAcesso().equals("Funcionario")) { 
				response.sendRedirect("home");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equals("/novoLote")){
			if (Usuario.getAcesso().equals("Administracao")) {
				novoLote(request, response);
			} else if (Usuario.getAcesso().equals("Funcionario")) { 
				response.sendRedirect("home");
			} else {
				response.sendRedirect("Login.jsp");
			}
		} else if (action.equals("/consultarEstoque")){
           if (Usuario.getAcesso().equals("Administracao") || Usuario.getAcesso().equals("Funcionario")) {
              consultarEstoque(request, response);
          } else {
              response.sendRedirect("Login.jsp");
          }
        } else if (action.equals("/atualizarUsuario")){
           if (Usuario.getAcesso().equals("Administracao")) {
              atualizarUsuario(request, response);
          } else if (Usuario.getAcesso().equals("Funcionario")) { 
              response.sendRedirect("home");
          } else {
              response.sendRedirect("Login.jsp");
          }
        } else if (action.equals("/atualizarEstoque")){
           if (Usuario.getAcesso().equals("Administracao")) {
              atualizarEstoque(request, response);
          } else if (Usuario.getAcesso().equals("Funcionario")) { 
              response.sendRedirect("home");
          } else {
              response.sendRedirect("Login.jsp");
          }
        } else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setCpf(request.getParameter("CPF"));
		usuario.setSenha(request.getParameter("Senha"));
		if (dao.validarUsuario(usuario)) {
			RequestDispatcher rd = request.getRequestDispatcher("home");
			rd.forward(request, response);
		} else {
			Usuario.setAcesso("negado");
			request.setAttribute("acesso", usuario);
			response.sendRedirect("Login.jsp");
		}
	}
	
	protected void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Usuario> lista = dao.listarAdministracao();
		lista.addAll(dao.listarFuncionario());
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("usuario.jsp");
		rd.forward(request, response);
	}
	
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto produto = new Produto();
		produto.setNome(request.getParameter("Nome"));
		produto.setPreco(Double.parseDouble(request.getParameter("Valor")));
		produto.setInfo(request.getParameter("inf_1") + request.getParameter("inf_2") + request.getParameter("inf_3"));
		dao.novoProduto(produto);
		response.sendRedirect("home");
	}
	
	protected void novoIdProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuario.setId(dao.idProduto() + 1);
		request.setAttribute("novoId", usuario);
		RequestDispatcher rd = request.getRequestDispatcher(("cadastroProduto.jsp"));
		rd.forward(request, response);
	}
	
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nomeCompleto"));
		usuario.setCpf(request.getParameter("CPF"));
		usuario.setSenha(request.getParameter("senha_text"));
		if (request.getParameter("usuario").equals("administrador")) {
		   dao.novoAdministrador(usuario);
		} else {
		   dao.novoFuncionario(usuario);
		}
		response.sendRedirect("usuario");
	}
	
	protected void atualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   Usuario usuario = new Usuario();
       usuario.setNome(request.getParameter("nomeCompleto"));
       usuario.setCpf(request.getParameter("CPF"));
       usuario.setSenha(request.getParameter("senha_text"));
       String acesso = dao.usuarioAcesso(usuario);
       if (request.getParameter("usuario").equals("administrador")) {
          if (acesso.equals("administrador")) {
             dao.atualizarAdministrador(usuario);
          } else if (acesso.equals("funcionario")){
             dao.deletarFuncionario(usuario);
             dao.novoAdministrador(usuario);
          }
       } else {
          if (acesso.equals("funcionario")) {
             dao.atualizarFuncionario(usuario);
          } else if (acesso.equals("administrador")){
             dao.deletarAdministrador(usuario);
             dao.novoFuncionario(usuario);
          }
       }
       response.sendRedirect("usuario");
	}
	
	protected void novoFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(request.getParameter("Nome"));
		fornecedor.setContato(request.getParameter("Contato"));
		dao.novoFornecedor(fornecedor);
		response.sendRedirect("Home.jsp");
	}
	
	protected void novoLote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Lote lote = new Lote();
		lote.setProduto(request.getParameter("NomeProd"));
		try {
			lote.setDataFab(sdf.parse(request.getParameter("DataFabricacao")));
			lote.setDataVal(sdf.parse(request.getParameter("DataVencimento")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		lote.setInfo(request.getParameter("inf_1") + request.getParameter("inf_2") + request.getParameter("inf_3"));
		lote.setNomeForn(request.getParameter("NomeForn"));
		lote.setPrecoLote(Double.parseDouble(request.getParameter("Valor")));
		lote.setQuantidade(Integer.parseInt(request.getParameter("Quantidade")));
		dao.novoLote(lote);
		response.sendRedirect("cadastro.html");
	}
	
	protected void lotesVencendo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<LoteVencendo> lista = dao.lotesVencendo();
		request.setAttribute("lotesVencendo", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}
	
	protected void consultarEstoque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   ArrayList<LoteEstoque> lista = dao.consultarEstoque();
       request.setAttribute("loteEstoque", lista);
       RequestDispatcher rd = request.getRequestDispatcher("consulta-estoque.jsp");
       rd.forward(request, response);
	}
	
	protected void atualizarEstoque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   Lote lote = new Lote();
	   lote.setProduto(request.getParameter("NomeProd"));
	   lote.setPrecoLote((Double.parseDouble(request.getParameter("Valor"))));
	   lote.setCodigo(Integer.parseInt(request.getParameter("CodigoLote")));
	   //lote.setQuantidade(Integer.parseInt(request.getParameter("Quantidade")));
	   dao.atualizarLote(lote);
	   response.sendRedirect("estoque.jsp");
	}
}
