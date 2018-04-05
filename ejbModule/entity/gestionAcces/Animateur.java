package entity.gestionAcces;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import parametreGestionAcces.Parametres;

/************************************************************************
 * Module: Animateur.java
 * Author:  zinks 
 * Purpose: Defines the Class Role
 ***********************************************************************/

@Entity

@Table(name = Parametres.TBL_ANIMATEUR)
/** Class Fille animateur herite de Role */
public class Animateur extends Role implements Serializable {

	public Animateur(int id) {
		super(id);
	}
	public Animateur(){

	}
	public Animateur(int id, String nom, boolean admin) {
		super(id, nom, admin);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Animateur [isAdmin()=" + isAdmin() + ", getId()=" + getId() + ", getNom()=" + getNom() + "]";
		}
}