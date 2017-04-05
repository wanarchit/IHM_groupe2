package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class Realisation {
    
    private int numTentative;
    private ArrayList<Commande> listeCommande;
    private String commentaire;
    private String note;
    private boolean aCorriger;
    private Exercice exo;
    
    /**
     * Constructeur de Realisation, listeCommande vide de base ajout des commande via un bouton qui appelle addCommande
     * undo, enlève la dernière action faite, pas de redo.
     * @param numero
     * @param com
     * @param n
     */
    public Realisation(int numero, String com, String n, Exercice exerc) {
        exo = exerc;
        numTentative = numero;
        commentaire = com;
        note = n;
        listeCommande = new ArrayList<Commande>();
        aCorriger = true;
    }
    
    /**
     * Setter de note
     * @param n la nouvelle note
     */
    public void setNote(String n){
        note = n;
    }
    
    /**
     * Getter de l'exercie
     * @return L'exercice pour lequel la réalisation a été faite.
     */
    public Exercice getExercice(){
        return(exo);
    }
    
    /**
     * Getter de note
     * @return la note, un String.
     */
    public String getNote(){
        return note;
    }
    
    /**
     * Getter de commentaire
     * @return le commentaire, un String
     */
    public String getCommentaire() {
        return commentaire;
    }
    
    public int getNumeroTentative(){
        return numTentative;
    }
    
    /**
     * Setter de commentaire
     * @param com le nouveau commentaire
     */
    public void setCommentaire(String com) {
        commentaire = com;
    }
    
    /**
     * Ajoute une commande à la liste de commande
     * @param cmd la commande ajoutée
     */
    public void ajouterCommande(Commande cmd) {
        listeCommande.add(cmd);
    }
    
    /**
     * Getter de listeCommande
     * @return la liste de Commande
     */
    public ArrayList<Commande> getListeCommande() {
        return listeCommande;
    }
    
    /**
     * Enlève la dernière commande ajoutée dans listeCommande
     */
    public void supprimeDerniereCommande() {
        int l;
        l = listeCommande.size();
        listeCommande.remove(l-1);
    }
    
    public Commande getCommandeInListe(int i) {
        return listeCommande.get(i);
    }
    
    public void setACorriger(boolean bool) {
        if (aCorriger) { //ne change pas si à false, pas besoin de le corriger
            aCorriger = bool;
        }
    }
}
