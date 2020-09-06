package dev.controller.dto;

import java.time.LocalDateTime;

public class ReservationCovoiturageDto {

	protected LocalDateTime dateDepart;

	protected String infosDepart;

	protected String infosDestination;

	protected String statutReservationCovoiturage;

	protected String infosVehiculeParticulier;

	protected String infosConducteur;
	
	protected String statutAnnonceCovoiturage;
	
	protected Long id;

	public ReservationCovoiturageDto() {
	}

	public ReservationCovoiturageDto(LocalDateTime dateDepart, String infosDepart, String infosDestination,
			String statutReservationCovoiturage, String infosVehiculeParticulier, String infosConducteur) {
		this.dateDepart = dateDepart;
		this.infosDepart = infosDepart;
		this.infosDestination = infosDestination;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
		this.infosVehiculeParticulier = infosVehiculeParticulier;
		this.infosConducteur = infosConducteur;
	}
	
	public ReservationCovoiturageDto(LocalDateTime dateDepart, String infosDepart, String infosDestination,
			String statutReservationCovoiturage, String infosVehiculeParticulier, String infosConducteur, String statutAnnonceCovoiturage) {
		this.dateDepart = dateDepart;
		this.infosDepart = infosDepart;
		this.infosDestination = infosDestination;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
		this.infosVehiculeParticulier = infosVehiculeParticulier;
		this.infosConducteur = infosConducteur;
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
	}
	
	public ReservationCovoiturageDto(LocalDateTime dateDepart, String infosDepart, String infosDestination,
			String statutReservationCovoiturage, String infosVehiculeParticulier, String infosConducteur, String statutAnnonceCovoiturage, Long id) {
		this.dateDepart = dateDepart;
		this.infosDepart = infosDepart;
		this.infosDestination = infosDestination;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
		this.infosVehiculeParticulier = infosVehiculeParticulier;
		this.infosConducteur = infosConducteur;
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
		this.id = id;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getInfosDepart() {
		return infosDepart;
	}

	public void setInfosDepart(String infosDepart) {
		this.infosDepart = infosDepart;
	}

	public String getInfosDestination() {
		return infosDestination;
	}

	public void setInfosDestination(String infosDestination) {
		this.infosDestination = infosDestination;
	}

	public String getStatutReservationCovoiturage() {
		return statutReservationCovoiturage;
	}

	public void setStatutReservationCovoiturage(String statutReservationCovoiturage) {
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}

	public String getInfosVehiculeParticulier() {
		return infosVehiculeParticulier;
	}

	public void setInfosVehiculeParticulier(String infosVehiculeParticulier) {
		this.infosVehiculeParticulier = infosVehiculeParticulier;
	}

	public String getInfosConducteur() {
		return infosConducteur;
	}

	public void setInfosConducteur(String infosConducteur) {
		this.infosConducteur = infosConducteur;
	}

	public String getStatutAnnonceCovoiturage() {
		return statutAnnonceCovoiturage;
	}

	public void setStatutAnnonceCovoiturage(String statutAnnonceCovoiturage) {
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
