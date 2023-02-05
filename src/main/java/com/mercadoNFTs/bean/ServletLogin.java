package com.mercadoNFTs.bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercadoNFTs.conexao.Conexao;
import com.mercadoNFTs.control.Login;
import com.mercadoNFTs.dao.LoginDao;
import com.mercadoNFTs.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Login login = new Login();
        login.setEmail(email);
        login.setSenha(senha);

        LoginDao loginDAO = new LoginDao();

        Login loginBuscado = loginDAO.pesquisar(login);

        if (loginBuscado.getEmail() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("email", loginBuscado.getEmail());
            session.setAttribute("id_usuarios", loginBuscado.getId());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

		
		
	}
	
}
