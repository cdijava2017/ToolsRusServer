package entity.uc3_Donner1Avis.compteur;

import java.io.Serializable;

public abstract class Compteur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idCompteur;
	private int compteur;
	private CptLike idComptLike;
	private CptDislike idComptDislike;


	public Compteur() {}

	public Compteur(int id, int compteur) {
		this.idCompteur = id;
		this.compteur = compteur;
	}

	public Compteur(int id, int compteur, CptLike comptLike, CptDislike comptDislike) {
		this.idCompteur = id;
		this.compteur = compteur;
		this.idComptLike = comptLike;
		this.idComptDislike = comptDislike;
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", compteur=" + compteur + ", ComptLike=" + idComptLike
				+ ", ComptDislike=" + idComptDislike + "]";
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

	public CptLike getComptLike() {
		return idComptLike;
	}
	public void setComptLike(CptLike comptLike) {
		this.idComptLike = comptLike;
	}

	public CptDislike getComptDislike() {
		return idComptDislike;
	}
	public void setComptDislike(CptDislike comptDislike) {
		this.idComptDislike = comptDislike;
	}


	public boolean equals(Compteur compt) {
		boolean resultat;
		if (compt.idCompteur == this.idCompteur || compt.compteur == this.compteur) resultat = true;
		else resultat = false;
		return resultat;
	}

}
