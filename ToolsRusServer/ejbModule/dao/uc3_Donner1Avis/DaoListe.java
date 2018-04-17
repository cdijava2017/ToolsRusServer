package dao.uc3_Donner1Avis;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.Compteurs;
import entity.uc3_Donner1Avis.titre.Titre;
import entity.uc3_Donner1Avis.titre.Titres;
/**
 * <p>	Classe g�rant la partie Dao qui sert � lister les commentaires. Etant donn� que tout est en cascade, nous n'aurons pas besoin 
 * 		des parties pour les Titres et les Compteurs mais dans un soucis d'�volution, elles ont quand m�me �t� cod�es.		</p>
 * @author Stag
 *
 */

@LocalBean
@Singleton
public class DaoListe {

	@PersistenceContext(unitName=UtilBdD.PERSISTANCE_UNITNAME2)
	EntityManager em; 
	
	/********************************************************************************
	 * Cette partie concerne les Commentaires et aura toutes les m�thodes relatives 
	 * @throws DaoException *
	 ********************************************************************************/
	
	public ArrayList<Commentaire> getAllCommParId() throws CommentaireException {
		System.out.println("DaoListe m�thode getAllCommParId()");
		ArrayList<Commentaire> liste = new ArrayList<Commentaire>();
		if (em.createQuery(UtilBdD.GET_ALL_COMM).getResultList() == null)  throw new CommentaireException(DaoErrorMessage.ERR_LISTE_VIDE);
		for (Object commentaire : em.createQuery(UtilBdD.GET_ALL_COMM).getResultList()) {   
			if (commentaire instanceof Commentaire) {
				liste.add((Commentaire) commentaire);
			}
		}
		return liste;
	}
	
	public Commentaire getCommParRef(int ref) throws DaoException {
		System.out.println("DaoListe m�thode getCommParRef()");
		Commentaire commentaire =  em.find(Commentaire.class, ref);
		if (commentaire == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return commentaire;
	}
	
	
	/**************************************************************************
	 * Cette partie concerne les Titres et aura toutes les m�thodes relatives *
	 **************************************************************************/
	
	public Titres getAllTitreParId() {
		System.out.println("DaoListe m�thode getAllTitreParId()");
		Titres liste = new Titres();

		for (Object titre : em.createQuery(UtilBdD.GET_ALL_TITRE).getResultList()) {   
			if (titre instanceof Titre) {
				liste.add((Titre) titre);
			}
		}
		return liste;
	}
	
	public Titre getTitreParRef(int ref) throws DaoException {
		System.out.println("DaoListe m�thode getTitreParRef()");
		Titre titre =  em.find(Titre.class, ref);
		if (titre == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return titre;
	}

	/*****************************************************************************
	 * Cette partie concerne les Compteurs et aura toutes les m�thodes relatives *
	 *****************************************************************************/
	
	public Compteurs getAllCompteurParId() {
		System.out.println("DaoListe m�thode getAllCompteurParId()");
		Compteurs liste = new Compteurs();

		for (Object compteur : em.createQuery(UtilBdD.GET_ALL_COMPTEUR).getResultList()) {   
			if (compteur instanceof Compteur) {
				liste.add((Compteur) compteur);
			}
		}
		return liste;
	}
	
	public Compteur getCompteurParRef(int ref) throws DaoException {
		System.out.println("DaoListe m�thode getCompteurParRef()");
		Compteur compteur =  em.find(Compteur.class, ref);
		if (compteur == null) throw new DaoException(DaoErrorMessage.ERR_INEXISTANT);
		return compteur;
	}


	
	

}
