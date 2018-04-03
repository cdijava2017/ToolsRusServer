package entity.uc4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * class Mot have an association with class Image
 * class Mot knows her Image wich associate
 * @author iceman
 *
 */

@Entity
@Table(name="Mot")
public class Mot {
	
	@Id
	@Column(nullable=false)
	int 	idMot;
	String 	libelleMot;
	Image 	image;
	
	
	//constructor
	public Mot(int idMot, String libelleMot, Image image) {
		super();
		this.idMot = idMot;
		this.libelleMot = libelleMot;
		this.image = image;
	}


	public int getIdMot() {
		return idMot;
	}


	public void setIdMot(int idMot) {
		this.idMot = idMot;
	}


	public String getLibelleMot() {
		return libelleMot;
	}


	public void setLibelleMot(String libelleMot) {
		this.libelleMot = libelleMot;
	}

	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "identifiant du Mot= (" + idMot + ", libelle du Mot=" + libelleMot + ")";
	}
	

}
