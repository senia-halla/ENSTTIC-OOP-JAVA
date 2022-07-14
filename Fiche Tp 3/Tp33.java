import java.util.*;
class Persone {
	private String nom;
	private String prenom;
	private int age;

	public Persone(String nom, String prenom, int age){
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
}
class Salarie extends Persone{
	private String poste;

	public Salarie(String nom, String prenom, int age, String poste){
		super(nom,prenom,age);
		this.poste = poste;
	}

	public String toString(){
		return (super.toString() +" - Poste : "+poste) ;
	}

	public boolean equals(Object o){
		Salarie p = (Salarie)o;
		if (this.getNom().equals(p.getNom()) && this.getPrenom().equals(p.getPrenom()) && this.getAge() == p.getAge() && this.poste.equals(p.poste)){
			return true;
		}
		else{
			return false;
		}
	}
}



public class Tp33{
	public static class Entreprise {
		List<Salarie> employes = new ArrayList<>();

		public Entreprise(List<Salarie> employes){
			super();
			this.employes = employes;
		}

		public Entreprise(){
			super();
		}

		public boolean existe(Salarie s){
			Iterator<Salarie> it = this.employes.iterator();
			while(it.hasNext()){
				if(s.equals(it.next())){
					return true;
				}	
			}
			return false ;	
		}

		public void add(Salarie s) throws Exception{
			if(this.existe(s)){
				throw new Exception (s + " fait déja partie des employés");
			}
			else{
				this.employes.add(s);
			}
		}

		public String toString(){
			return this.employes.toString();
		}
	}


	public static void main(String[] args){
		Entreprise entreprise = new Entreprise();
		Scanner clavier = new Scanner(System.in);
		
		int i=1;
		boolean continuer = true;

		while(continuer){
			System.out.println("Salarié N° "+i);

			System.out.print("\t Nom : ");
			String nom = clavier.nextLine();
			System.out.println();

			System.out.print("\t Prenom : ");
			String prenom = clavier.nextLine();
			System.out.println();

			System.out.print("\t Age : ");
			int age = clavier.nextInt();
			clavier.nextLine();
			System.out.println();

			System.out.print("\t Poste : ");
			String poste = clavier.nextLine();

			try{
				entreprise.add(new Salarie(nom,prenom,age,poste));
			}catch(Exception e){
				System.err.println(e.getMessage());
			}

			System.out.print("Voulez vous continuer ? : o pour oui , n pour non ");
			String choix = clavier.next();
			clavier.nextLine();
			if(choix.toLowerCase().equals("n")){
				continuer = false ;
			}
			i++;
		}
		System.out.print("Les employes de l'entreprise sont : "+entreprise);
		clavier.close();
	}
}