/*
La pharmacie g�re des clients et des m�dicaments. Un client est caract�ris� par un nom et un cr�dit.
Le cr�dit repr�sente la somme que ce client doit � la pharmacie. Le cr�dit peut �tre n�gatif si le client a
vers� plus d'argent que le montant. Un m�dicament est caract�ris� par un nom (de type String), un prix (de type double)
et un stock (de type int). Les m�thodes � compl�ter auront les caract�ristiques suivantes:

affichage(..) permet d'afficher les clients et leurs cr�dits respectifs ainsi que les m�dicaments et leurs stocks respectifs.
approvisionner(..) permet d'approvisionner le stock d'un m�dicament. Le nom du m�dicament � approvisionner ainsi que la quantit�
� ajouter au stock doivent �tre lus depuis le terminal. Lorsque le nom du m�dicament est introduit, il faut v�rifier qu'il s'agit
bien d'un nom connu dans la liste des m�dicaments de la pharmacie. Le programme doit boucler jusqu'� introduction d'un nom correct. 
Cette proc�dure de v�rification sera prise en charge par la m�thode lireMedicament(..) d�crite plus bas. 
achat(..) permet de traiter un achat fait par un client. l'achat porte sur un m�dicament donn� dans une quantit� donn�e. 
Pour cette transaction le client paie un certain prix. Une op�ration d'achat aura pour effet de d�duire la quantit� achet�e du stock 
du m�dicaments correspondant et d'augmenter le cr�dit du client (d'un montant �quivalent au montant de l'achat moins la somme pay�e).
Les noms du client et du m�dicament doivent �tre lus depuis le terminal. Le programme doit boucler jusqu'� introduction de noms connus
aussi bien pour les clients que les m�dicament. Ces proc�dures de v�rification seront prises en charge par les m�thodes lireClient et 
lireMedicament (voir plus bas). La quantit� achet�e et le montant pay� sont aussi lus depuis le terminal. Ils seront suppos�s corrects.
quitter(..) affiche le message ``programme termin�!''.
Vous d�finirez une m�thode auxiliaire lireClient(..) prenant comme param�tre un tableau de clients. Elle permettra de lire le nom d'un
client depuis le terminal et de v�rifier si ce client existe dans le tableau des clients. Dans ce cas le client sera retourn�. 
Cette m�thode doit boucler jusqu'� ce qu'un client soit trouv�. Elle sera utilis�e par la m�thode achat(..). Une m�thode similaire,
lireMedicament(..) sera fournie pour les m�dicaments. Elle sera utilis�e par les m�thodes achat(..) et approvisionnement(..).
Vous �tes libre de d�finir, en plus de ces m�thodes, toutes celles que vous jugerez n�cessaires.
Lors de la programmation, il vous est demand� de respecter scrupuleusement les indications suivantes:

Votre programme doit �tre bien modularis� � la fois sous forme de m�thodes auxiliaires de la m�thode main() et sous forme de classes pour
les objets du programme. En particulier:
Chaque variable et m�thode doit �tre d�clar�e dans la classe la plus adapt�e.
Dans chaque classe li�e � un objet, il faut utiliser le mot-cl� private autant que possible. En particulier, toutes les variables d'instances seront priv�es.
Votre programme doit montrer une utilisation judicieuse de tableaux aux endroits adapt�s.
la comparaison de deux chaines s1 et s2 se fera au moyen de la m�thode java equals() (s1.equals(s2) retourne true si s1 et s2 sont identiques).

Vous pouvez utiliser les m�thodes scanner.nextInt(),
scanner.nextDouble() et scanner.nextLine().

*/

import java.util.*;
class Client{
	//Varible
	private String nom = "";
	private double credit = 0.0;
	//Constructeur client carcteris� nom, credit
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
	// Constructeur medicament cract�ris� par : nom, prix, stock
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
			System.out.println("Achat impossible . Quantit� de Stock insufisante");
		}
	}
	// Approvisionnemnt
	static void approvisionnemnt(Medicament[] medicaments){
		Medicament medicament = lireMedicament(medicaments);
		System.out.println("Donner la quantit� entr� : ");
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
		System.out.println("Programme Termin�");
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
		System.out.println("Quelle est la quantit� achet� ?");
		quantite = clavier.nextInt();
		return quantite;
	}	
}