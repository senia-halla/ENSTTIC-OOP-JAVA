import java.util.*;
class Point {
    private char nom ; 
    private double x , y ;

    public Point(char nom , double x , double y ){
        this.nom = nom ; 
        this.x = x ;
        this.y = y ;
    }

    public void translationAbcisse(double dx){
        x += dx ;
    }

    public void translationOrdonne(double dy){
        y += dy ;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y ;
    }

    public void affichage(){
        System.out.println("Point : "+nom+" ("+getX()+" , "+getY()+") ");
    }
}

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Point p1 = new Point('A', 2 , 7);
        p1.affichage();

        System.out.println("Translation de l'abcisse : ");
        int dx ;
        dx = sc.nextInt(); sc.nextLine();
        p1.translationAbcisse(dx);

       System.out.println("Translation de l'ordonné  : ");
        int dy ;
        dy = sc.nextInt(); sc.nextLine();
        p1.translationOrdonne(dy);

        p1.affichage();
    }
}