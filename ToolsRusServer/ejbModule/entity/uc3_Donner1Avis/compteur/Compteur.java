package entity.uc3_Donner1Avis.compteur;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="ECF_Compteur")
public abstract class Compteur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idCompteur")
	@GeneratedValue(strategy = GenerationType.AUTO)     // à commenter/décommenter si la table contient ou non une séquence active
	@SequenceGenerator(name="seq_compteur", sequenceName="seq_compteur", initialValue=1)
	private int idCompteur;
	
	@Column(name="nbClick", nullable=true)
	private int compteur;

//	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
////	@JoinColumn(name = "idComptLike", unique = true, nullable = true)
//	private CptLike comptLike;
//
//	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
////	@JoinColumn(name = "idComptDislike", unique = true, nullable = true)
//	private CptDislike comptDislike;


	public Compteur() {}
	
	public Compteur(int compteur) {
		this.compteur = compteur;
	}

//	public Compteur(int id, int compteur) {
//		this.idCompteur = id;
//		this.compteur = compteur;
//	}

	@Override
	public String toString() {
		return "idCompteur=" + idCompteur + ", compteur=" + compteur;
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
	
	public void compteurPlus1(){
		compteur = compteur++;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resultat = false;
		
		if (obj instanceof Compteur) {
			Compteur compt = (Compteur) obj;
			if (compt.idCompteur == this.idCompteur && compt.compteur == this.compteur) resultat = true;
		}
		return resultat;
	}

}
