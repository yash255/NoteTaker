package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.factoryProvider;

/**
 * Servlet implementation class SaveNote
 */
public class SaveNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			NoteTaker note = new NoteTaker(title,content,new Date());
			
		//	System.out.println(note.getTitle());
			
	Session session= factoryProvider.getFactory().openSession();
	Transaction tx = session.beginTransaction();
	session.save(note);
	tx.commit();
	

	session.close();
	response.setContentType("text/html");
	out.println("<h1>Note is added</h1>");
	response.sendRedirect("show_notes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
