package entity.uc3_Donner1Avis.commentaire;

import java.io.Serializable;

import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.titre.Titre;

/**
 * TODO Commenter cette classe au maximum
 * @author Nacer
 *
 */

public class Commentaire implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idComm;
	private String  texteComm;
	private Titre titre;
	private Compteur compteur;
	
	
	/**
	 * Constructeur vide par défaut
	 */
	public Commentaire() {}
	/**
	 *  Constructeur standard avec @param idComm et @param texteComm. 
	 */
	public Commentaire(int idComm, String texteComm) {
		this.idComm = idComm;
		this.texteComm = texteComm;
	}
	/**
	 *  Constructeur avec le titre en plus. 
	 *  @param idComm, @param texteComm et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
	}
	/**
	 *  Constructeur avec le titre en plus. 
	 *  @param idComm, @param texteComm et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre, Compteur compteur) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
		this.compteur = compteur;
	}

	
	public int getIdComm() {
		return idComm;
	}
	public void setIdComm(int idComm) {
		this.idComm = idComm;
	}

	public String getTexteComm() {
		return texteComm;
	}
	public void setTexteComm(String texteComm) {
		this.texteComm = texteComm;
	}

	public Titre getTitre() {
		return titre;
	}
	public void setTitre(Titre titre) {
		this.titre = titre;
	}
	

	public Compteur getCompteur() {
		return compteur;
	}
	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}
	@Override
	public String toString() {
		return "Commentaire [idComm=" + idComm + ", texteComm=" + texteComm + ", titre=" + titre + ", compteur="
				+ compteur + "]";
	}
	
}
