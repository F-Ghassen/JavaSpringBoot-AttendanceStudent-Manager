package com.absence.etudiant.domain.model;

public class NbrAbsence {

	private Etudiant etudiant;
	private Matiere matiere ;
	private int nbAbsence ;
	
	
	
	public NbrAbsence() {
		super();
	}

	public NbrAbsence(Etudiant etudiant, Matiere matiere, int nbAbsence) {
		super();
		this.etudiant = etudiant;
		this.matiere = matiere;
		this.nbAbsence = nbAbsence;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public int getNbAbsence() {
		return nbAbsence;
	}
	public void setNbAbsence(int nbAbsence) {
		this.nbAbsence = nbAbsence;
	}

	@Override
	public String toString() {
		return "NbrAbsence [etudiant=" + etudiant + ", matiere=" + matiere + ", nbAbsence=" + nbAbsence + "]";
	}
	
	
}
