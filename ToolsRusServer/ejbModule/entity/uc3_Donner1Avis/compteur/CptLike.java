package entity.uc3_Donner1Avis.compteur;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ECF_CompteurLike") 
public class CptLike extends Compteur{

	private static final long serialVersionUID = 1L;

	public CptLike() {}

	//	public CptLike(int id, int compteur) {
	//	super(id,compteur);
	//}
	public CptLike(int compteur) {
		super(compteur);
	}

	@Override
	public String toString() {
		return "CptLike [ " + super.toString() + " ]";
	}


}
