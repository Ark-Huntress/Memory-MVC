// Matière:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Théo Richier
// Création : 	15/11/2021 à 22:36

package memory;

import java.util.Observable;
import java.util.Observer;

import java.awt.*;      

import javax.swing.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PanneauImages extends JPanel implements Observer {
	
	// Attributs contenant les objets Images correspondants aux fichiers des images
	private Image background, img[];
	
	private Model model;
	
	public PanneauImages(Model m) {
		model = m;
		this.img = new Image[10]; // Création de le tableau contenant nos 10 images
		
		try { // Lancement de l'instruction
			background = ImageIO.read(new File("img/empty_stripe.jpg")); // Cherche dans le dossier img notre background
			for(int i = 0; i<10; i++){
				img[i] = ImageIO.read(new File("img/image_"+i+".jpg")); // Cherche dans le dossier img nos cartes
			}
		}
		catch(IOException e){
			System.out.println("ERREUR du chargement des images "+e);
		};
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);			
		setBackground(Color.white);
		int x=5,y=5; //coordonnees des positions ou les images doivent etre dessinees
			
		// Affiche l'image fond dans chaque zone
		// --> a faire evoluer ensuite pour faire apparaitre les images de im dans les bonnes zones
		for(int i=0;i<20;i++){
			if(!model.getVisible()[i]){
				g.drawImage(background,x,y,this); //Dessine l'image fond a la position (x,y)
			}else{
				g.drawImage(img[model.getOrdre()[i]],x,y,this);
			}
			x+=120;
			if(x==605){
				x=5;y+=120;
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();	
	}
}