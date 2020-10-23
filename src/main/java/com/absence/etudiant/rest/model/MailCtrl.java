//package com.absence.etudiant.rest.model;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.absence.etudiant.domain.model.Absence;
//import com.absence.etudiant.domain.model.Etudiant;
//import com.absence.etudiant.domain.model.Matiere;
//import com.absence.etudiant.repository.model.AbsenceRepository;
//import com.absence.etudiant.service.model.AbsenceService;
//import com.absence.etudiant.service.model.ClasseService;
//import com.absence.etudiant.service.model.EtudiantService;
//import com.absence.etudiant.service.model.MatiereService;
//
//@RestController
//public class MailCtrl {
//
//	 @Autowired
//     private AbsenceService absenceService ;
//    @Autowired
//    private EtudiantService etudiantService ;
//    @Autowired
//    private MatiereService matiereService ;
//    
//    @Autowired
//     private ClasseService classeService ;
//    @Autowired
//    private AbsenceRepository absdao;
//    
//    
//    @Autowired
//    public JavaMailSender emailSender;
//	
//	@Autowired
//    private JavaMailSenderImpl javaMailSender;
//
//
//
//    @RequestMapping(value = { "/send" }, method = RequestMethod.GET)
//    public String sendMain() {
//    	
//    	List<Etudiant> etudiants = etudiantService.findAll();
//   	 
//   	 for (Etudiant etudiant : etudiants) {
//			List<Matiere> matieres = matiereService.findAll();
//			for (Matiere matiere : matieres) {
//				Absence a = absdao.findAbsenceByEtudiantAndMatiere(etudiant, matiere);
//				
//				if (a.getNbrHeure()>matiere.getLimit()) {
//					SimpleMailMessage message = new SimpleMailMessage(); 
//			          message.setTo(etudiant.getEmail()); 
//			          message.setSubject("Elimination"); 
//			          message.setText("Vous ete eliminé de "+matiere.getLabel());
//			          emailSender.send(message);
//				}
//			}
//		}
//    	
//    	return "sent";
//    }
//    
//}