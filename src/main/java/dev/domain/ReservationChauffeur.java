package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ReservationChauffeur extends ReservationEntreprise {
		
	@ManyToOne(cascade = CascadeType.ALL)
	protected Utilisateur passager;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Utilisateur chauffeur;

	public ReservationChauffeur() {
		super();
	}

	public ReservationChauffeur(LocalDateTime dateDepart, Localisation depart, Localisation destination,
			Utilisateur chauffeur, LocalDateTime dateArrivee, VehiculeEntreprise vehiculeEntreprise,
			StatutReservationEntreprise statutReservationEntreprise, Utilisateur passager) {
		super(dateDepart, depart, destination, dateArrivee, vehiculeEntreprise, statutReservationEntreprise);
		this.passager = passager;
		this.chauffeur = chauffeur;
	}

	public Utilisateur getPassager() {
		return passager;
	}

	public void setPassager(Utilisateur passager) {
		this.passager = passager;
	}

	public Utilisateur getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Utilisateur chauffeur) {
		this.chauffeur = chauffeur;
	}
}
