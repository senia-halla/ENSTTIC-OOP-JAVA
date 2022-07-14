class Point{
	private int x,y ;

	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void deplace(int dx, int dy){
		x += dx;
		y += dy;
	}
	public void affichageCoordonnes(){
		System.out.println("Les cordonnées : "+x+","+y);
	}
}

class PointNom extends Point{
	private String nom;
	public void setPointNom(int x, int y, String nom){
		setPoint(x,y);
		this.nom = nom ; 
	}
	public void setNom(String nom){
		this.nom = nom;
	}

	public void affichageCoordonnesNom(){
		System.out.print("Nom point : "+nom+" , ");
		affichageCoordonnes();
	}
}

public class Ex2ClasseDerive{
	public static void main(String[] args){
		Point p = new Point();
		p.setPoint(2,5);
		p.affichageCoordonnes();

		PointNom p1 = new PointNom();
		p1.setPointNom(2, 7, "S");
		p1.affichageCoordonnesNom();
		p1.deplace(-1, 1);
		p1.setNom("sDeplace");
		p1.affichageCoordonnesNom();
	}
}