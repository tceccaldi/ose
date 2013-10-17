package fr.mertzel.ose.vue;

import fr.mertzel.ose.modele.* ;
import fr.mertzel.ose.vue.*;
/** Paramètres de l'interface graphique
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class Parametres {
	/** Nombre de rangées
	 */
	public final static int NB_RANGEES =  4 ;
	
	/** Nombre de travées
	 */
	public final static int NB_TRAVEES = 4 ;
	
	/** Hauteur en pixels d'une rangée
	 */
	public final static int HAUTEUR_RANGEE = 100 ;
	
	/** Largeur en pixels d'une travée
	 */
	public final static int LARGEUR_TRAVEE = 100 ;
	
	/** Largeur en pixels d'un poste de travail
	 */
	public final static int LARGEUR_POSTE = 20 ;
	
	/** Longueur en pixels d'un poste de travail
	 */
	public final static int LONGUEUR_POSTE = 50 ;
	
	/** Largeur en pixels d'un candidat
	 */
	public final static int LARGEUR_PERSONNE = 20 ;
	
	/** Convertir un numéro de travee en abscisse
	 * @param travee Numéro de la travée
	 * @return Abscisse
	 */
	public static int centrePositionX(int travee) {
		return travee * LARGEUR_TRAVEE + LARGEUR_TRAVEE / 2 ;
	}
	
	/** Convertir un numéro de rangée en ordonnée
	 * @param rangee Numéro de la rangée
	 * @return Ordonnée
	 */
	public static int centrePositionY(int rangee){
		return rangee * HAUTEUR_RANGEE + HAUTEUR_RANGEE / 2 ;
	}
	
	/** Calculer l'abscisse du centre l'abscisse du centre de la représentation d'un poste de travail
	 * @param travee Numéro de la travée du poste de travail
	 * @param orientation Orientation du poste de travail
	 * @return Abscisse du centre de la représentation du poste de travail
	 */
	public static int posteX(int travee,int orientation){
		int centreX = centrePositionX(travee) ;
		switch(orientation){
			case Orientation.NORD :
				centreX -= 25 ;
				break ;
			case Orientation.EST :
				break ;
			case Orientation.SUD :
				centreX -= 25 ;
				break ;
			case Orientation.OUEST :
				centreX -= 20 ;
				break ;
		}
		return centreX ;
	}
	
	/** Calculer l'ordonnée du centre l'abscisse du centre de la représentation d'un poste de travail
	 * @param rangee Numéro de la rangée du poste de travail
	 * @param orientation Orientation du poste de travail
	 * @return Ordonnée du centre de la représentation du poste de travail
	 */
	public static int posteY(int rangee,int orientation){
		int centreY = centrePositionY(rangee) ;
		switch(orientation){
			case Orientation.NORD :
				centreY -= 20 ;
				break ;
			case Orientation.EST :
				centreY -= 25 ;
				break ;
			case Orientation.SUD :
				break ;
			case Orientation.OUEST :
				centreY -= 25 ;
				break ;
		}
		return centreY ;
	}
	
	/** Calculer l'abscisse de la position de la représentation graphique d'un candidat
	 * @param travee Numéro de la travée du candidat
	 * @param orientation Orientation du candidat
	 * @return Abscisse de la position de la représentation graphique du candidat
	 */
	public static int personneX(int travee,int orientation){
		int centreX = centrePositionX(travee) ;
		switch(orientation){
			case Orientation.NORD :
				centreX -= 10 ;
				break ;
			case Orientation.EST :
				centreX -= 25 ;
				break ;
			case Orientation.SUD :
				centreX -= 10 ;
				break ;
			case Orientation.OUEST :
				centreX += 5 ;
				break ;
		}
		return centreX ;
	}
	
	/** Calculer l'ordonnée de la position de la représentation graphique d'un candidat
	 * @param rangee Numéro de la rangée du candidat
	 * @param orientation Orientation du candidat
	 * @return Ordonnée de la position de la représentation graphique du candidat
	 */
	public static int personneY(int rangee,int orientation){
		int centreY = centrePositionY(rangee) ;
		switch(orientation){
			case Orientation.NORD :
				centreY += 5 ;
				break ;
			case Orientation.EST :
				centreY -= 10 ;
				break ;
			case Orientation.SUD :
				centreY -= 25 ;
				break ;
			case Orientation.OUEST :
				centreY -= 10 ;
				break ;
		}
		return centreY ;
	}
	
	/** Calculer l'abscisse du centre de la représentation graphique d'un candidat
	 * @param travee Numéro de la travée du candidat
	 * @param orientation Orientation du candidat
	 * @return Abscisse du centre de la représentation graphique du candidat
	 */
	public static int centrePersonneX(int travee,int orientation){
		int x = personneX(travee,orientation) ;
		x += LARGEUR_PERSONNE / 2 ;
		return x ;
	}
	
	/** Calculer l'ordonnée du centre de la représentation graphique d'un candidat
	 * @param rangee Numéro de la rangée du candidat
	 * @param orientation Orientation du candidat
	 * @return Ordonnée du centre de la représentation graphique du candidat
	 */
	public static int centrePersonneY(int rangee,int orientation){
		int y = personneY(rangee,orientation) ;
		y += LARGEUR_PERSONNE / 2 ;
		return y ;
	}
	
}
