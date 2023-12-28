package com.example.demo.repositories;

import com.example.demo.beans.Presentant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentantRepository extends JpaRepository<Presentant, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}
