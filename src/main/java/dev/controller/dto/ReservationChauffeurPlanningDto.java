package dev.controller.dto;

import java.time.LocalDateTime;

import dev.domain.enumeration.StatutReservationEntrepriseEnum;

public class ReservationChauffeurPlanningDto {
	
	private LocalDateTime dateDebut;
	
	private LocalDateTime dateFin;
	
	private String infosPassager;
	
	private String telPassager;
	
	private String immatriculation;
	
	private StatutReservationEntrepriseEnum statut;
	
	private Long reservationId;
	
	public ReservationChauffeurPlanningDto() {}

	public ReservationChauffeurPlanningDto(LocalDateTime dateDebut, LocalDateTime dateFin, String infosPassager,
			String telPassager, String immatriculation, StatutReservationEntrepriseEnum statut, Long reservationId) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.infosPassager = infosPassager;
		this.telPassager = telPassager;
		this.immatriculation = immatriculation;
		this.statut = statut;
		this.reservationId = reservationId;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public String getInfosPassager() {
		return infosPassager;
	}

	public void setInfosPassager(String infosPassager) {
		this.infosPassager = infosPassager;
	}

	public String getTelPassager() {
		return telPassager;
	}

	public void setTelPassager(String telPassager) {
		this.telPassager = telPassager;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public StatutReservationEntrepriseEnum getStatut() {
		return statut;
	}

	public void setStatut(StatutReservationEntrepriseEnum statut) {
		this.statut = statut;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
}
