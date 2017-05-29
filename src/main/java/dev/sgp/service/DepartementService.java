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
import dev.sgp.entite.DepartEvt;
import dev.sgp.entite.Departement;
import dev.sgp.entite.TypeCollabEvt;


@Stateless
public class DepartementService {
	
	@PersistenceContext(unitName="SGPDS") private EntityManager em;
	
	public List<Departement> listerDepartement() {
		TypedQuery<Departement> query = em.createQuery("select d from Departement d", Departement.class);
		return query.getResultList();
	}
	
	public void sauvegarderDepartement(Departement depart) {
		em.persist(depart);

	}
	

}
