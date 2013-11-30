package com.ornilabs.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_UTILISATEUR = "/WEB-INF/ShowList.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter()
		// .write("<!DOCTYPE...);
		request.setAttribute("liste_actions", Data.getActionList());
		this.getServletContext().getRequestDispatcher(VUE_UTILISATEUR)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// super.doGet(request, response);

//		 System.out.println(request);
//		 String name = request.getParameter("user");
//		 if ("".equals(name)) { name = "there"; }
//		 System.out.println(name);

		// response.setContentType("text/json");
		// response.setCharacterEncoding("UTF-8");
		// response.getWriter().write(URLEncoder.encode("{'test':loul}","UTF-8"));

//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(URLEncoder.encode("{'test':loul}", "UTF-8"));
//		response.setStatus(200);
	

		String id = request.getParameter("id");
		Integer duree = getIntFromRequest(request, "duree");
		Integer profondeur = getIntFromRequest(request, "profondeur");
		String start = request.getParameter("start");
		String ressource = request.getParameter("ressource").toLowerCase();

		Data.addAction(new Action(id,duree,profondeur,start,ressource));
		
	}

//	private Double getDoubleFromRequest(HttpServletRequest request, String parameter) {
//			String valueTxt = request.getParameter(parameter);
//			Double value = 0d;
//			if(valueTxt!=null) value = Double.parseDouble(valueTxt);
//			return value;
//	}

	private Integer getIntFromRequest(HttpServletRequest request, String parameter) {
		String valueTxt = request.getParameter(parameter);
		Integer value = 0;
		if(valueTxt!=null) value = Integer.parseInt(valueTxt);
		return value;
	}
}
