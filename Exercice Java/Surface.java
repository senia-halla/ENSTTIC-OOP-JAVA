/* Dans ce programme, les 2 rectangles sont encapsulés dans un objet
   de type Terrain qui s'occupe de calculer et d'afficher la surface
   totale. Le mot-clé private a été utilisé le plus possible dans
   toutes les classes. La classe Rectangle met aussi à disposition des
   méthodes get et set pour ses variables (il s'agit d'un service que
   le programmeur de la classe peut offrir à ses utilisateurs s'il le
   juge utile).  */
import java.util.*;
public class Surface {
    public static void main(String[] args) {
		Scanner clavier = new Scanner(System.in);
        double l1, h1, l2, h2, r1, r2;

		System.out.println("Largeur et hauteur du 1 er rectangle");
		l1 = clavier.nextDouble();
		h1 = clavier.nextDouble();
		System.out.println("Largeur et hauteur du 2 eme rectangle");
		l2 = clavier.nextDouble();
		h2 = clavier.nextDouble();
		System.out.println("Rayon de 1 er cercle");
		r1 = clavier.nextDouble();
		System.out.println("Rayon de 2 eme cercle");
		r2 = clavier.nextDouble();
		
        Terrain t = new Terrain(l1, h1, l2, h2, r1, r2);
        t.afficherSurfaceTotale();
    }

}

class Terrain {
    private Rectangle r1, r2;
	private Cercle c1, c2;
    

    public Terrain(double l1, double h1, double l2, double h2, double ry1 , double ry2) {
        // Construction des 2 rectangles définissant le terrain:
        r1 = new Rectangle(l1, h1);
        r2 = new Rectangle(l2, h2);
		c1 = new Cercle(ry1);
		c2 = new Cercle(ry2);
    }

    private double calculerSurfaceTotale() {
        return r1.calculerSurface() + r2.calculerSurface() + c1.calculerSurface() + c2.calculerSurface();
    }

    public void afficherSurfaceTotale() {
        double surfaceTotale = calculerSurfaceTotale();
       System.out.println("La surface totale est " + surfaceTotale);
    }
}

class Rectangle {
    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double calculerSurface() {
        return (largeur * hauteur);
    }
}

class Cercle {
	private double rayon;
	public Cercle(double rayon){
		this.rayon = rayon;
	}

	public void setRayon(double rayon){
		this.rayon = rayon;
	}

	public double getRayon(){
		return rayon;
	}

	public double calculerSurface() {
        return (Math.PI * rayon * rayon);
    }
}