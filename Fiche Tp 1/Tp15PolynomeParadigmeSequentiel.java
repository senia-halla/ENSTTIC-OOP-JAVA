/*Suivant un paradigme séquentiel, le problème est abordé d’un point de vue « traitement ». 
Ainsi, le programme se résume en une classe exécutable contenant une méthode statique 
main décrivant séquentiellement la solution au problème : saisie du degré et des coefficients
du polynôme et de la valeur de x, calcul de la valeur du polynôme en ce point et affichage du résultat.*/
import java.util.*;
import java.lang.*;
public class Tp15PolynomeParadigmeSequentiel{
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);

		// variables
		int degrePolynome;
		double [] tabDesCoeff ;
		double [] monome;
		double poly=0;
		double x;
		int i;

		// saisie du degrePolynome :
		System.out.println("Quel est le degré de votre polynome");
		degrePolynome = clavier.nextInt();

		// Les coefficients du polynome
		System.out.println("Entrez les coefficients");
		tabDesCoeff = new double[degrePolynome+1];

		for(i=0;i<=degrePolynome; i++){
			System.out.println("Entrez le coefficient corrependant au degré "+i);
			tabDesCoeff[i] = clavier.nextInt();
		}

		// la valeur de x
		System.out.println("Vous voulez calculer le polynome au niveau de quel point ?");
		x = clavier.nextDouble();

		// calcul du monome pour la valeur de x 
		monome = new double[degrePolynome+1];
		for(i=0 ; i<= degrePolynome; i++){
			monome[i]=tabDesCoeff[i]*(double)Math.pow(x,i);
		}
		
		for(i=0 ; i<= degrePolynome; i++){
			poly += monome[i];
		}
		System.out.println("Le resultat du polynome au point "+x+" est "+poly);
	}
}