import java.util.*;
class Vecteur3d {
    private double x , y , z ;

    public Vecteur3d(double x , double y , double z){
        this.x = x ; 
        this.y = y ;
        this.z = z ;
    }

    public String afficheVecteur(){
        return("< "+x+" , "+y+" , "+z+" >");
    }

    public double normeVecteur(){
        return ( Math.sqrt(x*x + y*y + z*z));
    }

    public static Vecteur3d sommeDeuxVecteur(Vecteur3d v1 , Vecteur3d v2){
        Vecteur3d s = new Vecteur3d(v1.x + v2.x , v1.y + v2.y , v1.z + v2.z );
        return s ;
    }

    public double produitCart(Vecteur3d v){
        return ( (this.x * v.x) + (this.y * v.y) + (this.z * v.z) ); 
    }
}

public class TestVecteur{
    public static void main (String args[]){

        Vecteur3d v1 = new Vecteur3d(1,2,3);
        Vecteur3d v2 = new Vecteur3d(4,5,6);
        Vecteur3d v3 = new Vecteur3d(7,8,9);

        System.out.println(v1.afficheVecteur());
        System.out.println(v2.afficheVecteur());
        System.out.println("Le produit Scalaire et v1 et v2 " +v2.produitCart(v1));
        Vecteur3d somme = Vecteur3d.sommeDeuxVecteur(v2,v3);
        System.out.println("La somme de v1 et de v2 : "+somme.afficheVecteur());

    }
}
