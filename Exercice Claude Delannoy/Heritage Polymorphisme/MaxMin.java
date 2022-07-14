import java.util.*;
public class MaxMin {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        final int n = 5 ;
        double [] tab = new double [n];

        System.out.println("Entrez 5 valeurs Floatantes : ");
        for (int i=0; i<n ; i++){
            tab[i] = sc.nextDouble();
        }

        double valeurMax = tab[0];
        double valeurMin = tab[0];
        double sum = 0;

        for(double t : tab){
            if(t > valeurMax ){ valeurMax = t ;}
            if(t < valeurMin ){ valeurMin = t ;}
            sum += t ;
        }
        System.out.println("La valeur max est : "+valeurMax);
        System.out.println("La valeur min est : "+valeurMin);
        System.out.println("La moyenne est : "+sum/n);
    }
}