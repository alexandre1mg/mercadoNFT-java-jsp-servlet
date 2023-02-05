
package com.mercadoNFTs.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercadoNFTs.dao.UsuarioDAO;
import com.mercadoNFTs.model.Usuario;

@WebServlet(urlPatterns = "/ServletUsuario")
public class ServletUsuario extends HttpServlet {

	private static final long serialVersionUID = 3181168871362193755L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String v_nome=request.getParameter("nm");
            String v_cpf=request.getParameter("cpf") ;
            String v_email=request.getParameter("email"); 
            String v_senha=request.getParameter("senha");

            Usuario a = new Usuario();
            a.setNome(v_nome);
            a.setEmail(v_email);
            a.setCpf(v_cpf);
            a.setSenha(v_senha);

            
              UsuarioDAO m = new UsuarioDAO();
            m.cadastrar(a);
            
         
            response.sendRedirect("login.jsp");
        } catch (Exception ex) {
            Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
