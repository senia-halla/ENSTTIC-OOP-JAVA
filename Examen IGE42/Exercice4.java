import java.util.*;

interface FonctionDerivable{
	double f (double x);
	double f_derivee (double x);
}

class Polynome implements FonctionDerivable {
	private int degrePolynome;
	private double [] coefficientsPolynome;

	public Polynome(){
	
	}

	public Polynome(int degrePolynome , double [] coefficientsPolynome){
		this.degrePolynome = degrePolynome;
		this.coefficientsPolynome = coefficientsPolynome;
	}

	public Polynome derivee(){
		int j=0;
		double [] coefficientsPolynomeDerivee = new double[degrePolynome];
		for(int i=degrePolynome;i>0; i--){
			coefficientsPolynomeDerivee [j] = coefficientsPolynome[j]*i;
			j++;
		}
		int degrePolynomeDerivee = degrePolynome - 1;
		return new Polynome(degrePolynomeDerivee,coefficientsPolynomeDerivee);
	}

	public double f(double x){
		double resultatDuPolynomeDansPointX = 0;
		for(int i=0 ; i<= degrePolynome; i++){
			resultatDuPolynomeDansPointX += coefficientsPolynome[i]*Math.pow(x,degrePolynome-i);
		}
		return resultatDuPolynomeDansPointX;
	}

	public double f_derivee(double x){
		Polynome p = this.derivee();
		return p.f(x);
	}

	public double [] getCoefficientPolynome(){
		return coefficientsPolynome;
	}

	public int getDegrePolynome(){
		return degrePolynome;
	}

	

	public String tostring(){
		String polynomeAffiche;
		polynomeAffiche = (coefficientsPolynome[0]+"x^"+degrePolynome);
		for(int i=1; i<= degrePolynome-1 ; i++){
			polynomeAffiche = polynomeAffiche + ("+" + coefficientsPolynome[i] +" x^"+(degrePolynome - i));
		}
		polynomeAffiche = polynomeAffiche + (" + "+coefficientsPolynome[0]);
		return polynomeAffiche;
	}

	
}

public class Exercice4{
	public static Scanner clavier = new Scanner(System.in);
	public static void main(String[] args){
		double [] coefficientsPolynome;
		int degrePolynome;
		double x;

		degrePolynome = degrePolynome();
		coefficientsPolynome = coefficientsPolynome(degrePolynome);
		Polynome polynome = new Polynome(degrePolynome , coefficientsPolynome);
		Polynome polynomeDerivee = polynome.derivee();
		x = pointX();
		double resultatPolynome = polynome.f(x);
		double resultatDerivee = polynome.f_derivee(x);
		System.out.println(" p = " + polynome.tostring() );
		System.out.println(" p' = " + polynome.derivee().tostring() );
		System.out.println("La valeur du polynome dans le point x : "+resultatPolynome);
		System.out.println("Et la valeur du polynome derive : "+resultatDerivee);
	}

	static int degrePolynome(){
		int degrePolynome;
		System.out.print("Entrez le degre de votre polynome : ");
		degrePolynome = clavier.nextInt();
		return degrePolynome;
	}

	static double [] coefficientsPolynome(int degrePolynome){
		double [] coefficients = new double[degrePolynome + 1];
		System.out.println("Entrez les coefficients de votre Polynome : ");
		for(int i = 0; i <= degrePolynome; i++){
			System.out.print("Coefficient n� "+(i+1)+" : ");
			coefficients[i] = clavier.nextDouble();
		}
		return coefficients;
	}

	static double pointX(){
		double x;
		System.out.print("Pour quel point vous voulez calculer : ");
		x = clavier.nextDouble();
		return x;
	}
}