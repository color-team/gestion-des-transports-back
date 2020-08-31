package dev.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dev.domain.enumeration.StatutReservationEntrepriseEnum;

@Entity
public class StatutReservationEntreprise {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(cascade = CascadeType.ALL)
    protected ReservationEntreprise reservationEntreprise;

    @Enumerated(EnumType.STRING)
    protected StatutReservationEntrepriseEnum statutReservationEntreprise;

    public StatutReservationEntreprise() {}
    
	public StatutReservationEntreprise(ReservationEntreprise reservationEntreprise,
			StatutReservationEntrepriseEnum statutReservationEntreprise) {
		super();
		this.reservationEntreprise = reservationEntreprise;
		this.statutReservationEntreprise = statutReservationEntreprise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservationEntreprise getReservationEntreprise() {
		return reservationEntreprise;
	}

	public void setReservationEntreprise(ReservationEntreprise reservationEntreprise) {
		this.reservationEntreprise = reservationEntreprise;
	}

	public StatutReservationEntrepriseEnum getStatutReservationEntreprise() {
		return statutReservationEntreprise;
	}

	public void setStatutReservationEntreprise(StatutReservationEntrepriseEnum statutReservationEntreprise) {
		this.statutReservationEntreprise = statutReservationEntreprise;
	}
}
