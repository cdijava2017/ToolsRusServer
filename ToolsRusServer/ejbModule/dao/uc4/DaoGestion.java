package dao.uc4;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.uc4.DaoUtil;
import entity.uc4.Mot;


@LocalBean
@Singleton
public class DaoGestion {
	
	@PersistenceContext(unitName=DaoUtil.PERSISTENCE_UNITNAME)
	EntityManager em;
	
public void persist(Mot mot) {
		
		//System.out.println("DaoGestion_persist_ apres instance localisation");
		em.persist(mot);
		em.flush();
		System.out.println("je persiste mon mot");
	}

}
