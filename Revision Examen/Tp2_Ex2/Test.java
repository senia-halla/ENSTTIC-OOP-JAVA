abstract class Forme {
    public abstract double surface();
    public abstract double perimetre();

    public boolean plusGrand(Forme f){
        if(this.surface() > f.surface()){
            return true ;
        }
        else return false ;   
    }

    public boolean plusGrand(Forme f1, Forme f2){
        if(f1.surface() > f2.surface() ) {
            return true ; 
        }

        else {
            return false ; 
        } 
    }
} 

class Rectangle extends Forme {
    private double longeur ; 
    private double largeur ; 

    public Rectangle(double largeur , double longeur){
        this.largeur = largeur;
        this.longeur = longeur;
    }

    public double surface(){
        return longeur*largeur;
    }

    public double perimetre(){
        return 2 * longeur + largeur ;
    }
}

class Cercle extends Forme {
    private double rayon ; 

    public Cercle(double rayon){
        this.rayon = rayon ;
    }

    public double surface(){
        return Math.PI * rayon * rayon ;
    }

    public double perimetre(){
        return 2* Math.PI * rayon ;
    }
}

class Carre extends Rectangle {
    private double cote ; 

    public Carre(double cote){
        super(cote,cote);
    }

} 

public class Test {
    public static void main(String[] args){
        Forme f1 = new Rectangle (5,5);
        System.out.println("f1 : la surface "+f1.surface()+" , Perimetre : "+f1.perimetre());

        Cercle f2 = new Cercle(3);
        System.out.println("f1 : la surface "+f2.surface()+" , Perimetre : "+f2.perimetre());

        if(Forme.pluGrand(f1,f2)){
            System.out.println("le rectangle est plus grand que cercle");
        }

        else{
            System.out.println("le cercle est plus grand que Rextangle");
        }
    }
}