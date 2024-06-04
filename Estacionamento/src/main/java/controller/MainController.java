package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet( urlPatterns = {"/MainController", "/main", "/insert", "/select", "/update", "/delete"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// instâncias a serem usadas na comunicação nos métodos com as classes
	DAO dao = new DAO(); 
	JavaBeans novoCarro = new JavaBeans();
	
	
    public MainController() {
        super();
    }

    //TRATADOR DE REQUISIÇÕES
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//dao.testeConexao();
		String action = request.getServletPath();
		if(action.equals("/main")) {
			registrador(request, response);
		}
		else if(action.equals("/insert")) {
			adicionaCarro(request, response);
		}
		else if(action.equals("/select")) {
			listarInfo(request, response);
		}
		else if(action.equals("/update")) {
			editarInfo(request, response);
		}
		else if(action.equals("/delete")) {
			deletarInfo(request, response);
		}
		else {
			response.sendRedirect("index.html");		
		}
	}
	
	// cria dinamicamente a pagina de registros
	protected void registrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> registros = dao.listaRegistros();
		request.setAttribute("registros", registros);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	
	// adiciona registro
	protected void adicionaCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		novoCarro.setPlaca(request.getParameter("placa"));
		novoCarro.setNome(request.getParameter("nome"));
		novoCarro.setTelefone(request.getParameter("telefone"));
		dao.insereCarroNoBanco(novoCarro);
		response.sendRedirect("main");
	}
	
	// mostra os atributos principais de todos os registros
	protected void listarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCARRO = request.getParameter("idCarro");
		//System.out.println(idCARRO);
		novoCarro.setIdCarro(idCARRO);
		dao.selecionar(novoCarro);
		//System.out.println(novoCarro.getTelefone());
		request.setAttribute("placa", novoCarro.getPlaca());
		request.setAttribute("nome", novoCarro.getNome());
		request.setAttribute("telefone", novoCarro.getTelefone());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	// edição de registro
	protected void editarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println(request.getParameter("placa")); //teste
		novoCarro.setPlaca(request.getParameter("placa"));
		novoCarro.setNome(request.getParameter("nome"));
		novoCarro.setTelefone(request.getParameter("telefone"));
		dao.alterar(novoCarro);
		response.sendRedirect("main");
		
	}
	
	//deleção de registro
	protected void deletarInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idCarro");
		novoCarro.setIdCarro(id);
		dao.deleteInfo(novoCarro);
		response.sendRedirect("main");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
