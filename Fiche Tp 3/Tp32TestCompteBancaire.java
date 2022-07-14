import java.util.*;

class CompteBancaire {
	private String nom;
	private int id;
	private double totalCompte;

	public CompteBancaire(String nom, int id, double totalCompte) throws Exception {
		this.nom = nom;
		this.id = id;
		if(totalCompte < 0){
			throw new Exception("Solde negatif");
		}
		else{
			this.totalCompte = totalCompte;
		}
	}

	public CompteBancaire(String nom, int id){
		this.nom = nom;
		this.id = id;
		this.totalCompte = 0;
	}

	public String getNom(){
		return nom;
	}

	public int getId(){
		return id;
	}

	public double getTotalCompte(){
		return totalCompte;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Nom : "+getNom()+"\n");
		sb.append("Id : "+getId()+"\n");
		sb.append("Total Compte : "+getTotalCompte()+"\n");
		return sb.toString();
	}

	public void virement(double montant) throws Exception {
		if(montant <= 0){
			throw new Exception("Virement impossible ! montant negatif ou nul");
		}
		else {
			totalCompte += montant;
		}
	}

	public void retrait(double montant) throws Exception {
		if(montant<0 || montant>this.totalCompte){
			throw new Exception("Retrait impossible ! montant negatif ou superieur au total du compte");
		}
		else{
			totalCompte -= montant;
		}
	}
}

public class Tp32TestCompteBancaire{
	public static Scanner clavier = new Scanner(System.in);
	public static void main(String[] args){

		String nomUtilisateur;
		int idUtilisateur;
		double totalCompteUtilisateur;

		double montant;

		int choix;

		System.out.println("************* GESTION DE COMPTE BANCAIRE *************");
		nomUtilisateur = nomUtilisateur();
		idUtilisateur = idUtilisateur();
		totalCompteUtilisateur = totalCompteUtilisateur();
		CompteBancaire compteBancaire ;
		
		try{
			compteBancaire = new CompteBancaire(nomUtilisateur,idUtilisateur,totalCompteUtilisateur);
		} catch(Exception e){
			System.out.println("Compte initialisé par défaut");
			compteBancaire = new CompteBancaire(nomUtilisateur,idUtilisateur); 	
		}
		
		do{
			choix = menu();
			switch(choix){
				case 1 : {
					afficherLeCompte(compteBancaire);
				} break;

				case 2 : {
					effectuerUnRetrait(compteBancaire);
				} break;

				case 3 : {
					effectuerUnVirement(compteBancaire);
				} break;

				case 4 : {
					quitter();
				} break ;
			}
		
		}while(choix != 4);
	}

	static String nomUtilisateur(){
		String nomUtilisateur;
		System.out.print("Entrez votre Nom : ");
		nomUtilisateur = clavier.nextLine();
		return nomUtilisateur;
	}
	static int idUtilisateur(){
		int idUtilisateur;
		System.out.print("Entrez votre identififant : ");
		idUtilisateur = clavier.nextInt();
		return idUtilisateur;
	}
	static double totalCompteUtilisateur(){
		double totalCompteUtilisateur = 0;
		System.out.print("Entrez votre total compte : ");
		totalCompteUtilisateur = clavier.nextDouble();
		return totalCompteUtilisateur;
	}

	static int menu(){
		int choix ;
		System.out.println("Tapez 1 : pour afficher votre compte");
		System.out.println("Tapez 2 : pour effectuer un retrait");
		System.out.println("Tapez 3 : pour effectuer un virement");
		System.out.println("Tapez 4 : pour quitter le programme");
		choix = clavier.nextInt();
		return choix;
	}

	static void afficherLeCompte(CompteBancaire cb){
		System.out.println(cb);
	}

	static void effectuerUnRetrait(CompteBancaire cb){
		double montant;
		try{
		System.out.println("Combien voulez vous retirez d'argent");
		montant = clavier.nextDouble();
		cb.retrait(montant);
		} catch(Exception e){
			System.err.println(e.getMessage());
		}
		System.out.println("Votre total compte vaut maintenant : "+cb.getTotalCompte());
	}

	static void effectuerUnVirement(CompteBancaire cb){
		double montant;
		try{
			System.out.println("Combien voulez vous verser d'agent ");
			montant = clavier.nextDouble();
			cb.virement(montant);
		} catch(Exception e){
			System.err.println(e.getMessage());
		}
		System.out.println("Votre total compte vaut maintenant : "+cb.getTotalCompte());
	}

	static void quitter(){
		System.out.println("Programme Terminé");
	}
}