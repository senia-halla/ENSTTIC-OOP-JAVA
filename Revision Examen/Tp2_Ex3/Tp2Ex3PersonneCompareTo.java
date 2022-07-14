import java.util.*;
class Personne implements Comparable {
    private String nom ;
    private String prenom ;
    private int age ;

    public Personne (String nom , String prenom , int age ){
        this.nom = nom ;
        this.prenom = prenom ;
        this.age = age ;
    }

    public String toString(){
        return ("Nom et Prenom : "+nom+"  "+prenom+" , "+age+" ans ");
    }

    public int compareTo(Object o){
        Personne p = (Personne) o;
        if(this.age > p.age){ return 1 ;}
        else if(this.age < p.age){ return -1 ;}
        else { return 0;}
    }
}

class Etu extends Personne {
    private String promotion ;

    public Etu(String nom ,String prenom , int age , String Promotion ){
        super(nom , prenom , age);
        this.promotion = promotion;
    }

    public String toString(){
        return (super.toString()+" , Promotion : "+promotion);
    }
}

class Ens extends Personne{
    private String module ; 

    public Ens(String nom , String prenom , int age , String module){
        super(nom , prenom , age);
        this.module = module;
    } 
    
    public String toString(){
        return (super.toString()+" , Module  : "+module);
    }


}

class Sec extends Personne {
    private int numBureau ;

    public Sec(String nom , String prenom , int age , int numBureau){
        super(nom , prenom ,age);
        this.numBureau = numBureau;
    }

    public String toString(){
        return (super.toString()+" , Num Bureau  : "+numBureau);
    }

}

public class Tp2Ex3PersonneCompareTo{
    public static void main (String args[]){

        Scanner sc = new Scanner (System.in);
        Personne [] listPersonne = new Personne [4];
        String nom , prenom , module , promotion; 
        int  age ;

        System.out.println("Saisie d'une list de 4 personne : 2 etudiant et 2 enseignant  ");
        for(int i = 0 ; i<2 ; i++){
            System.out.println(" Etudiant : "+(i+1)+" : Entrez nom , prenom ,age , promotion ");
            
            nom = sc.nextLine();
            prenom = sc.nextLine();
            age = sc.nextInt();
            sc.nextLine();
            promotion = sc.nextLine();

            listPersonne[i] = new Etu (nom , prenom , age ,promotion);
        }

        for(int i = 2 ; i<4 ; i++){
            System.out.println(" Enseignat  : "+(i-1)+" : Entrez nom , prenom ,age , module ");
            
            nom = sc.nextLine();
            prenom = sc.nextLine();
            age = sc.nextInt();
            sc.nextLine();
            module = sc.nextLine();

            listPersonne[i] = new Ens (nom , prenom , age ,module);
        }

        for(Personne p : listPersonne){
            System.out.println(p.toString());
        }

        Arrays.sort(listPersonne);

        System.out.println("Liste Trier selon l'ordre d'age");
        for(Personne p : listPersonne){
            System.out.println(p.toString());
        }



    }
}