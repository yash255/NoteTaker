package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.factoryProvider;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	
	try {
		
		int note_id = Integer.parseInt(request.getParameter("note_id").trim());
		
		Session s = factoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
	NoteTaker note=	s.get(NoteTaker.class, note_id);
		s.delete(note);
		tx.commit();
		s.close();
		
		response.sendRedirect("show_notes.jsp");
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	}

}
