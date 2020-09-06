package dev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.*;
import dev.domain.enumeration.*;
import dev.repository.*;

/**
 * Code de démarrage de l'application.
 * Insertion de jeux de données.
 */
@Component
@Transactional
public class StartupListener {

    private String appVersion;
    private VersionRepo versionRepo;
    private PasswordEncoder passwordEncoder;
    private UtilisateurRepo utilisateurRepo;
    private ReservationCovoiturageRepository reservationCovoiturageRepository;
    private ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepository;
    private ReservationSansChauffeurRepository reservationSansChauffeurRepo; 
    private VehiculeEntrepriseRepository vehiculeEntrepriseRepo; 


    public StartupListener( @Value("${app.version}") String appVersion, VersionRepo versionRepo, PasswordEncoder passwordEncoder,
			UtilisateurRepo utilisateurRepo, ReservationCovoiturageRepository reservationCovoiturageRepository,
			ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepository,
			ReservationSansChauffeurRepository reservationSansChauffeurRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.utilisateurRepo = utilisateurRepo;
		this.reservationCovoiturageRepository = reservationCovoiturageRepository;
		this.reservationCovoituragePassagerRepository = reservationCovoituragePassagerRepository;
		this.reservationSansChauffeurRepo = reservationSansChauffeurRepo;
	}



	@EventListener(ContextRefreshedEvent.class)
    public void onStart() {
        this.versionRepo.save(new Version(appVersion));

        // Création des utilisateurs

        Utilisateur user1 = new Utilisateur();
        user1.setNom("Admin");
        user1.setPrenom("DEV");
        user1.setEmail("admin@dev.fr");
        user1.setMotDePasse(passwordEncoder.encode("superpass"));
        user1.setRoles(Arrays.asList(new RoleUtilisateur(user1, Role.ROLE_ADMINISTRATEUR), new RoleUtilisateur(user1, Role.ROLE_COLLABORATEUR), new RoleUtilisateur(user1, Role.ROLE_CHAUFFEUR)));
        user1.setMatricule("AD-667-09-KK");
        user1.setCategoriePermis("A");
        user1.setPhotUrl("https://randomuser.me/api/portraits/men/9.jpg");
        user1.setTelephone("0033656095487");
        this.utilisateurRepo.save(user1);

        Utilisateur user2 = new Utilisateur();
        user2.setNom("User");
        user2.setPrenom("DEV");
        user2.setEmail("user@dev.fr");
        user2.setMotDePasse(passwordEncoder.encode("superpass"));
        user2.setRoles(Arrays.asList(new RoleUtilisateur(user2, Role.ROLE_COLLABORATEUR)));
        user2.setMatricule("US-666-01-BK");
        this.utilisateurRepo.save(user2);
        
        Utilisateur user3 = new Utilisateur();
        user3.setNom("Driver");
        user3.setPrenom("DEV");
        user3.setEmail("driver@dev.fr");
        user3.setMotDePasse(passwordEncoder.encode("superpass"));
        user3.setRoles(Arrays.asList(new RoleUtilisateur(user3, Role.ROLE_COLLABORATEUR), new RoleUtilisateur(user3, Role.ROLE_CHAUFFEUR)));
        user3.setMatricule("DR-669-02-PQ");
        user3.setCategoriePermis("C");
        user3.setPhotUrl("https://randomuser.me/api/portraits/men/35.jpg");
        user3.setTelephone("0033767094565");
        this.utilisateurRepo.save(user3);
        
        Utilisateur user4 = new Utilisateur();
        user4.setNom("User4");
        user4.setPrenom("DEV");
        user4.setEmail("user4@dev.fr");
        user4.setMotDePasse(passwordEncoder.encode("superpass"));
        user4.setRoles(Arrays.asList(new RoleUtilisateur(user4, Role.ROLE_COLLABORATEUR)));
        user4.setMatricule("US-666-04-BK");
        this.utilisateurRepo.save(user4);
        
        Utilisateur user5 = new Utilisateur();
        user5.setNom("User5");
        user5.setPrenom("DEV");
        user5.setEmail("user5@dev.fr");
        user5.setMotDePasse(passwordEncoder.encode("superpass"));
        user5.setRoles(Arrays.asList(new RoleUtilisateur(user5, Role.ROLE_COLLABORATEUR)));
        user5.setMatricule("US-666-05-BK");
        this.utilisateurRepo.save(user5);
        
        Utilisateur user7 = new Utilisateur();
        user7.setNom("User7");
        user7.setPrenom("DEV");
        user7.setEmail("user7@dev.fr");
        user7.setMotDePasse(passwordEncoder.encode("superpass"));
        user7.setRoles(Arrays.asList(new RoleUtilisateur(user7, Role.ROLE_COLLABORATEUR)));
        user7.setMatricule("US-666-07-BK");
        this.utilisateurRepo.save(user7);
        
        Utilisateur user8 = new Utilisateur();
        user8.setNom("User8");
        user8.setPrenom("DEV");
        user8.setEmail("user8@dev.fr");
        user8.setMotDePasse(passwordEncoder.encode("superpass"));
        user8.setRoles(Arrays.asList(new RoleUtilisateur(user8, Role.ROLE_COLLABORATEUR)));
        user8.setMatricule("US-666-08-BK");
        this.utilisateurRepo.save(user8);
        
        Utilisateur user9 = new Utilisateur();
        user9.setNom("Julo");
        user9.setPrenom("DEV");
        user9.setEmail("souleymanethiam22@gmail.com");
        user9.setMotDePasse(passwordEncoder.encode("superpass"));
        user9.setRoles(Arrays.asList(new RoleUtilisateur(user9, Role.ROLE_COLLABORATEUR), new RoleUtilisateur(user9, Role.ROLE_CHAUFFEUR)));
        user9.setMatricule("DR-669-09-PQ");
        user9.setCategoriePermis("C");
        user9.setPhotUrl("https://randomuser.me/api/portraits/women/39.jpg");
        user9.setTelephone("0033769696969");
        this.utilisateurRepo.save(user9);
        
        Utilisateur teamColor = new Utilisateur();
        teamColor.setNom("Team Color");
        teamColor.setPrenom("DEV");
        teamColor.setEmail("color.team.dta@gmail.com");
        teamColor.setMotDePasse(passwordEncoder.encode("superpass"));
        teamColor.setRoles(Arrays.asList(new RoleUtilisateur(teamColor, Role.ROLE_COLLABORATEUR)));
        teamColor.setMatricule("DR-666-66-PQ");
        teamColor.setPhotUrl("https://randomuser.me/api/portraits/men/10.jpg");
        this.utilisateurRepo.save(teamColor);
        
        Utilisateur koulk = new Utilisateur();
        koulk.setNom("Koulk");
        koulk.setPrenom("Zbda");
        koulk.setEmail("koulkzbda@gmail.com");
        koulk.setMotDePasse(passwordEncoder.encode("superpass"));
        koulk.setRoles(Arrays.asList(new RoleUtilisateur(koulk, Role.ROLE_COLLABORATEUR)));
        koulk.setMatricule("XD-666-66-GG");
        koulk.setPhotUrl("https://randomuser.me/api/portraits/men/11.jpg");
        this.utilisateurRepo.save(koulk);
        
        Utilisateur alprodh = new Utilisateur();
        alprodh.setNom("Alprodh");
        alprodh.setPrenom("DEV");
        alprodh.setEmail("alexis.prodhom@hotmail.fr");
        alprodh.setMotDePasse(passwordEncoder.encode("superpass"));
        alprodh.setRoles(Arrays.asList(new RoleUtilisateur(alprodh, Role.ROLE_COLLABORATEUR)));
        alprodh.setMatricule("PD-404-66-BG");
        alprodh.setPhotUrl("https://randomuser.me/api/portraits/women/69.jpg");
        this.utilisateurRepo.save(alprodh);
        
        //  Création d'un véhicule particulier

        VehiculeParticulier vehiculeParticulier1 = new VehiculeParticulier(
        		"AKG-666-69", "Ford", 
        		"https://images.caradisiac.com/logos/4/0/6/1/254061/S8-nouvelle-ford-focus-st-prix-agressif-mais-malus-eleve-176166.jpg", 
        		null, "Focus", "Berline");
        
        //  Création de réservationCovoiturage
        ReservationCovoiturage covoit1 = new ReservationCovoiturage(
        		LocalDateTime.of(2020,9,17,9,10),
        		new Localisation("31 Rue de la paix, Paris", "Paris", 75000, 48.8534f , 2.3488f),
        		new Localisation("Gare de Marseille-St-Charles, Marseille", "Marseille", 13000, 43.3f , 5.4f),
        		user2,
        		(byte) 4,
        		vehiculeParticulier1
        );
        covoit1.setStatutAnnonceCovoiturage(new StatutAnnonceCovoiturage(covoit1, StatutAnnonceCovoiturageEnum.PUBLIEE));
        this.reservationCovoiturageRepository.save(covoit1);
        
        ReservationCovoituragePassager reservationsCovoituragePassagers1a = new ReservationCovoituragePassager(user5, covoit1, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        ReservationCovoituragePassager reservationsCovoituragePassagers1b = new ReservationCovoituragePassager(user7, covoit1, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers1a);
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers1b);
        
        ReservationCovoiturage covoit2 = new ReservationCovoiturage(LocalDateTime.of(2020,9,25,12,30), new Localisation("31 Rue de la paix, Paris", "Paris", 75000, 48.8534f , 2.3488f), new Localisation("Gare de Toulouse-Matabiau, Toulouse", "Toulouse", 31000, 43.60f , 1.433333f), user2, (byte) 4, vehiculeParticulier1);
        covoit2.setStatutAnnonceCovoiturage(new StatutAnnonceCovoiturage(covoit2, StatutAnnonceCovoiturageEnum.PUBLIEE));
        this.reservationCovoiturageRepository.save(covoit2);
        
        ReservationCovoituragePassager reservationsCovoituragePassagers2a = new ReservationCovoituragePassager(user8, covoit2, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        ReservationCovoituragePassager reservationsCovoituragePassagers2b = new ReservationCovoituragePassager(user7, covoit2, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers2a);
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers2b);
        
        
        ReservationCovoiturage covoit3 = new ReservationCovoiturage(LocalDateTime.of(2020,8,19,14,00), new Localisation("31 Rue de la paix, Paris", "Paris", 75000, 48.8534f , 2.3488f), new Localisation("Gare de Toulouse-Matabiau, Toulouse", "Toulouse", 31000, 43.60f , 1.433333f), user5, (byte) 4, vehiculeParticulier1);
        covoit3.setStatutAnnonceCovoiturage(new StatutAnnonceCovoiturage(covoit3, StatutAnnonceCovoiturageEnum.TERMINEE));
        this.reservationCovoiturageRepository.save(covoit3);
        
        ReservationCovoituragePassager reservationsCovoituragePassagers3a = new ReservationCovoituragePassager(user8, covoit3, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.TERMINEE));
        ReservationCovoituragePassager reservationsCovoituragePassagers3b = new ReservationCovoituragePassager(user7, covoit3, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.TERMINEE));
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers3a);
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers3b);
        
        ReservationCovoiturage covoit4 = new ReservationCovoiturage(
        		LocalDateTime.of(2020,9,19,10,30),
        		new Localisation("Porte d'Italie, Paris", "Paris", 75000, 48.8534f , 2.3488f),
        		new Localisation("Gare de Marseille-St-Charles, Marseille", "Marseille", 13000, 43.3f , 5.4f),
        		alprodh,
        		(byte) 4,
        		vehiculeParticulier1
        );
        covoit4.setStatutAnnonceCovoiturage(new StatutAnnonceCovoiturage(covoit4, StatutAnnonceCovoiturageEnum.PUBLIEE));
        this.reservationCovoiturageRepository.save(covoit4);
        
        ReservationCovoituragePassager reservationsCovoituragePassagers4a = new ReservationCovoituragePassager(koulk, covoit4, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        ReservationCovoituragePassager reservationsCovoituragePassagers4b = new ReservationCovoituragePassager(teamColor, covoit4, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers4a);
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers4b);
        
        ReservationCovoiturage covoit5 = new ReservationCovoiturage(
        		LocalDateTime.of(2020,9,22,11,30),
        		new Localisation("Place de la République, Paris", "Paris", 75000, 48.8534f , 2.3488f),
        		new Localisation("Gare de Marseille-St-Charles, Marseille", "Marseille", 13000, 43.3f , 5.4f),
        		koulk,
        		(byte) 4,
        		vehiculeParticulier1
        );
        covoit5.setStatutAnnonceCovoiturage(new StatutAnnonceCovoiturage(covoit5, StatutAnnonceCovoiturageEnum.PUBLIEE));
        this.reservationCovoiturageRepository.save(covoit5);
        
        ReservationCovoituragePassager reservationsCovoituragePassagers5a = new ReservationCovoituragePassager(alprodh, covoit5, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        ReservationCovoituragePassager reservationsCovoituragePassagers5b = new ReservationCovoituragePassager(teamColor, covoit5, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers5a);
        this.reservationCovoituragePassagerRepository.save(reservationsCovoituragePassagers5b);
        
        // Création de véhicules entreprise
        byte nbPlaces = 4;
        VehiculeEntreprise vehiculeEntreprise1 = new VehiculeEntreprise( "PRO-000-01", "Fiat", 
        		"https://s1.cdn.autoevolution.com/images/gallery/FIATMultipla-2416_1.jpg", 
        		null, "Multipla", "Citadine", nbPlaces, null, new ArrayList<ReservationEntreprise>(), new StatutVehicule(null, StatutVehiculeEnum.EN_SERVICE));
       
        
        VehiculeEntreprise vehiculeEntreprise2 = new VehiculeEntreprise( "PRO-000-02", "Mercedes", 
        		"https://i.ytimg.com/vi/HD-vr3x9raU/maxresdefault.jpg", 
        		null, "Cla", "Coupé", nbPlaces, null, new ArrayList<ReservationEntreprise>(), new StatutVehicule(null, StatutVehiculeEnum.EN_SERVICE));
        
        // Création Reservation sans chauffeurs
        StatutReservationEntreprise statut1 = new StatutReservationEntreprise();
        statut1.setStatutReservationEntreprise( StatutReservationEntrepriseEnum.ACCEPTEE);
        ReservationSansChauffeur reservationSansChauffeur1 = new ReservationSansChauffeur(
        		LocalDateTime.of( 2020, 12, 1, 8, 0, 0),
        		LocalDateTime.of( 2020, 12, 9, 20, 0, 0),
    			null, null, user7, vehiculeEntreprise1, statut1);
        
        statut1.setReservationEntreprise(reservationSansChauffeur1);
        reservationSansChauffeur1.setStatutReservationEntreprise(statut1);
        vehiculeEntreprise1.addReservationEntreprise(reservationSansChauffeur1);
        reservationSansChauffeur1.setVehiculeEntreprise(vehiculeEntreprise1);
        this.reservationSansChauffeurRepo.save( reservationSansChauffeur1);
        
        
        StatutReservationEntreprise statut2 = new StatutReservationEntreprise();
        statut2.setStatutReservationEntreprise( StatutReservationEntrepriseEnum.ANNULEE);
        ReservationSansChauffeur reservationSansChauffeur2 = new ReservationSansChauffeur(
        		LocalDateTime.of( 2020, 12, 10, 8, 0, 0),
        		LocalDateTime.of( 2020, 12, 19, 20, 0, 0),
    			null, null, user8, vehiculeEntreprise2, statut2);
        
        statut2.setReservationEntreprise(reservationSansChauffeur2);
        reservationSansChauffeur2.setStatutReservationEntreprise(statut2);
        vehiculeEntreprise2.addReservationEntreprise(reservationSansChauffeur2);
        reservationSansChauffeur2.setVehiculeEntreprise(vehiculeEntreprise2);
        this.reservationSansChauffeurRepo.save( reservationSansChauffeur2);
    }

}
