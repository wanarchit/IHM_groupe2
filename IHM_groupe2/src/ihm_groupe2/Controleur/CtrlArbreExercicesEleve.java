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
 * @author Groupe 2
 */
public class CtrlArbreExercicesEleve implements TreeSelectionListener{
    
    private JTree myTree;
    private ApplicationProf appli;
    private Eleve eleve;
    
    /**
     * Constructeur du controleur CtrlArbreExercicesEleve
     * @param tree : arbre utilisée
     * @param lAppli : application utilisée
     * @param lEleve  : élève choisi
     */
    public CtrlArbreExercicesEleve(JTree tree,ApplicationProf lAppli,Eleve lEleve){
        myTree = tree;
        appli = lAppli;
        eleve = lEleve;
    }

    @Override
    /**
     * Méthode valueChanged
     * Permet d'effectuer une action en fonction du noeud clické
     * Soit un exercice : affiche l'exercice de l'élève
     * Soit une réalisation : affiche la réalisation de l'élève
     * @param e : tree selection event
     */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) myTree.getLastSelectedPathComponent();
        
        if (node.getUserObject() instanceof Exercice){ //EXERCICE
            Exercice exo = (Exercice) node.getUserObject();
            appli.afficheExoEleve(exo);
        }else if (node.getUserObject() instanceof Realisation){  //REALISATION
            Realisation laRea = (Realisation) node.getUserObject();
            appli.afficheReaEleve(laRea,eleve);
        }
    }
}
