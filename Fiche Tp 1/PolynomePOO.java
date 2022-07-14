import java.util.*;
class Polynome{
	private int degrePolynome ;
	private double [] tabCoeff ;

	public Polynome(int degrePolynome , double [] tabCoeff){
		this.degrePolynome = degrePolynome;
		this.tabCoeff = tabCoeff;
	}

	public double [] getCoeff(){
		return tabCoeff;
	}

	public double calculValeurPolynomePourPointX(double x){
		double valeurPolynome = 0;
		for(int i=0 ; i<= degrePolynome ; i++){
			valeurPolynome += tabCoeff[i]*(double)Math.pow(x,i);
		}
		return valeurPolynome;
	}
}

public class PolynomePOO{
	public static Scanner clavier = new Scanner(System.in);
	public static void main(String[] args){
		int degrePolynome;
		double [] tabDesCoeff ;
		double x;

		degrePolynome = getDegrePolynome();
		tabDesCoeff = entrezLesCoefficients(degrePolynome);

		Polynome polynome = new Polynome(degrePolynome, tabDesCoeff);
		polynome.toString();
		x = getPointX();
		System.out.println("resultat : "+polynome.calculValeurPolynomePourPointX(x));
		
	}

	static int getDegrePolynome(){
		int degrePolynome;
		System.out.println("Quel est le degre de votre polynome");
		degrePolynome = clavier.nextInt();
		return degrePolynome;
	}

	static double [] entrezLesCoefficients(int degrePolynome){
		System.out.println("*********les coefficients***********");
		double [] tabDesCoeff = new double[degrePolynome+1];

		for(int i=0;i<=degrePolynome; i++){
			System.out.println("Entrez le coefficient corrependant au degre "+i);
			tabDesCoeff[i] = clavier.nextInt();
		}
		return tabDesCoeff;
	}
	static double getPointX(){
		double x ;
		System.out.println("Vous voulez calculer le polynome au niveau de quel point ?");
		x = clavier.nextDouble();
		return x;
	}
}