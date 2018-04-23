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
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;
import utils.ICommentable;

/**
 * La classe Commentaire est l'entity principale de ma partie. Une table est créée quand le serveur est lancé.
 * Les annotations @ servent à initier des comportements prédéfinis dans Jboss et Wildfly.
 * L'Id sera saisi par l'utilisateur dans le cadre de l'ECF mais le code pour mettre en place une séquence est mis en commentaire.
 * Les associations sont expliquées plus bas, juste avant celle qu'elles décrivent.
 * La méthode equals() a été personnalisée pour correspondre aux besoins de comparaison des commentaires entre eux.
 * 
 * @author Nacer
 *
 */


@Entity
@Table(name="ECF_Commentaire") 
public class Commentaire implements Serializable, ICommentable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numCommentaire")
	//  Le code commenté ci dessous servira si plus tard, on veut rajouter une séquence à la création d'un commentaire.
	//	Attention cependant à l'id du titre car celui ci est calqué sur l'id du commentaire.
	//	@GeneratedValue(strategy = GenerationType.AUTO)     // à commenter/décommenter si la table contient ou non une séquence active
	//	@SequenceGenerator(name="seq_comm", sequenceName="seq_comm", initialValue=1)
	private int idComm;
	@Column(name="txtCommentaire", length=500, nullable=false)
	private String  texteComm;
	/**
	 * Le titre est une association 1-1 avec la classe Titre. 
	 * Un commentaire n'a qu'un titre et un titre n'appartient qu'à un commentaire.
	 */
	@OneToOne (cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idTitre", unique = true, nullable = true)
	private Titre titre;
	/**
	 * La liste de compteurs est une association 1-plusieurs avec la classe Compteurs. 
	 * Un commentaire a une liste de compteur (2 à chaque fois) et une liste de compteurs n'appartient qu'à un commentaire.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "idCommentaire", nullable = true)
	private Collection<Compteur> listeCompteurs = null;


	/**
	 * Constructeur vide par défaut
	 */
	public Commentaire() {
		this.listeCompteurs = new ArrayList<Compteur>();
	}
	/**
	 *  Constructeur standard avec @param idComm et @param texteComm. 
	 */
	public Commentaire(int idComm, String texteComm) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.listeCompteurs = new ArrayList<Compteur>();
	}
	/**
	 *  Constructeur avec le titre en plus. 
	 *  @param idComm, @param texteComm et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
		this.listeCompteurs = new ArrayList<Compteur>();
	}
	/**
	 *  Constructeur avec le titre et la liste de compteurs en plus. 
	 *  @param idComm, @param texteComm, @param compteurs et @param titre. 
	 */
	public Commentaire(int idComm, String texteComm, Titre titre, ArrayList<Compteur> compteurs) {
		this.idComm = idComm;
		this.texteComm = texteComm;
		this.titre = titre;
		if (compteurs != null) this.listeCompteurs = compteurs;
		else this.listeCompteurs = new ArrayList<Compteur>();
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

	public Collection<Compteur> getListeCompteurs() {
		return listeCompteurs;
	}
	public void setListeCompteurs(Collection<Compteur> compteurs) {
		this.listeCompteurs = compteurs;
	}
	public void addCompteur(Compteur compteur) {
		this.listeCompteurs.add(compteur);
	}

	@Override
	public String toString() {
		return "Commentaire [idComm=" + idComm + ", texteComm=" + texteComm + ", titre=" + titre + ", compteurs="
				+ listeCompteurs + "]";
	}

	public boolean equals(Commentaire comm) {			
		boolean resultat;
		if (comm.idComm == this.idComm || comm.texteComm == this.texteComm) resultat = true;
		else resultat = false;
		return resultat;
	}
	
	public void incrementDislike() {					// incrémente de +1 le compteur de Dislike dans la listes des compteurs du commentaire
		for (Compteur cpt : listeCompteurs) {
			if (cpt instanceof CptDislike) cpt.compteurPlus1();
		}		
	}
	public void incrementLike() {						// incrémente de +1 le compteur de Like dans la liste des compteurs du commentaire
		for (Compteur cpt : listeCompteurs) {
			if (cpt instanceof CptLike) cpt.compteurPlus1();
		}		
	}
	
	public Compteur getCptDislike() {					// récupère le compteur de Dislike dans la liste des compteurs du commentaire
		CptDislike cptDislike = null;
		for (Compteur cpt : listeCompteurs) {
			if (cpt instanceof CptDislike) cptDislike = (CptDislike) cpt;
		}		
		return cptDislike;
	}
	public Compteur getCptLike() {						// récupère le compteur de Like dans la liste des compteurs du commentaire
		CptLike cptLike = null;
		for (Compteur cpt : listeCompteurs) {
			if (cpt instanceof CptLike) cptLike = (CptLike) cpt;
		}	
		return cptLike;
	}
	/**
	 * La méthode commToDto() convertie un commentaire retourné par la base en un Objet de classe Commentaire. 
	 * Ceci afin de pouvoir l'utiliser sans avoir de conflit de typage.
	 * @return commToDo qui est un commentaire modifié
	 */
	public Commentaire commToDto() {
		Commentaire commToDto = new Commentaire(this.getIdComm(), this.getTexteComm());
		if (this.getTitre() != null) commToDto.setTitre(this.getTitre().titreToDto());
		if (this.getListeCompteurs() != null) {
			ArrayList<Compteur> cptToDto = new ArrayList<>();
			for (Compteur compteur : this.getListeCompteurs()) {
				Compteur compteurDto = compteur.cptToDto();
				cptToDto.add(compteurDto);
			}
			commToDto.setListeCompteurs(cptToDto);
		}
		return commToDto;
	}
	
}
