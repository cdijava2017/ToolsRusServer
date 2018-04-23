package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clientServer.IFacade;
import dao.uc3_Donner1Avis.UtilBdD;
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
	private Commentaire commentaireTest;
//	private ArrayList<Commentaire> listeCommentaires = null;
	private Titre titre1;
	
	/**
	 * Au lancement de la classe de test, la méthode debutClasse() annotée @BeforeClass se lance (une seule fois)
	 * et ouvre la connexion avec le serveur pour tous les tests qui vont être exécutés ensuite.
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
	 * Avant chaque cas de test, nous supprimons les commentaires en base pour commencer le test avec 
	 * base saine et vide, ce qui évitera les erreurs de doublons si ce n'est pas voulu.
	 * @throws java.lang.Exception
	 */
	@Before 
	public void debut() throws Exception { 
		System.out.println("@Before : " + commentaire1);
		interfaceFacade.supAllCompteurs();
		interfaceFacade.supAllCommentaires();
		interfaceFacade.supAllTitres();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After 
	public void fin() throws Exception { 
		System.out.println("@After : " + commentaire1);

	}

	/**
	 * Cas nominal! On créé un commentaire avec un idComm = 1, txtComm = "commentaire 1" et on lui associe un titre idTitre = 1, txtTitre = titre 1.
	 * Ensuite, on persiste et on va chercher en base le commentaire pour vérifier qu'il existe bien
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommCasNominal() throws CommentaireException {
		System.out.println("testAjouterCommCasNominal()");
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
		commentaireTest = interfaceFacade.getCommParRef(commentaire1.getIdComm());
		if (commentaireTest instanceof Commentaire && commentaire1.equals(commentaireTest) ) {
			retour = true;
		}
		assertTrue(retour);
	}

	/**
	 * On créé un commentaire null et on ne lui associe pas de titre. Ensuite, on persiste en base le commentaire. 
	 * La persistence doit nous renvoyer une CommentaireException avec un message. Après avoir récupéré le message dans la variable @param obtenu,
	 * on le compare avec celui stocké dans la variable @param UtilBdD.COMM_NULL. Si les deux messages sont les mêmes, on set @param retour à true,
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommNull() throws CommentaireException {
		String attendu = UtilBdD.COMM_NULL;
		String obtenu = null;
		setCommentaire1(null);
		System.out.println("testAjouterCommNull() : " + commentaire1);
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("exception testAjouterCommNull() : " + e.getMessage());
			obtenu = e.getMessage();
		} 
		assertEquals(attendu, obtenu);
	}

	/**
	 * On créé un commentaire avec un id null (une variable de type int ne peut être vide, l'équivalent est le chiffre 0) 
	 * et on ne lui associe pas de titre. Ensuite, on persiste en base le commentaire. 
	 * La persistence doit nous renvoyer une CommentaireException avec un message stocké dans la variable @param IDCOMM_INVALIDE .
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommIdNull() throws CommentaireException {
		String attendu = UtilBdD.IDCOMM_INVALIDE;
		String obtenu = null;
		setCommentaire1(new Commentaire(0, "commentaire " + nb));
		System.out.println("testAjouterCommIdNull() : " + commentaire1);
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("exception testAjouterCommIdNull() : " + e.getMessage());
			obtenu = e.getMessage();
		} 
		assertEquals(attendu, obtenu);
	}

	/**
	 * On créé un commentaire avec un idComm = 1 et un txtComm à null mais on ne lui associe pas de titre. Ensuite, on persiste en base le commentaire. 
	 * La persistence doit nous renvoyer une CommentaireException avec un message stocké dans la variable @param TXTCOMM_INVALIDE .
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommTxtNull() throws CommentaireException {
		String attendu = UtilBdD.TXTCOMM_INVALIDE;
		String obtenu = null;
		setCommentaire1(new Commentaire(1, null));
		System.out.println("testAjouterCommTxtNull() : " + commentaire1);
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("exception testAjouterCommTxtNull() : " + e.getMessage());
			obtenu = e.getMessage();
		} 
		assertEquals(attendu, obtenu);
	}

	/**
	 * On créé un commentaire avec un idComm = 1, txtComm = "commentaire 1" et on lui associe un titre idTitre = 1, txtTitre = titre 1.
	 * La persistence doit nous renvoyer une CommentaireException avec un message stocké dans la variable @param ERREUR_2 .
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommDoublon() throws CommentaireException {
		String attendu = UtilBdD.ERREUR_2;
		String obtenu = null;
		setCommentaire1(new Commentaire(nb, "commentaire " + nb));
		setTitre1(new Titre(commentaire1.getIdComm(), "titre " + nb));
		commentaire1.setTitre(titre1);
		System.out.println("testAjouterCommDoublon() : " + commentaire1);
		// Première persistence pour ajouter le commentaire en base
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("1ère exception testAjouterCommDoublon() : " + e.getMessage());
		} 
		// Deuxième persistence pour créer un doublon
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("2ème exception testAjouterCommDoublon() : " + e.getMessage());
			obtenu = e.getMessage();
		} 
		assertEquals(attendu, obtenu);
	}
	
	/**
	 * On créé un commentaire avec un idComm = 1, txtComm = "commentaire 1" et on lui associe un titre idTitre = 1, txtTitre = titre 1.
	 * La persistence doit nous renvoyer une CommentaireException avec un message stocké dans la variable @param ERREUR_2 .
	 * Test method for {@link dao.uc3_Donner1Avis.DaoGestion#ajouter(entity.uc3_Donner1Avis.commentaire.Commentaire)}.
	 * @throws CommentaireException 
	 */
	@Test
	public final void testAjouterCommTitreNull() throws CommentaireException {
		String attendu = UtilBdD.ERREUR_2;
		String obtenu = null;
		setCommentaire1(new Commentaire(nb, "commentaire " + nb));
		setTitre1(new Titre(commentaire1.getIdComm(), "titre " + nb));
		commentaire1.setTitre(titre1);
		System.out.println("testAjouterCommDoublon() : " + commentaire1);
		// Première persistence pour ajouter le commentaire en base
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("1ère exception testAjouterCommDoublon() : " + e.getMessage());
		} 
		// Deuxième persistence pour créer un doublon
		try {
			System.out.println("persistence commentaire");
			interfaceFacade.addCommentaire(commentaire1);
			System.out.println("commentaire persisté");
		} catch (CommentaireException e) {
			System.out.println("2ème exception testAjouterCommDoublon() : " + e.getMessage());
			obtenu = e.getMessage();
		} 
		assertEquals(attendu, obtenu);
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
