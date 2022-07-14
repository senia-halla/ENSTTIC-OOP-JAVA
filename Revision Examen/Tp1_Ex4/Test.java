import java.util.*;
class Point{
    private double x , y;
    private char nom ;
    
    public Point(char nom , double x , double y ){
        this.x = x ; 
        this.y = y ; 
        this.nom = nom ;
    }

    public void deplacement(double dx , double dy){
        x += dx ;
        y += dy ;
    }

    public char getNom(){
        return nom ; 
    }

    public double getX(){
        return x ; 
    }

    public double getY(){
        return y ; 
    }


    public void setNom(char nom){
        this.nom = nom ; 
    }

    public void setX(double x){
        this.x = x ;
    }

    public void setY(double y){
        this.y = y ;
    }

    public void affichage(){
        System.out.println(getNom()+" ( "+getX()+" , "+getY()+" ) ");
    }
}

class Segment{
    private Point org , ext ;
    
    public Segment(Point org , Point ext){
        this.org = org ; 
        this.ext = ext ;
    }

    public Segment(char nom1 , double x1 , double y1 , char nom2 , double x2 , double y2){
        org = new Point(nom1 , x1 , y1);
        ext = new Point(nom2 , x2 , y2);
    }

    public void affichage(){
        System.out.println("Segement : [ "+org.getNom()+" , "+ext.getNom()+" ]");
        System.out.println("Origine : ");
        org.affichage();
        System.out.println("Extremite : ");
        ext.affichage();
    }

    public double longueur(){
        double l ; 
        double x1 = org.getX();
        double x2 = ext.getX();
        double y1 = org.getY();
        double y2 = ext.getY();

        l = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return l ; 
    }

    public void deplacementOrg(double dx , double dy){
        org.deplacement(dx,dy);
    }

    public void deplacementExt(double dx , double dy){
        ext.deplacement(dx,dy);
    }
}

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Point org = new Point('O' , 1 , 2);
        Point ext = new Point('E' , 2 , 1);

        Segment seg = new Segment(org , ext);
        seg.affichage();

        System.out.println();
        System.out.println("Deplacement origine");
        seg.deplacementOrg(1,2);
        seg.affichage();

        System.out.println();

        System.out.println("Deplacement extrimite");
        seg.deplacementExt(2,1);
        seg.affichage();
    }
}