/*
Ecrivez un programme Geometrie qui permet à l'utilisateur d'entrer les coordonnées (x, y) des sommets d'un triangle. 
Le programme affiche ensuite le périmètre du triangle ainsi qu'un message indiquant s'il s'agit d'un triangle isocèle. 
Votre programme doit être orienté objets. Indications:
Un triangle est isocèle si au moins deux côtés ont la même longueur.
La formule pour calculer la distance entre deux points (x1, y1) et (x2, y2) est: racine carrée de (x1 - x2)2 + (y1 - y2)2.
Java met à disposition la méthode Math.sqrt() pour calculer la racine carrée. Cette méthode prend un nombre non-négatif 
en paramètre. 
Exemple: 
double a = Math.sqrt(9.0);  // la valeur 3.0 sera affectée à a
Exemple d'affichage du programme pour un triangle isocèle:
Construction d'un nouveau point
Veuillez entrer x : 0
Veuillez entrer y : 0
Construction d'un nouveau point
Veuillez entrer x : 2.5
Veuillez entrer y : 2.5
Construction d'un nouveau point
Veuillez entrer x : 0
Veuillez entrer y : 5
Périmètre : 12.071067811865476 
Le triangle est isocèle
Dans cet exercice, vous élaborerez un programme orienté objets de manière indépendante pour la première fois.
Si vous n'avez pas le temps de faire cet exercice, n'oubliez pas d'en étudier le corrigé.
Réfléchissez aux objets que vous aimeriez utiliser dans le programme. Vous pourriez par exemple représenter le triangle par une classe 
Triangle et ses points par une classe Point. Une troisième classe Geometrie pourrait héberger la méthode main.
Réfléchissez aux variables et méthodes d'instance qui seraient utiles pour les classes Triangle et Point.
Un objet de type Point a typiquement les coordonnées x et y. Un objet de type Triangle a trois sommets qui peuvent 
être représentés par des objets de type Point.
Les coordonnées des points peuvent par exemple être entrées dans la méthode constructeur de la classe Point à l'aide 
de la méthode scanner.nextDouble(). Dans ce cas, la méthode constructeur n'a pas de paramètres.
Le périmètre d'un triangle peut être calculé comme la somme des distances entre les trois sommets.
Une méthode calculerDistance() peut être utile pour calculer la distance entre deux points. La formule est indiquée ci-dessus. 
Si cette méthode se trouve dans la classe Point, le premier point est accessible sous forme de
l'objet utilisé pour appeler la méthode (l'objet actuel this), mais il faut envoyer le deuxième point en paramètre.
Si les variables d'instance x et y du deuxième point sont privées, il faut mettre à disposition des méthodes getX() et getY() 
afin de pouvoir accéder aux valeurs nécessaires pour le calcul.
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

		System.out.println("Entrez l'abcisse et l'ordonnée du point "+nom1);
		x1 = clavier.nextDouble();
		y1 = clavier.nextDouble();
		PoinT p1 = new PoinT(nom1, x1 ,y1);
		System.out.println(p1.toString());

		System.out.println("Entrez l'abcisse et l'ordonnée du point "+nom2);
		x2 = clavier.nextDouble();
		y2 = clavier.nextDouble();
		PoinT p2 = new PoinT(nom2, x2 ,y2);
		System.out.println(p2.toString());

		System.out.println("Entrez l'abcisse et l'ordonnée du point "+nom3);
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
			System.out.println("Le triangle est isocèle");
		}
		else {
			System.out.println("Le triangle n'est pas isocèle");
		}
	}
}