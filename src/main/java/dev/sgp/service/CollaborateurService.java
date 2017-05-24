package dev.sgp.service;

import java.util.List;

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
	
}
