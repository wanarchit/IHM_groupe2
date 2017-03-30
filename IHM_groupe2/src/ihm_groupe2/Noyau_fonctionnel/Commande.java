package ihm_groupe2.Noyau_fonctionnel;

/**
 *
 * @author Paul
 */
public class Commande {
    
    private String nomCommande;
    private TortueG tortue;
    
    /**
     * Constructeur de commande
     * @param nomCom le nom de la commande
     * @param t la tortue utilisée
     */
    public Commande(String nomCom, TortueG t){
        nomCommande = nomCom;
        tortue = t;
    }
    
    /**
     * Getter de nomCommande
     * @return Le nom de la commande
     */ 
    public String getCommande(){
        return nomCommande;
    }
    
    /**
     * Getter de tortue
     * @return Le type de tortue utilisée
     */
    public TortueG getTortue() {
        return tortue;
    }
    
    /**
     * Rejoue une action
     */
    public void doAction() {
        
    }
}
