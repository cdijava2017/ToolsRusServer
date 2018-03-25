package entity.uc3_Donner1Avis.commentaire;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entity.uc3_Donner1Avis.titre.Titre;
import utils.ICommentable;

/**
 * TODO Commenter cette classe au maximum
 * @author Nacer
 *
 */


@Entity
@Table(name="Commentaire") 
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
	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "idTitre", unique = true, nullable = false)
	private Titre titre;
	
	
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
	

	public String toString() {
		return "Commentaire = " + idComm + ", son titre est : " + titre.getTxtTitre();
	}
	
}
