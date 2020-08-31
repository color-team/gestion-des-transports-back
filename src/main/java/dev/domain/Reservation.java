package dev.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
	
	protected LocalDateTime dateDepart;
	
	@OneToOne(cascade = CascadeType.ALL)
	protected Localisation depart;
	
	@OneToOne(cascade = CascadeType.ALL)
	protected Localisation destination;
	
	public Reservation() {}
	
	public Reservation(LocalDateTime dateDepart, Localisation depart, Localisation destination) {
		this.dateDepart = dateDepart;
		this.depart = depart;
		this.destination = destination;
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

	public Localisation getDepart() {
		return depart;
	}

	public void setDepart(Localisation depart) {
		this.depart = depart;
	}

	public Localisation getDestination() {
		return destination;
	}

	public void setDestination(Localisation destination) {
		this.destination = destination;
	}
}
