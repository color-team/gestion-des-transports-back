package dev.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dev.domain.enumeration.StatutReservationCovoiturageEnum;

@Entity
public class StatutReservationCovoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(cascade = CascadeType.ALL)
    protected ReservationCovoituragePassager reservationCovoituragePassager;

    @Enumerated(EnumType.STRING)
    protected StatutReservationCovoiturageEnum statutReservationCovoiturage;

    public StatutReservationCovoiturage() {}
    
	public StatutReservationCovoiturage(ReservationCovoituragePassager reservationCovoituragePassager,
			StatutReservationCovoiturageEnum statutReservationCovoiturage) {
		this.reservationCovoituragePassager = reservationCovoituragePassager;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservationCovoituragePassager getReservationCovoituragePassager() {
		return reservationCovoituragePassager;
	}

	public void setReservationCovoituragePassager(ReservationCovoituragePassager reservationCovoituragePassager) {
		this.reservationCovoituragePassager = reservationCovoituragePassager;
	}

	public StatutReservationCovoiturageEnum getStatutReservationCovoiturage() {
		return statutReservationCovoiturage;
	}

	public void setStatutReservationCovoiturage(StatutReservationCovoiturageEnum statutReservationCovoiturage) {
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}
}
