import java.util.*;
import java.lang.*;
class Cercle {
    private int x , y ;
    private double rayon ;

    public Cercle(int x , int y , double rayon ){
        this.x = x ;
        this.y = y ;
        this.rayon = rayon ;
    }

    public void affiche(){
        System.out.println("Cercle de rayon : "+rayon+" , et de Centre : ("+x+","+y+") .");
    }

    public int getX(){
        return x ; 
    }

    public int getY(){
        return y ; 
    }

    public double getRayon(){
        return rayon ;
    }
}

class ComparateurRayon implements Comparator {
    public int compare(Object o1 , Object o2){
        Cercle c1 = (Cercle) o1;
        Cercle c2 = (Cercle) o2;
        //Ordre Croissant selon le rayon  : 
        if(c1.getRayon() > c2.getRayon()){ return  1; }
        if(c1.getRayon() < c2.getRayon()){ return -1; }
        else{ return 0; }
    }
}

class ComparateurAbscisse implements Comparator {
    public int compare(Object o1, Object o2){
        Cercle c3 = (Cercle) o1;
        Cercle c4 = (Cercle) o2;
        //Ordre Croissant selon l'abscisse :
        if( c3.getX() > c4.getX() ){ return  1 ; }
        if( c3.getX() < c4.getX() ){ return -1 ; }
        else{ return 0 ;}
    }
}

public class ObjetComparateur {
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        ArrayList<Cercle> listeCercle = new ArrayList<Cercle>(3);
        Iterator<Cercle> it = listeCercle.iterator();
        double rayon ;
        int x , y ;
        

        

       for(int i = 0 ; i<4 ; i++){
            System.out.println("Entrees les cordonnes de votre Cercle num "+(i+1)+" : ");
            System.out.println();
            System.out.print("Rayon : "); rayon = sc.nextDouble(); 
            sc.nextLine() ; 

            System.out.print("Abscisse Origine  : "); x = sc.nextInt(); 
            sc.nextLine() ; 

            System.out.print("Ordennée Origine  : "); y = sc.nextInt(); 
            sc.nextLine() ; 

            listeCercle.add(new Cercle(x,y,rayon));
        }
       
        
        
        /*int i = 1;
        while(it.hasNext()){
            System.out.println("Entrees les cordonnées de votre Cercle num "+i+" : ");
            System.out.print("Rayon : "); rayon = sc.nextDouble(); 
            sc.nextLine() ; System.out.println();

            System.out.print("Abscisse Origine  : "); x = sc.nextInt(); 
            sc.nextLine() ; System.out.println();

            System.out.print("Ordennée Origine  : "); y = sc.nextInt(); 
            sc.nextLine() ; System.out.println();

            listeCercle.add(new Cercle(x,y,rayon));
            i++;
            it.next();
        }*




        /*Cercle c1 = new Cercle(1,2,2);
        Cercle c2 = new Cercle(4,2,3);
        Cercle c3 = new Cercle(5,4,1);
        
        listeCercle.add(c1);
        listeCercle.add(c2);
        listeCercle.add(c3);*/


        System.out.println();
        System.out.println("Liste des Cercles sans tri : ");
        for(Cercle c : listeCercle){
            c.affiche();
        }

        System.out.println();
        Collections.sort(listeCercle, new ComparateurRayon());
        System.out.println("Liste des cercle tries suivant leur rayon : ");
        for(Cercle c : listeCercle ){
            c.affiche();
        }

        System.out.println();
        Collections.sort(listeCercle, new ComparateurAbscisse());
        System.out.println("Liste des cercles tries suivant la valeur des abcisse");
        for(Cercle c : listeCercle){
            c.affiche();
        }
    }
}