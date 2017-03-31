package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import ihm_groupe2.Inferface.Menu.MenuConnexionProf;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlMenuPrincipal
 * Permet de choisir le type d'utilisateur : élève ou professeur
 * Selon le choix, l'utilisateur sera renvoyé vers la page de connexion appropriée
 * @author Paul
 */
public class CtrlMenuPrincipal implements ActionListener{
    
    private MenuPrincipal leMenu;
    
    public CtrlMenuPrincipal(MenuPrincipal MenuPrincip){
        leMenu = MenuPrincip;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getButtonEleve()){
            // On affiche le menu de connexion d'un élève
            new MenuConnexionEleve(leMenu.getMainFrame());
            
        }else{      // bouton Professeur
            // On affiche le menu de connexion d'un professeur
            new MenuConnexionProf(leMenu.getMainFrame());
        }
        
    }
    
}
