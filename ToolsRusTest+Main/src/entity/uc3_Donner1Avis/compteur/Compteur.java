package entity.uc3_Donner1Avis.compteur;

import java.io.Serializable;

public abstract class Compteur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idCompteur;
	// nb de click sur le compteur
	private int compteur;

	public Compteur() {}

	public Compteur(int compteur) {
		this.compteur = compteur;
	}

//	public Compteur(int id, int compteur) {
//		this.idCompteur = id;
//		this.compteur = compteur;
//	}

	@Override
	public String toString() {
		return "idCompteur=" + idCompteur + ", compteur=" + compteur;
	}

	public int getIdCompteur() {
		return idCompteur;
	}
	public void setIdCompteur(int idCompteur) {
		this.idCompteur = idCompteur;
	}

	public int getCompteur() {
		return compteur;
	}
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public void compteurPlus1(){
		compteur = compteur++;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean resultat = false;
		
		if (obj instanceof Compteur) {
			Compteur compt = (Compteur) obj;
			if (compt.idCompteur == this.idCompteur && compt.compteur == this.compteur) resultat = true;
		}
		return resultat;
	}

}
