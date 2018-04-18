package entity.uc4;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * class Mot have an association with class Image
 * class Mot knows her Image wich associate
 * inheritance for class MotHumeur and Theme: one table by concrete class
 * @author iceman
 *
 */

@Entity
@Table(name="Mot", uniqueConstraints = {@UniqueConstraint(columnNames="libellemot")})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Mot implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idmot", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int 	idMot;
	
	@Column(name="libellemot", length=50, nullable=false)
	private String 	libelleMot;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="idImage", unique=true, nullable=true)
	private Image 	image;
	
//	@ManyToMany()
//	this relation could be analysed this way: a word can contain many words, like a compound word:
//	court-circuit is the association of the word "court" and the word "circuit".
//	TODO
	
	//default constructor
	public Mot() {
		super();
		}
	
	//constructor
	public Mot(int idMot, String libelleMot, Image image) {
		super();
		this.idMot = idMot;
		this.libelleMot = libelleMot;
		this.image = image;
	}
	
	//constructor for the classes which inheritence, like class MotHumeur or Theme
	public Mot(int idMot, String libelleMot) {
		super();
		this.idMot = idMot;
		this.libelleMot = libelleMot;
		
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
		return "identifiant du Mot= " + idMot + ", libelle du Mot=" + libelleMot;
	}

	
	

}
