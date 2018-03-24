package dao.uc3_Donner1Avis;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.Commentaires;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.Titres;


@LocalBean
@Singleton
public class DaoListe {

	@PersistenceContext(unitName="Nacerhibernate")
	EntityManager em; 
	
	/********************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les méthodes relatives *
	 ********************************************************************************/
	
	public Commentaires getAllCommParId() {
		Commentaires liste = new Commentaires();

		for (Object commentaire : em.createQuery("select c from Commentaire c order by c.cote asc").getResultList()) {   
			if (commentaire instanceof Commentaire) {
				liste.add((Commentaire) commentaire);
			}
		}
		return liste;
	}
	
	public Commentaire getCommParRef(int ref) throws DaoException {
		Commentaire commentaire =  em.find(Commentaire.class, ref);
		if (commentaire == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return commentaire;
	}
	
	
	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives *
	 **************************************************************************/
	
	public Titres getAllTitreParId() {
		Titres liste = new Titres();

		for (Object titre : em.createQuery("select t from Titre t order by t.idLocalisation asc").getResultList()) {   
			if (titre instanceof Titre) {
				liste.add((Titre) titre);
			}
		}
		return liste;
	}
	
	public Titre getTitreParRef(int ref) throws DaoException {
		Titre titre =  em.find(Titre.class, ref);
		if (titre == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return titre;
	}

	
	

}
