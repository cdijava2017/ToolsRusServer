package entity.uc4;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fichier")
public class Fichier implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idfichier", nullable=false)
	private int idFichier;
	
	@Column(name="libellefichier", length=50, nullable=false)
	private String libelleFichier;

	public Fichier(int idFichier, String libelleFichier) {
		super();
		this.idFichier = idFichier;
		this.libelleFichier = libelleFichier;
	}

	public int getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(int idFichier) {
		this.idFichier = idFichier;
	}

	public String getLibelleFichier() {
		return libelleFichier;
	}

	public void setLibelleFichier(String libelleFichier) {
		this.libelleFichier = libelleFichier;
	}

	@Override
	public String toString() {
		return "Fichier [idFichier=" + idFichier + ", libelleFichier=" + libelleFichier + "]";
	}
	
	

}
