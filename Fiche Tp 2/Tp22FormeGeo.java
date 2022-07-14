import java.util.*;
import java.lang.*;

abstract class Forme{
	public abstract double surface();
	public abstract double perimetre();
	public static boolean plusGrand (Forme f1, Forme f2) {
		if (f1.surface() > f2.surface()){
			return true;
		}
		else {
			return false;
		}
	}
} 

class Cercle extends Forme {
	private double rayon ;

	public Cercle(double rayon){
		this.rayon = rayon;
	}

	public double perimetre(){
		return (2*Math.PI*rayon);
	}

	public double surface(){
		return (Math.PI*rayon*rayon);
	}
}

class Rectangle extends Forme{
	private double longueur;
	private double largeur;

	public Rectangle(double longueur, double largeur){
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public double perimetre(){
		return(2*(longueur + largeur));
	}

	public double surface(){
		return(longueur*largeur);
	}
}

class Carre extends Rectangle{
	private double cote;
	public Carre(double cote){
		super(cote,cote);
	}
}

public class Tp22FormeGeo{
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);
		double rayon, longeur,largeur,cote;
		int typeDeForme;

		Cercle cercleReference = new Cercle(7);
		Rectangle rectangleReference = new Rectangle(7,2);
		Carre carreReference = new Carre(2);

		System.out.println("*******Calcul surface + perimetre d'une forme*******");
		System.out.println("Quel est votre forme ?");
		System.out.println("1. Cercle");
		System.out.println("2. Rectangle");
		System.out.println("3. Carré");
		typeDeForme = clavier.nextInt();
		switch(typeDeForme){
			case 1 : {
				System.out.println("Entrez le rayon de votre cercle");
				rayon = clavier.nextDouble();
				Cercle cercle = new Cercle(rayon);
				System.out.println("La surface de votre cercle est : "+cercle.surface()+" et le perimetre : "+cercle.perimetre());
				System.out.println("Le cercle choisi est plus grand que le cercle reference ? "+Forme.plusGrand(cercle,cercleReference));
			} break;

			case 2 : {
				System.out.println("Entrez la longeur et la largeur de votre rectangle");
				largeur = clavier.nextDouble();
				longeur = clavier.nextDouble();
				Rectangle rectangle = new Rectangle(longeur, largeur);
				System.out.println("La surface de votre rayon est : "+rectangle.surface()+" et le perimetre : "+rectangle.perimetre());
				System.out.println("Le rectangle choisi est plus grand que le rectangle reference ? "+Forme.plusGrand(rectangle,rectangleReference));
			} break;

			case 3 : {
				System.out.println("Entrez la cote de votre carr�");
				cote = clavier.nextDouble();
				Carre carre = new Carre(cote);
				System.out.println("La surface de votre rayon est : "+carre.surface()+" et le perimetre : "+carre.perimetre());
				System.out.println("Le carr� choisi est plus grand que le carr� reference ? "+Forme.plusGrand(carre,carreReference));
			} break;
		}
	}
}
