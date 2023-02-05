package com.mercadoNFTs.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercadoNFTs.dao.UsuarioDAO;
import com.mercadoNFTs.model.Usuario;

/**
 * Servlet implementation class EditarPerfilServlet
 */
@WebServlet(urlPatterns = "/EditarPerfil")
public class ServletEditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 int id = Integer.parseInt(request.getParameter("codigo"));
         String nome = request.getParameter("nome");
         //double cpf = Double.parseDouble(String.valueOf(request.getParameter("valor")).replace(".", "").replace(",", "."));
         String cpf = request.getParameter("cpf");;
         String email = request.getParameter("email");;
         
         Usuario usuario = new Usuario();
         usuario.setId(id);
         usuario.setNome(nome);
         usuario.setCpf(cpf);
         usuario.setEmail(email);
         
         UsuarioDAO usuarioDAO = new UsuarioDAO();
         usuarioDAO.alterar(usuario);
         
         request.getRequestDispatcher("perfil.jsp").forward(request, response);
	}

}
