package com.projet.AppResidents.repository;
import com.projet.AppResidents.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    //List<Chambre> findByStatut(String statut);
}