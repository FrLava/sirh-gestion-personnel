package dev.sgp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {

	@Inject Event<CollabEvt> collabEvt;
	
	@PersistenceContext(unitName="SGPDS") private EntityManager em;
	
	public List<Collaborateur> listerCollaborateurs() {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c", Collaborateur.class);
		return query.getResultList();
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		em.persist(collab);
		collabEvt.fire(new CollabEvt(TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));

	}
	
	public void updateCollaborateur(String matricule, Collaborateur collab) {
		
		Map<String, String> errorMap=new HashMap<>();
		
		boolean error=false;
		
		TypedQuery<Collaborateur> pQuery=em.createQuery("select c from Collaborateur c where c.matricule="+"'"+matricule+"'",Collaborateur.class);
		Collaborateur c=pQuery.getSingleResult();
		
		if(collab.getNom()==null){
			error=true;
			errorMap.put("nom", "missing");
			
		}
		if(collab.getPrenom()==null){
			error=true;
			errorMap.put("prenom", "missing");
			
		}
		if(collab.getAdresse()==null){
			errorMap.put("adresse", "missing");
			
		}
		if(collab.getNumSecu()==null){
			error=true;
			errorMap.put("numSecu", "missing");
			
		}
		
		for(char x : collab.getNumSecu().toCharArray()){
			if(!Character.isDigit(x)){
				error = false;
				errorMap.put("numSecu", "error");
				break;
			}
		}
		
		if(!error){
			c.setNom(collab.getNom());
			c.setPrenom(collab.getPrenom());
			c.setAdresse(collab.getAdresse());
			c.setNumSecu(collab.getNumSecu());
			c.setDateDeNaissance(collab.getDateDeNaissance());
			em.persist(c);
		}

		
	}
	
	public Collaborateur getCollabByMatricule(String matricule) {
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.matricule="+"'"+matricule+"'", Collaborateur.class);
		return query.getSingleResult();
	}

	public List<Collaborateur> getCollabByDepartement(String idDepart) {
		int id=Integer.parseInt(idDepart);
		TypedQuery<Collaborateur> query = em.createQuery("select c from Collaborateur c where c.departement.id="+"'"+id+"'",Collaborateur.class);
		return query.getResultList();
	}
	
}
