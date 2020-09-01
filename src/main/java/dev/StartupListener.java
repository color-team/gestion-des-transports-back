package dev;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Localisation;
import dev.domain.ReservationCovoiturage;
import dev.domain.RoleUtilisateur;
import dev.domain.StatutReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.domain.VehiculeParticulier;
import dev.domain.Version;
import dev.domain.enumeration.Role;
import dev.domain.enumeration.StatutReservationCovoiturageEnum;
import dev.repository.ReservationCovoiturageRepository;
import dev.repository.UtilisateurRepo;
import dev.repository.VersionRepo;

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

    public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo, PasswordEncoder passwordEncoder, UtilisateurRepo utilisateurRepo, ReservationCovoiturageRepository reservationCovoiturageRepository) {
        this.appVersion = appVersion;
        this.versionRepo = versionRepo;
        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepo = utilisateurRepo;
        this.reservationCovoiturageRepository = reservationCovoiturageRepository;
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
        
        //  Création d'un véhicule particulier
        Utilisateur[] passagers1 = {user5, user7};
        Utilisateur[] passagers2 = {user8, user7};
        VehiculeParticulier vehiculeParticulier1 = new VehiculeParticulier("AKG-666-69", "Ford", "https://images.caradisiac.com/logos/4/0/6/1/254061/S8-nouvelle-ford-focus-st-prix-agressif-mais-malus-eleve-176166.jpg", null, "Focus", "Berline");
        
        //  Création de réservationCovoiturage
        ReservationCovoiturage covoit1 = new ReservationCovoiturage(LocalDateTime.of(2020,9,17,9,10), new Localisation("31 Rue de la paix, Paris", "Paris", 75000, 48.8534f , 2.3488f), new Localisation("Gare de Marseille-St-Charles, Marseille", "Marseille", 13000, 43.3f , 5.4f), user2, (byte) 4, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE), vehiculeParticulier1, Arrays.asList(passagers1) );
        this.reservationCovoiturageRepository.save(covoit1);
        
        ReservationCovoiturage covoit2 = new ReservationCovoiturage(LocalDateTime.of(2020,9,25,12,30), new Localisation("31 Rue de la paix, Paris", "Paris", 75000, 48.8534f , 2.3488f), new Localisation("Gare de Toulouse-Matabiau, Toulouse", "Toulouse", 31000, 43.60f , 1.433333f), user2, (byte) 4, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE), vehiculeParticulier1, Arrays.asList(passagers2));
        this.reservationCovoiturageRepository.save(covoit2);
        
        ReservationCovoiturage covoit3 = new ReservationCovoiturage(LocalDateTime.of(2020,8,25,12,30), new Localisation("31 Rue de la paix, Paris", "Paris", 75000, 48.8534f , 2.3488f), new Localisation("Gare de Toulouse-Matabiau, Toulouse", "Toulouse", 31000, 43.60f , 1.433333f), user5, (byte) 4, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE), vehiculeParticulier1, Arrays.asList(passagers2));
        this.reservationCovoiturageRepository.save(covoit3);
        
    }

}
