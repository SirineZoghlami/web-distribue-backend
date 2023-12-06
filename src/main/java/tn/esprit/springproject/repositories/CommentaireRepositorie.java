package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entites.Commentaire;

public interface CommentaireRepositorie extends JpaRepository<Commentaire,Integer> {
}
