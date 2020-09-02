package dev.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationCovoituragePassagerKey implements Serializable {

	private static final long serialVersionUID = -3714353642317226610L;

	@Column(name = "utilisateur_id")
	protected Long utilisateurId;

	@Column(name = "reservation_covoiturage_id")
	protected Long reservationCovoiturageId;

	public ReservationCovoituragePassagerKey() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reservationCovoiturageId == null) ? 0 : reservationCovoiturageId.hashCode());
		result = prime * result + ((utilisateurId == null) ? 0 : utilisateurId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationCovoituragePassagerKey other = (ReservationCovoituragePassagerKey) obj;
		if (reservationCovoiturageId == null) {
			if (other.reservationCovoiturageId != null)
				return false;
		} else if (!reservationCovoiturageId.equals(other.reservationCovoiturageId))
			return false;
		if (utilisateurId == null) {
			if (other.utilisateurId != null)
				return false;
		} else if (!utilisateurId.equals(other.utilisateurId))
			return false;
		return true;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public Long getReservationCovoiturageId() {
		return reservationCovoiturageId;
	}

	public void setReservationCovoiturageId(Long reservationCovoiturageId) {
		this.reservationCovoiturageId = reservationCovoiturageId;
	}

}
