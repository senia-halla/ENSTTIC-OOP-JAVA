/* Ce m�me probl�me peut �tre abord� selon un paradigme orient� objet d�un point de vue � donn�e �.
On cherche d�abord � mod�liser un polyn�me en d�finissant une classe Polynome. 
Ensuite, cette classe peut �tre instanci�e � tout moment pour repr�senter un polyn�me,
l�afficher, calculer sa racine, l��valuer en un point x, etc. */ 
import java.util.*;
import java.lang.*;
class Polynome{
	Scanner clavier = new Scanner(System.in);

	private double [] coefficients;
	private int degrePolynome=0;
	
	double x;
	double poly;
	double [] monome;
	
	public Polynome(int degrePolynomeEntre){
		degrePolynome = degrePolynomeEntre;
	}

	public void coefficients(int degrePolynome){
		int i=0;
		coefficients = new double[degrePolynome+1];
		for(i=0;i<=degrePolynome; i++){
			System.out.println("Entrez le coefficient corrependant au degr� "+i);
			coefficients[i] = clavier.nextInt();
		}
	}

	public void affiche(){
		int i=0;
		for(i=0;i<=degrePolynome; i++){
			System.out.print(coefficients[i]+"X^"+i+" + ");
		}
	}

	/* public double [] monome (int degreMonome){
		int i=0;
		double x;
		monome = new double[degrePolynome+1];
		for(i=0 ; i<= degrePolynome; i++){
			monome[i]=coefficients[i]*(double)Math.pow(x,i);
		}
		return monome;
	}*/
	public double resultatDansUnPoint(double x){
		int i=0;
		poly = 0;
		for(i=0 ; i<= degrePolynome; i++){
			poly += coefficients[i]*(double)Math.pow(x,i);
		}
		return poly;
	}
}

public class Tp15PolynomeParadigmeOrienteObjet {
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);
		int degrePolynome =0;
		double x;
		double [] tabCoeff;
		

		//degr�s polynome 
		System.out.println("Entrez le degre de votre polynome");
		degrePolynome = clavier.nextInt();
		Polynome p1 = new Polynome (degrePolynome);
		// entree de coefficients
		p1.coefficients(degrePolynome); 
		
		//affichage polynome 
		p1.affiche();

		//valeur de x
		System.out.println("Vus vouliez calculer le polynome dans quel point");
		x = clavier.nextDouble();
		double r=0;
		r=p1.resultatDansUnPoint(x);
		//Resultat du polynome a la valeur de x
		System.out.println("Le resultat du polynome au poin"+x+"est egale � "+r);
	}
}