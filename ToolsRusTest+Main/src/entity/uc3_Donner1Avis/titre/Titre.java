package entity.uc3_Donner1Avis.titre;

import java.io.Serializable;


public class Titre  implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idTitre;
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

	public Titre titreToDto() {
		return new Titre(this.getIdTitre(), this.getTxtTitre());
	}
	
}
