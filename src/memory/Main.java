// Matière:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Théo Richier
// Création : 	15/11/2021 à 22:36

package memory;

import java.util.Observer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main {

	public static void main(String[] args) {
		
		JPanel panneauMenu; // Contient les labels de nombre de Coups et paires + les boutons
		PanneauImages panneauImages; //
		JLabel nbCoups; // Affiche le nombre de coups
		JLabel nbPaires; // Affiche le nombre de paires trouvées
		Border border;
		
		JFrame frame = new JFrame("Le Memory Pokémon MVC");
		
		
		// Création de l'instance Model
		Model model = new Model();
		
		// Création de l'instance Controler
		Controler controler = new Controler(model);
		
		// Création des bords le l'interface
		Border raisedbevel 	= BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		border = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
		
		// Configuration de panneauMenu
		panneauMenu = new JPanel(new GridLayout(3,1));
		
		// Ajout du JLabel NbCoups + sa configuration visuel
		nbCoups=new VueNbCoups();
		nbCoups.setPreferredSize(new Dimension(605,55)); // On utilise setPreferredSize plutôt que size car le label à un parent
		nbCoups.setOpaque(false); // Transparence
		nbCoups.setForeground(Color.gray);
		nbCoups.setBorder(border);
		panneauMenu.add(nbCoups);
		
		// Ajout du JLabel NbPaires + sa configuration visuel
		nbPaires=new VueNbPaires();
		nbPaires.setPreferredSize(new Dimension(605,55));
		nbPaires.setOpaque(false); // Transparence
		nbPaires.setForeground(Color.gray);
		nbPaires.setBorder(border);
		panneauMenu.add(nbPaires);
		
		JPanel boutons;
		
		// Création du JPanel contenant les actions rejouer et quitter
		boutons = new JPanel();
		
		//JButton ????? = new ControlerBouton(model); "Dans le cas où on voudra gérer les boutons dans une autre class"
		JButton rejouer = new JButton("Rejouer");
		rejouer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				model.init();
				
			}
			
		});
		
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(new ActionListener(){ //ActionListener permet grâce à un clic de souris, d'effectuer une action

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cela équivaut à un System.exit(), ça arrête le progamme
			}
			
		});
		
		boutons.add(rejouer);
		boutons.add(quitter);
		panneauMenu.add(boutons);
		
		panneauImages = new PanneauImages(model);
		panneauImages.setPreferredSize(new Dimension(605, 485));
		panneauImages.setBorder(border);
		
		// Ajout du controler dans MouseListener
		panneauImages.addMouseListener(controler);
		
		//  Ajout des vues à l'Observable
		model.addObserver(panneauImages);
		model.addObserver((Observer) nbCoups);
		model.addObserver((Observer) nbPaires);
		
		// Construction de l'IG dans une JFrame		 
		
		frame.getContentPane().setBackground(Color.GRAY);	 
		
		frame.getContentPane().add(panneauImages,BorderLayout.CENTER);
		frame.getContentPane().add(panneauMenu,BorderLayout.SOUTH);
		  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);			
	
	}
}
