// Mati�re:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Th�o Richier
// Cr�ation : 	15/11/2021 � 22:36

package memory;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class VueNbCoups extends JLabel implements Observer {
	
	public VueNbCoups(){
		this.setText("Nombre de coups: 0");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setText("Nombre de coups: "+ ((Model)o).getNbCoups());
		
	}
}
