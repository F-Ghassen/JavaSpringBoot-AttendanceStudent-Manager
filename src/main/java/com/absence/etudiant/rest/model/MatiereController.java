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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.absence.etudiant.domain.model.Classe;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.domain.model.Matiere;
import com.absence.etudiant.service.model.ClasseService;
import com.absence.etudiant.service.model.MatiereService;

@Controller
public class MatiereController {

      @Autowired
       private MatiereService matiereService ;
      @Autowired
      private ClasseService classeService ;

      @GetMapping(value="/matiereadd")
      public String addEtudiant(Matiere etudiant ,Model model) {
    	  List<Classe> classe = classeService.findAll() ;
    	  model.addAttribute("classe", classe);
    	  return "Matiere/addMatiere.html";
    	  }
      
      @PostMapping(value ="/matieres")
      public ModelAndView save(@Valid Matiere matiere) {
          matiereService.saveOrUpdate(matiere);
          return new ModelAndView("redirect:/matieres") ;
}
      @GetMapping(value ="/matiereedit/{id}")
      public String showEtudiant(@PathVariable("id") Long id, Model model) {
    	  Matiere matiere = matiereService.findById(id).orElse(null) ; 
    	  List<Classe> classe = classeService.findAll() ;
    	 model.addAttribute("matiere", matiere);
    	  model.addAttribute("classe", classe);
    	  return "Matiere/updateMatiere.html" ;
          //etudiantService.saveOrUpdate(etudiant);
}
      @PostMapping("/matiereupdate/{id}")
      public ModelAndView updatematiere(@PathVariable("id") long id, @Valid Matiere matiere, Model model) {
          
          matiereService.saveOrUpdate(matiere);
          //model.addAttribute("etudiants", etudiantService.findAll());
          return new ModelAndView("redirect:/matieres");
      }
      
      @GetMapping(value ="/matiereDelete/{id}")
      public ModelAndView delete(@PathVariable Long id) {
    	  matiereService.deleteById(id);
          return new ModelAndView("redirect:/matieres");
}


      @GetMapping(value ="/matieres/{id}")
      public Optional<Matiere>  findById(@PathVariable Long id) {
          return matiereService.findById(id);
}

      @GetMapping(value ="/matieres")
      public String  findAll(Model model ) {
         model.addAttribute("matieres", matiereService.findAll()) ;
         return "Matiere/ListMatiere.html" ;
}
}