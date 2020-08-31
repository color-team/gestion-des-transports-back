package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReservationChauffeur extends ReservationEntreprise {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
