// Matière:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Théo Richier
// Création : 	15/11/2021 à 22:36

package memory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controler implements MouseListener{
	
	// Modèle de MVC
	private Model model;
	
	// Le paramètre de Model
	public Controler(Model m){
		model = m;
	}
	
	//
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int positionImage = (int)Math.floor(x/120) + (int)Math.floor(y/120)*5;
		model.modificationGrille(positionImage);
	}

	// L'interface MouseListener déclare cinq méthodes, nous sommes obliger de définir ces 4 autres méthodes, même si on ne va pas les utilisés.
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}