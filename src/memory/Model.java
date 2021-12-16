// Matière:		ACD4
// TP: 			TP4_Memory_MVC
// Autheur : 	Dobrina Boltcheva
// Editeur : 	Théo Richier
// Création : 	15/11/2021 à 22:36

package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

	// Création de l'orde des images grâce à une liste
	private List<Integer> ordre;
	
	// Création d'un status de visibilité pour savoir si les images sont retournées ou non
	private boolean[] visible;
	
	private int nbPaires; // Nombre de paires trouvées
	private int nbCoups; // Nombre de coups jouées
	private int clicZone1; // Correspond au numéro de case que le jouer à cliquer pour la première fois
	private int clicZone2; // Correspond au numéro de case que le jouer à cliquer pour la deuxième fois
	private int nbClic; // par défaut O, Max de clic est de 2 clic 
	
	public Model() {
		// Création du tableau de la grille de jeu (comment ça je respecte pas le principe du hasard, je ne vois pas de quoi vous parlez)
		int[] grille = {0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
		ordre = new ArrayList<Integer>();
		
		// Permet de « visiter » toutes les cases en faisant avancer leur indice i
		for(int i = 0; i<grille.length;i++) {
			ordre.add(grille[i]); // On intègre la grille dans la list ordre 
		}
		
		// Configuration des valeurs par défauts
		visible = new boolean[20];
		nbPaires = 0;
		nbCoups = 0;
		clicZone1 = -1; // Pour être sur qu'il ne soit pas dans la grille
		clicZone2 = -1; // Pour être sur qu'il ne soit pas dans la grille
		nbClic = 0; // Peut aller jusqu'à 2
	}
	
	public boolean[] getVisible() {
		return visible;
	}

	public int getNbPaires() {
		return nbPaires;
	}
	
	public int getNbCoups() {
		return nbCoups;
	}
	
	public int[] getOrdre() {
		
		int[] grille = new int[20]; // Est egal à un tableau de 20 valeurs
		int i=0;
		for(int n: ordre){
			grille[i]=n;
			i++;
		}
		return grille;
	}
	
	public void modificationGrille(int numZone){
			if(nbClic == 2){
				nbClic = 0; // Réinitialise le nombe de coups, ce qui indique que c'est la fin du coups
				if(ordre.get(clicZone1)!= ordre.get(clicZone2)){ // Si la zone 1 et la zone 2 sont différents, alors ils redeviennent cacher
					visible[clicZone1]=false;
					visible[clicZone2]=false;
	
			}}
		if(!visible[numZone]){
			//}
			//else{
				if(nbClic == 0){ // On retourne la case sélectionner et on ajout 1 au nombre de clics
					clicZone1 = numZone;
					visible[numZone]=true;
					nbClic++;
				}
				else{
					if(nbClic == 1){ // On retourne la case sélectionner et on ajout 1 au nombre de clics et de coups
						clicZone2 = numZone;
						visible[numZone]=true;
						nbClic++;
						nbCoups++;
						if(ordre.get(clicZone1) == ordre.get(clicZone1)){ // On a trouvé une paire
							nbPaires++;
						}
					}
			//	}
			}
			this.setChanged(); //
			this.notifyObservers(); // Celui-ci vérifie si l'objet n'a pas changé
		}
		
	}
	
	// Méthode qui remet les valeurs par défaut 
	public void init() {
		
		// Configuration des valeurs par défauts
		visible = new boolean[20];
		nbPaires = 0;
		nbCoups = 0;
		clicZone1 = -1; // Pour être sur qu'il ne soit pas dans la grille
		clicZone2 = -1; // Pour être sur qu'il ne soit pas dans la grille
		nbClic = 0; // Peut aller jusqu'à 2
		
		Collections.shuffle(ordre); // Permet de mélanger aléatoirement la liste orde
		
		this.setChanged(); //
		this.notifyObservers(); // Celui-ci vérifie si l'objet n'a pas changé
	}
}
