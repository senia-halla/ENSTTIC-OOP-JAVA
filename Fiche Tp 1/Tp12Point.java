class Point1D {
	private char nomDuPoint ;
	private double abcisse ;

	public Point1D (char nomDuPointEntree, double abcisseEntree ) {
		nomDuPoint = nomDuPointEntree;
		abcisse = abcisseEntree;
	}

	public void affiche(){
		System.out.println(nomDuPoint+"("+abcisse+")");
	}

	public void deplacement(double deplacementEntree){
		abcisse = abcisse + deplacementEntree ;
	}
}

public class Tp12Point {
	public static void main(String[] args){
		// creation d'un point 
		Point1D originalPoint = new Point1D('x', 4);
		//Affichage d'un point
		originalPoint.affiche();
		// deplacement
		originalPoint.deplacement(2.5);
		System.out.println("Apres un deplacement de  2.5  : ");
		originalPoint.affiche();
	}
}

