package entity.uc3_Donner1Avis.compteur;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ECF_CompteurDislike") 
public class CptDislike extends Compteur {

	private static final long serialVersionUID = 1L;

	@Column(name="comptDislike", nullable=true)
	private int nbDislike;

	// Constructeur avec le compteur seulement car l'id est générée automatiquement.
	public CptDislike(int compteur) {
		this.nbDislike = compteur;
	}


	public int getCompteurDislike() {
		return nbDislike;
	}
	public void setCompteurDislike(int compteurDislike) {
		this.nbDislike = compteurDislike;
	}

	@Override
	public String toString() {
		return "CptDislike [ compteurDislike = " + nbDislike + " ]";
	}



}
