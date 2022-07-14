import java.util.*;
import java.lang.*;
class Polynome {
	private int degrePolynome;
	private double [] coefficient;
	private int i = 0;
	private double x;

	public Polynome(int degrePolynomeEntre, double [] coefficientEntre){
		this.degrePolynome = degrePolynomeEntre;
		this.coefficient = coefficientEntre;
	}

	public void calculMonome(int degre){
		double [] monome = new double[degrePolynome+1];
		for(i=0;i<=degrePolynome;i++){
			monome[i]=coefficient[i]*(double)Math.pow(x,i);
		}
	}

	public double calculPolynomeDansPoint(double x){
		double poly = 0;
		for(i=0;i<=degrePolynome;i++){
			poly += coefficient[i]*(double)Math.pow(x,i);
		}
		return poly;
	}
}

public class Tp15Polynome{
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);
		int degrePolynome = 0;
		double x=0;
		double [] tabCoeff;
		int i=0;
		double r = 0;

		System.out.println("************* Calcul sur un polynome *************");
		System.out.println("Quel est le degr� de votre polynome ?");
		degrePolynome = clavier.nextInt();
		tabCoeff = new double[degrePolynome+1]; // instance du tableau apres definition du degr� de polynome
		System.out.println("Entrez les coefficient de votre polynome : ");
		for(i=0;i<=degrePolynome;i++){
			System.out.println("le coefficient du polynome degre"+i);
			tabCoeff[i]=clavier.nextDouble();
		}
		Polynome polynome = new Polynome(degrePolynome, tabCoeff); // instance du polynome apres affectation des valeurs tableau et deg sinon il prendera comme parametre les valeurs initial
		System.out.println("Vous voulez calculer le r�sultat de polynome dans quel point?");
		x = clavier.nextInt();
		r = polynome.calculPolynomeDansPoint(x);
		System.out.println("Le resultat du polynome au point "+x+" est "+r);
	}
}
