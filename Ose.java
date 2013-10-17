/** Application OSE
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
 public class Ose {
	 
	/** Point d'entrée dans le programme
	 */
	public static void main(String [] args){
		PlanSalle modele = new PlanSalle("Sans Nom") ;
		FenetrePrincipale vue = new FenetrePrincipale(modele) ;
		new Controleur(vue,modele) ;
	}
}
