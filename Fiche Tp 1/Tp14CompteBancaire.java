import java.util.*;
class CompteBancaire {
	private String nom;
	private int id;
	private double totalCompte;
	// On peut pas creer un constructeur par defaut dans notre cas 
	public CompteBancaire(String nom, int id, double totalCompte){
		this.nom = nom;
		this.id = id;
		this.totalCompte = totalCompte;
	}
	// on peut creer un constructeur sans totalCompte 
	public CompteBancaire(String nom, int id){
		this.nom = nom;
		this.id = id;
		this.totalCompte = 0;
	}
	/* On peut avoir 3 acceseurs  
		on peut pas poser des set : la modification du totalCompte se fait par virement virement 
		et retrait ,les nom et id sont inchangeable
		on a 3 get
	*/
	public void affiche(){
		System.out.println("Nom : "+nom);
		System.out.println("Identifiant Compte : "+id);
		System.out.println("Total Compte Initial : "+totalCompte);
	}

	public void virement(double montant){
		if(montant>0){
			totalCompte += montant ;
		}
		// le else n'est pas necessaire
		else{
			System.out.println("Virement impossible");
		}
	}
	// se sont des methodes d'objet 
	public void retrait(double montant){
		if(montant>0 && montant<=this.totalCompte){
			this.totalCompte -= montant ;
		}

		else{
			System.out.println("Retrait impossible");
		}
	}

	public String getNomCompteBancaire(){
		return nom;
	}

	public int getIdentifiantCompteBancaire(){
		return id;
	}

	public double getTotalCompteBancaire(){
		return totalCompte;
	}
}

public class Tp14CompteBancaire{
	public static void main(String[] args){
		/*
			sacnf = scan format : dans quel format on recuper les donnèes 
			tout ce que saisie l'utilisateur va etre dans un tampon memoire Buffer
			fscanf(f,format,&varible) : pour un file 
			System.in c'est l'equivalent de stdin : entrain de lire ce qui est saisie par l'utilisateur 
			nextIn elle va dans le tampon memoire elle recupere une certaine quantité d'info qui correspond au type
			elle vide le tampon
			dans fscanf on utilise un fflush();
			=> nextInt() elle le recupere et elle vide 
		*/

		Scanner clavier = new Scanner(System.in);

		//initialisation compte :
		String nom;
		int identifiant;
		double totalCompte;
		double v;
		double r;

		System.out.println("Entrez votre Nom et Prenom : ");
		nom = clavier.nextLine();
		System.out.println("Entrez votre identifinat : ");
		identifiant = clavier.nextInt();
		System.out.println("Entrez votre Somme total : ");
		totalCompte = clavier.nextDouble();

		CompteBancaire monCompte = new CompteBancaire(nom, identifiant, totalCompte);

		//menu 
		boolean menu = true;
		int choixOperation;
		while(menu){
			System.out.println("Tapez 1 : pour afficher votre compte .");
			System.out.println("Tapez 2 : pour effectuer un virement .");
			System.out.println("Tapez 3 : pour effectuer un retrait  .");
			System.out.println("Tapez 4 : pour sortir                .");
			choixOperation = clavier.nextInt();

			switch(choixOperation){
				case 1 : {
					monCompte.affiche();
					break;
				} 

				case 2 : {
					System.out.println("Donnez votre virement");
					v = clavier.nextDouble();
					monCompte.virement(v);
					break;
				} 

				case 3 : {
					System.out.println("Donnez votre retrait");
					r = clavier.nextDouble();
					monCompte.retrait(r);
					break;
				} 

				case 4 : {
					menu = false ;
					break;
				} 
			}
		}
		System.out.println("voici votre total : "+monCompte.getTotalCompteBancaire());
	}
}