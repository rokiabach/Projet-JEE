package com.projet.AppResidents.repository;

import com.projet.AppResidents.model.Requete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RequeteRepository extends JpaRepository<Requete, Long> {
    List<Requete> findByStatut(String statut);
}
