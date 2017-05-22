package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Collaborateur {
	
	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private String numSecu;
	private String emailPro;
	private String photo;
	
	private LocalDate dateDeNaissance;
	private ZonedDateTime dateHeureCreation;
	
	private boolean actif;
	
	public Collaborateur (String nom, String prenom, String adresse, String numSecu, String dateDeNaissance){
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.numSecu=numSecu;
		this.dateDeNaissance=LocalDate.parse(dateDeNaissance);
		
		this.emailPro=this.prenom+"."+this.nom+"@"+"societe.com";
		this.photo="url";
		this.matricule="m";
		
		this.dateHeureCreation=ZonedDateTime.now();
		this.actif=true;
	}
	
	public String toString(){
		String string = "Collaborateur : "+this.nom+" "+this.prenom+","
						+ " matricule : "+this.matricule
						+", adresse : "+this.adresse
						+", numéro de sécurité sociale : "+this.numSecu
						+", email proffessionel : "+this.emailPro
						+", date de naissance : "+this.dateDeNaissance
						+", créé le : "+this.dateHeureCreation;
		return string;
	}

	public String getMatricule() {
		return matricule;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	
}
