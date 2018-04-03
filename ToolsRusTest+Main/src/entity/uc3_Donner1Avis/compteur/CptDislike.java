package entity.uc3_Donner1Avis.compteur;

public class CptDislike extends Compteur {

	private static final long serialVersionUID = 1L;

	private int compteurDislike;

	// Constructeur avec le compteur seulement car l'id est générée automatiquement.
	public CptDislike(int compteur) {
		this.compteurDislike = compteur;
	}


	public int getCompteurDislike() {
		return compteurDislike;
	}
	public void setCompteurDislike(int compteurDislike) {
		this.compteurDislike = compteurDislike;
	}

	@Override
	public String toString() {
		return "CptDislike [ compteurDislike = " + compteurDislike + " ]";
	}



}
