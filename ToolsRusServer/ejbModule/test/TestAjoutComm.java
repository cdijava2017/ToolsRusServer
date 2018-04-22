package test;

import static org.junit.Assert.assertTrue;

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
import entity.uc3_Donner1Avis.titre.Titre;

/**
 * @author moi
 *
 */
public class TestAjoutComm {

	private int nb = 1;
	private static IFacade interfaceFacade;
	private Commentaire commentaire1;
//	private Commentaire commentaire2;
//	private ArrayList<Commentaire> listeCommentaires = null;
	private Titre titre1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass // 1 fois au lancement de la classe de test
	public static void debutClasse() throws Exception { 
		System.out.println("@BeforeClass : ");
		Context context = new InitialContext();
		interfaceFacade = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before // avant chaque test, nous supprimons les commentaire en base
	public void debut() throws Exception { 
		System.out.println("@Before : " + commentaire1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After // après chaque test, nous supprimons le contenu des tables commentaire, titre et compteur
	public void fin() throws Exception { 
		System.out.println("@After : " + commentaire1);
		interfaceFacade.supAllCompteurs();
		interfaceFacade.supAllCommentaires();
		interfaceFacade.supAllTitres();
	}

	/**
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 * Cas nominal!
	 */
	@Test
	public final void testAjouterCommCasNominal() throws CommentaireException {
		System.out.println("testAjouterCommCasNominal()");
		interfaceFacade.supAllCommentaires();
		setCommentaire1(new Commentaire(nb, "commentaire " + nb));
		setTitre1(new Titre(commentaire1.getIdComm(), "titre " + nb));
		commentaire1.setTitre(titre1);
		System.out.println("testCreerComm() : " + commentaire1);
		boolean retour = false;
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("exception testCreerComm() : " + e.getMessage());
		}
		if (interfaceFacade.getCommParRef(commentaire1.getIdComm()).equals(commentaire1)) retour = true;
		assertTrue(retour);
	}

	/**
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommNull() throws CommentaireException {
		System.out.println("testAjouterCommNull()");
		interfaceFacade.supAllCommentaires();
		setCommentaire1(null);
		System.out.println("testCreerComm() : " + commentaire1);
		boolean retour = false;
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("exception testCreerComm() : " + e.getMessage());
			retour = true;
		} 
		assertTrue(retour);
		
	}

	public Commentaire getCommentaire1() {
		return commentaire1;
	}

	public void setCommentaire1(Commentaire commentaire1) {
		this.commentaire1 = commentaire1;
	}

	public Titre getTitre1() {
		return titre1;
	}

	public void setTitre1(Titre titre1) {
		this.titre1 = titre1;
	}
}
