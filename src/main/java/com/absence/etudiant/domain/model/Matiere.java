

package com.absence.etudiant.domain.model ;
 import com.fasterxml.jackson.annotation.*;
 import javax.persistence.*;
 import java.io.Serializable;
 import java.time.LocalDate;
 import java.util.*;

@Entity
@Table(name="Matiere")

public class  Matiere implements Serializable {
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;

@Column(name="Label")
     private String label; 
 @Column(name="NbrHeure")
     private Integer nbrHeure; 
 
 @Column(name="limite")
 private Integer limite;
 
 


public Integer getLimit() {
	return limite;
}

public void setLimit(Integer limit) {
	this.limite = limit;
}

@ManyToOne
 @JsonIgnoreProperties("matieres")
 private Classe classe ;
 @OneToMany(mappedBy="matiere")
 @JsonIgnore
 private Set<Absence>absences = new HashSet<>();

public Matiere() {
       super();
   }

public Matiere(String label  ,Integer nbrHeure  , Integer limit) {
    this.label =label;
    this.nbrHeure =nbrHeure;
    this.limite =limit ;
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

public Integer getNbrHeure() {
      return this.nbrHeure;
   }
 public void  setNbrHeure(Integer NbrHeure) {
        this.nbrHeure= NbrHeure;
  }

public void setClasse(Classe classe){
 this.classe = classe ; 
 }
 public Classe getClasse(){
 return this.classe ; 
 }
 public void setAbsences (Set<Absence> absence){
 this.absences = absence ; 
 }
 public Set<Absence> getAbsences (){
 return this.absences  ; 
 }

@Override
public String toString() {
	return "Matiere [id=" + id + ", label=" + label + ", nbrHeure=" + nbrHeure + ", classe=" + classe + ", absences="
			+ absences + "]";
}

}