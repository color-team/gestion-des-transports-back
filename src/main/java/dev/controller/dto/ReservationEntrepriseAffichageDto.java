package dev.controller.dto;

import java.time.LocalDateTime;

import dev.domain.enumeration.StatutReservationEntrepriseEnum;

public class ReservationEntrepriseAffichageDto {
	
	private String infosChauffeur;
	
	private LocalDateTime dateDepart;
	
	private LocalDateTime dateArrivee;
	
	private String immatriculation;
	
	private String marque;
	
	private String modele;
	
	private Long reservationId;
	
	private StatutReservationEntrepriseEnum statut;
	
	public ReservationEntrepriseAffichageDto() {}

	public ReservationEntrepriseAffichageDto(String infosChauffeur, LocalDateTime dateDepart, LocalDateTime dateArrivee,
			String immatriculation, String marque, String modele, Long reservationId,
			StatutReservationEntrepriseEnum statut) {
		super();
		this.infosChauffeur = infosChauffeur;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.reservationId = reservationId;
		this.statut = statut;
	}

	public String getInfosChauffeur() {
		return infosChauffeur;
	}

	public void setInfosChauffeur(String infosChauffeur) {
		this.infosChauffeur = infosChauffeur;
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

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public StatutReservationEntrepriseEnum getStatut() {
		return statut;
	}

	public void setStatut(StatutReservationEntrepriseEnum statut) {
		this.statut = statut;
	}

}
