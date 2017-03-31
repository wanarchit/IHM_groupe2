package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Classe CtrlConnEleve
 Permet de controler la connexion d'un élève ou d'un professeur en validant le formulaire
 et en récupérant les données dans la base de données
 Permet de rediriger vers la page des exercices de l'élève pour un élève ou du menu d'un professeur
 * @author Paul
 */
public class CtrlConnEleve implements ActionListener {
    
    private MenuConnexionEleve leMenu;
    
    public CtrlConnEleve(MenuConnexionEleve menuCo){
        leMenu = menuCo;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Eleve leEleve = new Eleve(null,null,"Rousse","Delphine");
        new MenuEleve(leEleve,leMenu.getMainFrame());
    }
    
}
