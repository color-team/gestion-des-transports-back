package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ReservationEntreprise extends Reservation {

	protected LocalDateTime dateArrivee;

	@ManyToOne(cascade = CascadeType.ALL)
	protected VehiculeEntreprise vehiculeEntreprise;

	@OneToOne(cascade = CascadeType.ALL)
	protected StatutReservationEntreprise statutReservationEntreprise;

	public ReservationEntreprise() {
		super();
	}

	public ReservationEntreprise(LocalDateTime dateDepart, Localisation depart, Localisation destination,
			LocalDateTime dateArrivee, VehiculeEntreprise vehiculeEntreprise,
			StatutReservationEntreprise statutReservationEntreprise) {
		super(dateDepart, depart, destination);
		this.dateArrivee = dateArrivee;
		this.vehiculeEntreprise = vehiculeEntreprise;
		this.statutReservationEntreprise = statutReservationEntreprise;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public VehiculeEntreprise getVehiculeEntreprise() {
		return vehiculeEntreprise;
	}

	public void setVehiculeEntreprise(VehiculeEntreprise vehiculeEntreprise) {
		this.vehiculeEntreprise = vehiculeEntreprise;
	}

	public StatutReservationEntreprise getStatutReservationEntreprise() {
		return statutReservationEntreprise;
	}

	public void setStatutReservationEntreprise(StatutReservationEntreprise statutReservationEntreprise) {
		this.statutReservationEntreprise = statutReservationEntreprise;
	}
}
