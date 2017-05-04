package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.RejouerReaEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Groupe 2
 */
public class CtrlRejouerReaEleve implements ActionListener{
    
    private RejouerReaEleve leMenu;
    
    public CtrlRejouerReaEleve(RejouerReaEleve menu){
        leMenu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getButRetour()){
            leMenu.dispose();
        }else if (e.getSource() == leMenu.getButAvance()){
            leMenu.avancer();
        }else if (e.getSource() == leMenu.getButRecule()){
            leMenu.annuler();
        }
    }
}
