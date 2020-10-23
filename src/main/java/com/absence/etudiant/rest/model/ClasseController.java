package com.absence.etudiant.rest.model; 

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.absence.etudiant.domain.model.Classe;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.service.model.ClasseService;

@Controller
public class ClasseController {

      @Autowired
       private ClasseService classeService ;

      @GetMapping(value="/classesadd")
      public String addEtudiant(Classe classe ) {
    	  
    	  return "classe/addClasse.html";
    	  }
      
      
      @PostMapping(value ="/classes")
      public ModelAndView save(@Valid Classe classe) {
          classeService.saveOrUpdate(classe);
          return new ModelAndView("redirect:/classes");
}
      
      @GetMapping(value ="/classedit/{id}")
      public String showClasse(@PathVariable("id") Long id, Model model) {
    	 Classe classe = classeService.findById(id).orElse(null) ; 
    	  model.addAttribute("classe", classe);
    	  return "classe/updateclasse.html" ;
}
      @PostMapping("/updateclasse/{id}")
      public ModelAndView updateetudiant(@PathVariable("id") long id, @Valid Classe classe, Model model) {
    	  classeService.saveOrUpdate(classe);
          //model.addAttribute("etudiants", etudiantService.findAll());
          return new ModelAndView("redirect:/classes");
      }
      
   
      @GetMapping(value ="/classesDelete/{id}")
      public ModelAndView delete(@PathVariable Long id) {
          classeService.deleteById(id);
          return new ModelAndView("redirect:/classes");
}

      @GetMapping(value ="/classes/{id}")
      public Optional<Classe>  findById(@PathVariable Long id) {
          return classeService.findById(id);
}

      @GetMapping(value ="/classes")
      public String findAll(Model model) {
    	  
         model.addAttribute("class",classeService.findAll());
         return "classe/ListClasse.html";
}
}