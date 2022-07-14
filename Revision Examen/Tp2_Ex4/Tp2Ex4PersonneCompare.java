import java.util.*;
class Personne  {
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

    public String getNom(){
        return nom ;
    }

    public String getPrenom(){
        return prenom ;
    }

    public int getAge(){
        return age ;
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

class ComparePersonneNom implements Comparator {
    public int compare(Object o1 , Object o2){
        Personne p1 = (Personne) o1 ;
        Personne p2 = (Personne) o2 ;
        return p1.getNom().compareTo(p2.getNom());
    }
}

class ComparePersonnePrenom implements Comparator {
    public int compare(Object o1 , Object o2){
        Personne p1 = (Personne) o1 ;
        Personne p2 = (Personne) o2 ;
        return p1.getPrenom().compareTo(p2.getPrenom());
    }
}

public class Tp2Ex4PersonneCompare{
    @SuppressWarnings("unchecked")
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
        System.out.println();

        System.out.println("Liste non trier ");

        for(Personne p : listPersonne){
            System.out.println(p.toString());
        }

        System.out.println();

        Arrays.sort(listPersonne , new ComparePersonneNom());
        
        System.out.println("Liste Trier selon l'ordre alphabetique du nom ");
        for(Personne p : listPersonne){
            System.out.println(p.toString());
        }

        System.out.println();

        Arrays.sort(listPersonne, new ComparePersonnePrenom());
        System.out.println("Liste Trier selon l'ordre alphabetique du prenom ");
        for(Personne p : listPersonne){
            System.out.println(p.toString());
        }
    }
}
