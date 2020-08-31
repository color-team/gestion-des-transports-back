package dev.domain;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class VehiculeParticulier extends Vehicule {

	@OneToMany(mappedBy = "vehiculeParticulier", cascade = CascadeType.ALL)
	protected List<ReservationCovoiturage> reservationsCovoiturage;
	
	public VehiculeParticulier() {
		super();
	}
	
	public VehiculeParticulier(String immatriculation, String marque, String photoUrl, Blob photo, String modele,
			String categorie) {
		super(immatriculation, marque, photoUrl, photo, modele, categorie);
	}

	public List<ReservationCovoiturage> getReservationsCovoiturage() {
		return reservationsCovoiturage;
	}

	public void setReservationsCovoiturage(List<ReservationCovoiturage> reservationsCovoiturage) {
		this.reservationsCovoiturage = reservationsCovoiturage;
	}
	
}
