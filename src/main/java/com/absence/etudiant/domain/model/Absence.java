

package com.absence.etudiant.domain.model ;
 import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Absence")

public class  Absence implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;

@Column(name="NbrHeure")
     private Integer nbrHeure; 

@DateTimeFormat(pattern = "yyyy-MM-dd")
 @Column(name="DateAbsence")
     private LocalDate dateAbsence; 

@ManyToOne
 @JsonIgnoreProperties("absences")
 private Etudiant etudiant ;

 @ManyToOne
 @JsonIgnoreProperties("absences")
 private Matiere matiere ;

public Absence() {
       super();
   }

public Absence(Integer nbrHeure  ,LocalDate dateAbsence ) {
    this.nbrHeure =nbrHeure;
    this.dateAbsence =dateAbsence;
 }

public Long getId(){
return this.id;

}

public void setId(Long id){
this.id = id;

}
public Integer getNbrHeure() {
      return this.nbrHeure;
   }
 public void  setNbrHeure(Integer NbrHeure) {
        this.nbrHeure= NbrHeure;
  }

public LocalDate getDateAbsence() {
      return this.dateAbsence;
   }
 public void  setDateAbsence(LocalDate DateAbsence) {
        this.dateAbsence= DateAbsence;
  }

public void setEtudiant(Etudiant etudiant){
 this.etudiant = etudiant ; 
 }
 public Etudiant getEtudiant(){
 return this.etudiant ; 
 }
 public void setMatiere(Matiere matiere){
 this.matiere = matiere ; 
 }
 public Matiere getMatiere(){
 return this.matiere ; 
 }

}