package com.absence.etudiant.repository.model; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.absence.etudiant.domain.model.Absence;
import com.absence.etudiant.domain.model.Etudiant;
import com.absence.etudiant.domain.model.Matiere;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Long>{

	@Query("select sum(nbrHeure) from Absence ab where ab.etudiant =?1 and ab.matiere=?2")
	int nbrAbsence (Etudiant e,Matiere matiere);
	
	
//	Absence findAbsenceByEtudiantAndMatiere(Etudiant etudiant, Matiere matiere);
} 