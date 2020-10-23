package com.absence.etudiant.repository.model; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.absence.etudiant.domain.model.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long>{

}