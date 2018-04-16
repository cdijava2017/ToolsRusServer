package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServer.IFacade;
import dao.uc3_Donner1Avis.DaoException;
import dao.uc3_Donner1Avis.DaoGestion;
import dao.uc3_Donner1Avis.DaoListe;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;

public class TestGestion {

	private int nb = 1;
	private DaoGestion daoG;
	private DaoListe daoL;
	private static IFacade interfaceFacade;
	private Commentaire comm1 = new Commentaire(nb, "comm" + nb);
	
	@BeforeClass // 1 fois
	public static void debutClasse() throws Exception { 
		Context context = new InitialContext();
		interfaceFacade = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
	}

	@Before // avant chaque test
	public void debut() throws Exception { }

	@After // après chaque test
	public void fin() throws Exception { }

	@AfterClass // 1 fois
	public static void finClasse() throws Exception { }


	@Test
	public void testCreerComm() {
		boolean retour = false;
		try {
			interfaceFacade.addCommentaire(comm1);
		} catch (DaoException e) {
			e.printStackTrace();
			System.out.println("CommentaireVideException levée");
		}
		if (interfaceFacade.getCommParRef(comm1.getIdComm()).equals(comm1)) retour = true;
		assertTrue(retour);
	}

	@Test
	public void testSupAllCommentaires() throws DaoException {
		interfaceFacade.addCommentaire(comm1);
		interfaceFacade.supAllCommentaires();
		boolean retour = false;
		try {
			if (interfaceFacade.getAllCommParId().isEmpty()) retour = true;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertTrue(retour);
	}

	@Test
	public void testModifCommentaire() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreerTitre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSupAllTitres() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifTitre() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreerCompteur() {
		fail("Not yet implemented");
	}

	@Test
	public void testSupAllCompteurs() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifCompteur() {
		fail("Not yet implemented");
	}

}
