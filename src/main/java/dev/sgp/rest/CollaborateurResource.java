package dev.sgp.rest;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurResource {
	
	@Inject private CollaborateurService collabService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") String idDepart) {
		
		List<Collaborateur> collab;
		
		if(idDepart==null){
			collab = collabService.listerCollaborateurs();
		}
		
		else{
			collab = this.getCollabByDepartement(idDepart);
		}
		
		
		return collab;

	}
	
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Collaborateur getCollabByMatricule(@PathParam("matricule") String matricule){
		return collabService.getCollabByMatricule(matricule);
		
	}
	
	public List<Collaborateur> getCollabByDepartement(@QueryParam("departement") String idDepart){
		return collabService.getCollabByDepartement(idDepart);
		
	}
	
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public void updateCollaborateur(Collaborateur c, @PathParam("matricule") String matricule ){
		collabService.updateCollaborateur(matricule, c);
	
	}
	
	

}
