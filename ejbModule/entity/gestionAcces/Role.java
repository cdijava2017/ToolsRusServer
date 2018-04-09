package entity.gestionAcces;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import parametreGestionAcces.Parametres;

/***********************************************************************
 * Module:  Role.java
 * Author:  zinks
 * Purpose: Defines the Class Role
 ***********************************************************************/

/** Class mere Role */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = Parametres.TBL_ROLE)

public abstract class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idRole")
	private int id;
	// @Column(name = "nom", length = 70, nullable = true)
	// private String nom;
	@Column(name = "admin", nullable = false)
	private boolean admin; // verif si ok admin ou pas -

	public Role() {

	}

	public Role(int id) {
		super();
	}

	public Role(int id, /* String nom, */ boolean admin) {
		super();
		this.id = id;
		// this.nom = nom;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nom=" + /* nom + */", admin=" + admin + "]";
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/*
	 * public String getNom() { return nom; }
	 * 
	 * public void setNom(String nom) { this.nom = nom; }
	 */
}