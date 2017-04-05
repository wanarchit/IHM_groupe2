package ihm_groupe2.Noyau_fonctionnel;

/**
 *
 * @author Paul
 */
public class Commande {
    
    private String nomCommande;
    private TortueG maTortue;

    
    /**
     * Constructeur de commande
     * @param nomCom le nom de la commande
     * @param t la tortue utilisée
     */
    public Commande(String nomCom, TortueG t){
        nomCommande = nomCom;
        maTortue = t;
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
        return maTortue;
    }
    
    /**
     * Rejoue une commande, pour une tortue
     * @param c la commande à rejouer
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
