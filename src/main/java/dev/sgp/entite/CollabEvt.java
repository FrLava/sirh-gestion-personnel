package dev.sgp.entite;

import java.time.ZonedDateTime;

public class CollabEvt {
	
	private ZonedDateTime dateHeure;
	private TypeCollabEvt type;
	private String matricule;
	
	public CollabEvt(TypeCollabEvt type, String matricule){
		
		this.type = type;
		this.matricule = matricule;
		this.dateHeure=ZonedDateTime.now();
		
	}
	
	public String getDateHeure() {
		return dateHeure.toString();
	}

	public TypeCollabEvt getType() {
		return type;
	}
	
	public String getTypeString() {
		return type.toString();
	}

	public String getMatricule() {
		return matricule;
	}
	
}
