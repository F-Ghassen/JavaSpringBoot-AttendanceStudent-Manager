package com.absence.etudiant.repository.model; 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.absence.etudiant.domain.model.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> , JpaSpecificationExecutor<Etudiant>{

}