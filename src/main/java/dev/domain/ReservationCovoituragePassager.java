package dev.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ReservationCovoituragePassager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
    @ManyToOne(cascade = CascadeType.ALL)
    protected Utilisateur passager;
 
    @ManyToOne(cascade = CascadeType.ALL)
    protected ReservationCovoiturage reservationCovoiturage;
    
    @OneToOne(cascade = CascadeType.ALL)
	protected StatutReservationCovoiturage statutReservationCovoiturage;

    public ReservationCovoituragePassager() {}
    
	public ReservationCovoituragePassager(Utilisateur passager, ReservationCovoiturage reservationCovoiturage,
			StatutReservationCovoiturage statutReservationCovoiturage) {
		this.passager = passager;
		this.reservationCovoiturage = reservationCovoiturage;
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}

	public Utilisateur getPassager() {
		return passager;
	}

	public void setPassager(Utilisateur passager) {
		this.passager = passager;
	}

	public ReservationCovoiturage getReservationCovoiturage() {
		return reservationCovoiturage;
	}

	public void setReservationCovoiturage(ReservationCovoiturage reservationCovoiturage) {
		this.reservationCovoiturage = reservationCovoiturage;
	}

	public StatutReservationCovoiturage getStatutReservationCovoiturage() {
		return statutReservationCovoiturage;
	}

	public void setStatutReservationCovoiturage(StatutReservationCovoiturage statutReservationCovoiturage) {
		this.statutReservationCovoiturage = statutReservationCovoiturage;
	}

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
