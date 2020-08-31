package dev.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ReservationCovoiturage extends Reservation {

	/**	nombre initial de places pour les passagers */
	protected byte nbPlacesPassagers;
	
	@OneToOne(cascade = CascadeType.ALL)
	protected StatutReservationCovoiturage statutReservationCovoiturage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected VehiculeParticulier vehiculeParticulier;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Utilisateur conducteur;
	
	@ManyToMany(cascade = CascadeType.ALL)
	protected List<Utilisateur> passagers;

	public ReservationCovoiturage() {}

	public ReservationCovoiturage(LocalDateTime dateDepart, Localisation depart, Localisation destination,
			Utilisateur conducteur, byte nbPassagers, StatutReservationCovoiturage statutReservationCovoiturage,
			VehiculeParticulier vehiculeParticulier, List<Utilisateur> passagers) {
		super(dateDepart, depart, destination);
		this.nbPlacesPassagers = nbPassagers;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
		this.vehiculeParticulier = vehiculeParticulier;
		this.conducteur = conducteur;
		this.passagers = passagers;
	}
	
	public int getNbPlacesDisponibles() {
		return nbPlacesPassagers - passagers.size();
	}

	public byte getNbPassagers() {
		return nbPlacesPassagers;
	}

	public void setNbPassagers(byte nbPassagers) {
		this.nbPlacesPassagers = nbPassagers;
	}

	public StatutReservationCovoiturage getStatutReservationCovoiturage() {
		return statutReservationCovoiturage;
	}

	public void setStatutReservationCovoiturage(StatutReservationCovoiturage statutReservationCovoiturage) {
		this.statutReservationCovoiturage = statutReservationCovoiturage;
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

	public List<Utilisateur> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<Utilisateur> passagers) {
		this.passagers = passagers;
	}
}
