package entity.uc4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * class Image in association with Mot
 * association also with class Fichier but not treated for the moment
 * @author iceman
 *
 */

@Entity
@Table(name="Image")
public class Image {
	
	@Id
	@Column(nullable=false)
	int 	idImage;
	String 	libelleImage;
	
	
	public Image(int idImage, String libelleImage) {
		super();
		this.idImage = idImage;
		this.libelleImage = libelleImage;
	}


	public int getIdImage() {
		return idImage;
	}


	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}


	public String getLibelleImage() {
		return libelleImage;
	}


	public void setLibelleImage(String libelleImage) {
		this.libelleImage = libelleImage;
	}


	@Override
	public String toString() {
		return "identifiant de l'Image= (" + idImage + ", libelle de l'Image=" + libelleImage + ")";
	}
	

}
