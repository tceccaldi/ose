package fr.mertzel.ose.vue;

import fr.mertzel.ose.modele.*;
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;

/** Fenêtre principale de l'application
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PlanSalle modele ;
	private Plan plan ;
	
	private JMenuItem itemNouveau ;
	private JMenuItem itemOuvrir ;
	private JMenuItem itemEnregistrer ;
	private JMenuItem itemQuitter ;
	
	private JPopupMenu menuActions ;
	
	private JMenu menuPlacer ;
	private JMenuItem itemPlacerNord ;
	private JMenuItem itemPlacerEst ;
	private JMenuItem itemPlacerSud ;
	private JMenuItem itemPlacerOuest ;
	private JMenuItem itemRetirer ;

	/** Constructeur
	 * @param modele Modèle (MVC)
	 */
	public FenetrePrincipale(PlanSalle modele){
		super() ;
		this.modele = modele ;
		this.setTitle(modele.getNom() + " - OSE") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		this.creerBarreMenus() ;
		this.creerMenuContextuel() ;
		JLayeredPane lp = new JLayeredPane() ;
		lp.setPreferredSize(new Dimension(Parametres.NB_TRAVEES*Parametres.LARGEUR_TRAVEE,Parametres.NB_RANGEES*Parametres.HAUTEUR_RANGEE)) ;
		plan = new Plan(modele) ;
		plan.setBounds(0,0,Parametres.NB_TRAVEES*Parametres.LARGEUR_TRAVEE,Parametres.NB_RANGEES*Parametres.HAUTEUR_RANGEE) ;
		lp.add(plan,new Integer(0)) ;
		Container conteneur = this.getContentPane() ;
		conteneur.setLayout(new FlowLayout()) ;
	
		conteneur.add(lp) ;
		this.pack() ;
		this.setLocationRelativeTo(null) ;
		this.setVisible(true) ;
	}
	
	/** Créer la barre de menus
	 */
	private void creerBarreMenus(){
		JMenuBar barreMenus = new JMenuBar() ;
		
		JMenu menuFichier = new JMenu("Fichier") ;
		itemNouveau = new JMenuItem("Nouveau") ;
		itemOuvrir = new JMenuItem("Ouvrir") ;
		itemEnregistrer = new JMenuItem("Enregistrer") ;
		itemQuitter = new JMenuItem("Quitter") ;
		menuFichier.add(itemNouveau) ;
		menuFichier.add(itemOuvrir) ;
		menuFichier.add(itemEnregistrer) ;
		menuFichier.addSeparator() ;
		menuFichier.add(itemQuitter) ;
		barreMenus.add(menuFichier) ;
		
		this.setJMenuBar(barreMenus) ;
		itemNouveau.setEnabled(false) ;
		itemOuvrir.setEnabled(false) ;
		itemEnregistrer.setEnabled(false) ;
	}
	
	/** Créer le menu contextuel
	 */
	private void creerMenuContextuel(){
		menuActions = new JPopupMenu() ;
		menuPlacer = new JMenu("Placer") ;
		menuActions.add(menuPlacer) ;
		itemRetirer = new JMenuItem("Retirer") ;
		menuActions.add(itemRetirer) ;
		itemPlacerNord = new JMenuItem("vers Nord") ;
		menuPlacer.add(itemPlacerNord) ;
		itemPlacerEst = new JMenuItem("vers Est") ;
		menuPlacer.add(itemPlacerEst) ;
		itemPlacerSud = new JMenuItem("vers Sud") ;
		menuPlacer.add(itemPlacerSud) ;
		itemPlacerOuest = new JMenuItem("vers Ouest") ;
		menuPlacer.add(itemPlacerOuest) ;
	}
	
	/** Obtenir une référence à l'item Ouvrir du menu Fichier
	 * @return Référence à l'item Ouvrir
	 */
	public JMenuItem getItemOuvrir(){
		return this.itemOuvrir ;
	}
	
	/** Obtenir une référence à l'item Enregistrer du menu Fichier
	 * @return Référence à l'item Enregistrer
	 */
	public JMenuItem getItemEnregistrer(){
		return this.itemEnregistrer ;
	}
	
	/** Obtenir une référence à l'item Quitter du menu Fichier
	 * @return Référence à l'item Quitter
	 */
	public JMenuItem getItemQuitter(){
		return this.itemQuitter ;
	}
	
	/** Obtenir une référence à l'item Placer/Nord du menu contextuel
	 * @return Référence à l'item Placer/Nord
	 */
	public JMenuItem getItemPlacerNord(){
		return this.itemPlacerNord ;
	}
	
	/** Obtenir une référence à l'item Placer/Est du menu contextuel
	 * @return Référence à l'item Placer/Est
	 */
	public JMenuItem getItemPlacerEst(){
		return this.itemPlacerEst ;
	}
	
	/** Obtenir une référence à l'item Placer/Sud du menu contextuel
	 * @return Référence à l'item Placer/Sud
	 */
	public JMenuItem getItemPlacerSud(){
		return this.itemPlacerSud ;
	}
	
	/** Obtenir une référence à l'item Placer/Ouest du menu contextuel
	 * @return Référence à l'item Placer/Ouest
	 */
	public JMenuItem getItemPlacerOuest(){
		return this.itemPlacerOuest ;
	}
	
	/** Obtenir une référence à l'item Retirer du menu contextuel
	 * @return Référence à l'item Retirer
	 */
	public JMenuItem getItemRetirer(){
		return this.itemRetirer ;
	}

	/** Obtenir une référence à la représentation graphique du plan de salle
	 * @return Référence à la représentation graphique du plan de salle
	 */
	public Plan getPlan(){
		return this.plan ;
	}
	
	/** Rafraichir la représentation graphique du plan de salle
	 */
	public void visualiserPlan(){
		this.plan.repaint() ;
	}
	
	/** Afficher le menu contextuel
	 * @param x Position X
	 * @param y Position y
	 */
	public void afficherMenuContextuel(int x,int y){
		Position position = new Position(y/Parametres.HAUTEUR_RANGEE,x/Parametres.LARGEUR_TRAVEE) ;
		if(this.modele.positionOccupee(position)){
			this.menuPlacer.setEnabled(false) ;
			this.itemRetirer.setEnabled(true) ;
		}
		else {
			this.menuPlacer.setEnabled(true) ;
			this.itemRetirer.setEnabled(false) ;
		}
		menuActions.show((Component)plan,x,y) ;
	}
	
	/** Vue (MVC) de l'application - Représentation graphique du plan de salle
	 * @since Janvier 2013
	 * @author xilim
	 * @version 0.2
	 */
	public class Plan extends JPanel {

		private static final long serialVersionUID = 1L;
		
		private PlanSalle modele ;
		
		/** Constructeur
		 * @param modele Modèle (MVC) - Représentation mémoire du plan de salle
		 */
		public Plan(PlanSalle modele){
			super() ;
			this.modele = modele ;
			this.setBackground(Color.white) ;
		}
			
		/** Dessiner le plan de salle
		 * @param g Contexte graphique
		 */
		public void paintComponent(Graphics g){
			super.paintComponent(g) ;
			Graphics2D g2d = (Graphics2D) g ;
			this.quadriller(g2d) ;
			this.placerPostes(g2d) ;
			this.tracerVisualisations(g2d) ;
		}
		
		/** Quadriller les plan de salle pour faire apparaître les rangées et les travées
		 * @param g Contexte graphique
		 */
		private void quadriller(Graphics2D g){
			float dash[]={2f,0f,2f} ;
			BasicStroke pointilles = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,dash,2f) ;
			g.setStroke(pointilles) ;
			for(int i = 1 ; i <= Parametres.NB_TRAVEES-1 ; i++){
				g.drawLine(Parametres.LARGEUR_TRAVEE*i,0,Parametres.LARGEUR_TRAVEE*i,Parametres.NB_RANGEES*Parametres.HAUTEUR_RANGEE-1) ;
			}
			for(int i = 1 ; i <= Parametres.NB_RANGEES-1 ; i++){
				g.drawLine(0,Parametres.HAUTEUR_RANGEE*i,Parametres.NB_TRAVEES*Parametres.LARGEUR_TRAVEE-1,Parametres.HAUTEUR_RANGEE*i) ;
			}
		}
		
		/** Dessiner les postes sur le plan de salle
		 * @param g Contexte graphique
		 */
		private void placerPostes(Graphics2D g){
			g.setStroke(new BasicStroke()) ;
			for(PlanSalle.Poste poste : modele.listerPostes()){
				g.setColor(Color.gray) ;
				int xPoste = Parametres.posteX(poste.getPosition().getTravee(),poste.getOrientation()) ;
				int yPoste = Parametres.posteY(poste.getPosition().getRangee(),poste.getOrientation()) ;
				int xPersonne = Parametres.personneX(poste.getPosition().getTravee(),poste.getOrientation()) ;
				int yPersonne = Parametres.personneY(poste.getPosition().getRangee(),poste.getOrientation()) ;
				if(poste.getOrientation() == Orientation.NORD || poste.getOrientation() == Orientation.SUD){
					g.fill3DRect(xPoste,yPoste,Parametres.LONGUEUR_POSTE,Parametres.LARGEUR_POSTE,true) ;
				}
				else {
					g.fill3DRect(xPoste,yPoste,Parametres.LARGEUR_POSTE,Parametres.LONGUEUR_POSTE,true) ;
				}
				g.drawOval(xPersonne,yPersonne,Parametres.LARGEUR_PERSONNE,Parametres.LARGEUR_PERSONNE) ;
				if(poste.peutVoir()){
						g.setColor(Color.red) ;
				}
				else {
					g.setColor(Color.blue) ;
				}
				g.fillOval(xPersonne,yPersonne,20,20) ;
			}
		}
		
		/** Tracer les lignes de visualisation entre les candidats et les écrans des autres postes
		 * @param g Contexte graphique
		 */
		private void tracerVisualisations(Graphics2D g){
			float dash[]={2f,0f,2f} ;
			BasicStroke pointilles = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,dash,2f) ;
			g.setStroke(pointilles) ;
			g.setColor(Color.red) ;
			for(PlanSalle.Poste poste : modele.listerPostes()){
				int centreX = Parametres.centrePersonneX(poste.getPosition().getTravee(),poste.getOrientation()) ;
				int centreY = Parametres.centrePersonneY(poste.getPosition().getRangee(),poste.getOrientation()) ;
				for(PlanSalle.Poste posteVisible : poste.getPostesVisibles()){
					int visibleX = Parametres.centrePositionX(posteVisible.getPosition().getTravee()) ;
					int visibleY = Parametres.centrePositionY(posteVisible.getPosition().getRangee()) ;
					g.drawLine(centreX,centreY,visibleX,visibleY) ;
				}
			}
		}
	
}
	
}
