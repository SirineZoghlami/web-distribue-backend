package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Commentaire;
import tn.esprit.springproject.entites.Forum;
import tn.esprit.springproject.entites.Message;
import tn.esprit.springproject.entites.Utilisateur;

import java.util.List;

public interface IService {
   
	void ajouterUtilisateur(Utilisateur nouvelUtilisateur, long forumId);

	void ajouterMessage(Message nouveauMessage, long forumId);

	List<Message> afficherDerniersMessages(long forumId);

	void afficherProfil(long utilisateurId);

	void ajouterCommentaire(Commentaire commentaire);

	void ajouterMessage(Message message);

	void envoyerMessage(Message message);
}
