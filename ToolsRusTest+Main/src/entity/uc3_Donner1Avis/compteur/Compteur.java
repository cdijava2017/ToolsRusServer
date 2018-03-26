package entity.uc3_Donner1Avis.compteur;

import java.io.Serializable;

public class Compteur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idCompteur;
	private int compteur;

	public Compteur() {}

	public Compteur(int id, int compteur) {
		this.idCompteur = id;
		this.compteur = compteur;
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", compteur=" + compteur + "]";
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


}
