package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe Réalisation
 * Elle représente une tentative de résolution d'un exercice par un élève.
 * Chaque réalisation est caractérisée par un numéro de tentative,
 * une liste de commande associée (mouvements faits), d'un commentaire d'évaluation,
 * d'une note et d'un exercice.
 * 
 * @author Groupe 2
 */
public class Realisation {
    
    private int numTentative;
    private ArrayList<Commande> listeCommande;
    private String commentaire;
    private String note;
    private boolean aCorriger;
    private Exercice exo;
    
    /**
     * Constructeur de Realisation
     * Permet la création d'une réalisation
     * Initialise la liste des commandes à vide au départ
     * 
     * @param numero : numéro de la tentative
     * @param comm : commentaire de l'évaluation
     * @param n : note de la réalisation
     * @param exerc : exercice lié à cette tentative
     */
    public Realisation(int numero, String comm, String n, Exercice exerc) {
        exo = exerc;
        numTentative = numero;
        commentaire = comm;
        note = n;
        listeCommande = new ArrayList<Commande>();
        aCorriger = true;
    }
    
    /**
     * Méthode getExercice
     * Permet de retourner l'exercice lié à cette réalisation
     * @return exo : objet de type Exercice
     */
    public Exercice getExercice(){
        return(exo);
    }
    
    /**
     * Méthode getNote
     * Permet de retourner la note liée à cette réalisation
     * @return note : de type String
     */
    public String getNote(){
        return note;
    }
    
    /**
     * Méthode getCommentaire
     * Permet de retourner le commentaire liée à cette réalisation
     * @return commentaire : de type String
     */
    public String getCommentaire() {
        return commentaire;
    }
    
    /**
     * Méthode getNumeroTentative
     * Permet de retourner le numéro de tentative liée à cette réalisation
     * @return numTentative : de type integer
     */
    public int getNumeroTentative(){
        return numTentative;
    }
    
    /**
     * Méthode getListeCommande
     * Permet de retourner la liste des commandes liée à cette réalisation
     * @return listeCommande : Array List de Commande
     */
    public ArrayList<Commande> getListeCommande() {
        return listeCommande;
    }
    
    /**
     * Méthode getCommandeInListe
     * Permet de retourner une commande selon son numéro (première...)
     * @param i : numéro de la commande souhaité
     * @return listeCommande.get(i) : commande à la position i
     */
    public Commande getCommandeInListe(int i) {
        return listeCommande.get(i);
    }
    
    /**
     * Méthode isACorriger
     * Permet de retourner si la tentative est à corriger ou non
     * @return aCorriger : booléen vrai ou faux
     * Vrai : la tentative est à corriger
     */
    public boolean isACorriger(){
        return aCorriger;
    }
    
    /**
     * Méthode setNote
     * Permet de modifier la valeur de la note pour cette réalisation
     * @param n : la nouvelle note (String)
     */
    public void setNote(String n){
        note = n;
    }
    
    /**
     * Méthode setCommentaire
     * Permet de modifier la valeur du commentaire pour cette réalisation
     * @param com : le nouveau commentaire (String)
     */
    public void setCommentaire(String com) {
        commentaire = com;
    }
    
    /**
     * Méthode setACorriger
     * Permet de modifier la valeur du booléen à corriger
     * Il ne change pas s'il est déjà à la valeur false
     * @param bool : vrai ou faux
     */  
    public void setACorriger(boolean bool) {
        if (aCorriger) { //ne change pas si à false, pas besoin de le corriger
            aCorriger = bool;
        }
    }
    
    /**
     * Méthode ajouterCommande
     * Ajoute une commande à la liste de commande
     * @param cmd : la commande à ajouter (de type Commande)
     */
    public void ajouterCommande(Commande cmd) {
        listeCommande.add(cmd);
    }

    /**
     * Méthode supprimeDerniereCommande
     * Enlève la dernière commande ajoutée dans listeCommande
     */
    public void supprimeDerniereCommande() {
        int l;
        l = listeCommande.size();
        listeCommande.remove(l-1);
    }
}
