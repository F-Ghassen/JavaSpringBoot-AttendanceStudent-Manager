package com.absence.etudiant.repository.model; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.absence.etudiant.domain.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long>{

}