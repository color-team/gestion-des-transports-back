package dev.controller.dto;

public class ChauffeurDto {

	 private long id;
	 private String nom;
	 private String prenom;
	 private String matricule;
	 private String email;
	 private String categorie_permis;
	 private String photoUrl;
	 private String telephone;
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param matricule
	 * @param email
	 * @param categorie_permis
	 * @param photoUrl
	 * @param telephone
	 */
	public ChauffeurDto(long id, String nom, String prenom, String matricule, String email, String categorie_permis,
			String photoUrl, String telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.email = email;
		this.categorie_permis = categorie_permis;
		this.photoUrl = photoUrl;
		this.telephone = telephone;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the categorie_permis
	 */
	public String getCategorie_permis() {
		return categorie_permis;
	}
	/**
	 * @param categorie_permis the categorie_permis to set
	 */
	public void setCategorie_permis(String categorie_permis) {
		this.categorie_permis = categorie_permis;
	}
	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}
	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
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
	@Override
	public String toString() {
		return "ChauffeurDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", matricule=" + matricule
				+ ", email=" + email + ", categorie_permis=" + categorie_permis + ", photoUrl=" + photoUrl
				+ ", telephone=" + telephone + "]";
	}
	
	 
	
	
}
