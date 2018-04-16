package dao.uc3_Donner1Avis;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.Titres;
/**
 * <p>	Classe gérant la partie Dao qui sert à lister les commentaires. Etant donné que tout est en cascade, nous n'aurons pas besoin 
 * 		des parties pour les Titres et les Compteurs mais dans un soucis d'évolution, elles ont quand même été codées.		</p>
 * @author Stag
 *
 */

@LocalBean
@Singleton
public class DaoListe {

	@PersistenceContext(unitName="DMhibernate")
	EntityManager em; 
	
	/********************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les méthodes relatives *
	 ********************************************************************************/
	
	public ArrayList<Commentaire> getAllCommParId() {
		System.out.println("DaoListe méthode getAllCommParId()");
		ArrayList<Commentaire> liste = new ArrayList<Commentaire>();

		for (Object commentaire : em.createQuery("select c from Commentaire c order by c.idComm asc").getResultList()) {   
			if (commentaire instanceof Commentaire) {
				liste.add((Commentaire) commentaire);
			}
		}
		return liste;
	}
	
	public Commentaire getCommParRef(int ref) throws DaoException {
		System.out.println("DaoListe méthode getCommParRef()");
		Commentaire commentaire =  em.find(Commentaire.class, ref);
		if (commentaire == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return commentaire;
	}
	
	
	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les méthodes relatives *
	 **************************************************************************/
	
	public Titres getAllTitreParId() {
		System.out.println("DaoListe méthode getAllTitreParId()");
		Titres liste = new Titres();

		for (Object titre : em.createQuery("select t from Titre t order by t.idTitre asc").getResultList()) {   
			if (titre instanceof Titre) {
				liste.add((Titre) titre);
			}
		}
		return liste;
	}
	
	public Titre getTitreParRef(int ref) throws DaoException {
		System.out.println("DaoListe méthode getTitreParRef()");
		Titre titre =  em.find(Titre.class, ref);
		if (titre == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return titre;
	}

	/*****************************************************************************
	 * Cette partie concerne les Compteurs et aura toutes les méthodes relatives *
	 *****************************************************************************/
	
	public Compteurs getAllCompteurParId() {
		System.out.println("DaoListe méthode getAllCompteurParId()");
		Compteurs liste = new Compteurs();

		for (Object compteur : em.createQuery("select c from Compteur c order by c.idCompteur asc").getResultList()) {   
			if (compteur instanceof Compteur) {
				liste.add((Compteur) compteur);
			}
		}
		return liste;
	}
	
	public Compteur getCompteurParRef(int ref) throws DaoException {
		System.out.println("DaoListe méthode getCompteurParRef()");
		Compteur compteur =  em.find(Compteur.class, ref);
		if (compteur == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return compteur;
	}


	
	

}
