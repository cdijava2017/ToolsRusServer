package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clientServer.IFacade;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;

public class Main2 {

	public static void main(String[] args) throws Exception {
		try {
			int nb = 1;
			
			System.out.println("création du context");
			Context context = new InitialContext();
			IFacade interfaceFacade = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
			
			
			// On commence par tout supprimer dans la base
			interfaceFacade.supAllCommentaires();
			interfaceFacade.supAllTitres();
			interfaceFacade.supAllCompteurs();
			
			Commentaire comm1 = new Commentaire(nb, "comm" + nb);
			Titre t1 = new Titre(nb, "titre "+nb);
			CptDislike cptDislike1 = new CptDislike(4);
			CptLike cptLike1 = new CptLike(2);
			
			comm1.addCompteur(cptDislike1);
			comm1.addCompteur(cptLike1);
			comm1.setTitre(t1);
			
			System.out.println("** 1 - persistence des commentaires");
			System.out.println(comm1);
			comm1 = interfaceFacade.addCommentaire(comm1);
			System.out.println("** 2 - persistence des commentaires");
			System.out.println(comm1);
			
			
		
//			System.out.println("la liste des commentaires est : ");
////			System.out.println(interfaceFacade.getAllCommParId());
//			
//
////			// Lister les commentaires et titres dans la base
////			System.out.println("Les commentaires :");
////			System.out.println(interfaceFacade.getAllCommParId());
////			System.out.println("Les titres :");
////			System.out.println(interfaceFacade.getAllTitreParId());
////			System.out.println("Les compteurs :");
////			System.out.println(interfaceFacade.getAllCompteurParId());
//			
			comm1.incrementDislike();
			System.out.println("** 3 - +1 dans compteur dislike ");
			System.out.println(comm1);
			

			comm1.getTitre().setTxtTitre("gsdrf");
			comm1.setTexteComm("pojpsjd");
			interfaceFacade.modifCommentaire(comm1);
			System.out.println("*** 4 - textTitre et textComm et compteur incrémentés ");
			System.out.println(comm1);
			
			nb++;
			
			Commentaire comm2 = new Commentaire(nb, "comm" + nb);
			Titre t2 = new Titre(nb, "titre "+ nb);
			CptDislike cptDislike2 = new CptDislike(1);
			CptLike cptLike2 = new CptLike(1);
			
			comm2.addCompteur(cptDislike2);
			comm2.addCompteur(cptLike2);
			comm2.setTitre(t2);
			
			System.out.println("** 5 - syso des commentaires");
			System.out.println(comm2);
			comm2 = interfaceFacade.addCommentaire(comm2);
			System.out.println("** 6 - persistence des commentaires");
			System.out.println(comm2);
			
			comm2.incrementDislike();
			comm2.incrementLike();
			System.out.println("** 7 - +1 dans compteur like et dislike ");
			System.out.println(comm2);
			

			comm2.getTitre().setTxtTitre("titreDeux");
			comm2.setTexteComm("comm2");
			interfaceFacade.modifCommentaire(comm2);
			System.out.println("*** 8 - textTitre2 et textComm2 et compteur2 incrémentés ");
			System.out.println(comm2);
			
			
			
//			System.out.println("1 - Les compteurs modifiés :");
//			System.out.println(interfaceFacade.getAllCompteurParId());
//			interfaceFacade.incrementerCompteur(cptDislike1);
//			System.out.println(cptDislike1);

//			interfaceFacade.modifCommentaire(comm1);
			System.out.println("**** syso de tous les compteurs :");
			System.out.println(interfaceFacade.getAllCompteurParId());
			
			interfaceFacade.supCommParId(comm1);


		} catch (NamingException e) {

			e.printStackTrace();
		}
		System.out.println("termine ...");
	}

}
