import java.util.*;
import java.lang.*;
class Personne2 {
	private String nom;
	private String prenom;
	private int age;

	public Personne2(String nom, String prenom, int age){
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public String toString(){
		return ("NOM : "+nom+" , PRENOM : "+prenom+" , AGE : "+age);
	}
	
	public String getNom(){
		return nom;
	}

	public String getPrenom(){
		return prenom;
	}

	public int getAge(){
		return age;
	}	
}

class Enseignant extends Personne2{
	private String module;
	public Enseignant(String nom, String prenom, int age, String module){
		super(nom,prenom,age);
		this.module = module;
	}

	public String toString(){
		return(super.toString()+" , Module Enseigné : "+module);
	}
	
	public String getModule(){
		return module;
	}
}

class Secretaire extends Personne2{
	private int numBureau;
	public Secretaire(String nom, String prenom, int age, int numBureau){
		super(nom,prenom,age);
		this.numBureau = numBureau;
	}

	public String toString(){
		return(super.toString()+" , Numero de bureau  : "+numBureau);
	}

	public int getNumBureau(){
		return numBureau;
	}
}

class Etudiant extends Personne2{
	private String promotion;
	public Etudiant(String nom, String prenom, int age, String promotion){
		super(nom,prenom,age);
		this.promotion = promotion;
	}

	public String toString(){
		return(super.toString()+" , Promotion : "+promotion);
	}

	public String getPromotion(){
		return promotion;
	}
}
class CompareNom implements Comparator {
	public int compare(Object o1, Object o2){
		Personne2 p1 = (Personne2)o1;
		Personne2 p2 = (Personne2)o2;
		return p1.getNom().compareTo(p2.getNom());
	}
}

class ComparePrenom implements Comparator {
	public int compare(Object o1, Object o2){
		Personne2 p1 = (Personne2)o1;
		Personne2 p2 = (Personne2)o2;
		return p1.getPrenom().compareTo(p2.getPrenom());
	}
}
public class Tp24TestPersonne{
	 @SuppressWarnings("unchecked")
	private static Scanner clavier = new Scanner(System.in);
	public static void main(String[] args){

		String nom, prenom, module, promotion;
		int age , numBureau;
		int proffesion;

		Personne2[] listPersonne = new Personne2[3];
		System.out.println("List de 3 Personne");

		for(int i=0; i<listPersonne.length ;i++){
			System.out.println("Entrez les corrdonnées de la personne");
			nom = nom();
			prenom = prenom();
			age = age();
			proffesion = menu();
			switch(proffesion){
				case 1 : {
					System.out.println("Quel module ensignait vous ?");
					clavier.nextLine();
					module = clavier.nextLine();
					Enseignant enseignant = new Enseignant(nom, prenom, age, module);
					listPersonne[i] = new Enseignant (nom, prenom, age, module);
				} break;

				case 2 : {
					System.out.println("Quel est le numero de votre bureau ?");
					clavier.nextLine();
					numBureau = clavier.nextInt();
					Secretaire secretaire = new Secretaire(nom, prenom, age, numBureau);
					listPersonne[i] = new Secretaire (nom, prenom, age, numBureau);
				} break;

				case 3 : {
					System.out.println("Quel est votre promotion ?");
					promotion = clavier.nextLine();
					Etudiant etudiant = new Etudiant(nom, prenom, age, promotion);
					listPersonne[i] = new Etudiant (nom, prenom, age, promotion);
				} break;

				default : {
					System.out.println("Erreur");
				} break;
			}
		}

		Arrays.sort(listPersonne, new CompareNom());
		System.out.println("La liste avec classement par nom : ");

		for(int i=0;i<listPersonne.length;i++){
			System.out.println(listPersonne[i]);
		}

		Arrays.sort(listPersonne, new ComparePrenom());
		System.out.println("La liste apres le classement prenom : ");

		for(int i=0;i<listPersonne.length;i++){
			System.out.println(listPersonne[i]);
		}
	}


	static int menu(){
		int proffesion = 0;
		System.out.println("Entrez le numero correspondant a votre proffesion");
		System.out.println("1. Enseignant");
		System.out.println("2. Secretaire");
		System.out.println("3. Etudiant");
		proffesion = clavier.nextInt();
		return proffesion;
	}

	static String nom(){
		String nom;
		System.out.print("NOM : ");
		nom = clavier.nextLine();
		return nom;
	}

	static String prenom(){
		String prenom;
		System.out.print("PRENOM : ");
		prenom = clavier.nextLine();
		return prenom;
	}

	static int age(){
		int age;
		System.out.print("AGE : ");
		age = clavier.nextInt();
		return age;
	}	
}