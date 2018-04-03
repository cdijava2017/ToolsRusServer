package entity.uc3_Donner1Avis.compteur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ECF_CompteurLike") 
public class CptLike extends Compteur{

	private static final long serialVersionUID = 1L;

	@Column(name="comptLike", nullable=true)
	private int nbLike;

	// Constructeur avec le compteur seulement car l'id est générée automatiquement.
	public CptLike(int compteur) {
		this.nbLike = compteur;
	}


	public int getCompteurLike() {
		return nbLike;
	}
	public void setCompteurLike(int compteurLike) {
		this.nbLike = compteurLike;
	}

	@Override
	public String toString() {
		return "CptLike [ compteurLike = " + nbLike + " ]";
	}


}
