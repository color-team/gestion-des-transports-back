package dev.controller.dto;

public class AcceptationChauffeurDto {

	private Long reservationId;
	
	private String chauffeurMatricule;

	public AcceptationChauffeurDto() {}
	
	public AcceptationChauffeurDto(Long reservationId, String chauffeurMatricule) {
		super();
		this.reservationId = reservationId;
		this.chauffeurMatricule = chauffeurMatricule;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getChauffeurMatricule() {
		return chauffeurMatricule;
	}

	public void setChauffeurMatricule(String chauffeurMatricule) {
		this.chauffeurMatricule = chauffeurMatricule;
	}
}
