package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clientServer.IFacade;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.compteur.Compteur;
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			System.out.println("création du context");
			Context context = new InitialContext();
			
			System.out.println("réussi, connexion au lookup");
			IFacade IF = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
			
			
			// On commence par tout supprimer dans la base
			IF.supAllCommentaires();
			IF.supAllTitres();
			IF.supAllCompteurs();

			Commentaire c1 = new Commentaire(1, "comm1");
			Commentaire c2 = new Commentaire(2, "comm2");
			Commentaire c3 = new Commentaire(3, "comm3");
			Titre t1 = new Titre(1, "titre 1");
			Titre t2 = new Titre(2, "titre 2");
			Titre t3 = new Titre(3, "titre 3");
			
			CptDislike cc1 = new CptDislike(0);
			CptLike cc11 = new CptLike(0);
			
			c1.setCompteurs(cc1);
			c1.setCompteurs(cc11);
//			Compteur cc2 = new Compteur(2, 2);
//			Compteur cc3 = new Compteur(3, 3);
//			c1.setTitre(t1);
//			c1.setCompteurs(cc1);
//			c2.setTitre(t2);
//			c3.setTitre(t3);
//			c2.setCompteurs(cc2);
//			c3.setCompteurs(cc3);
			System.out.println(c1);
//			System.out.println(c2);
//			System.out.println(c3);
//			IF.addCommentaire(c1);
//			IF.addCommentaire(c2);
//			IF.addCommentaire(c3);
//			IF.getAllCommParId();
			
//			System.out.println("réussi, persist d'un document");
//			Commentaire comm1 = new Commentaire(1, "comm 1");
//			Commentaire comm2 = new Commentaire(2, "comm 2");
//			Commentaire comm3 = new Commentaire(3, "comm 3");
//			Commentaire comm4 = new Commentaire(4, "comm 4");
//			System.out.println("docs créés");
//			Titre titre1 = new Titre(1, "titre 1");
//			Titre titre2 = new Titre(2, "titre 2");
//			Titre titre3 = new Titre(3, "titre 3");
//			comm1.setTitre(titre1);
//			comm2.setTitre(titre2);
//			comm3.setTitre(titre3);
//			
//			IF.addCommentaire(comm1);
//			IF.addCommentaire(comm2);
//			IF.addCommentaire(comm3);
//			IF.addCommentaire(comm4);
////			IF.addTitre(titre3);
//			System.out.println("docs sauvegardés");
//
//			// Lister les commentaires et titres dans la base
//			System.out.println("Les commentaires :");
//			System.out.println(IF.getAllCommParId());
//			System.out.println("Les titres :");
//			System.out.println(IF.getAllTitreParId());
//
//
//			// Supprimer tous les commentaires et titres dans la base
//			IF.supAllCommentaires();
//			IF.supAllTitres();
//			
//			// Lister les commentaires et titres dans la base
//			System.out.println("Les commentaires :");
//			System.out.println(IF.getAllCommParId());
//			System.out.println("Les titres :");
//			System.out.println(IF.getAllTitreParId());
//			
//			// création des titres
//			System.out.println("on recréé les comms et les titres");
//			comm1 = new Commentaire(5, "comm 5");
//			comm2 = new Commentaire(6, "comm 6");
//			comm3 = new Commentaire(7, "comm 7");
//			System.out.println("comms créés");
//			titre1 = new Titre(4, "titre 4");
//			titre2 = new Titre(5, "titre 5");
//			titre3 = new Titre(6, "titre 6");
//			System.out.println("titres créés");
//			comm1.setTitre(titre1);
//			comm2.setTitre(titre2);
//			comm3.setTitre(titre3);
//			
//			IF.addCommentaire(comm1);
//			IF.addCommentaire(comm2);
//			IF.addCommentaire(comm3);
//
//			
//			// Lister les commentaires et titres dans la base
//			System.out.println("Les commentaires :");
//			System.out.println(IF.getAllCommParId());
//			System.out.println("Les titres :");
//			System.out.println(IF.getAllTitreParId());
//			
//			// Supprimer tous les commentaires et titres dans la base
//			IF.supAllCommentaires();
//			IF.supAllTitres();
//			
//			System.out.println("on resupprime tout et on recréé les commentaires");
//			Commentaire comm5 = new Commentaire(8, "comm 8");
//			Commentaire comm6 = new Commentaire(9, "comm 9");
//			Commentaire comm7 = new Commentaire(10, "comm 10");
//			System.out.println("comms créés");
//			Titre titre4 = new Titre(7, "titre 7");
//			Titre titre5 = new Titre(8, "titre 8");
//			Titre titre6 = new Titre(9, "titre 9");
//			System.out.println("titres créés");
//			comm5.setTitre(titre4);
//			comm6.setTitre(titre5);
//			comm7.setTitre(titre6);
//
//			System.out.println("création des compteurs");
//			Compteur c1 = new Compteur(1, 1); System.out.println("1 - " + c1.toString());
//			Compteur c2 = new Compteur(2, 2); System.out.println("2 - " + c2.toString());
//			Compteur c3 = new Compteur(3, 3); System.out.println("3 - " + c3.toString());
//			System.out.println("on rajoute les compteurs aux commentaires");
//			comm5.setCompteur(c1); System.out.println("1 - " + comm5.toString());
//			comm6.setCompteur(c2); System.out.println("2 - " + comm6.toString());
//			comm7.setCompteur(c3); System.out.println("3 - " + comm7.toString());
//			
//			// Persistence des commentaires
//			System.out.println("persistence");
//			IF.addCompteur(c1);
//			IF.addCommentaire(comm5);
//			IF.addCommentaire(comm6);
//			IF.addCommentaire(comm7);
//			System.out.println("docs sauvegardés");
//			
//			// Lister les commentaires et titres dans la base
//			System.out.println("Les commentaires :");
//			System.out.println(IF.getAllCommParId());
//			System.out.println("Les titres :");
//			System.out.println(IF.getAllTitreParId());
//			System.out.println("Les compteurs :");
//			System.out.println(IF.getAllCompteurParId());
			
			
			
		} catch (NamingException e) {

			e.printStackTrace();
		}
		System.out.println("termine ...");
	}

}
