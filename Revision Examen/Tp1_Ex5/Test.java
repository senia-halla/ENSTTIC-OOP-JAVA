import java.util.*;
class CompteBancaire{
    private String nom ; 
    private int id ; 
    private double solde ;

    public CompteBancaire(String nom , int id , double solde){
        this.nom = nom ; 
        this.id = id ; 
        this.solde = solde ;
    }

    public String getNom(){
        return nom ; 
    }

    public int getId(){
        return id ;
    }

    public double getSolde(){
        return solde ; 
    }

    public void retrait(double montant){
         if(montant < 0 || solde < montant){
             System.out.println("Retrait impossible");
         }
        
         else{
             solde = solde - montant ;
         } 
    }

    public void virement(double montant){
        if (montant > 0){
            solde = solde + montant ; 
        }

        else{
            System.out.println("Retrait impossible");
        }
    }

    public void affichage(){
        System.out.println("***************************");
        System.out.println("Nom : "+getNom());
        System.out.println("Numero de compte : "+getId());
        System.out.println("solde : "+getSolde());
        System.out.println("***************************");
    }
}

public class Test{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String nom ; 
        int id ; 
        double solde , montant; 
        boolean rester = true ;
        int choix ; 

        /// entree des cordonnes : 

        System.out.println("Entre votre nom , Identifiant et solde initial : ");

        System.out.print("Nom : "); nom = sc.nextLine();
        System.out.println();

        System.out.print("Identifient : "); id = sc.nextInt(); sc.nextLine();
        System.out.println();

        System.out.print("Solde initiale : "); solde = sc.nextDouble(); sc.nextLine();
        System.out.println();

        CompteBancaire cb = new CompteBancaire(nom, id, solde);
        do{
            System.out.println("Que voulez vous effectuer comme tache : ");

            System.out.println("1. Consultation du compte");
            System.out.println("2. Virement");
            System.out.println("3. Retrait");
            System.out.println("4. Quitter");
            choix = sc.nextInt() ; sc.nextLine();

            switch(choix){
                case 1 : {
                    cb.affichage();
                } break ;

                case 2 : {
                    System.out.println("Quel montant voulez vous virer ?");
                    montant = sc.nextDouble(); sc.nextLine();
                    cb.virement(montant);
                    System.out.println("Votre solde est maintenant de : "+cb.getSolde());
                } break ;

                case 3 : {
                    System.out.println("Quel montant voulez vous retirer ?");
                    montant = sc.nextDouble(); sc.nextLine();
                    cb.retrait(montant);
                    System.out.println("Votre solde est maintenant de : "+cb.getSolde());
                } break ; 

                default : {
                    System.out.println("**************** Merci a vous !******************");
                    System.out.println("*************************************************");
                    rester = false ;
                } break ; 
            }
        }while(rester == true) ;
    }
}