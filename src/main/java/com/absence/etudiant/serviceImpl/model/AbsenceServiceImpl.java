package com.absence.etudiant.serviceImpl.model; 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absence.etudiant.domain.model.Absence;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.domain.model.Matiere;
import com.absence.etudiant.repository.model.AbsenceRepository;
import com.absence.etudiant.service.model.AbsenceService;

@Service
public class AbsenceServiceImpl implements AbsenceService {

   @Autowired
      private AbsenceRepository absenceRepository ;

   @Override
     public void saveOrUpdate(Absence absence){
          absenceRepository.save(absence);
      }

   @Override
     public void deleteById(Long id){
          absenceRepository.deleteById(id);
      }

   @Override
     public Optional<Absence> findById(Long id){
          return absenceRepository.findById(id);
}

   @Override
      public List<Absence> findAll(){
           return absenceRepository.findAll();
}

@Override
public int nbrAbsence(Etudiant e , Matiere matiere) {
	// TODO Auto-generated method stub
	return absenceRepository.nbrAbsence(e,matiere);
}

}