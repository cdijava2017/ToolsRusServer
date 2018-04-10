package entity.uc4;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * class Image in association with Mot
 * association also with class Fichier but not treated for the moment
 * @author iceman
 *
 */

@Entity
@Table(name="Image")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public /*abstract*/ class Image implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idimage", nullable=false)
	private int 	idImage;
	
	@Column(name="libelleimage", length=30, nullable=true)
	private String 	libelleImage;
	
	@Column(name="fichier", nullable=true)
	private Fichier fichier;
	
	
	public Image(int idImage, String libelleImage) {
		super();
		this.idImage 		= idImage;
		this.libelleImage 	= libelleImage;
	}
	
	public Image(int idImage, String libelleImage, Fichier fichier) {
		super();
		this.idImage 		= idImage;
		this.libelleImage 	= libelleImage;
		this.fichier 		= fichier;
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


	public Fichier getFichier() {
		return fichier;
	}


	public void setFichier(Fichier fichier) {
		this.fichier = fichier;
	}


	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", libelleImage=" + libelleImage + ", fichier=" + fichier + "]";
	}
	

}
