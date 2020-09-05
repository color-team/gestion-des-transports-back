package dev.controller.dto;

import java.time.LocalDateTime;

public class ReservationSansChauffeurInfosDto {

	private String infosConducteur;
	
	private LocalDateTime dateDepart;
	
	private LocalDateTime dateArrivee;
	
	private String infosVehicule;
	
	private String infosStatutReservation;

	public ReservationSansChauffeurInfosDto() {}
	
	public ReservationSansChauffeurInfosDto(String infosConducteur, LocalDateTime dateDepart, LocalDateTime dateArrivee,
			String infosVehicule, String infosStatutReservation) {
		super();
		this.infosConducteur = infosConducteur;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.infosVehicule = infosVehicule;
		this.infosStatutReservation = infosStatutReservation;
	}

	public String getInfosConducteur() {
		return infosConducteur;
	}

	public void setInfosConducteur(String infosConducteur) {
		this.infosConducteur = infosConducteur;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDateTime getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDateTime dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getInfosVehicule() {
		return infosVehicule;
	}

	public void setInfosVehicule(String infosVehicule) {
		this.infosVehicule = infosVehicule;
	}

	public String getInfosStatutReservation() {
		return infosStatutReservation;
	}

	public void setInfosStatutReservation(String infosStatutReservation) {
		this.infosStatutReservation = infosStatutReservation;
	}
}
