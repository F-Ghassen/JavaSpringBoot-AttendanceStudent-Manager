

package com.absence.etudiant.domain.model ;
 import com.fasterxml.jackson.annotation.*;
 import javax.persistence.*;
 import java.io.Serializable;
 import java.time.LocalDate;
 import java.util.*;

@Entity
@Table(name="Classe")

public class  Classe implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;

@Column(name="Label")
     private String label; 
 @Column(name="NomComplet")
     private String NomComplet; 

@OneToMany(mappedBy="classe",cascade = CascadeType.ALL)
 @JsonIgnore
 private Set<Etudiant>etudiants = new HashSet<>();

 @OneToMany(mappedBy="classe",cascade = CascadeType.ALL)
 @JsonIgnore
 private Set<Matiere>matieres = new HashSet<>();

public Classe() {
       super();
   }

public Classe(String label  ,String NomComplet ) {
    this.label =label;
    this.NomComplet =NomComplet;
 }

public Long getId(){
return this.id;

}

public void setId(Long id){
this.id = id;

}
public String getLabel() {
      return this.label;
   }
 public void  setLabel(String Label) {
        this.label= Label;
  }

public String getNomComplet() {
      return this.NomComplet;
   }
 public void  setNomComplet(String NomComplet) {
        this.NomComplet= NomComplet;
  }

public void setEtudiants (Set<Etudiant> etudiant){
 this.etudiants = etudiant ; 
 }
 public Set<Etudiant> getEtudiants (){
 return this.etudiants  ; 
 }
 public void setMatieres (Set<Matiere> matiere){
 this.matieres = matiere ; 
 }
 public Set<Matiere> getMatieres (){
 return this.matieres  ; 
 }



}