package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Noyau_fonctionnel.Eleve;
import javax.swing.JPanel;

/**
 * Classe MenuEleve
 * Permet de créer le menu d'un eleve
 * Dans ce menu on affichera les exercices à faires, les exercices réalisés, les tentatives et les évaluations
 * @author Paul
 */
public class MenuEleve extends JPanel{
    
    private Eleve eleveConnecte;
    
    /**
     * Constructeur de la classe MenuEleve
     * Permet de créer le menu pour un eleve
     * @param eleve : concerné par le menu (ses dessins)
     */
    public MenuEleve(Eleve eleve){
        eleveConnecte = eleve;
    }
}
