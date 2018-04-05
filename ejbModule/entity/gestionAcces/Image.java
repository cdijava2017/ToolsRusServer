package entity.gestionAcces;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IdImage")
	private int id;

	@Override
	public String toString() {
		return "Image [id=" + id +"ton avatar"+ "]";
	}
}
