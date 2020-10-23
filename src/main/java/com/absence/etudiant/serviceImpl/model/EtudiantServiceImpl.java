package com.absence.etudiant.serviceImpl.model; 

import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.service.model.EtudiantService;
import com.absence.etudiant.repository.model.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EtudiantServiceImpl implements EtudiantService {

   @Autowired
      private EtudiantRepository etudiantRepository ;

   @Override
     public void saveOrUpdate(Etudiant etudiant){
          etudiantRepository.save(etudiant);
      }

   @Override
     public void deleteById(Long id){
          etudiantRepository.deleteById(id);
      }

   @Override
     public Optional<Etudiant> findById(Long id){
          return etudiantRepository.findById(id);
}

   @Override
      public List<Etudiant> findAll(){
           return etudiantRepository.findAll();
}

}