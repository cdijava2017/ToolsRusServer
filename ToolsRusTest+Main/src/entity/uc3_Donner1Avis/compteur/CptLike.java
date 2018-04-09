package entity.uc3_Donner1Avis.compteur;

public class CptLike extends Compteur{

	private static final long serialVersionUID = 1L;

	public CptLike() {}

	//	public CptLike(int id, int compteur) {
	//	super(id,compteur);
	//}
	public CptLike(int compteur) {
		super(compteur);
	}

	public CptLike(int idCompteur, int compteur) {
		super(idCompteur, compteur);
	}

	@Override
	public String toString() {
		return "CptLike [ " + super.toString() + " ]";
	}


}
