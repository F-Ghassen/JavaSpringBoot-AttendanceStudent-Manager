package com.absence.etudiant.service.model; 

import java.util.List;
import java.util.Optional;

import com.absence.etudiant.domain.model.Absence;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.domain.model.Matiere;

public interface AbsenceService{

      void saveOrUpdate(Absence absence);

      void deleteById(Long id ) ;

      Optional<Absence> findById(Long id);

      List<Absence> findAll();
      int nbrAbsence(Etudiant etudiant , Matiere matiere );

}