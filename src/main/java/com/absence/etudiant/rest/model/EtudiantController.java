package com.absence.etudiant.rest.model; 

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.absence.etudiant.domain.model.Classe;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.service.model.ClasseService;
import com.absence.etudiant.service.model.EtudiantService;

@Controller
public class EtudiantController {

      @Autowired
       private EtudiantService etudiantService ;
      
      @Autowired
      private ClasseService classeService ;

     

      
      @GetMapping(value="/etudiantadd")
      public String addEtudiant(Etudiant etudiant ,Model model) {
    	  List<Classe> classe = classeService.findAll() ;
    	  model.addAttribute("classe", classe);
    	  return "Etudiants/addEtudiant.html";
    	  }
      
      @PostMapping(value ="/etudiants")
      public ModelAndView  save(@Valid Etudiant etudiant) {
          etudiantService.saveOrUpdate(etudiant);
          return new ModelAndView("redirect:/etudiants");
}

      @GetMapping(value ="/etudiantedit/{id}")
      public String showEtudiant(@PathVariable("id") Long id, Model model) {
    	  Etudiant etudiant = etudiantService.findById(id).orElse(null) ; 
    	  List<Classe> classe = classeService.findAll() ;
    	  System.out.println(etudiant.getEmail());
    	 model.addAttribute("etudiant", etudiant);
    	  model.addAttribute("classe", classe);
    	  return "Etudiants/updateEtudiant.html" ;
          //etudiantService.saveOrUpdate(etudiant);
}

      @PostMapping("/etudiantupdate/{id}")
      public ModelAndView updateetudiant(@PathVariable("id") long id, @Valid Etudiant etudiant, Model model) {
          System.out.println("***********"+""+etudiant.getClasse());
    	  etudiantService.saveOrUpdate(etudiant);
          //model.addAttribute("etudiants", etudiantService.findAll());
          return new ModelAndView("redirect:/etudiants");
      }
      @GetMapping(value ="/etudiantDelete/{id}")
      public ModelAndView delete(@PathVariable Long id) {
          etudiantService.deleteById(id);
          return new ModelAndView("redirect:/etudiants");
}

      @GetMapping(value ="/etudiants/{id}")
      public Optional<Etudiant>  findById(@PathVariable Long id) {
          return etudiantService.findById(id);
}

      @GetMapping(value ="/etudiants")
      public String  findAll(Model model) {
    	  model.addAttribute("etudiants", etudiantService.findAll()) ;
    	  return "Etudiants/ListEtudiant.html" ;
}
}