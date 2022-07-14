import java.util.*;

class Livre{
    private int ref , stock;
    private String titre , auteur;

    public Livre(int ref, String titre , String auteur , int stock){
        this.ref = ref;
        this.titre = titre;
        this.auteur = auteur;
        this.stock = stock ;
    }

    public int getRef(){
        return ref ;
    }

    public String getTitre(){
        return titre;
    }

    public String getAuteur(){
        return auteur;
    }

    public int getStock(){
        return stock ;
    }

    public void setRef(int ref){
        this.ref = ref ;
    }

    public void setTitre(String titre){
        this.titre = titre ;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur ;
    }

    public void augmenterStock(int quantite){
        stock =+ quantite ;
    }

    public void diminuerStock(int quantite){
        stock =- quantite ;
    }
}

class Etudiant {
    private String nom ,  ige ;
    private int numSerie ;
    private List livreEmprunter ;

    public Etudiant(int numSerie, String nom , String ige , List livreEmprunter){
        this.numSerie = numSerie;
        this.nom = nom ;
        this.ige = ige ;
        this.livreEmprunter = livreEmprunter; 
    }

    public int getNumSerie(){
        return numSerie;
    }

    public String getNom(){
        return nom ;
    }

    public String getIge(){
        return ige;
    }

    public void setNumSerie(int numSerie){
        this.numSerie = numSerie;
    }

    public void setNom(String nom){
        this.nom = nom ;
    }

    public void setIge(String ige){
        this.ige = ige ;
    }

    public void rendre(Livre l){
        livreEmprunter.remove(l);
        l.diminuerStock(1);
    }

    public List<Livre> getLivreEmprunter(){
        return livreEmprunter;
    }

    public void emprunter(Etudiant e, Livre l){
        List<Livre> listLivreEmprunter = e.getLivreEmprunter() ;
        for(Livre livre : listLivreEmprunter){
            if(livre.getTitre().equal(l.getTitre())){
                System.out.println("Ce livre appartient deja a votre liste de livre emprunter ! ");
            }

            else{
                livreEmprunter.add(l);
                l.diminuerStock(1);
            }
        }
    }

    public void rendre(Etudiant e , Livre l){
        for(Livre livre : e.getLivreEmprunter()){
            if(livre.getTitre().equal(l.getTitre())){
                livreEmprunter.add(l);
                l.diminuerStock(1);
            }

            else{
                System.out.println("Vous n'avez pas empreinter ce livre il y a peut etre une erreur");
            }
        }
    }
}

static class Gestion{

    public static void nouvelArrivage(List<Livre> listLivre , Livre l , int quantite){
        for(Livre livre : listLivre){
            if(l.getNom().equal(livre.getNom())){}
            else{
                listLivre.add(l);
            }
        }
        l.augmenterStock(quantite);
    }

    public static void nouvelEtudiant(List<Etudiant> listEtudiant , Etudiant e){
        for(Etudiant etudiant : listEtudiant){
            if(etudiant.getNom().equal(e.getNom())){
                System.out.println("Vous etes deja inscrit");
            }

            else{
                listEtudiant.add(e);
            }
        }
    }

    public static void affichageEtat(List listEtudiant , List listLivre){
        for(Livre l : listLivre){
            int i=0;
            System.out.println("---------------------------------------------------------");
            System.out.println(l.getRef()+" , "+l.getTitre()+" |  Stock "+l.getStock());
            System.out.prinln("Les etudiants qui l'ont emprunter : ");
            for(Etudiant e : listEtudiant){
                for(Livre liv : e.getLivreEmprunter()){
                    if(l.getTitre().equal(liv.getTitre())){
                       System.out.println(e.getNumSerie()+" , "+e.getNom()+" , "+e.getIge());
                        i++;
                    }
                }
            }
            System.out.println("---------------------------------------------------------");
            System.out.println("Nombre Total des etudiants qui ont empreinter ce livre : "+i);
        }
    }
}

public class TestBib{
    @SuppressWarnings("unchecked")
    public static void main(String[] args){

    }
}
