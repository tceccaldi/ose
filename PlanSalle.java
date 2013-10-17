import java.util.* ;

/** Modèle (MVC) de l'application - Représentation mémoire du plan de salle
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class PlanSalle {
	private String nom ;
	private List<Poste> postes = new ArrayList<Poste>() ;

	/** Constructeur
	 * @param nom Nom du plan de salle
	 */
	public PlanSalle(String nom) {
		super();
		this.nom = nom;
	}

	/** Obtenir le nom du plan de salle
	 * @return Nom du plan de salle
	 */
	public String getNom() {
		return nom;
	}

	/** Modifier le nom du plan de salle
	 * @param nom Nouveau nom du plan de salle
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/** Ajouter un poste au plan de salle
	 * @param position Position du nouveau poste
	 * @param orientation Orientation du nouveau poste
	 */
	public void ajouterPoste(Position position,int orientation){
		postes.add(new Poste(position,orientation)) ;
		this.rechercherPostesVisibles() ;
	}
	
	/** Retirer un poste du plan de salle
	 * @param position Position à libérer
	 */
	public void retirerPoste(Position position){
		int indice = this.rechercherPoste(position) ;
		if(indice != -1){
			postes.remove(indice) ;
			this.rechercherPostesVisibles() ;
		}
	}
	
	/** Visualiser sous forme textuelle le plan de salle
	 */
	public void visualiserPostes(){
		int i = 0 ;
		for(Poste poste : postes){
			System.out.println(i+" : "+poste) ;
			i++ ;
		}
	}
	
	/** Rechercher l'indice d'un poste dans le plan de salle
	 * @return Indice du poste recherché
	 */
	public int rechercherPoste(Position position){
		int i = 0 ;
		int indice = -1 ;
		while(i < postes.size() && indice == -1){
			if(position.equals(postes.get(i).getPosition())){
				indice = i ;
			}
			else {
				i++ ;
			}
		}
		return indice ;
	}
	
	/** Savoir si une position est occupée par un poste
	 * @return true si la position est occupée, et false dans le cas contraire
	 */
	public boolean positionOccupee(Position position){
		int indice = this.rechercherPoste(position) ;
		if(indice != -1){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Obtenir la liste des postes
	 * @return Liste des postes
	 */
	public List<Poste> listerPostes(){
		return this.postes ;
	}
	
	/** Créer, pour chaque poste, la liste des postes visibles
	 */
	private void rechercherPostesVisibles(){
		for(Poste poste : postes){
			poste.initialiserPostesVisibles() ;
			for(int orientation = Orientation.NORD ; orientation <= Orientation.NORDOUEST ; orientation += 1){
				Position positionCible = Position.voisin(poste.getPosition(),orientation) ;
				if(Position.estPositionValide(positionCible)){
					int indicePosteVoisin = this.rechercherPoste(positionCible) ;
					if(indicePosteVoisin != -1){
						if(Orientation.estVisible(poste.getOrientation(),orientation,postes.get(indicePosteVoisin).getOrientation())){
							poste.ajouterPosteVisible(postes.get(indicePosteVoisin)) ;
						}
					}
				}
			}
		}
	}
}
