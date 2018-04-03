package entity.uc4;

public class Image {
	
	int 	idImage;
	String 	libelleImage;
	
	
	public Image(int idImage, String libelleImage) {
		super();
		this.idImage = idImage;
		this.libelleImage = libelleImage;
	}


	public int getIdImage() {
		return idImage;
	}


	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}


	public String getLibelleImage() {
		return libelleImage;
	}


	public void setLibelleImage(String libelleImage) {
		this.libelleImage = libelleImage;
	}


	@Override
	public String toString() {
		return "identifiant de l'Image= (" + idImage + ", libelle de l'Image=" + libelleImage + ")";
	}
	

}
