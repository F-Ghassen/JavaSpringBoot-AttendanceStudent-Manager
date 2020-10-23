package com.absence.etudiant.serviceImpl.model; 

import com.absence.etudiant.domain.model.Classe;
import com.absence.etudiant.service.model.ClasseService;
import com.absence.etudiant.repository.model.ClasseRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClasseServiceImpl implements ClasseService {

   @Autowired
      private ClasseRepository classeRepository ;

   @Override
     public void saveOrUpdate(Classe classe){
          classeRepository.save(classe);
      }

   @Override
     public void deleteById(Long id){
          classeRepository.deleteById(id);
      }

   @Override
     public Optional<Classe> findById(Long id){
          return classeRepository.findById(id);
}

   @Override
      public List<Classe> findAll(){
           return classeRepository.findAll();
}

}