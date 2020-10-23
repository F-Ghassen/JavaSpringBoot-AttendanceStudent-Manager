package com.absence.etudiant.service.model; 

import com.absence.etudiant.domain.model.Etudiant;
import java.util.Optional;
import java.util.List;

public interface EtudiantService{

      void saveOrUpdate(Etudiant etudiant);

      void deleteById(Long id ) ;

      Optional<Etudiant> findById(Long id);

      List<Etudiant> findAll();

}