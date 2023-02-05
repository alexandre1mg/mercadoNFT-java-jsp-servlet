package com.mercadoNFTs.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercadoNFTs.dao.ItemDao;
import com.mercadoNFTs.model.Item;

/**
 * Servlet implementation class ServletDeletarItem
 */
@WebServlet("/ServletDeletarItem")
public class ServletDeletarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int codigo = Integer.parseInt(String.valueOf(request.getParameter("codigo")));
        
        Item item = new Item();
        item.setId(codigo);
        
        ItemDao itemDAO = new ItemDao();
        itemDAO.deletar(item);
        
        response.sendRedirect("meusitens.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
