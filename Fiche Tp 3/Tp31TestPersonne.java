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
		return("NOM : "+nom+" , PRENOM : "+prenom+" , AGE : "+age+" ans.");
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

	public int compareTo(Object o){
		Personne p = (Personne)o;

		if(this.age < p.age){
			return -1;
		}
		else if(this.age > p.age){
			return +1;
		}
		else{
			return 0;
		}
	}
}

class Encadrant extends Personne{
	private String module;

	public Encadrant(String nom, String prenom, int age, String module){
		super(nom,prenom,age);
		this.module = module;
	}

	public String getModule(){
		return module;
	}

	/*public String toString(){
		return(super.toString()+" , MODULE : "+module+".");
	}*/
}

class Etudiant extends Personne{
	private String pfe;

	public Etudiant(String nom, String prenom, int age, String promotion){
		super(nom,prenom,age);
		this.pfe = pfe;
	}

	public String getPromotion(){
		return pfe;
	}

	/*public String toString(){
		return(super.toString()+" , PFE : "+pfe+" .");
	}*/
}

class CompareNom implements Comparator{
	public int compare(Object o1, Object o2){
		Personne personne1 = (Personne)o1;
		Personne personne2 = (Personne)o2;
		return personne1.getNom().compareTo(personne2.getNom());
	}
}

class ComparePrenom implements Comparator{
	public int compare(Object o1, Object o2){
		Personne personne3 = (Personne)o1;
		Personne personne4 = (Personne)o2;
		return personne3.getPrenom().compareTo(personne4.getPrenom());
	}
}

public class Tp31TestPersonne{
	
	private static Scanner clavier = new Scanner(System.in);
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		String nom, prenom, module, pfe;
		int age, i;
		List<Personne> listPersonne = new ArrayList<Personne>();

		System.out.println("Saisissez 6 personnes : 3 étudiants et leurs encadrants respectifs ");

		System.out.println("**********Etudiants**********");
		for(i=0;i<3;i++){
			System.out.println("L'etudiant N° "+(i+1));
			nom = nom();
			prenom = prenom();
			age = age();
			pfe = pfe();
			Etudiant etudiant = new Etudiant(nom,prenom,age,pfe);
			listPersonne.add(etudiant);
		}	

		System.out.println("**********Encadrants**********");
		for(i=3;i<6;i++){
			System.out.println("L'encadrant de l'etudiant N° "+(i-2));
			nom = nom();
			prenom = prenom();
			age = age();
			module = module();
			Encadrant encadrant = new Encadrant(nom,prenom,age,module);
			listPersonne.add(encadrant);
		}

		System.out.println("On va trier notre liste par ordre d'age : ");
		Collections.sort(listPersonne);
		System.out.println(listPersonne);
		System.out.println();

		System.out.println("On va trier notre liste par ordre alphabetique NOM : ");
		Collections.sort(listPersonne, new CompareNom());
		System.out.println(listPersonne);
		System.out.println();

		System.out.println("On va trier notre liste par ordre alphabetique PRENOM ");
		Collections.sort(listPersonne, new ComparePrenom());
		System.out.println(listPersonne);
		System.out.println();
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
		clavier.nextLine();
		return age;
	}
	
	static String pfe(){
		String pfe;
		System.out.print("PFE : ");
		pfe = clavier.nextLine();
		return pfe;
	}

	static String module(){
		String module;
		System.out.print("MODULE : ");
		module = clavier.nextLine();
		return module;
	}
}