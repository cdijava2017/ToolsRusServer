package dao.uc3_Donner1Avis;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServer.IFacade;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.commentaire.CommentaireException;
import junit.framework.TestCase;

public class TestDaoGestion extends TestCase {

	private int nb = 1;
//	private DaoGestion daoG;
//	private DaoListe daoL;
	private static IFacade interfaceFacade;
	Commentaire comm1 = new Commentaire(nb, "comm" + nb);
	
	
	@BeforeClass // 1 fois
	public static void debutClasse() throws Exception { 
		Context context = new InitialContext();
		interfaceFacade = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
	}

	@Before // avant chaque test
	public void debut() throws Exception { 
		try {
			interfaceFacade.addCommentaire(comm1);
		} catch (CommentaireException e) {
			e.printStackTrace();
			System.out.println("CommentaireException levée");
		}
	}

	@After // après chaque test
	public void fin() throws Exception { }

	@AfterClass // 1 fois
	public static void finClasse() throws Exception { }
	
	
	@Test
	public void testAjouterCommentaire() throws CommentaireException {
		boolean retour = false;
		System.out.println("test ajout");
		System.out.println("comm1 : " + comm1);
//		Commentaire comm2 = interfaceFacade.getCommParRef(1);
		System.out.println("test");

		if (interfaceFacade.getCommParRef(comm1.getIdComm()).equals(comm1)) retour = true;
		assertTrue(retour);
	}
	@Test
	public void testSupAllCommentaires() throws CommentaireException {
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
	public void testSupCommParId() {
		fail("Not yet implemented");
	}
	@Test
	public void testModifCommentaire() {
		fail("Not yet implemented");
	}
	@Test
	public void testRecupCommentaire() {
		fail("Not yet implemented");
	}
	@Test
	public void testAjouterTitre() {
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
	public void testRecupTitre() {
		fail("Not yet implemented");
	}
	@Test
	public void testAjouterCompteur() {
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
	@Test
	public void testRecupCompteur() {
		fail("Not yet implemented");
	}
	@Test
	public void testIncrementCompteur() {
		fail("Not yet implemented");
	}

}
