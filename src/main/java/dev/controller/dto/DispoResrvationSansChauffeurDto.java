package dev.controller.dto;

import java.time.LocalDateTime;

public class DispoResrvationSansChauffeurDto {
	
	protected Long id;
	
	protected LocalDateTime dateDepart;
	
	protected LocalDateTime dateArrivee;
	
	protected String statutReservation;
	
	public DispoResrvationSansChauffeurDto() {}

	public DispoResrvationSansChauffeurDto(Long id, LocalDateTime dateDepart, LocalDateTime dateArrivee,
			String statutReservation) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.statutReservation = statutReservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatutReservation() {
		return statutReservation;
	}

	public void setStatutReservation(String statutReservation) {
		this.statutReservation = statutReservation;
	}
}
