package entity.uc4;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * class Mot have an association with class Image
 * class Mot knows her Image wich associate
 * @author iceman
 *
 */

@Entity
@Table(name="Mot")
public class Mot implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable=false)
	private int 	idMot;
	private String 	libelleMot;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idImage", unique=true, nullable=true)
	private Image 	image;
	
	@ManyToMany()
	private Mots listeMot;
	
	
	
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
