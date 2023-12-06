package tn.esprit.springproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.springproject.entites.Commentaire;
import tn.esprit.springproject.entites.Forum;
import tn.esprit.springproject.entites.Message;
import tn.esprit.springproject.entites.Utilisateur;
import tn.esprit.springproject.repositories.UtilisateurRepositorie;
import tn.esprit.springproject.services.Servicelmp;

import java.util.List;
import java.util.NoSuchElementException;
@AllArgsConstructor
@RestController
public class Controller {

    private Servicelmp servicelmp;
    private UtilisateurRepositorie utilisateurRepositorie;

    @PostMapping("/ajouterUtilisateur/{forumId}")
    public ResponseEntity<String> ajouterUtilisateur(@RequestBody Utilisateur nouvelUtilisateur, @PathVariable long forumId) {
        try {
        	servicelmp.ajouterUtilisateur(nouvelUtilisateur, forumId);
            return new ResponseEntity<>("Utilisateur ajouté avec succès.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout de l'utilisateur.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ajouterMessage/{forumId}")
    public ResponseEntity<String> ajouterMessage(@RequestBody Message nouveauMessage, @PathVariable long forumId) {
        try {
        	servicelmp.ajouterMessage(nouveauMessage, forumId);
            return new ResponseEntity<>("Message ajouté avec succès.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout du message.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/afficherDerniersMessages/{forumId}")
    public ResponseEntity<List<Message>> afficherDerniersMessages(@PathVariable long forumId) {
        try {
            List<Message> derniersMessages = servicelmp.afficherDerniersMessages(forumId);
            return new ResponseEntity<>(derniersMessages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/afficherProfil/{utilisateurId}")
    public ResponseEntity<String> afficherProfil(@PathVariable long utilisateurId) {
        try {
        	servicelmp.afficherProfil(utilisateurId);
            return new ResponseEntity<>("Profil affiché avec succès.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Utilisateur non trouvé.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'affichage du profil.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/ajouterCommentaire")
    public ResponseEntity<String> ajouterCommentaire(@RequestBody Commentaire commentaire) {
        try {
        	servicelmp.ajouterCommentaire(commentaire);
            return new ResponseEntity<>("Commentaire ajouté avec succès.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout du commentaire.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/ajouterMessage")
    public ResponseEntity<String> ajouterMessage(@RequestBody Message message) {
        try {
        	servicelmp.ajouterMessage(message);
            return new ResponseEntity<>("Message ajouté avec succès.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'ajout du message.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/envoyerMessage/{destinataireId}")
    public ResponseEntity<String> envoyerMessage(
            @PathVariable long destinataireId,
            @RequestBody Message message) {
        try {
            Utilisateur destinataire = utilisateurRepositorie.findById((int) destinataireId)
                    .orElseThrow(NoSuchElementException::new);

            message.setDestinataire(destinataire);

            servicelmp.envoyerMessage(message);
            return new ResponseEntity<>("Message envoyé avec succès.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Destinataire non trouvé.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de l'envoi du message.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
