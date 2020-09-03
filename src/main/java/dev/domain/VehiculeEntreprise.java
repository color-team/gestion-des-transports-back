package dev.domain;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VehiculeEntreprise extends Vehicule {

	protected byte nbPlaces;
	
	@OneToOne
	protected Localisation localisation;
	
	@OneToMany(mappedBy = "vehiculeEntreprise")
	protected List<ReservationEntreprise> reservationsEntreprise;
	
	@OneToOne
	protected StatutVehicule statutVehicule;

	public VehiculeEntreprise() {
		super();
	}

	public VehiculeEntreprise(String immatriculation, String marque, String photoUrl, Blob photo, String modele,
			String categorie, byte nbPlaces, Localisation localisation,
			List<ReservationEntreprise> reservationsEntreprise) {
		super(immatriculation, marque, photoUrl, photo, modele, categorie);
		this.nbPlaces = nbPlaces;
		this.localisation = localisation;
		this.reservationsEntreprise = reservationsEntreprise;
	}

	public List<ReservationEntreprise> getReservationsEntreprise() {
		return reservationsEntreprise;
	}

	public void setReservationsEntreprise(List<ReservationEntreprise> reservationsEntreprise) {
		this.reservationsEntreprise = reservationsEntreprise;
	}

	public byte getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(byte nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public StatutVehicule getStatutVehicule() {
		return statutVehicule;
	}

	public void setStatutVehicule(StatutVehicule statutVehicule) {
		this.statutVehicule = statutVehicule;
	}
}
