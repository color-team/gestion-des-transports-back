package dev.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import dev.domain.enumeration.StatutReservationCovoiturageEnum;

@Entity
public class ReservationCovoiturage extends Reservation {

	/**	nombre initial de places pour les passagers */
	protected byte nbPlacesPassagers;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected VehiculeParticulier vehiculeParticulier;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Utilisateur conducteur;
	
	@OneToMany
	protected List<ReservationCovoituragePassager> reservationsCovoituragePassagers = new ArrayList<>();

	public ReservationCovoiturage() {}
	
	public ReservationCovoiturage(
			LocalDateTime dateDepart,
			Localisation depart,
			Localisation destination,
			Utilisateur conducteur,
			byte nbPassagers,
			VehiculeParticulier vehiculeParticulier
		) {
		super(dateDepart, depart, destination);
		this.nbPlacesPassagers = nbPassagers;
		this.vehiculeParticulier = vehiculeParticulier;
		this.conducteur = conducteur;
	}

	public ReservationCovoiturage(
			LocalDateTime dateDepart,
			Localisation depart,
			Localisation destination,
			Utilisateur conducteur,
			byte nbPassagers,
			VehiculeParticulier vehiculeParticulier,
			List<ReservationCovoituragePassager> reservationsCovoituragePassagers
		) {
		super(dateDepart, depart, destination);
		this.nbPlacesPassagers = nbPassagers;
		this.vehiculeParticulier = vehiculeParticulier;
		this.conducteur = conducteur;
		this.reservationsCovoituragePassagers = reservationsCovoituragePassagers;
	}
	
	public int getNbPlacesDisponibles() {
		return nbPlacesPassagers - reservationsCovoituragePassagers.stream()
				.map(ReservationCovoituragePassager::getStatutReservationCovoiturage)
				.filter(statut -> statut.getStatutReservationCovoiturage() != StatutReservationCovoiturageEnum.ANNULEE)
				.collect(Collectors.toList())
				.size();
	}

	public VehiculeParticulier getVehiculeParticulier() {
		return vehiculeParticulier;
	}

	public void setVehiculeParticulier(VehiculeParticulier vehiculeParticulier) {
		this.vehiculeParticulier = vehiculeParticulier;
	}

	public Utilisateur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Utilisateur conducteur) {
		this.conducteur = conducteur;
	}

	public byte getNbPlacesPassagers() {
		return nbPlacesPassagers;
	}

	public void setNbPlacesPassagers(byte nbPlacesPassagers) {
		this.nbPlacesPassagers = nbPlacesPassagers;
	}

	public List<ReservationCovoituragePassager> getReservationsCovoituragePassagers() {
		return reservationsCovoituragePassagers;
	}

	public void setReservationsCovoituragePassagers(List<ReservationCovoituragePassager> reservationsCovoituragePassagers) {
		this.reservationsCovoituragePassagers = reservationsCovoituragePassagers;
	}
}
