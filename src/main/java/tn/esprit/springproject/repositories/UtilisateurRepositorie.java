package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entites.Utilisateur;

public interface UtilisateurRepositorie extends JpaRepository<Utilisateur,Integer> {
}
