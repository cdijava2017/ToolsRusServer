package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

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

public class TestGestion {

	private int nb = 1;
	private static IFacade interfaceFacade;
	private Commentaire commentaire1;
	private Commentaire commentaire2;
	private ArrayList<Commentaire> listeCommentaires = null;
	private Titre titre1;

	@BeforeClass // 1 fois
	public static void debutClasse() throws Exception { 
		System.out.println("@BeforeClass : ");
		Context context = new InitialContext();
		interfaceFacade = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
	}

	@Before // avant chaque test, nous supprimons les commentaire en base
	public void debut() throws Exception { 
		System.out.println("@Before : " + commentaire1);
//		interfaceFacade.supAllCommentaires();

	}

	@After // après chaque test, nous remettons le commentaire et le titre à null
	public void fin() throws Exception { 
		System.out.println("@After : " + commentaire1);
		interfaceFacade.supAllCompteurs();
		interfaceFacade.supAllCommentaires();
		interfaceFacade.supAllTitres();
	}

	@AfterClass // 1 fois
	public static void finClasse() throws Exception { }


	@Test
	public void testCreerComm() throws CommentaireException {
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
//
//	@Test
//	public void testSupAllCommentaires() throws CommentaireException {
//		interfaceFacade.supAllCommentaires();
//		setCommentaire1(new Commentaire(nb, "commentaire " + nb));
//		setTitre1(new Titre(commentaire1.getIdComm(), "titre " + nb));
//		commentaire1.setTitre(titre1);
//		System.out.println("testSupAllCommentaires() : " + commentaire1);
//		System.out.println("persistence commentaire");
//		interfaceFacade.addCommentaire(commentaire1);
//		System.out.println("commentaire persisté");
//		System.out.println("suppression des commentaires");
//		interfaceFacade.supAllCommentaires();
//		System.out.println("commentaires supprimés");
//		boolean retour = false;
//		try {
//			interfaceFacade.getAllCommParId();
//			retour = true;
//		} catch (CommentaireException e) {
//			System.out.println(e.getMessage());
//			retour = true;
//		}
//		assertTrue(retour);
//	}
//
//	@Test
//	public void testModifCommentaire() {
//		System.out.println("testModifCommentaire()");
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCreerTitre() {
//		System.out.println("testCreerTitre()");
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSupAllTitres() {
//		System.out.println("testSupAllTitres()");
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testModifTitre() {
//		System.out.println("testModifTitre()");
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCreerCompteur() {
//		System.out.println("testCreerCompteur()");
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSupAllCompteurs() {
//		System.out.println("testSupAllCompteurs()");
//		fail("Not yet implemented");
//	}

	@Test
	public void testModifCompteur() throws CommentaireException {
		System.out.println("testModifCompteur()");
		commentaire1 = new Commentaire(nb, "comm " + nb);
		interfaceFacade.addCommentaire(commentaire1);
		Commentaire commentaire2 = interfaceFacade.getCommParRef(commentaire1.getIdComm());
		System.out.println("comm récupéré 1 : " + commentaire2);
		commentaire2.getCptLike().compteurPlus1();
		System.out.println("compteur +1");
		System.out.println(commentaire2);
		interfaceFacade.modifCommentaire(commentaire2);
		commentaire2 = interfaceFacade.getCommParRef(commentaire2.getIdComm());
		System.out.println("comm récupéré 2 : " + commentaire1);
		if (commentaire1.getListeCompteurs().equals(commentaire2.getListeCompteurs())) assertTrue(false);
		else assertTrue(true);
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
