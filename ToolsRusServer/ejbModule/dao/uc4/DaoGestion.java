package dao.uc4;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import entity.uc4.Mot;
import exception.uc4.ExistantException;
import exception.uc4.InexistantException;

/**
 * methods to manage words
 * method persist=> throws an exception of an existant word that already exist in database
 * @author Fred
 *
 */

@LocalBean
@Singleton
public class DaoGestion {
	
	@PersistenceContext(unitName=DaoUtil.PERSISTENCE_UNITNAME)
	private EntityManager em;
	
	/******************************************************
						GESTION DU MOT
	 ******************************************************/
	
	//method to add a word in the database
		public Mot persist(Mot mot) throws ExistantException {
				
			try {	em.persist(mot);
					em.flush();
					
				} 
			catch (PersistenceException pe) {
				
				Throwable t = pe.getCause();
					while ((t!=null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
						t = t.getCause();
					}
					if (t instanceof SQLIntegrityConstraintViolationException) throw new ExistantException();
				}
					return mot;
		}
		
	//method to update a word in the database
		public Mot update(Mot mot) throws ExistantException {
			if (mot !=null) {
				try {
					em.merge(mot);
					em.flush();
				}
				catch (PersistenceException pe) {
					
					Throwable t = pe.getCause();
						while ((t!=null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
							t = t.getCause();
						}
						if (t instanceof SQLIntegrityConstraintViolationException) throw new ExistantException();
					}
				
			}
			return mot;
		}
		
	//method to delete a word in the database
		public void delete(Mot mot) throws InexistantException {
			
				Mot motLambda = null;
			try {
				
					if (mot !=null) {
						motLambda = em.find(Mot.class, mot);
					}
				}catch (PersistenceException pe){
					if (pe.getClass().equals(NoResultException.class)) {
						throw new InexistantException();
						}
					}
					em.remove(motLambda);
					em.flush();
				}
			
		public Mot getMot(int idMot) throws InexistantException {
			
			Mot mot = null;
			
			try {
				mot = em.find(Mot.class, idMot);
			}
			catch (PersistenceException pe) {
				if (pe.getClass().equals(NoResultException.class)) {
					throw new InexistantException();
				}
			}
			
			return mot;
		}
		
		
		
		/*******************************************************
							GESTION DE L IMAGE
		*******************************************************/
		
		
}
