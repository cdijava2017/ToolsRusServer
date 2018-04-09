/***********************************************************************
 * Module:  Participant.java
 * Author:  zinks
 * Purpose: Defines the Class Participant
 ***********************************************************************/

package entity.gestionAcces;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import parametreGestionAcces.Parametres;

@Entity
@Table(name = Parametres.TBL_PARTICIPANT)
/** Class Fille Participant herite de Role */
public class Participant extends Role implements Serializable {

	
	public Participant() {
		super();
	}

	public Participant(int id,boolean admin) {
		super(id, /*nom,*/ admin);
	}

	public Participant(int id) {
		super(id);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Participant [isAdmin()=" + isAdmin() + ", getId()=" + getId() +/* ", getNom()=" + getNom() +*/ "]";
	}
	
}