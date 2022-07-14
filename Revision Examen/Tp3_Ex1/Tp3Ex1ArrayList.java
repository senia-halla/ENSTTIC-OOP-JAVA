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

    public String getNom(){
        return nom ;
    }

    public String getPrenom(){
        return prenom ;
    }

    public int getAge(){
        return age ;
    }

    public int compareTo(Object o){
        Personne p = (Personne) o;
        if(this.getAge() > p.getAge()){ return  1 ;}
        if(this.getAge() < p.getAge()){ return -1 ;}
        else {return 0 ;} 
    }
}

class Etudiant extends Personne {
    private String promotion ;

    public Etudiant(String nom ,String prenom , int age , String promotion ){
        super(nom , prenom , age);
        this.promotion = promotion;
    }

    public String toString(){
        return (super.toString()+" , Promotion : "+promotion);
    }
}

class Enseignant extends Personne{
    private String module ; 

    public Enseignant(String nom , String prenom , int age , String module){
        super(nom , prenom , age);
        this.module = module;
    } 
    
    public String toString(){
        return (super.toString()+" , Module  : "+module);
    }
}

class CompareNom implements Comparator{
    public int compare(Object o1 , Object o2){
        Personne p1 = (Personne) o1;
        Personne p2 = (Personne) o2;
        return (p1.getNom().compareTo(p2.getNom()));
    }
}

class ComparePrenom implements Comparator{
    public int compare(Object o1 , Object o2){
        Personne p1 = (Personne) o1 ; 
        Personne p2 = (Personne) o2 ;
        return (p1.getPrenom().compareTo(p2.getPrenom()));
    }
}



public class Tp3Ex1ArrayList{
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String nom , prenom , promotion , module ;
        int age ;

        // une liste créer en utilisant les types génériques
        List<Personne>listPersonne = new ArrayList<Personne>();

        /*
            Une liste créer sans types génériques : 
            List listPersonne = new ArrayList();
        */

        System.out.println("Saisie d'une liste de 4 personne : 2 etudiant et 2 enseignant ");

        for(int i = 0 ; i<2 ; i++){
            System.out.println("  Etudiant "+(i+1)+" : entrez nom , prenom , age , promotion ");
            
            nom = sc.nextLine();
            prenom = sc.nextLine();
            age = sc.nextInt();
            sc.nextLine();
            promotion = sc.nextLine();

            listPersonne.add(new Etudiant(nom , prenom , age , promotion));
        }

        for(int i = 2 ; i<4 ; i++){
            System.out.println("  Enseignant "+(i-1)+" : entrz nom , prenom , age , module ");

            nom = sc.nextLine();
            prenom = sc.nextLine();
            age = sc.nextInt();
            sc.nextLine();
            module = sc.nextLine();
            
            listPersonne.add(new Enseignant(nom, prenom , age , module));
        }
         
        Iterator<Personne>it = listPersonne.iterator();
        // Iterator it = listPersonne.iterator(); non génériques 
        
        System.out.println();

        System.out.println("Liste non tri : ");
        System.out.println();
        while(it.hasNext()){
            System.out.println(it.next());
            // sans types génériques : (Personne)it.next()
        }

        System.out.println();

        // tri selon age : 
        Collections.sort(listPersonne);
        it = listPersonne.iterator();
        System.out.println("Liste tri par prdre d'age : ");
        System.out.println();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();

        // tri par ordre alphabetique nom : 
        Collections.sort(listPersonne, new CompareNom());
        it = listPersonne.iterator();
        System.out.println("Liste tri par ordre alphabetique du nom : ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();

        // tri par ordre alphabetique : prenom 
        Collections.sort(listPersonne , new ComparePrenom());
        it = listPersonne.iterator();
        System.out.println("Liste tri par ordre laphabetique du prenom : ");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
    }
}