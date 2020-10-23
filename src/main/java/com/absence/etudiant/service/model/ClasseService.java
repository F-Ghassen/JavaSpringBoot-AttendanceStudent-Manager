package com.absence.etudiant.service.model; 

import com.absence.etudiant.domain.model.Classe;
import java.util.Optional;
import java.util.List;

public interface ClasseService{

      void saveOrUpdate(Classe classe);

      void deleteById(Long id ) ;

      Optional<Classe> findById(Long id);

      List<Classe> findAll();

}