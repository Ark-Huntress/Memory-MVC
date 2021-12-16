// Matière:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Théo Richier
// Création : 	15/11/2021 à 22:36

package memory;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class VueNbPaires extends JLabel implements Observer {

	public VueNbPaires(){
		this.setText("Nombre de paires: 0");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.setText("Nombre de paires: "+ ((Model)o).getNbCoups());
		
	}
}
