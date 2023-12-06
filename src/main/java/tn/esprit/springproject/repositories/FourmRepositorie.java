package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entites.Forum;

public interface FourmRepositorie extends JpaRepository<Forum,Long> {
}
