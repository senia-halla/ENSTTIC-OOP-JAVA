class Point{
	private int x,y ;

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void deplace(int dx, int dy){
		x += dx;
		y += dy;
	}
	public void affichage(){
		System.out.println("Les cordonnées : "+x+","+y);
	}
}
class PointNom2 extends Point{
	private String nom;
	public PointNom2(int x, int y, String nom){
		super(x, y);
		this.nom = nom;
	}
	//redifinition de la methode affiche 
	public void affichage(){
		System.out.print("Nom point : "+nom+" , ");
		super.affichage();
	}
}

public class Ex3HeritageAppelConstructeur{
	public static void main(String[] args){
		PointNom2 p = new PointNom2(2,3,"A");
		p.affichage();
	}
}