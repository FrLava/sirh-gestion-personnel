package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Collaborateur")
public class Collaborateur {
	
	private static String SUFFIXE_EMAIL = ResourceBundle.getBundle("application").getString("suffixeMail.val");
	
	@Id
	private UUID matricule;
	
	@Column(name="Nom")
	private String nom;
	@Column(name="Prenom")
	private String prenom;
	@Column(name="Adresse")
	private String adresse;
	@Column(name="NumSecu")
	private String numSecu;
	@Column(name="EmailPro")
	private String emailPro;
	@Column(name="Photo")
	private String photo;
	
	@Column(name="DatedeNaissance")
	private LocalDate dateDeNaissance;
	@Column(name="DateHeuredecreation")
	private ZonedDateTime dateHeureCreation;
	@Column(name="actif")
	private boolean actif;
	
	public Collaborateur(){
		
	}
	
	public Collaborateur (String nom, String prenom, String adresse, String numSecu, String dateDeNaissance){
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.numSecu=numSecu;
		this.dateDeNaissance=LocalDate.parse(dateDeNaissance);
		
		this.emailPro=this.prenom+"."+this.nom+"@"+SUFFIXE_EMAIL;
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
						+", créé le : "+this.dateHeureCreation.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
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
