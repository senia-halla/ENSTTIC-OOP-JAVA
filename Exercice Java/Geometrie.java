/*
Ecrivez un programme Geometrie qui permet � l'utilisateur d'entrer les coordonn�es (x, y) des sommets d'un triangle. 
Le programme affiche ensuite le p�rim�tre du triangle ainsi qu'un message indiquant s'il s'agit d'un triangle isoc�le. 
Votre programme doit �tre orient� objets. Indications:
Un triangle est isoc�le si au moins deux c�t�s ont la m�me longueur.
La formule pour calculer la distance entre deux points (x1, y1) et (x2, y2) est: racine carr�e de (x1 - x2)2 + (y1 - y2)2.
Java met � disposition la m�thode Math.sqrt() pour calculer la racine carr�e. Cette m�thode prend un nombre non-n�gatif 
en param�tre. 
Exemple: 
double a = Math.sqrt(9.0);  // la valeur 3.0 sera affect�e � a
Exemple d'affichage du programme pour un triangle isoc�le:
Construction d'un nouveau point
Veuillez entrer x : 0
Veuillez entrer y : 0
Construction d'un nouveau point
Veuillez entrer x : 2.5
Veuillez entrer y : 2.5
Construction d'un nouveau point
Veuillez entrer x : 0
Veuillez entrer y : 5
P�rim�tre : 12.071067811865476 
Le triangle est isoc�le
Dans cet exercice, vous �laborerez un programme orient� objets de mani�re ind�pendante pour la premi�re fois.
Si vous n'avez pas le temps de faire cet exercice, n'oubliez pas d'en �tudier le corrig�.
R�fl�chissez aux objets que vous aimeriez utiliser dans le programme. Vous pourriez par exemple repr�senter le triangle par une classe 
Triangle et ses points par une classe Point. Une troisi�me classe Geometrie pourrait h�berger la m�thode main.
R�fl�chissez aux variables et m�thodes d'instance qui seraient utiles pour les classes Triangle et Point.
Un objet de type Point a typiquement les coordonn�es x et y. Un objet de type Triangle a trois sommets qui peuvent 
�tre repr�sent�s par des objets de type Point.
Les coordonn�es des points peuvent par exemple �tre entr�es dans la m�thode constructeur de la classe Point � l'aide 
de la m�thode scanner.nextDouble(). Dans ce cas, la m�thode constructeur n'a pas de param�tres.
Le p�rim�tre d'un triangle peut �tre calcul� comme la somme des distances entre les trois sommets.
Une m�thode calculerDistance() peut �tre utile pour calculer la distance entre deux points. La formule est indiqu�e ci-dessus. 
Si cette m�thode se trouve dans la classe Point, le premier point est accessible sous forme de
l'objet utilis� pour appeler la m�thode (l'objet actuel this), mais il faut envoyer le deuxi�me point en param�tre.
Si les variables d'instance x et y du deuxi�me point sont priv�es, il faut mettre � disposition des m�thodes getX() et getY() 
afin de pouvoir acc�der aux valeurs n�cessaires pour le calcul.
*/
import java.util.*;
import java.lang.*;

class PoinT{
	private char nom;
	private double x = 0.0;
	private double y = 0.0;
	// constructeur 
	public PoinT(char nom ,double x, double y){
		this.nom = nom;
		this.x = x;
		this.y = y;
	}



	public String toString(){
		return (nom+" ( "+x+" , "+y+" )");
	}


	// acceseurs 
	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
}
class Triangle{
	private char nom1, nom2, nom3 ;
	private double x1 , y1, x2, y2 , x3, y3;

	private PoinT point1 = new PoinT( nom1, x1, y1);
	private PoinT point2 = new PoinT(nom2, x2,  y2);
	private PoinT point3 = new PoinT(nom3, x3,  y3);

	public Triangle(PoinT point1, PoinT point2, PoinT point3) {
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
 
	public double perimetre(){
		double p = 0;
		p = longueur(point1,point2) + longueur(point1,point3) + longueur(point2,point3);
		return p;
	}

	public String toString() {
		return ("Triangle : " + point1.toString() + " , " + point2.toString() + " , " + point3.toString() );
	}

	public PoinT getP1(){
		return point1;
	}
	public PoinT getP2(){
		return point2;
	}
	public PoinT getP3(){
		return point3;
	}	

	public static double longueur(PoinT a, PoinT b){
		double longueur = 0;
		double diff1 = (a.getX() - b.getX());
		double diff2 = (a.getY() - b.getY());
		double somme = ( diff1*diff1 ) + ( diff2*diff2 );
		longueur = Math.sqrt(somme);
		return longueur;
	}		
}

public class Geometrie{
	public static void main( String[] args ){
		Scanner clavier = new Scanner(System.in);
		double x1, y1, x2, y2, x3, y3;
		char nom1 = 'A', nom2 = 'B', nom3 = 'C';

		System.out.println("Entrez l'abcisse et l'ordonn�e du point "+nom1);
		x1 = clavier.nextDouble();
		y1 = clavier.nextDouble();
		PoinT p1 = new PoinT(nom1, x1 ,y1);
		System.out.println(p1.toString());

		System.out.println("Entrez l'abcisse et l'ordonn�e du point "+nom2);
		x2 = clavier.nextDouble();
		y2 = clavier.nextDouble();
		PoinT p2 = new PoinT(nom2, x2 ,y2);
		System.out.println(p2.toString());

		System.out.println("Entrez l'abcisse et l'ordonn�e du point "+nom3);
		x3 = clavier.nextDouble();
		y3 = clavier.nextDouble();
		PoinT p3 = new PoinT(nom3, x3 ,y3);
		System.out.println(p3.toString());

		Triangle triangle = new Triangle(p1,p2,p3);
		System.out.println(triangle.toString());

		System.out.println(triangle.perimetre());
		double l1 = Triangle.longueur(p1,p2);
		double l2 = Triangle.longueur(p1,p3);
		double l3 = Triangle.longueur(p2,p3);

		if( l1 == l2 || l1 ==  l3 || l3 == l2 ){
			System.out.println("Le triangle est isoc�le");
		}
		else {
			System.out.println("Le triangle n'est pas isoc�le");
		}
	}
}