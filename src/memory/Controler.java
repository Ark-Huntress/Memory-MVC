// Mati�re:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Th�o Richier
// Cr�ation : 	15/11/2021 � 22:36

package memory;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controler implements MouseListener{
	
	// Mod�le de MVC
	private Model model;
	
	// Le param�tre de Model
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

	// L'interface MouseListener d�clare cinq m�thodes, nous sommes obliger de d�finir ces 4 autres m�thodes, m�me si on ne va pas les utilis�s.
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}