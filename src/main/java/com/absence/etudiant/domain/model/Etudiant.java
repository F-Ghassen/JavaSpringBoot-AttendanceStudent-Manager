

package com.absence.etudiant.domain.model ;
 import com.fasterxml.jackson.annotation.*;
 import javax.persistence.*;
 import java.io.Serializable;
 import java.time.LocalDate;
 import java.util.*;

@Entity
@Table(name="Etudiant")

public class  Etudiant implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;

@Column(name="Matricule")
     private Long matricule; 
 @Column(name="Nom")
     private String nom; 
 @Column(name="Prenom")
     private String prenom; 
 @Column(name="Email")
     private String email; 
 @Column(name="Datenaissence")
     private LocalDate datenaissence; 

@OneToMany(mappedBy="etudiant")
 @JsonIgnore
 private Set<Absence>absences = new HashSet<>();

 @ManyToOne
 @JsonIgnoreProperties("etudiants")
 private Classe classe ;

public Etudiant() {
       super();
   }

public Etudiant(Long matricule  ,String nom  ,String prenom  ,String email  ,LocalDate datenaissence ) {
    this.matricule =matricule;
    this.nom =nom;
    this.prenom =prenom;
    this.email =email;
    this.datenaissence =datenaissence;
 }

public Long getId(){
return this.id;

}

public void setId(Long id){
this.id = id;

}
public Long getMatricule() {
      return this.matricule;
   }
 public void  setMatricule(Long Matricule) {
        this.matricule= Matricule;
  }

public String getNom() {
      return this.nom;
   }
 public void  setNom(String Nom) {
        this.nom= Nom;
  }

public String getPrenom() {
      return this.prenom;
   }
 public void  setPrenom(String Prenom) {
        this.prenom= Prenom;
  }

public String getEmail() {
      return this.email;
   }
 public void  setEmail(String Email) {
        this.email= Email;
  }

public LocalDate getDatenaissence() {
      return this.datenaissence;
   }
 public void  setDatenaissence(LocalDate Datenaissence) {
        this.datenaissence= Datenaissence;
  }

public void setAbsences (Set<Absence> absence){
 this.absences = absence ; 
 }
 public Set<Absence> getAbsences (){
 return this.absences  ; 
 }
 public void setClasse(Classe classe){
 this.classe = classe ; 
 }
 public Classe getClasse(){
 return this.classe ; 
 }

@Override
public String toString() {
	return "Etudiant [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", email="
			+ email + ", datenaissence=" + datenaissence + ", absences=" + absences + ", classe=" + classe + "]";
}

}