package parametreGestionAcces;

public class Parametres {
	
	
	// --------Tables_gestion_des_acces_--------------
	public static final String TBL_USER = "jpa_User";
	public static final String TBL_PROFIL = "jpa_Profil";
	public static final String TBL_ROLE = "jpa_Role";
	public static final String TBL_PARTICIPANT = "jpa_Partip";
	public static final String TBL_ANIMATEUR = "jpa_Anim";
	public static final String TBL_SUPERADMIN = "jpa_SupAdmin";

	// ---------------------------------voir_persistence.xml------------------
	public final static String CONTEXT_PERSISTANCE = "DMhibernate";
	// --------------------------------------------------
	public final static String EJB_SERVICE_FACADE = "ejb:/ToolsRUsServer/Facade!clientServeur.IFacade";
}
