package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entites.Message;

public interface MessageRepositorie extends JpaRepository<Message,Integer> {
}
