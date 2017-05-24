package dev.sgp.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebServlet("/collaborateurs/ajouter")
public class AjouterCollaborateurControleur extends HttpServlet {
	
	@Inject private CollaborateurService collabService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);
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
			this.collabService.sauvegarderCollaborateur(collab);
			
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister"); //Redirection une fois le formulaire valider
			
			
		}
		
	}
	
	
}
