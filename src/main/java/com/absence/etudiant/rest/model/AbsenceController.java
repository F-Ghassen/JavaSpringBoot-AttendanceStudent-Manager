package com.absence.etudiant.rest.model; 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.absence.etudiant.domain.model.Absence;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.domain.model.NbrAbsence;
import com.absence.etudiant.repository.model.AbsenceRepository;
import com.absence.etudiant.service.model.AbsenceService;
import com.absence.etudiant.service.model.ClasseService;
import com.absence.etudiant.service.model.EtudiantService;
import com.absence.etudiant.service.model.MatiereService;

@Controller
public class AbsenceController {

      @Autowired
       private AbsenceService absenceService ;
      @Autowired
      private EtudiantService etudiantService ;
      @Autowired
      private MatiereService matiereService ;
      
      @Autowired
       private ClasseService classeService ;
      @Autowired
      private AbsenceRepository absdao;
      
      
      @Autowired
      public JavaMailSender emailSender;
   
     
    	  
  
      @GetMapping(value="/absenceadd")
      public String addAbsence (Absence absence ,Model model) {
    	  List<Etudiant> etudiant = etudiantService.findAll() ;
//    	  List<Class> classe = lasseService
    	  model.addAttribute("matieres", matiereService.findAll());
    	  model.addAttribute("etudiants", etudiant);
//    	  model.addAttribute("class", classeService.findAll());
    	  return "absence/addAbsence.html";
    	  }
      
      @PostMapping(value ="/absences")
      public ModelAndView save(@Valid Absence absence) {
//    	  SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    	  Date date = simpleDateFormat. parse("25/12/2010"); 
//    	  System.out.println(absence.getEtudiant().getNom());
          absenceService.saveOrUpdate(absence);
          return new ModelAndView("redirect:/absences");
}

      @GetMapping(value ="/absnecedit/{id}")
      public String showClasse(@PathVariable("id") Long id, Model model) {
    	 Absence abs = absenceService.findById(id).orElse(null) ; 
    	 System.out.println();
    	  model.addAttribute("absence", abs);
    	  model.addAttribute("etudiant", abs.getEtudiant());
    	  model.addAttribute("matiere", abs.getMatiere());
    	  
    	  return "absence/updateabsence.html" ;
}
      @PostMapping("/updateabsence/{id}")
      public ModelAndView updateetudiant(@PathVariable("id") long id, @Valid Absence absence, Model model) {
    	  absenceService.saveOrUpdate(absence);
          //model.addAttribute("etudiants", etudiantService.findAll());
          return new ModelAndView("redirect:/absences");
      }
      

      @GetMapping(value ="/absenceDelete/{id}")
      public ModelAndView delete(@PathVariable Long id) {
          absenceService.deleteById(id);
          return new ModelAndView("redirect:/absences") ;
}

      @GetMapping(value ="/absences/{id}")
      public Optional<Absence>  findById(@PathVariable Long id) {
          return absenceService.findById(id);
}

      @GetMapping(value="/absencechaquetudiant")
      public String findByMatiere(Model model){
    	  
    	  List<NbrAbsence> nbrAbsence = new ArrayList<NbrAbsence>() ;
    	  
    	  absenceService.findAll().stream().map(e->{
    		 Etudiant etudiant = e.getEtudiant();
			int somme = absenceService.nbrAbsence( etudiant,e.getMatiere());
    		 System.out.println(nbrAbsence.contains(etudiant));
    		 boolean test = false ;
    		 NbrAbsence nbrAbsenceObj = new NbrAbsence(etudiant,e.getMatiere(), somme) ;
    		 if(nbrAbsence.isEmpty())
    			 nbrAbsence.add(nbrAbsenceObj ) ;
    		 else {
    			 for(NbrAbsence nbr:nbrAbsence) {
        			 if( nbr.getEtudiant().equals(etudiant) && nbr.getMatiere().equals(e.getMatiere())) {
        			test = true ;
        		}
        		 }
    			 if(test == false) {
    				 
         			if(e.getMatiere().getLimit()<=somme) {
         				SimpleMailMessage message = new SimpleMailMessage(); 
         				System.out.println(etudiant.getEmail());
     			          message.setTo(etudiant.getEmail()); 
     			          message.setSubject("Elimination"); 
     			          message.setText("Vous ete eliminé de "+e.getMatiere().getLabel());
     			          emailSender.send(message);
         			}
         			nbrAbsence.add(nbrAbsenceObj ) ;
    			 }
    		 }


    			
    			 
    		  return nbrAbsence  ;  
    	  }).collect( Collectors.toList() );
    	  
    	  System.out.println(nbrAbsence.toString());
    	  model.addAttribute("nbrAbsence", nbrAbsence) ;
    	  return "absence/absencechaqueetudiant.html" ;
      }
      @GetMapping(value ="/absences")
      public String  findAll(Model model) {
         model.addAttribute("absences", absenceService.findAll());
         return "absence/ListAbsence.html" ; 
}
}