package dev.controller.dto;

import dev.domain.ReservationEntreprise;

import java.time.LocalDateTime;

public class ReservationEntrepriseDto {

	private String reservant;
	
	private LocalDateTime dateDepart;
	
	private LocalDateTime dateArrivee;
	
	private Long vehiculeId;
	
	private boolean avecChauffeur;

	public ReservationEntrepriseDto() {}

	public ReservationEntrepriseDto(String reservant, LocalDateTime dateDepart, LocalDateTime dateArrivee,
			Long vehiculeId, boolean avecChauffeur) {
		this.reservant = reservant;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.vehiculeId = vehiculeId;
		this.avecChauffeur = avecChauffeur;
	}

	public ReservationEntrepriseDto(ReservationEntreprise reservationEntreprise) {
		this.dateDepart = reservationEntreprise.getDateDepart();
		this.dateArrivee = reservationEntreprise.getDateArrivee();
	}

	public String getReservant() {
		return reservant;
	}

	public void setReservant(String reservant) {
		this.reservant = reservant;
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

	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
	}
}
