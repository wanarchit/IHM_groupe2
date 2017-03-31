package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
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
    private ApplicationEleve Appli;
    
    public CtrlConnEleve(MenuConnexionEleve menuCo, ApplicationEleve lAppli){
        leMenu = menuCo;
        Appli = lAppli;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Eleve leEleve = new Eleve(null,null,"Rousse","Delphine");
        if (!leMenu.getTextPrenom().getText().isEmpty() ){
            if (!leMenu.getTextNom().getText().isEmpty()){
                if (Appli.tryConnexion(leMenu.getTextPrenom().getText(), leMenu.getTextNom().getText())){
                    Appli.seConnecter();
                }else{
                    System.out.println("Impossible de se connecter ...");
                }
            }else{
                System.out.println("Vous devez renseigner le nom de l'élève");
            }
        }else{
            System.out.println("Vous devez renseigner le prénom de l'élève");
        }
        
        
    }
    
}
