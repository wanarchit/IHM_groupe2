package Applications;

import ihm_groupe2.Inferface.Menu.MenuConnexionProf;

/**
 * Classe ApplicationProf : permet de gérer tous les éléments liés aux professeurs
 * @author Paul
 */
public class ApplicationProf {
    
    private MainFrame fenetreMain;
    
    public ApplicationProf(MainFrame main){
        fenetreMain = main;
        new MenuConnexionProf(fenetreMain);
    }
}
