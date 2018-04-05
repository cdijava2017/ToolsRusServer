/***********************************************************************
 * Module: User.java 
 * Author: zinks 
 * Purpose: Defines the Class User
 ***********************************************************************/
package entity.gestionAcces;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import parametreGestionAcces.Parametres;



@Entity
@Table(name = Parametres.TBL_USER)
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** attributs */
	@Id
	@Column(name = "idUser")
	private int id;
	@Column(name = "pseudo", length = 70, nullable = true)
	private String pseudo;
	@Column(name = "pw", length = 70, nullable = true)
	private String pw;
	
	public User() {}

	public User(int id) {
		super();
		this.id = id;
	}
	
	public User(int id, String pseudo, String pw) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pseudo=" + pseudo + ", pw=" + pw + "]";
	}

	public int getId() {
		return id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getPw() {
		return pw;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}