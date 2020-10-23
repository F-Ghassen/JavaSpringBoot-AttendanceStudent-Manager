package com.absence.etudiant.service.model; 

import com.absence.etudiant.domain.model.Matiere;
import java.util.Optional;
import java.util.List;

public interface MatiereService{

      void saveOrUpdate(Matiere matiere);

      void deleteById(Long id ) ;

      Optional<Matiere> findById(Long id);

      List<Matiere> findAll();

}