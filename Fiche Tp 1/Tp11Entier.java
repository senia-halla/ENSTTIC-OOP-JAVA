class Entier {
	private int n;
	public Entier (int nEntree){
		n = nEntree;
	}

	public void incrementation(int incrementEntree){
		n = n + incrementEntree ;
	}
	public void affichage(){
		System.out.println(n);
	}
}

public class Tp11Entier {
	public static void main(String[] args){
		Entier n1 = new Entier(2) ;
		Entier n2 = new Entier(5) ;
		// Affichage de n1 
		System.out.println("Numero 1 : ");
		n1.affichage();

		// Affichage de n2
		System.out.println("Numero 2 : ");
		n2.affichage();

		// incrementation de n1 par 3
		n1.incrementation(3);

		// verification d'egaliter entre n1 apres incrementation et n2
		System.out.println(" (n1 == n2) = "+(n1==n2));

		// Affectation de n2 à n1
		n1 = n2 ;
		n2.incrementation(4);

		//Affichage des nouvels valeur de n1 et n2
		n1.affichage();
		n2.affichage();

		// Verification d'egaliter entres les deux nouvels valeurs 
		System.out.println("(n1 == n2 ) : "+(n1 == n2 ));
	}
}