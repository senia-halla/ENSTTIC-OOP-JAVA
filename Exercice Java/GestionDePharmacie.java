/*
La pharmacie gère des clients et des médicaments. Un client est caractérisé par un nom et un crédit.
Le crédit représente la somme que ce client doit à la pharmacie. Le crédit peut être négatif si le client a
versé plus d'argent que le montant. Un médicament est caractérisé par un nom (de type String), un prix (de type double)
et un stock (de type int). Les méthodes à compléter auront les caractéristiques suivantes:

affichage(..) permet d'afficher les clients et leurs crédits respectifs ainsi que les médicaments et leurs stocks respectifs.
approvisionner(..) permet d'approvisionner le stock d'un médicament. Le nom du médicament à approvisionner ainsi que la quantité
à ajouter au stock doivent être lus depuis le terminal. Lorsque le nom du médicament est introduit, il faut vérifier qu'il s'agit
bien d'un nom connu dans la liste des médicaments de la pharmacie. Le programme doit boucler jusqu'à introduction d'un nom correct. 
Cette procédure de vérification sera prise en charge par la méthode lireMedicament(..) décrite plus bas. 
achat(..) permet de traiter un achat fait par un client. l'achat porte sur un médicament donné dans une quantité donnée. 
Pour cette transaction le client paie un certain prix. Une opération d'achat aura pour effet de déduire la quantité achetée du stock 
du médicaments correspondant et d'augmenter le crédit du client (d'un montant équivalent au montant de l'achat moins la somme payée).
Les noms du client et du médicament doivent être lus depuis le terminal. Le programme doit boucler jusqu'à introduction de noms connus
aussi bien pour les clients que les médicament. Ces procédures de vérification seront prises en charge par les méthodes lireClient et 
lireMedicament (voir plus bas). La quantité achetée et le montant payé sont aussi lus depuis le terminal. Ils seront supposés corrects.
quitter(..) affiche le message ``programme terminé!''.
Vous définirez une méthode auxiliaire lireClient(..) prenant comme paramètre un tableau de clients. Elle permettra de lire le nom d'un
client depuis le terminal et de vérifier si ce client existe dans le tableau des clients. Dans ce cas le client sera retourné. 
Cette méthode doit boucler jusqu'à ce qu'un client soit trouvé. Elle sera utilisée par la méthode achat(..). Une méthode similaire,
lireMedicament(..) sera fournie pour les médicaments. Elle sera utilisée par les méthodes achat(..) et approvisionnement(..).
Vous êtes libre de définir, en plus de ces méthodes, toutes celles que vous jugerez nécessaires.
Lors de la programmation, il vous est demandé de respecter scrupuleusement les indications suivantes:

Votre programme doit être bien modularisé à la fois sous forme de méthodes auxiliaires de la méthode main() et sous forme de classes pour
les objets du programme. En particulier:
Chaque variable et méthode doit être déclarée dans la classe la plus adaptée.
Dans chaque classe liée à un objet, il faut utiliser le mot-clé private autant que possible. En particulier, toutes les variables d'instances seront privées.
Votre programme doit montrer une utilisation judicieuse de tableaux aux endroits adaptés.
la comparaison de deux chaines s1 et s2 se fera au moyen de la méthode java equals() (s1.equals(s2) retourne true si s1 et s2 sont identiques).

Vous pouvez utiliser les méthodes scanner.nextInt(),
scanner.nextDouble() et scanner.nextLine().

*/

import java.util.*;
class Client{
	//Varible
	private String nom = "";
	private double credit = 0.0;
	//Constructeur client carcterisé nom, credit
	public Client(String nom, double credit){
		this.nom = nom;
		this.credit = credit;
	}
	//Augmenter le credit d'un montant
	public void augmenterCredit(double montant){
		credit = credit + montant ;
	}
	//diminuer le credit d'un montant
	public void diminuerCredit(double montant){
		credit = credit - montant ;
	}
	// accesseur get credit nom, credit
	public String getNom(){
		return nom;
	}

	public double getCredit(){
		return credit;
	}
}
class Medicament{
	//variable
	private String nom = "";
	private double prix = 0.0;
	private int stock = 0;
	// Constructeur medicament cractérisé par : nom, prix, stock
	public Medicament(String nom, double prix, int stock){
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}
	//Augmenter le stock
	public void augmenterStock(int quantite){
		stock = stock + quantite ;
	}
	// diminuer stock
	public void diminuerStock(int quantite){
		stock = stock - quantite ;
	}
	// acceseur get nom , prix , stock
	public int getStock(){
		return stock;
	}

	public double getPrix(){
		return prix;
	}

	public String getNom(){
		return nom;
	}
} 

public class GestionDePharmacie{
	private static Scanner clavier = new Scanner(System.in);
	public static void main(String[] args){
		Client[] clients = new Client[3];
		Medicament[] medicaments = new Medicament[3];
		int choix = 0 ;

		clients[0] = new Client("HALLA Senia", 0.0);
		clients[1] = new Client("AHMED Yacine", 0.0);
		clients[2] = new Client("HALLA Assala", 0.0);

		medicaments[0] = new Medicament("LANTUS",8900,3);
		medicaments[1] = new Medicament("Novo Rapid",9700,5);
		medicaments[2] = new Medicament("LANTUS",10000,4);

		do{
			choix = menu();
			switch(choix){
				case 1:
					achat(clients , medicaments);
				break;

				case 2:
					approvisionnemnt(medicaments);
				break;

				case 3:
					affichage(clients , medicaments);
				break;

				case 4:
					quitter();
				break;
			}
		}while(choix<4);
	}

	static int menu() {
		int choix = 0;
		System.out.println("**************Menu**************");
		System.out.println("1. Achat medicament");
		System.out.println("2. Approvisionnemnt en medicament");
		System.out.println("3. Etat de stocks et de credit");
		System.out.println("4. Quitter");
		choix = clavier.nextInt();
		clavier.nextLine();
		return choix;
	}
	// Achat
	static void achat(Client[] clients, Medicament[] medicaments){
		Client client = lireClient(clients);
		Medicament medicament = lireMedicament(medicaments);
		double paiment = lirePaiment();
		int quantite = lireQuantite();
		if(quantite <= medicament.getStock()){
			medicament.diminuerStock(quantite);
			client.augmenterCredit((medicament.getPrix() * quantite) - paiment);
		}
		else{
			System.out.println("Achat impossible . Quantité de Stock insufisante");
		}
	}
	// Approvisionnemnt
	static void approvisionnemnt(Medicament[] medicaments){
		Medicament medicament = lireMedicament(medicaments);
		System.out.println("Donner la quantité entré : ");
		int quantite = clavier.nextInt();
		medicament.augmenterStock(quantite);
	}
	//Etat stock et credit :
	static void affichage(Client[] clients, Medicament[] medicaments){
		System.out.println("Affichage Stocks : ");
		for(int i = 0 ; i < medicaments.length ;i++){
			System.out.println("Stock du medicament "+medicaments[i].getNom()+" : "+medicaments[i].getStock());
		}

		System.out.println("Affichage credits : ");
		for(int i = 0 ; i < clients.length ;i++){
			System.out.println("credit du clients  "+clients[i].getNom()+" : "+clients[i].getCredit());
		}
	}
	// Quitter 
	static void quitter(){
		System.out.println("Programme Terminé");
	}
	
	static Client lireClient(Client[] clients){
		String nom ;
		boolean trouve=false;
		Client c = null;
		System.out.println("Entrez Nom du client");
		do{
			nom = clavier.nextLine();
			for(int i=0;(!trouve && i < clients.length);i++){
				if((clients[i].getNom()).equals(nom)){
					trouve = true;
					c = clients[i];
				}
			}
			if(!trouve){
				System.out.println("Client Inconnu");
			}
		} while(!trouve);
		return c;
	}

	static Medicament lireMedicament(Medicament[] medicaments){
		String nom;
		boolean trouve = false;
		Medicament m = null;
		System.out.println("Entrez Nom du Medicament ");
		do{
			nom = clavier.nextLine();
			for(int i=0; (!trouve && i < medicaments.length); i++){
				if((medicaments[i].getNom()).equals(nom)){
					trouve = true;
					m = medicaments[i];
				}
			}
			if(!trouve){
				System.out.println("Medicament Introuvanle");
			}
		}while(!trouve);
		return m;
	}

	static double lirePaiment(){
		double paiment;
		System.out.println("Quel est le montant du paiement ");
		paiment = clavier.nextDouble();
		return paiment;
	}

	static int lireQuantite(){
		int quantite;
		System.out.println("Quelle est la quantité acheté ?");
		quantite = clavier.nextInt();
		return quantite;
	}	
}