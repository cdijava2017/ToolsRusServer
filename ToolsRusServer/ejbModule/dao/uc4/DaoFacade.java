package dao.uc4;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class DaoFacade {
	
	@EJB
	DaoGestion daoGestion;
	
	
	//TODO

}
