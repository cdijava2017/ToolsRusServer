package entity.uc3_Donner1Avis.compteur;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="ECF_Compteur")
public abstract class Compteur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idCompteur")
	//		@GeneratedValue(strategy = GenerationType.AUTO)     // à commenter/décommenter si la table contient ou non une séquence active
	//		@SequenceGenerator(name="seq_compteur", sequenceName="seq_compteur", initialValue=1)
	private int idCompteur;

	@Transient
	// somme des cptlike et dislike
	private int  clicTousCpt;

//	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name = "idComptLike", unique = true, nullable = true)
//	private CptLike idComptLike;
//
//	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name = "idComptDislike", unique = true, nullable = true)
//	private CptDislike idComptDislike;


	public Compteur() {}

	public Compteur(int id, int compteur) {
		this.idCompteur = id;
		this.clicTousCpt = compteur;
	}

	public Compteur(int id, int compteur, CptLike comptLike, CptDislike comptDislike) {
		this.idCompteur = id;
//
//		this.idComptLike = comptLike;
//		this.idComptDislike = comptDislike;
		
		//TODO calculer compteur
		this.clicTousCpt = compteur;
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", compteur=" + clicTousCpt + 
//				", ComptLike=" + idComptLike + ", ComptDislike=" + idComptDislike + 
				"]";
	}

	public int getIdCompteur() {
		return idCompteur;
	}
	public void setIdCompteur(int idCompteur) {
		this.idCompteur = idCompteur;
	}

	public int getCompteur() {
		return clicTousCpt;
	}
	public void setCompteur(int compteur) {
		this.clicTousCpt = compteur;
	}
//
//	public CptLike getComptLike() {
//		return idComptLike;
//	}
//	public void setComptLike(CptLike comptLike) {
//		this.idComptLike = comptLike;
//	}
//
//	public CptDislike getComptDislike() {
//		return idComptDislike;
//	}
//	public void setComptDislike(CptDislike comptDislike) {
//		this.idComptDislike = comptDislike;
//	}


	public boolean equals(Compteur compt) {
		boolean resultat;
		if (compt.idCompteur == this.idCompteur || compt.clicTousCpt == this.clicTousCpt) resultat = true;
		else resultat = false;
		return resultat;
	}

}
