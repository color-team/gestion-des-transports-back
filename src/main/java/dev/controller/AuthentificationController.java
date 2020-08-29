package dev.controller;

import dev.controller.dto.UtilisateurDto;
import dev.repository.UtilisateurRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WEB API d'authentification.
 *
 * Elle permet de récupérer les informations de l'utilisateur connecté.
 */
@RestController
public class AuthentificationController {

    private UtilisateurRepo utilisateurRepo;

    public AuthentificationController(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    @GetMapping("/me")
    public ResponseEntity<?> quiSuisJe() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.utilisateurRepo.findByEmail(email)
                .map(UtilisateurDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
    
    @GetMapping("administrateur/me")
    public ResponseEntity<?> quiSuisJeAdmin() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.utilisateurRepo.findByEmail(email)
                .map(UtilisateurDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
    
}
