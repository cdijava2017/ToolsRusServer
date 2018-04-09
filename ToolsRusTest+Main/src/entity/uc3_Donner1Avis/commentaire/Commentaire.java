package entity.uc3_Donner1Avis.commentaire;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;
import utils.ICommentable;


/**
 * TODO Commenter cette classe au maximum
 * @author Nacer
 *
 */

public class Commentaire implements Serializable, ICommentable {

	private static final long serialVersionUID = 1L;
	
	private int idComm;
	private String  texteComm;
	private Titre titre;
	private Collection<Compteur> listeCompteurs = null;


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
		this.listeCompteurs = new ArrayList<Compteur>();
	}
	/**
	 *  Constructeur avec le titre en plus. 
	 *  @param idComm, @param texteComm et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
		this.listeCompteurs = new ArrayList<Compteur>();
	}
	/**
	 *  Constructeur avec le titre et la liste de compteurs en plus. 
	 *  @param idComm, @param texteComm, @param compteur et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre, ArrayList<Compteur> compteurs) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
		this.listeCompteurs = new ArrayList<Compteur>();
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

	public Collection<Compteur> getCompteurs() {
		return listeCompteurs;
	}
	public void setCompteurs(ArrayList<Compteur> compteurs) {
		this.listeCompteurs = compteurs;
	}
	public void addCompteur(Compteur compteur) {
		this.listeCompteurs.add(compteur);
	}


	@Override
	public String toString() {
		return "Commentaire [idComm=" + idComm + ", texteComm=" + texteComm + ", titre=" + titre + ", compteurs="
				+ listeCompteurs + "]";
	}

	public boolean equals(Commentaire comm) {
		boolean resultat;
		if (comm.idComm == this.idComm || comm.texteComm == this.texteComm) resultat = true;
		else resultat = false;
		return resultat;
	}
	
	public void incrementDislike() {
		for (Compteur cpt : listeCompteurs) {
			if (cpt instanceof CptDislike) cpt.compteurPlus1();
		}		
	}
	public void incrementLike() {
		for (Compteur cpt : listeCompteurs) {
			if (cpt instanceof CptLike) cpt.compteurPlus1();
		}		
	}
	
	public Commentaire commToDto() {
		Commentaire commToDto = new Commentaire(this.getIdComm(), this.getTexteComm());
		if (this.getTitre() != null) commToDto.setTitre(this.getTitre().titreToDto());
		if (this.getCompteurs() != null) {
			ArrayList<Compteur> cptToDto = new ArrayList<>();
			for (Compteur compteur : this.getCompteurs()) {
				Compteur compteurDto = compteur.cptToDto();
				cptToDto.add(compteurDto);
			}
			commToDto.setCompteurs(cptToDto);
		}
		return commToDto;
	}
}
