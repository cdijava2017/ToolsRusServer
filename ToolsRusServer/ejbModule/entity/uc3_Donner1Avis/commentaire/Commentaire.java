package entity.uc3_Donner1Avis.commentaire;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.titre.Titre;
import utils.ICommentable;

/**
 * TODO Commenter cette classe au maximum
 * @author Nacer
 *
 */


@Entity
@Table(name="ECF_Commentaire") 
public class Commentaire implements Serializable, ICommentable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numCommentaire")
	//	@GeneratedValue(strategy = GenerationType.AUTO)     // à commenter/décommenter si la table contient ou non une séquence active
	//	@SequenceGenerator(name="seq_comm", sequenceName="seq_comm", initialValue=1)
	private int idComm;

	@Column(name="txtCommentaire", length=100, nullable=false)
	private String  texteComm;
	/**
	 * Le titre est une association 1-1 avec la classe Titre. 
	 * Un commentaire n'a qu'un titre et un titre n'appartient qu'à un commentaire.
	 */
	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idTitre", unique = true, nullable = true)
	private Titre titre;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idCommentaire", nullable = true)
	private Collection<Compteur> compteurs;


	/**
	 * Constructeur vide par défaut
	 */
	public Commentaire() {}
	/**
	 *  Constructeur standard avec @param idComm et @param texteComm. 
	 */
	public Commentaire(int idComm, String texteComm) {
		this.idComm = idComm;
		this.texteComm = texteComm;
	}
	/**
	 *  Constructeur avec le titre en plus. 
	 *  @param idComm, @param texteComm et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
	}
	/**
	 *  Constructeur avec le titre et la liste de compteurs en plus. 
	 *  @param idComm, @param texteComm, @param compteur et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre, ArrayList<Compteur> compteurs) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
		this.compteurs = new ArrayList<Compteur>();
	}


	public int getIdComm() {
		return idComm;
	}
	public void setIdComm(int idComm) {
		this.idComm = idComm;
	}

	public String getTexteComm() {
		return texteComm;
	}
	public void setTexteComm(String texteComm) {
		this.texteComm = texteComm;
	}

	public Titre getTitre() {
		return titre;
	}
	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public Collection<Compteur> getCompteurs() {
		return compteurs;
	}
	public void setCompteurs(ArrayList<Compteur> compteurs) {
		this.compteurs = compteurs;
	}
	public void addCompteur(Compteur compteur) {
		compteurs.add(compteur);
	}


	@Override
	public String toString() {
		return "Commentaire [idComm=" + idComm + ", texteComm=" + texteComm + ", titre=" + titre + ", compteurs="
				+ compteurs + "]";
	}

	public boolean equals(Commentaire comm) {
		boolean resultat;
		if (comm.idComm == this.idComm || comm.texteComm == this.texteComm) resultat = true;
		else resultat = false;
		return resultat;
	}
}
