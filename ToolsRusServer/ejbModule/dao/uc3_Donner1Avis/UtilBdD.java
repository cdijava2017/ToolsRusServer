package dao.uc3_Donner1Avis;

public class UtilBdD 
{
	
	public static final String PERSISTANCE_UNITNAME 	= "A1Persistence";
	public static final String PERSISTANCE_UNITNAME2 	= "DMhibernate";
	public static final String GET_ALL_COMM				= "select c from Commentaire c order by c.idComm asc";
	public static final String GET_ALL_TITRE			= "select t from Titre t order by t.idTitre asc";
	public static final String GET_ALL_COMPTEUR			= "select c from Compteur c order by c.idCompteur asc";
	public static final String DEL_COMMENTAIRE			= "delete from Commentaire";
	public static final String DEL_TITRE				= "delete from Titre";
	public static final String DEL_COMPTEUR 			= "delete from Compteur";
	public static final String ERREUR_1		 			= "*** Attention, erreur à la persistence du commentaire ***";
	public static final String ERREUR_1_2	 			= "*** Attention, erreur à la persistence du titre ***";
	public static final String ERREUR_1_3	 			= "*** Attention, erreur à la persistence du compteur ***";
	public static final String ERREUR_2 				= "*** Attention, un commentaire existe déjà en base avec cet id ***";
	public static final String ERREUR_2_2				= "*** Attention, un titre existe déjà en base avec cet id ***";
	public static final String ERREUR_2_3				= "*** Attention, un compteur existe déjà en base avec cet id ***";
	public static final String ERREUR_3 				= "*** Attention, aucun commentaire n'existe en base avec cet id ***";
	public static final String ERREUR_3_2				= "*** Attention, aucun titre n'existe en base avec cet id ***";
	public static final String ERREUR_3_3				= "*** Attention, aucun compteur n'existe en base avec cet id ***";
	public static final String IDCOMM_INVALIDE			= "*** Attention, l'id du commentaire saisi est invalide ***";
	public static final String TXTCOMM_INVALIDE			= "*** Attention le commentaire est vide ***";
	public static final String COMM_NULL				= "*** Attention : NullPointerException pour le commentaire! ***";
	
}
