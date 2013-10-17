import java.util.* ;

/** Poste de travail
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class Poste {
	private List<Poste> postesVisibles ;
	private Position position ;
	private int orientation ;
	
	/** Constructeur
	 * @param position Position du poste dans la salle
	 * @param orientation Orientation du poste
	 */
	public Poste(Position position, int orientation) {
		super() ;
		this.position = position ;
		this.orientation = orientation ;
		this.initialiserPostesVisibles() ;
	}

	/** Obtenir la position du poste
	 * @return Position du poste
	 */
	public Position getPosition() {
		return position;
	}

	/** Modifier la position du poste
	 * @param position Nouvelle position du poste
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/** Obtenir l'orientation du poste
	 * @return Orientation du poste
	 */
	public int getOrientation() {
		return orientation;
	}

	/** Modifier l'orientation du poste
	 * @param orientation Nouvelle orientation du poste
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	/** Obtenir une représentation textuelle du poste
	 * @return Représentation textuelle du poste
	 */
	public String toString(){
		return position + " : " + orientation + " : " + this.peutVoir() ;
	}
	
	/** Obtenir la travée du poste
	 * @return La travée du poste
	 */
	public int getTravee(){
		return this.position.getTravee() ;
	}
	
	/** Obtenir la rangée du poste
	 * @return La rangée du poste
	 */
	public int getRangee(){
		return this.position.getRangee() ;
	}
	
	/** Savoir si le candidat qui se trouve sur ce poste peut voir l'écran d'un autre poste
	 * @return Visibilité du candidat
	 */
	public boolean peutVoir(){
		if(this.postesVisibles.size() == 0){
			return false ;
		}
		else {
			return true ;
		}
	}
	
	/** Initialiser la liste des postes dont l'écran est visible à partir du poste du candidat
	 */
	public void initialiserPostesVisibles(){
		this.postesVisibles = new ArrayList<Poste>() ;
	}
	
	/** Ajouter un poste visible à partir du poste du candidat
	 * @param poste Poste dont l'écran est visible pas le candidat
	 */
	public void ajouterPosteVisible(Poste poste){
		this.postesVisibles.add(poste) ;
	}
	
	/** Obtenir la liste des postes dont l'écran est visible à partir du poste du candidat
	 * @return Liste des postes dont l'écran est visible
	 */
	public List<Poste> getPostesVisibles(){
		return this.postesVisibles ;
	}
	
	/** Obtenir le nombre de postes dont l'écran est visible à partir du poste du candidat
	 * @return Nombre de postes dont l'écran est visible
	 */
	public int nbPostesVisibles(){
		return this.postesVisibles.size() ;
	}
}
