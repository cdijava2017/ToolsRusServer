package entity.uc3_Donner1Avis.compteur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ECF_Compteur")
public class Compteur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idCompteur")
	//		@GeneratedValue(strategy = GenerationType.AUTO)     // à commenter/décommenter si la table contient ou non une séquence active
	//		@SequenceGenerator(name="seq_compteur", sequenceName="seq_compteur", initialValue=1)
	private int idCompteur;

	@Column(name="compteur", nullable=true)
	private int  compteur;

	public Compteur() {}

	public Compteur(int id, int compteur) {
		this.idCompteur = id;
		this.compteur = compteur;
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", compteur=" + compteur + "]";
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


}
