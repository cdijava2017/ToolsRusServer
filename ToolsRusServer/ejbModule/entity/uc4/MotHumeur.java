package entity.uc4;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MotHumeur")

public class MotHumeur extends Mot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="idHumeur", length=20)
	private int 	idHumeur;
	
	@Column(name="libelleHumeur", length=50)
	private String 	libelleHumeur;
	
		
	
	public MotHumeur() {
		super();
		
	}

	public MotHumeur(int idMot, String libelleMot, Image image,int idHumeur, String libelleHumeur) {
		super(idMot, libelleMot, image);
		this.idHumeur = idHumeur;
		this.libelleHumeur = libelleHumeur;
	}

	public MotHumeur(int idMot, String libelleMot, Image image) {
		super(idMot, libelleMot, image);
		
	}


	public MotHumeur(int idHumeur, String libelleHumeur) {
		super();
		this.idHumeur = idHumeur;
		this.libelleHumeur = libelleHumeur;
	}


	public int getIdHumeur() {
		return idHumeur;
	}


	public void setIdHumeur(int idHumeur) {
		this.idHumeur = idHumeur;
	}


	public String getLibelleHumeur() {
		return libelleHumeur;
	}


	public void setLibelleHumeur(String libelleHumeur) {
		this.libelleHumeur = libelleHumeur;
	}


	@Override
	public String toString() {
		return "MotHumeur [idHumeur=" + idHumeur + ", libelleHumeur=" + libelleHumeur + "]";
	}
	
	

}
