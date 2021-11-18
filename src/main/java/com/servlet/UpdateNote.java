package com.servlet;

import java.io.IOException;
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
 * Servlet implementation class UpdateNote
 */
public class UpdateNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int note_id = Integer.parseInt(request.getParameter("note_id").trim());
			
			
			
			Session session = factoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			
		NoteTaker note=	session.get(NoteTaker.class, note_id);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			
			tx.commit();
			session.close();
			
			response.sendRedirect("show_notes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
