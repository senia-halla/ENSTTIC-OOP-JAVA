import java.lang.*;
import java.util.*;

class Personne implements Comparable{
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

	public int compareTo(Object o){
		// transtypage
		Personne p = (Personne) o;

		if(this.age > p.age){
			return +1;
		}

		else if(this.age < p.age){
			return -1;
		}

		else {
			return 0;
		}

	}
}

class Enseignant extends Personne {
	private String module; 

	public Enseignant(String nom, String prenom, int age, String module){
		super(nom,prenom,age);
		this.module = module;
	}

	public String toString(){
		return ( super.toString() +" Module Enseigné  : "+module );
	}
}

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

public class Tp23TestPersonne{
	public static void main(String[] args){
		Scanner clavier = new Scanner(System.in);
		String nom, prenom, module, promotion;
		int age, bureau;
		int proffesion;
		
		Personne [] listPersonne = new Personne[3];
		System.out.println("Nous allons besoin d'une liste de personne");
		int i=0;
		while(i<listPersonne.length){
			System.out.println("Entrez le   nom et le prenom et l'age de la personne numero "+(i+1));
			nom = clavier.nextLine();
			prenom = clavier.nextLine();
			age = clavier.nextInt();

			listPersonne[i] = new Personne (nom, prenom, age);
			
			System.out.println("Entrez le numero correspondant a cette personne ");
			System.out.println("1. Enseignait");
			System.out.println("2. Secretaire");
			System.out.println("3. Etudiant");
			proffesion = clavier.nextInt();

			if(proffesion == 1){
				System.out.println("Quel module ensignait vous ?");
				clavier.nextLine();
				module = clavier.nextLine();
				Enseignant enseignant = new Enseignant(nom, prenom, age, module);
				listPersonne[i] = new Enseignant (nom, prenom, age, module);
			}
			else if (proffesion == 2){
				System.out.println("Quel est le numero de votre bureau ?");
				clavier.nextLine();
				bureau = clavier.nextInt();
				Secretaire secretaire = new Secretaire(nom, prenom, age, bureau);
				listPersonne[i] = new Secretaire (nom, prenom, age, bureau);
			}
			else if (proffesion == 3){
				System.out.println("Quel est votre promotion ?");
				clavier.nextLine();
				promotion = clavier.next();
				Etudiant etudiant = new Etudiant(nom, prenom, age, promotion);
				listPersonne[i] = new Etudiant (nom, prenom, age, promotion);
			}
			clavier.nextLine();
			i++;
		}

		System.out.println("La liste avant le classement d'age : ");
		for(i=0;i<listPersonne.length;i++){
			System.out.println(listPersonne[i]);
		}
		Arrays.sort(listPersonne);
		System.out.println("La liste apres le classement d'age : ");
		for(i=0;i<listPersonne.length;i++){
			System.out.println(listPersonne[i]);
		}	
	}
}