/** Orientations et conséquences
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class Orientation {
	/** Orientation NORD
	 */
	public final static int NORD = 0 ;
	
	/** Orientation NORD-EST
	 */
	public final static int NORDEST = 1 ;
	
	/** Orientation EST
	 */
	public final static int EST = 2 ;
	
	/** Orientation SUD-EST
	 */
	public final static int SUDEST = 3 ;
	
	/** Orientation SUD
	 */
	public final static int SUD = 4 ;
	
	/** Orientation SUD-OUEST
	 */
	public final static int SUDOUEST = 5 ;
	
	/** Orientation OUEST
	 */
	public final static int OUEST = 6 ;
	
	/** Orientation NORD-OUEST
	 */
	public final static int NORDOUEST = 7 ;
	
	/** Table de déduction des visibilités
	 */
	private final static boolean visibilite[][][] = {
			{
				{true,false,false,false},
				{true,true,false,false},
				{true,true,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{true,false,false,true},
				{true,false,false,true}
			} ,
			{
				{true,true,false,false},
				{true,true,false,false},
				{false,true,false,false},
				{false,true,true,false},
				{false,true,true,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false}
			} ,
			{
				{false,false,false,false},
				{false,false,false,false},
				{false,true,true,false},
				{false,true,true,false},
				{false,false,true,false},
				{false,false,true,true},
				{false,false,true,true},
				{false,false,false,false}
			} ,
			{
				{true,false,false,true},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,false,false},
				{false,false,true,true},
				{false,false,true,true},
				{false,false,false,true},
				{true,false,false,true}
			}
		} ;
		
	/** Indiquer si l'écran d'un poste cible est visible par le candidat qui se trouve sur le poste source
	 * @param orientationSource Orientation du poste source
	 * @param positionCible Position du poste cible
	 * @param orientationCible Orientation du poste Cible
	 * @return true si le candidat qui se trouve sur le poste source peut voir l'écran du poste cible et false dans le cas contraire
	 */
	public static boolean estVisible(int orientationSource, int positionCible, int orientationCible){
		int x = orientationSource / 2 ;
		int y = positionCible ; 
		int z = orientationCible / 2 ;
		return visibilite[x][y][z] ;
	}
}
