package main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clientServer.IFacade;
import entity.uc3_Donner1Avis.commentaire.Commentaire;
import entity.uc3_Donner1Avis.compteur.CptDislike;
import entity.uc3_Donner1Avis.compteur.CptLike;
import entity.uc3_Donner1Avis.titre.Titre;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			int nb = 1;
			
			System.out.println("création du context");
			Context context = new InitialContext();
			
			System.out.println("réussi, connexion au lookup");
			IFacade interfaceFacade = (IFacade) context.lookup("ejb:/ToolsRusServer/Facade!clientServer.IFacade");
			
			
			// On commence par tout supprimer dans la base
			interfaceFacade.supAllCommentaires();
			interfaceFacade.supAllTitres();
			interfaceFacade.supAllCompteurs();
			
			Commentaire comm1 = new Commentaire(nb, "comm" + nb);
			Titre t1 = new Titre(nb, "titre "+nb);
			Commentaire comm2 = new Commentaire(nb+1, "comm" + nb+1);
			Titre t2 = new Titre(nb+1, "titre "+nb+1);
			
//			CptDislike cptDislike1 = new CptDislike(1,5);
//			CptLike cptLike1 = new CptLike(2,1);
			CptDislike cptDislike1 = new CptDislike(4);
			CptLike cptLike1 = new CptLike(2);
			CptDislike cptDislike2 = new CptDislike(1);
			CptLike cptLike2 = new CptLike(1);
			
//			ArrayList<Compteur> c11 = new ArrayList<Compteur>();
//			c11.add(cptDislike1);
//			c11.add(cptLike1);
//			comm1.setCompteurs(c11);
			
			comm1.addCompteur(cptDislike1);
			comm1.addCompteur(cptLike1);
			comm1.setTitre(t1);
			System.out.println(comm1);
			comm2.addCompteur(cptDislike2);
			comm2.addCompteur(cptLike2);
			comm2.setTitre(t2);
			System.out.println(comm2);
			System.out.println("persistence des commentaires");
			interfaceFacade.addCommentaire(comm1);
			interfaceFacade.addCommentaire(comm2);
			
			System.out.println("la liste des commentaires est : ");
//			System.out.println(interfaceFacade.getAllCommParId());
			

			// Lister les commentaires et titres dans la base
			System.out.println("Les commentaires :");
			System.out.println(interfaceFacade.getAllCommParId());
			System.out.println("Les titres :");
			System.out.println(interfaceFacade.getAllTitreParId());
			System.out.println("Les compteurs :");
			System.out.println(interfaceFacade.getAllCompteurParId());
			
			cptDislike1.setCompteur(cptDislike1.getCompteur()+1);
			cptDislike2.setCompteur(cptDislike2.getCompteur()+1);
			t1.setTxtTitre("zepok");
			t2.setTxtTitre("ziplop");
			comm1.setTexteComm("pojpsjd");
			comm2.setTexteComm("amsdljkp");
			interfaceFacade.modifCommentaire(comm1);
			interfaceFacade.modifCommentaire(comm2);

			System.out.println("Les commentaires modifiés :");
			System.out.println(interfaceFacade.getAllCommParId());
			System.out.println("Les titres modifiés :");
			System.out.println(interfaceFacade.getAllTitreParId());
			System.out.println("Les compteurs modifiés :");
			System.out.println(interfaceFacade.getAllCompteurParId());
			
			
//			cptDislike1.setCompteur(cptDislike1.getCompteur()+1);
//			interfaceFacade.modifCommentaire(comm1);
//			System.out.println(interfaceFacade.getAllCompteurParId());
			
			//TODO changer modifier() comme pensé hier

		} catch (NamingException e) {

			e.printStackTrace();
		}
		System.out.println("termine ...");
	}

}
