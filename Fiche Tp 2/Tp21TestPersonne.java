/*Définissez une classe Personne ; une personne étant caractérisée par son nom, son prénom et son age.
Redéfinissez la méthode toString héritée de la super classe Object.
Définissez ensuite trois sous classes de la classe Personne, Enseignant, Secretaire et Etudiant, 
caractrisés respectivement par un module, un bureau et une promotion, en plus des caractéristiques
hérités de la classe Personne. Redéfinissez également la méthode toString().
Proposez une classe de test.*/

import java.util.*;
// class mere personne 
class Personne {
	private String nom; 
	private String prenom;
	private int age;
	
	public Personne(String nom, String prenom, int age){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String toString(){
		return (prenom+" "+nom+" , "+age+" ans");
	}
}

// classe fille Enseignant herité de personne 
class Enseignant extends Personne {
	private String module; 

	public Enseignant(String nom, String prenom, int age, String module){
		super(nom,prenom,age);
		//pour faire this.nom = nom ..ect il faut que les attributs de la classe personne soient définit autant que protected 
		this.module = module;
	}

	public String toString(){
		return ( super.toString() +" Module Enseigné  : "+module );
	}
}

// classe fille Secretaire herité de personne
class Secretaire extends Personne {
	private int numBureau;

	public Secretaire(String nom, String prenom, int age, int numBureau){
		super(nom,prenom,age);
		this.numBureau = numBureau;
	}

	public String toString(){
		return (super.toString()+" , Numero de bureau : "+numBureau);
	}
}

// classe fille Etudiant herité de personne
class Etudiant extends Personne {
	private String promotion;

	public Etudiant(String nom, String prenom, int age, String promotion){
		super(nom,prenom,age);
		this.promotion = promotion;
	}

	public String toString(){
		return(super.toString()+" , Promotion : "+promotion);
	}
}

// la class test 
public class Tp21TestPersonne{
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);
		String nom, prenom, module, promotion;
		int age,  bureau, proffesion;
		System.out.println("Bonjour. SVP entrez votre nom et votre prenom et votre age");
		nom = clavier.next();
		prenom = clavier.next();
		age = clavier.nextInt();

		System.out.println("Entrez le numero correspendant a votre proffesion");
		System.out.println("1. Enseignait");
		System.out.println("2. Secretaire");
		System.out.println("3. Etudiant");
		proffesion = clavier.nextInt();

		if(proffesion == 1){
			System.out.println("Quel module ensignait vous ?");
			clavier.nextLine();
			module = clavier.nextLine();
			Enseignant enseignant = new Enseignant(nom, prenom, age, module);
			System.out.println(enseignant);
		}
		else if (proffesion == 2){
			System.out.println("Quel est le numero de votre bureau ?");
			clavier.nextLine();
			bureau = clavier.nextInt();
			Secretaire secretaire = new Secretaire(nom, prenom, age, bureau);
			System.out.println(secretaire);
		}
		else if (proffesion == 3){
			System.out.println("Quel est votre promotion ?");
			clavier.nextLine();
			promotion = clavier.next();
			Etudiant etudiant = new Etudiant(nom, prenom, age, promotion);
			System.out.println(etudiant);
		}
	}
} 