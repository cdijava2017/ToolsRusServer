/***********************************************************************
 * Module:  SuperAdmin.java
 * Author:  zinks
 * Purpose: Defines the Class SuperAdmin
 ***********************************************************************/

package entity.gestionAcces;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import parametreGestionAcces.Parametres;

@Entity

@Table(name = Parametres.TBL_SUPERADMIN)
/** Defines the Class SuperAdmin herite de role */
public class SuperAdmin extends Role implements Serializable {

	public SuperAdmin() {
		super();
	}

	public SuperAdmin(int id, String nom, boolean admin) {
		super(id, nom, admin);
	}

	public SuperAdmin(int id) {
		super(id);
	}

	@Override
	public String toString() {
		return "SuperAdmin [isAdmin()=" + isAdmin() + ", getId()=" + getId() + ", getNom()=" + getNom() + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}