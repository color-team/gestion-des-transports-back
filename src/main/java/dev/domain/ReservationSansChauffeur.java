package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReservationSansChauffeur extends ReservationEntreprise {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Utilisateur conducteur;

	public ReservationSansChauffeur() {
		super();
	}

	public ReservationSansChauffeur(LocalDateTime dateDepart, Localisation depart, Localisation destination,
			Utilisateur conducteur, LocalDateTime dateArrivee, VehiculeEntreprise vehiculeEntreprise,
			StatutReservationEntreprise statutReservationEntreprise) {
		super(dateDepart, depart, destination, dateArrivee, vehiculeEntreprise, statutReservationEntreprise);
		this.conducteur = conducteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Utilisateur conducteur) {
		this.conducteur = conducteur;
	}
}
