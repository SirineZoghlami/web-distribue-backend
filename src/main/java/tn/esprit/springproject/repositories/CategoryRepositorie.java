package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entites.Category;

public interface CategoryRepositorie extends JpaRepository<Category,Integer> {
}
