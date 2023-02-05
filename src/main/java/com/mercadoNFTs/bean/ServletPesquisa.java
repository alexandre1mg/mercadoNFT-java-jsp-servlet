package com.mercadoNFTs.bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mercadoNFTs.dao.ItemDao;
import com.mercadoNFTs.model.Item;


@WebServlet("/ServletPesquisa")
public class ServletPesquisa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnm = String.valueOf(request.getParameter("pnm"));
		
        
        ItemDao itemDAO = new ItemDao();
        itemDAO.procurar(pnm);
            HttpSession session = request.getSession();
            session.setAttribute("pnm", pnm);

 
        response.sendRedirect("pesquisa.jsp");
	}

}
