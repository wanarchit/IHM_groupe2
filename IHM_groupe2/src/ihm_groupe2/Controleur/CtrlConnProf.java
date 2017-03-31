package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.MenuConnexionProf;
import ihm_groupe2.Inferface.Menu.MenuProf;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlConnEleve
 Permet de controler la connexion d'un élève ou d'un professeur en validant le formulaire
 et en récupérant les données dans la base de données
 Permet de rediriger vers la page des exercices de l'élève pour un élève ou du menu d'un professeur
 * @author Paul
 */
public class CtrlConnProf implements ActionListener {
    
    private MenuConnexionProf leMenu;
    
    public CtrlConnProf(MenuConnexionProf menuCo){
        leMenu = menuCo;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Professeur leProf = new Professeur("logProf","12345","LeGrand","Jean");
        new MenuProf(leProf,leMenu.getMainFrame());
    }
    
}
