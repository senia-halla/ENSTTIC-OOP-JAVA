import java.util.*;
class Tableau {
	//Variables 
	private int [] tableau; 
	private Random random ;
	private int temporaire;
	private boolean sortir = true;
	//Constructeur :
	public Tableau(){
		tableau = new int [10];
		random = new Random();
	}
	// Remplir Tableau 
	public void remplir(){
		for(int i=0; i<tableau.length;i++){
			tableau[i]= random.nextInt(100);
		}
	}

	// Afficher Tableau 
	public void afficher(){
		for(int i=0; i<tableau.length;i++){
			System.out.print(tableau[i]+"    ");
		}
	}

	// Trier Tableau
	public void trier(){
		while(sortir){
			sortir = false;
			for(int i=0; i<tableau.length-1;i++){
				if(tableau[i]>tableau[i+1]){
					temporaire = tableau[i];
					tableau[i] = tableau[i+1];
					tableau[i+1] = temporaire;
					sortir = true;
				}
			}
		}
	}
}

public class TriTableau{
	public static void main(String[] args){
		Tableau tableau = new Tableau();
		tableau.remplir();
		tableau.afficher();
		System.out.println();
		tableau.trier();
		tableau.afficher();
	}
}
