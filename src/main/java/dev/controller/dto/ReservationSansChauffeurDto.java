package dev.controller.dto;

import java.time.LocalDateTime;

public class ReservationSansChauffeurDto {
	
	private String conducteur;
	
	private LocalDateTime dateDepart;
	
	private LocalDateTime dateArrivee;
	
	private Long vehiculeId;

	public ReservationSansChauffeurDto() {}
	
	public ReservationSansChauffeurDto( String conducteur, LocalDateTime dateDepart, LocalDateTime dateArrivee,
			Long vehiculeId) {
		super();
		this.conducteur = conducteur;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.vehiculeId = vehiculeId;
	}

	public String getConducteur() {
		return conducteur;
	}

	public void setConducteur(String conducteur) {
		this.conducteur = conducteur;
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

	public Long getVehiculeId() {
		return vehiculeId;
	}

	public void setVehiculeId(Long vehiculeId) {
		this.vehiculeId = vehiculeId;
	}
}
