package entity.uc3_Donner1Avis.titre;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import entity.uc3_Donner1Avis.compteur.Compteur;
import utils.ICommentable;

@Entity
@Table(name="ECF_Titre")
public class Titre  implements Serializable, ICommentable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idTitre")
//	@GeneratedValue(strategy = GenerationType.AUTO)     // � commenter/d�commenter si la table contient ou non une s�quence active
//	@SequenceGenerator(name="seq_titre", sequenceName="seq_titre", initialValue=1)
	private int idTitre;
	
	@Column(name="txtTitre", length=100, nullable=false)
	private String  txtTitre;
	
	
	public Titre() {}
	
	public Titre(int idTitre, String txtTitre) {
		this.idTitre = idTitre;
		this.txtTitre = txtTitre;
	}

	public int getIdTitre() {
		return idTitre;
	}
	public void setIdTitre(int idTitre) {
		this.idTitre = idTitre;
	}

	public String getTxtTitre() {
		return txtTitre;
	}
	public void setTxtTitre(String txtTitre) {
		this.txtTitre = txtTitre;
	}
	
	
	public String toString() {
		return "Titre = " + idTitre + ", txtTitre = " + txtTitre;
	}
	
	public boolean equals(Titre titre) {
		boolean resultat;
		if (titre.idTitre == this.idTitre || titre.txtTitre == this.txtTitre) resultat = true;
		else resultat = false;
		return resultat;
	}
	
}
