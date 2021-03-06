package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.MenuConnexionProf;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Classe CtrlConnEleve
 * Permet de controler la connexion d'un professeur en validant le formulaire
 * et en récupérant les données dans la base de données
 * Permet de rediriger vers le menu d'un professeur
 * 
 * @author Groupe 2
 */
public class CtrlConnProf implements ActionListener {
    
    private MenuConnexionProf leMenu;
    private ApplicationProf appli;
    
    /**
     * Constructeur du controleur CtrlConnProf
     * @param menuCo : menu de connexion du professeur
     * @param lAppli  : application utilisée
     */
    public CtrlConnProf(MenuConnexionProf menuCo,ApplicationProf lAppli){
        leMenu = menuCo;
        appli = lAppli;      
    }
    
    @Override
    /**
     * Méthode actionPerformed
     * Permet d'effectuer une action en fonction de l'événement qui arrive
     * Lorsque l'on choisit le bouton valider : il vérifie que les champs ne
     * sont pas vides, qu'ils correspondent à un professeur notamment
     * Sinon cela affiche des boites de dialogue pour avertir l'utilisateur
     * @param e : Action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getButValidation()){
            if (!leMenu.getTextLogin().getText().isEmpty() ){
                if (!leMenu.getTextMdp().getText().isEmpty()){
                    Professeur leProf = appli.tryConnexion(leMenu.getTextLogin().getText(), leMenu.getTextMdp().getText());
                    if (leProf != null){
                        appli.seConnecter(leProf);
                    }else{
                         //Boîte du message d'information.
                        JOptionPane boiteDial = new JOptionPane();
                        boiteDial.showMessageDialog(null, "Vos identifiants sont incorrects", "Connexion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    //Boîte du message d'information.
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "Vous devez renseigner votre mot de passe", "Connexion", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                //Boîte du message d'information.
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "Vous devez renseigner votre login", "Connexion", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource() == leMenu.getButAnnuler()){
            appli.annulerConnexion();
        }
    }    
}