class Point{
	private int x,y;

	public void initialise(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void deplace(int dx, int dy){
		x += dx;
		y += dy;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}

class PointA extends Point{
	public void affiche(){
		System.out.println("******Les Cordonnées du point******");
		System.out.println("L'abcisse : "+getX()+" L'ordonnée "+getY());
	}
}

public class Ex1ClasseDerive{
	public static void main(String[] args){
		Point p = new Point();
		p.initialise(2,7);
		p.deplace(1,1);
		System.out.println("******Les Cordonnées du point******");
		System.out.println("L'abcisse : "+p.getX()+" L'ordonnée "+p.getY());
		PointA pa = new PointA();
		pa.initialise(25,12);
		pa.affiche();
	}
}