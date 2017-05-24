package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import javax.ejb.EJB;
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
	
	@EJB private CollaborateurService collabService;
	private String collabMatricule="";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collaborateur collab=null;
		collabMatricule = req.getParameter("matricule");
		
		for(Collaborateur c: collabService.listerCollaborateurs()){
			if(collabMatricule.equals(c.getMatricule())){
				collab=c;
			}
		}
		
		req.setAttribute("collab", collab);
		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		boolean flag = true;
		
		String nomCollabo = req.getParameter("textInputNom");
		String prenomCollabo = req.getParameter("textInputPrenom");
		String dateNaissanceCollabo = req.getParameter("textInputDate");
		String adresseCollabo = req.getParameter("textAreaAdresse");
		String secuCollabo = req.getParameter("textInputIdSecu");
		
		for(char c : secuCollabo.toCharArray()){
			if(!Character.isDigit(c)){
				flag = false;
				break;
			}
		}
		
		if(secuCollabo.length()!=15 || flag == false) {
			resp.setStatus(400);
			resp.getWriter().write("Mauvaise Saisie");
		}
		
		else{
			
			Collaborateur collab = new Collaborateur(nomCollabo,prenomCollabo,adresseCollabo,secuCollabo,dateNaissanceCollabo);
			this.collabService.updateCollaborateur(collabMatricule, collab);
			
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister"); //Redirection une fois le formulaire valider
			
			
		}
		
		
	}
	

}
