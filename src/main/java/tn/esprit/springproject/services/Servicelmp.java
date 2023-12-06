package tn.esprit.springproject.services;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.springproject.entites.Commentaire;
import tn.esprit.springproject.entites.Forum;
import tn.esprit.springproject.entites.Message;
import tn.esprit.springproject.entites.Utilisateur;
import tn.esprit.springproject.repositories.CategoryRepositorie;
import tn.esprit.springproject.repositories.CommentaireRepositorie;
import tn.esprit.springproject.repositories.FourmRepositorie;
import tn.esprit.springproject.repositories.MessageRepositorie;
import tn.esprit.springproject.repositories.UtilisateurRepositorie;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class Servicelmp  implements IService{

    @Autowired
    private FourmRepositorie forumRepository;

    @Autowired
    private UtilisateurRepositorie utilisateurRepository;

    @Autowired
    private MessageRepositorie messageRepository;

    @Autowired
    private CategoryRepositorie categorieRepository;
    
    @Autowired
    private CommentaireRepositorie commentaireRepositorie;

    @Override
    @Transactional
    public void ajouterUtilisateur(Utilisateur nouvelUtilisateur, long forumId) {
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(NoSuchElementException::new);
        nouvelUtilisateur.setForum(forum);
        utilisateurRepository.save(nouvelUtilisateur);
    }

    @Override
    @Transactional
    public void ajouterMessage(Message nouveauMessage, long forumId) {
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(NoSuchElementException::new);
        nouveauMessage.setForum(forum);
        messageRepository.save(nouveauMessage);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> afficherDerniersMessages(long forumId) {
        Forum forum = forumRepository.findById(forumId)
                .orElseThrow(NoSuchElementException::new);
        return forum.getMessages();
    }
    @Override
    @Transactional(readOnly = true)
    public void afficherProfil(long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById((int) utilisateurId)
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Profil de l'utilisateur : " + utilisateur);
    }
    @Override
    @Transactional
    public void ajouterCommentaire(Commentaire commentaire) {
    	commentaireRepositorie.save(commentaire);
    }
    
    @Override
    @Transactional
    public void ajouterMessage(Message message) {
        messageRepository.save(message);
    }
    
    @Override
    @Transactional
    public void envoyerMessage(Message message) {
       
        message.setDatePublication(new Date());

        messageRepository.save(message);
    }
}
