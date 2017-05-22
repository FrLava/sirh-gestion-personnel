package dev.sgp.web;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class AjouterCollaborateurControleur extends HttpServlet {
	
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nomCollabo = req.getParameter("textInputNom");
		String prenomCollabo = req.getParameter("textInputPrenom");
		String dateNaissanceCollabo = req.getParameter("textInputDate");
		String adresseCollabo = req.getParameter("textAreaAdresse");
		String secuCollabo = req.getParameter("textInputIdSecu");
		
		Collaborateur collab = new Collaborateur(nomCollabo,prenomCollabo,adresseCollabo,secuCollabo,dateNaissanceCollabo);
		
		this.collabService.sauvegarderCollaborateur(collab);
		
		//req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateur.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		
	}
	
	
}
