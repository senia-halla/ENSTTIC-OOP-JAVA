 class Point2D{
	private char nomDuPoint;
	private double abcisse;
	private double ordonne;

	public Point2D(char nomDuPointEntre, double abcisseEntre, double ordonneEntre) {
		nomDuPoint = nomDuPointEntre;
		abcisse = abcisseEntre;
		ordonne = ordonneEntre;
	}

	public void affiche(){
		System.out.println(nomDuPoint+"("+abcisse+","+ordonne+")");
	}

	public void deplacement(double dx, double dy){
		abcisse += dx;
		ordonne += dy;
	}
	// consultation get 
	public double getAbcisse(){
		return abcisse ;
	}

	public double getOrdonne(){
		return ordonne ;
	}

	public char getNom(){
		return nomDuPoint;
	}

	//modification set 
	public void setAbcisse(double abcisse){
		this.abcisse = abcisse ;
	}

	public void setOrdonne(double ordonne){
		this.ordonne = ordonne ;
	}

	public void setNom(char nomDuPoint){
		this.nomDuPoint = nomDuPoint;
	}
}

 class Segment{
	private Point2D pointOriginal, pointExtremite;
	
	// segment a partir de points existants :
	public Segment(Point2D p1, Point2D p2){
		pointOriginal = p1;
		pointExtremite = p2;
	}

	// segment creer au meme temps que les points :
	public Segment(char nomEntre1, double abcisseEntre1, double ordonneEntre1, char nomEntre2, double abcisseEntre2, double ordonneEntre2){
		pointOriginal = new Point2D(nomEntre1, abcisseEntre1, ordonneEntre1);
		pointExtremite = new Point2D(nomEntre2, abcisseEntre2, ordonneEntre2);
	}

	public void affiche(){
		System.out.println("[ " + pointOriginal.getNom() +" , "+ pointExtremite.getNom() +" ]");
	}

	public double longueur(){
		double x1 = pointOriginal.getAbcisse();
		double y1 = pointOriginal.getOrdonne();
		double x2 = pointExtremite.getAbcisse();
		double y2 = pointExtremite.getAbcisse();
		return Math.sqrt( ( (x2-x1)*(x2-x1) ) + ( (y2-y1)*(y2-y1) ) );
	}

	public void  deplacementOrigine(double dx, double dy){
		 pointOriginal.deplacement(dx,dy);
	}

	public void deplacementExtremite(double dx, double dy){
		 pointExtremite.deplacement(dx,dy);
	}
}

public class Tp13Segment{
	public static void main(String[] args){
		// creation deux points
		Point2D origine = new Point2D('o',2,4);
		Point2D extremite = new Point2D('e',1,5);

		// creation segment 
		Segment s = new Segment (origine,extremite);
		

		// affichage d'un segment
		System.out.println("Point origine o : ");
		origine.affiche();

		System.out.println("point extremité e : ");
		extremite.affiche();

		System.out.println("Segment s : ");
		s.affiche();

		//Affichage longeur
		System.out.println("La longueur du segment : "+ s.longueur());
		
		//deplacement des point origine extremiter

		/*
		origine.deplacement(1,1);
		extremite.deplacement(0,2);
		*/
		s.deplacementOrigine(1,1);
		s.deplacementExtremite(2,2);

		//affichage apres deplacement 
		Segment sDeplace = new Segment (origine,extremite);

		System.out.println("Le nouveau segment : ");
		sDeplace.affiche();

		System.out.println("Point origine o ': ");
		origine.affiche();

		System.out.println("point extremité e ': ");
		extremite.affiche();

		System.out.println("La longueur du nouveau segment : "+ sDeplace.longueur());
	}
}
