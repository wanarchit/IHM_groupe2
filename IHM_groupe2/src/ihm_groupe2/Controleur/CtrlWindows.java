package ihm_groupe2.Controleur;

import Applications.MainFrame;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import ihm_groupe2.Inferface.Menu.MenuProf;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Groupe 2
 */
public class CtrlWindows implements WindowListener{
    
    private MainFrame fenetre;
    public CtrlWindows(MainFrame fenetreMain){
        fenetre = fenetreMain;
    }
    
    public void windowClosing(WindowEvent e){
        if (fenetre.getContentPane().getClass() == MenuProf.class){
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer les modifications avant de quitter ?", "Quitter", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(option != JOptionPane.NO_OPTION && 
                option != JOptionPane.CANCEL_OPTION && 
                option != JOptionPane.CLOSED_OPTION){
                fenetre.getAppProf().enregistrementBDD();
                fenetre.dispose();
                System.exit(0);
             }else if (option != JOptionPane.YES_OPTION && 
                option != JOptionPane.CANCEL_OPTION && 
                option != JOptionPane.CLOSED_OPTION){
                fenetre.dispose();
                System.exit(0);
             }
            
        }else if(fenetre.getContentPane().getClass() == MenuEleve.class){     
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Déconnexion ...", "Déconnexion", JOptionPane.INFORMATION_MESSAGE);      
            fenetre.getAppEleve().enregistrementBDD();
            MenuPrincipal leMenuP = new MenuPrincipal(fenetre);
            fenetre.setContentPane(leMenuP);
            fenetre.repaint();
            fenetre.revalidate();
        }else{
            int reponse = JOptionPane.showConfirmDialog(fenetre,
                             "Voulez-vous quitter l'application ?",
                             "Confirmation",
                             JOptionPane.YES_NO_OPTION,
                             JOptionPane.QUESTION_MESSAGE);
            if (reponse==JOptionPane.YES_OPTION){
                    fenetre.dispose();
                    System.exit(0);
            }  
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
