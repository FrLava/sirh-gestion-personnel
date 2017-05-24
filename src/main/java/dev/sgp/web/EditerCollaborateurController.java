package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebServlet("/collaborateurs/editer")
public class EditerCollaborateurController extends HttpServlet {
	
	@Inject private CollaborateurService collabService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collaborateur collab=null;
		String collabMAtricule = req.getParameter("matricule");
		
		for(Collaborateur c: collabService.listerCollaborateurs()){
			if(collabMAtricule.equals(c.getMatricule())){
				collab=c;
			}
		}
		
		req.setAttribute("collab", collab);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	

}
