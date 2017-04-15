package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Classe CtrlArbreExercicesEleve
 * Permet de controler les actions effectuées sur l'arbre des exercices d'un élève
 * Le fait de cliquer sur une feuille permettra de renvoyer vers la tentative de l'élève et de l'évaluer
 * 
 * @author Paul
 */
public class CtrlArbreExercicesEleve implements TreeSelectionListener{
    
    private JTree myTree;
    private ApplicationProf appli;
    private Eleve eleve;
    
    public CtrlArbreExercicesEleve(JTree tree,ApplicationProf lAppli,Eleve lEleve){
        myTree = tree;
        appli = lAppli;
        eleve = lEleve;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) myTree.getLastSelectedPathComponent();
        
        if (node.getUserObject() instanceof Exercice){
            Exercice exo = (Exercice) node.getUserObject();
            appli.afficheExoEleve(exo);
        }else if (node.getUserObject() instanceof Realisation){
            Realisation laRea = (Realisation) node.getUserObject();
            appli.afficheReaEleve(laRea,eleve);
        }
    }
}
