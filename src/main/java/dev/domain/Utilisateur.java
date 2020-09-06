package dev.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nom;

    protected String prenom;

    protected String email;

    protected String motDePasse;
    
    protected String matricule;
    
    protected String categoriePermis = "";
    
    protected String photUrl;
    
    protected String telephone = "";

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    protected List<RoleUtilisateur> roles;
    
    @OneToMany(mappedBy = "conducteur")
    protected List<ReservationCovoiturage> annoncesCovoiturage;
    
    @OneToMany(mappedBy = "chauffeur")
    protected List<ReservationChauffeur> courses;
    
    @OneToMany(mappedBy = "passager")
    protected List<ReservationChauffeur> reservationsChauffeur;
    
    @OneToMany(mappedBy = "conducteur")
    protected List<ReservationSansChauffeur> reservationsSansChauffeur;
    
    @OneToMany(mappedBy = "passager")
    protected List<ReservationCovoituragePassager> reservationsCovoituragePassagers;

    public Utilisateur() {}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, String matricule,
			List<RoleUtilisateur> roles) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.matricule = matricule;
		this.roles = roles;
	}
	
	public Utilisateur(Long id, String nom, String prenom, String email, String motDePasse, String matricule,
			String categorie_permis, String photUrl, String telephone, List<RoleUtilisateur> roles) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.matricule = matricule;
		this.categoriePermis = categorie_permis;
		this.photUrl = photUrl;
		this.telephone = telephone;
		this.roles = roles;
	}
    
    public String getInfos() {
    	return prenom + " " + nom.toUpperCase();
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<RoleUtilisateur> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleUtilisateur> roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the categorie_permis
	 */
	public String getCategoriePermis() {
		return categoriePermis;
	}

	/**
	 * @param categorie_permis the categorie_permis to set
	 */
	public void setCategoriePermis(String categorie_permis) {
		this.categoriePermis = categorie_permis;
	}

	/**
	 * @return the photUrl
	 */
	public String getPhotUrl() {
		return photUrl;
	}

	/**
	 * @param photUrl the photUrl to set
	 */
	public void setPhotUrl(String photUrl) {
		this.photUrl = photUrl;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<ReservationCovoiturage> getAnnoncesCovoiturage() {
		return annoncesCovoiturage;
	}

	public void setAnnoncesCovoiturage(List<ReservationCovoiturage> annoncesCovoiturage) {
		this.annoncesCovoiturage = annoncesCovoiturage;
	}

	public List<ReservationChauffeur> getCourses() {
		return courses;
	}

	public void setCourses(List<ReservationChauffeur> courses) {
		this.courses = courses;
	}

	public List<ReservationChauffeur> getReservationsChauffeur() {
		return reservationsChauffeur;
	}

	public void setReservationsChauffeur(List<ReservationChauffeur> reservationsChauffeur) {
		this.reservationsChauffeur = reservationsChauffeur;
	}

	public List<ReservationSansChauffeur> getReservationsSansChauffeur() {
		return reservationsSansChauffeur;
	}

	public void setReservationsSansChauffeur(List<ReservationSansChauffeur> reservationsSansChauffeur) {
		this.reservationsSansChauffeur = reservationsSansChauffeur;
	}

	public List<ReservationCovoituragePassager> getReservationsCovoituragePassager() {
		return reservationsCovoituragePassagers;
	}

	public void setReservationsCovoituragePassager(List<ReservationCovoituragePassager> reservationsCovoituragePassagers) {
		this.reservationsCovoituragePassagers = reservationsCovoituragePassagers;
	}

	public List<ReservationCovoituragePassager> getReservationsCovoituragePassagers() {
		return reservationsCovoituragePassagers;
	}

	public void setReservationsCovoituragePassagers(List<ReservationCovoituragePassager> reservationsCovoituragePassagers) {
		this.reservationsCovoituragePassagers = reservationsCovoituragePassagers;
	}
}
