package ihm_groupe2.Noyau_fonctionnel;

/**
 * Cette classe représente les objets "commande".
 * Elle regroupe l'ensemble des commandes utilisables par l'ensemble des tortues
 * Une commande est caractérisée par un nom et un type de tortue (rapide, couleur ou G)
 * 
 * @author Groupe 2
 */
public class Commande {
    
    private String nomCommande;
    private TortueG maTortue;

    /**
     * Constructeur de commande
     * Permet la création d'une commande
     * @param nomCom le nom de la commande
     * @param t la tortue utilisée
     */
    public Commande(String nomCom, TortueG t){
        nomCommande = nomCom;
        maTortue = t;
    }
    
    /**
     * Méthode getCommande
     * Permet de retourner le nom de la commande
     * @return nomCommande : de type String
     */ 
    public String getCommande(){
        return nomCommande;
    }
    
    /**
     * Méthode getTortue
     * Permet de retourner la tortue utilisée
     * @return maTortue : de type TortueG
     */ 
    public TortueG getTortue() {
        return maTortue;
    }
    
    /**
     * Méthode doAction
     * Permet de rejouer une commande en fonction de la tortue
     * @param c : la commande à rejouer de type Commande
     */
    public void doAction(Commande c) {
        switch(c.getCommande()){
            case "Avancer":
                c.getTortue().avancer();
            case "Tourner":
                c.getTortue().tourner();
            case "Ecrire":
                c.getTortue().tracer(true);
            case "Pas ecrire":
                c.getTortue().tracer(false);
            case "Accélérer":
                if (c.getTortue() instanceof TortueRapide){
                    ((TortueRapide) c.getTortue()).accelerer();
                }
            case "Ralentir":
                if (c.getTortue() instanceof TortueRapide){
                    ((TortueRapide) c.getTortue()).ralentir();
                }
            case "Rouge":
                if (c.getTortue() instanceof TortueCouleur){
                    ((TortueCouleur) c.getTortue()).setCouleur("red");
                }
            case "Bleu":
                if (c.getTortue() instanceof TortueCouleur){
                    ((TortueCouleur) c.getTortue()).setCouleur("blue");
                }
            case "Magenta":
                if (c.getTortue() instanceof TortueCouleur){
                    ((TortueCouleur) c.getTortue()).setCouleur("magenta");
                }
            case "Noir":
                if (c.getTortue() instanceof TortueCouleur){
                    ((TortueCouleur) c.getTortue()).setCouleur("black");
                }
            case "Jaune":
                if (c.getTortue() instanceof TortueCouleur){
                    ((TortueCouleur) c.getTortue()).setCouleur("yellow");
                }
            case "Vert":
                if (c.getTortue() instanceof TortueCouleur){
                    ((TortueCouleur) c.getTortue()).setCouleur("green");
                }
        }
    }
}
