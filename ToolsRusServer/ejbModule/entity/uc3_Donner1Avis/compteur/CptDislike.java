package entity.uc3_Donner1Avis.compteur;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ECF_CompteurDislike") 
public class CptDislike extends Compteur {

	private static final long serialVersionUID = 1L;

	public CptDislike() {}
	
//	public CptDislike(int id, int compteur) {
//		super(id,compteur);
//	}
	public CptDislike(int compteur) {
		super(compteur);
	}


	@Override
	public String toString() {
		return "CptDislike [ " + super.toString() + " ]";
	}



}
