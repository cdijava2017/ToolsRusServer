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
	
		public Mot persist(Mot mot) {
				
				
				em.persist(mot);
				em.flush();
				System.out.println("je persiste mon mot");
				return mot;
			}
		
		}
