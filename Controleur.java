package fr.mertzel.ose.controleur;

import fr.mertzel.ose.vue.*;
import fr.mertzel.ose.modele.*;
import java.awt.event.* ;
import javax.swing.event.* ;
import javax.swing.* ;

/** Contrôleur (MVC) de l'application
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class Controleur implements MouseListener, ActionListener {

	private FenetrePrincipale vue ;
	private PlanSalle modele ;
	private Position position ;
	
	/** Constructeur
	 * @param vue Fenetre principale
	 * @param modele Modèle (MVC) - Plan de la salle
	 */
	public Controleur(FenetrePrincipale vue,PlanSalle modele) {
		this.vue = vue ;
		this.modele = modele ;
		vue.getItemOuvrir().addActionListener(this) ;
		vue.getItemEnregistrer().addActionListener(this) ;
		vue.getItemQuitter().addActionListener(this) ;
		vue.getItemNommer().addActionListener(this) ;
		vue.getItemPurger().addActionListener(this) ;
		vue.getItemPlacerNord().addActionListener(this) ;
		vue.getItemPlacerEst().addActionListener(this) ;
		vue.getItemPlacerSud().addActionListener(this) ;
		vue.getItemPlacerOuest().addActionListener(this) ;
		vue.getItemOrienterNord().addActionListener(this) ;
		vue.getItemOrienterEst().addActionListener(this) ;
		vue.getItemOrienterSud().addActionListener(this) ;
		vue.getItemOrienterOuest().addActionListener(this) ;
		vue.getItemRetirer().addActionListener(this) ;
		vue.getPlan().addMouseListener(this) ;
	}
	
	/** Traiter les événements liés au menu de l'application
	 * @param evt Evénement à traiter
	 */
	public void actionPerformed(ActionEvent evt){
		Object source = evt.getSource() ;
		if(source == vue.getItemOuvrir()){
			System.out.println("Ouvrir") ;
		}
		else if(source == vue.getItemEnregistrer()){
			System.out.println("Enregistrer") ;
		}
		else if(source == vue.getItemQuitter()){
			System.out.println("Quitter") ;
			System.exit(0) ;
		}
		else if(source == vue.getItemPurger()){		
			if (vue.saisirConfirmation())
			{
				System.out.println("Purger") ;
				modele.purger() ;
			}
			else{
				System.out.println("Purge annulée") ;
			}
		}
		else if(source == vue.getItemNommer()){
			String nom = vue.saisirNom();
			if (nom!="")
			{
				System.out.println("Nommer") ;
				modele.setNom(nom) ;
				System.out.println(modele.getNom()) ;
			}
			else{
				System.out.println("Nommer annulé") ;
			}
		}
		else if(source == vue.getItemPlacerNord()){
			modele.ajouterPoste(this.position,Orientation.NORD) ;
		}
		else if(source == vue.getItemPlacerEst()){
			modele.ajouterPoste(this.position,Orientation.EST) ;
		}
		else if(source == vue.getItemPlacerSud()){
			modele.ajouterPoste(this.position,Orientation.SUD) ;
		}
		else if(source == vue.getItemPlacerOuest()){
			modele.ajouterPoste(this.position,Orientation.OUEST) ;
		}
		else if(source == vue.getItemOrienterNord()){
			modele.orienterPoste(this.position,Orientation.NORD) ;
		}
		else if(source == vue.getItemOrienterEst()){
			modele.orienterPoste(this.position,Orientation.EST) ;
		}
		else if(source == vue.getItemOrienterSud()){
			modele.orienterPoste(this.position,Orientation.SUD) ;
		}
		else if(source == vue.getItemOrienterOuest()){
			modele.orienterPoste(this.position,Orientation.OUEST) ;
		}
		else if(source == vue.getItemRetirer()){
			modele.retirerPoste(this.position) ;
		}
		
	}
	
	public void mouseClicked(MouseEvent evt){
	}
	
	/** Afficher le menu contextuel dans la représentation graphique du plan de salle
	 * @param evt Evénement associé au bouton de la souris
	 */
	public void mousePressed(MouseEvent evt){
		Object source = evt.getSource() ;
		if(source == vue.getPlan()){
			if(evt.isPopupTrigger()){
				int rangee = evt.getY() / Parametres.HAUTEUR_RANGEE ;
				int travee = evt.getX() / Parametres.LARGEUR_TRAVEE ;
				this.position = new Position(rangee,travee) ;
				vue.afficherMenuContextuel(evt.getX(),evt.getY()) ;
			}
		}
	}
	
	public void mouseReleased(MouseEvent evt){
	}
	
	public void mouseEntered(MouseEvent evt){
	}
	
	public void mouseExited(MouseEvent evt){
	}
}
