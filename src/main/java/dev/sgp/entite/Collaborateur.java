package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;

public class Collaborateur {
	
	private ResourceBundle bundle=ResourceBundle.getBundle("application");
	private String valueMail=bundle.getString("suffixeMail.val");
	
	private UUID matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private String numSecu;
	private String emailPro;
	private String photo;
	
	private LocalDate dateDeNaissance;
	private ZonedDateTime dateHeureCreation;
	private DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
	
	private boolean actif;
	
	public Collaborateur (String nom, String prenom, String adresse, String numSecu, String dateDeNaissance){
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.numSecu=numSecu;
		this.dateDeNaissance=LocalDate.parse(dateDeNaissance);
		
		this.emailPro=this.prenom+"."+this.nom+"@"+this.valueMail;
		this.photo="url";
		this.matricule = UUID.randomUUID();
		

		this.dateHeureCreation=ZonedDateTime.now();
		this.actif=true;
	}
	
	public String toString(){
		String string = "Collaborateur : "+this.nom+" "+this.prenom+","
						+ " matricule : "+this.matricule.toString()
						+", adresse : "+this.adresse
						+", numéro de sécurité sociale : "+this.numSecu
						+", email proffessionel : "+this.emailPro
						+", date de naissance : "+this.dateDeNaissance
						+", créé le : "+this.dateHeureCreation.format(f);
		return string;
	}

	public String getMatricule() {
		return matricule.toString();
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
