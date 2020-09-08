package dev.controller.dto;

import javax.validation.constraints.NotNull;

import dev.domain.VehiculeEntreprise;

import java.util.ArrayList;
import java.util.List;

public class VehiculeEntrepriseInfosGeneralesDto {
	
	@NotNull
    protected String immatriculation;
    
	@NotNull
    protected String marque;
    
	@NotNull
    protected String modele;
    
	@NotNull
    protected String categorie;
    
	@NotNull
    protected Integer nbPlaces;
    
    protected String photoUrl;
    
    protected String statutVehicule;

    protected List<ReservationEntrepriseDto> reservationsEntreprise = new ArrayList<>();
    
    protected Long id;
    
    protected Float longitude;
    
    protected Float latitude;
    
    public VehiculeEntrepriseInfosGeneralesDto() {}

	public VehiculeEntrepriseInfosGeneralesDto(String immatriculation, String marque, String modele, String categorie, int nbPlaces,
			String photoUrl, String statutVehicule, Long id) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.categorie = categorie;
		this.nbPlaces = nbPlaces;
		this.photoUrl = photoUrl;
		this.statutVehicule = statutVehicule;
		this.id = id;
	}
	
	public VehiculeEntrepriseInfosGeneralesDto(VehiculeEntreprise vehiculeEntreprise) {
		this.immatriculation = vehiculeEntreprise.getImmatriculation();
		this.marque = vehiculeEntreprise.getMarque();
		this.modele = vehiculeEntreprise.getModele();
		this.categorie = vehiculeEntreprise.getCategorie();
		this.nbPlaces = (int) vehiculeEntreprise.getNbPlaces();
		this.photoUrl = vehiculeEntreprise.getPhotoUrl();
		vehiculeEntreprise.getReservationsEntreprise().forEach(reservationEntreprise -> {
			this.reservationsEntreprise.add(new ReservationEntrepriseDto(reservationEntreprise));
		});

		if ( vehiculeEntreprise.getStatutVehicule() != null ) {
			this.statutVehicule = vehiculeEntreprise.getStatutVehicule().getStatutVehicule().name();
		} else {
			this.statutVehicule = "EN_SERVICE";
		}
		this.id = vehiculeEntreprise.getId();
		
		if ( vehiculeEntreprise.getLocalisation() != null ) {
			this.longitude = vehiculeEntreprise.getLocalisation().getLongitude();
			this.latitude = vehiculeEntreprise.getLocalisation().getLatitude();
		}
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getStatutVehicule() {
		return statutVehicule;
	}

	public void setStatutVehicule(String statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public List<ReservationEntrepriseDto> getReservationsEntreprise() {
		return reservationsEntreprise;
	}

	public void setReservationsEntreprise(List<ReservationEntrepriseDto> reservationsEntreprise) {
		this.reservationsEntreprise = reservationsEntreprise;
	}
}
