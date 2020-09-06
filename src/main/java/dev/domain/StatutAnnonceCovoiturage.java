package dev.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dev.domain.enumeration.StatutAnnonceCovoiturageEnum;

@Entity
public class StatutAnnonceCovoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(mappedBy = "statutAnnonceCovoiturage", cascade = CascadeType.ALL)
    protected ReservationCovoiturage annonceCovoiturage;

    @Enumerated(EnumType.STRING)
    protected StatutAnnonceCovoiturageEnum statutAnnonceCovoiturage;

    public StatutAnnonceCovoiturage() {}

	public StatutAnnonceCovoiturage(ReservationCovoiturage annonceCovoiturage,
			StatutAnnonceCovoiturageEnum statutAnnonceCovoiturage) {
		this.annonceCovoiturage = annonceCovoiturage;
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReservationCovoiturage getAnnonceCovoiturage() {
		return annonceCovoiturage;
	}

	public void setAnnonceCovoiturage(ReservationCovoiturage annonceCovoiturage) {
		this.annonceCovoiturage = annonceCovoiturage;
	}

	public StatutAnnonceCovoiturageEnum getStatutAnnonceCovoiturage() {
		return statutAnnonceCovoiturage;
	}

	public void setStatutAnnonceCovoiturage(StatutAnnonceCovoiturageEnum statutAnnonceCovoiturage) {
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
	}
}
