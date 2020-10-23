package com.absence.etudiant.serviceImpl.model; 

import com.absence.etudiant.domain.model.Matiere;
import com.absence.etudiant.service.model.MatiereService;
import com.absence.etudiant.repository.model.MatiereRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MatiereServiceImpl implements MatiereService {

   @Autowired
      private MatiereRepository matiereRepository ;

   @Override
     public void saveOrUpdate(Matiere matiere){
          matiereRepository.save(matiere);
      }

   @Override
     public void deleteById(Long id){
          matiereRepository.deleteById(id);
      }

   @Override
     public Optional<Matiere> findById(Long id){
          return matiereRepository.findById(id);
}

   @Override
      public List<Matiere> findAll(){
           return matiereRepository.findAll();
}

}