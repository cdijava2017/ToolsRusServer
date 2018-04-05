package dao.uc4;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import dao.uc4.DaoUtil;
import entity.uc4.Mot;
import exception.uc4.ExistantException;

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
	EntityManager em;
	
	
	//method to add a word in the database
		public Mot persist(Mot mot) throws ExistantException {
				
			try {	em.persist(mot);
					em.flush();
					//System.out.println("je persiste mon mot");
					
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
		
}
