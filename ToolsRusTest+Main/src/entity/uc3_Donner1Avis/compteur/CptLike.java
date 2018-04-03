package entity.uc3_Donner1Avis.compteur;

public class CptLike extends Compteur{

	private static final long serialVersionUID = 1L;

	private int compteurLike;

	// Constructeur avec le compteur seulement car l'id est générée automatiquement.
	public CptLike(int compteur) {
		this.compteurLike = compteur;
	}


	public int getCompteurLike() {
		return compteurLike;
	}
	public void setCompteurLike(int compteurLike) {
		this.compteurLike = compteurLike;
	}

	@Override
	public String toString() {
		return "CptLike [ compteurLike = " + compteurLike + " ]";
	}


}
