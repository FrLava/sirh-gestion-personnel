package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("penom");
		
		resp.setContentType("text/html"); //Pour interpreter les balises html
		resp.getWriter().write("<h1> Edition des Collaborateurs </h1>");
		
		if(matriculeParam == null){
			resp.setStatus(400);
			resp.getWriter().write(
					"Un matricule est attendu."
					);
		}
		else{
			resp.setStatus(200);
			resp.getWriter().write(
					"Matricule : "+ matriculeParam
					);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<Boolean, List<String>> validationParams = validerParametres(req, "matricule","titre", "nom", "prenom");
		
		resp.setCharacterEncoding("utf-8");
		
		if (validationParams.get(false) != null) {
			resp.setStatus(400);
			
			resp.getWriter().write("Les paramètres suivants sont incorrects : " + validationParams.get(false).stream().collect(joining(",")));
		} else {
			resp.setStatus(201);
			
			resp.getWriter().write("Création d'un collaborateur avec les informations suivantes : " 
				+ validationParams.get(true).stream().map(p -> p + "=" + req.getParameter(p)).collect(joining(",")));
		}
		
	}
	
	private Map<Boolean, List<String>> validerParametres(HttpServletRequest req, String... params) {
		return Stream.of(params).collect(
				groupingBy(
						param -> req.getParameter(param) != null && !"".equals(req.getParameter(param)
				)));
	}

}
