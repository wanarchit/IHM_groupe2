package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class Realisation {
    
    private int numTentative;
    private ArrayList listeCommande;
    private String commentaire;
    private String note;
    
    /**
     * Constructeur de Realisation, listeCommande vide de base ajout des commande via un bouton qui appelle addCommande
     * undo, enlève la dernière action faite, pas de redo.
     * @param numero
     * @param com
     * @param n
     */
    public Realisation(int numero, String com, String n) {
        numTentative = numero;
        commentaire = com;
        note = n;
        listeCommande = new ArrayList<Commande>();
    }
    
    /**
     * Setter de note
     * @param n la nouvelle note
     */
    public void setNote(String n){
        note = n;
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
    public ArrayList getListeCommande() {
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
}
