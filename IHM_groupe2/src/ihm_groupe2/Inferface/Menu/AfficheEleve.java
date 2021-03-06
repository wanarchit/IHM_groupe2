package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlArbreExercicesEleve;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

/**
 * Classe AfficheEleve
 * Créer d'afficher un élève dans un arbre
 * @author Groupe 2
 */
public class AfficheEleve{
    
    private ApplicationProf appli;
    private JTree myTree;
    private ArrayList<Realisation> lesRealisations;
    private CtrlArbreExercicesEleve controleur;
    /**
     * Constructeur de la classe TableClasses
     * @param monEleve : élève qu'on souhaite afficher
     * @param Exos : Liste des exercices
     * @param lAppli : Application tournant
     */
    public AfficheEleve(Eleve monEleve, ArrayList<Exercice> Exos, ApplicationProf lAppli) {
        appli = lAppli;
        lesRealisations = monEleve.getLesRealisations();
        /* Création de l'arbre */
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(monEleve);
        DefaultMutableTreeNode exercice;
        DefaultMutableTreeNode realisation;
        
        for (Exercice ex : Exos){
            exercice = new DefaultMutableTreeNode(ex);
            root.add(exercice);  
        
            for (Realisation rea : lesRealisations) 
            {
                if (rea.getExercice().equals(ex)){
                    realisation = new DefaultMutableTreeNode(rea);
                    exercice.add(realisation);  
                }
            }
        }
        
        myTree = new JTree(root);
        myTree.setShowsRootHandles(true);  //Poignée sur la racine
        
        /**
         * Personnalisation du rendu des noeuds
         */
        myTree.setCellRenderer(new TreeCellRenderer(){
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            JLabel myLabel = new JLabel("");
            if (value instanceof DefaultMutableTreeNode){
                DefaultMutableTreeNode myNode = (DefaultMutableTreeNode) value;
                if (myNode.getUserObject() instanceof Exercice){  // Si c'est un exercice
                    Exercice ex = (Exercice)myNode.getUserObject();
                    myLabel = new JLabel(ex.getNom());   //Afficher le nom de l'exercice
                    if (selected & leaf & hasFocus){
                        myLabel.setForeground(Color.ORANGE);   //Colorie le noeud sélectionné en orange
                    }
                }
                else if (myNode.getUserObject() instanceof Eleve){
                    Eleve e = (Eleve)myNode.getUserObject();
                    myLabel = new JLabel(e.getNomPersonne() + " " + e.getPrenomPersonne());   //Afficher nom, prénom de l'élève
                }
                else{
                    Realisation rea = (Realisation)myNode.getUserObject();          //si le noeud est une réalisation
                    myLabel = new JLabel("Réalisation " + rea.getNumeroTentative());
                    if (selected & leaf & hasFocus){
                        myLabel.setForeground(Color.BLUE);      //colorie le noeud sélectionné en bleu
                    }
                }
            }
            JPanel pan = new JPanel();
            pan.setBackground(Color.WHITE);
            pan.add(myLabel);
            return pan;   
        }
        });
        controleur = new CtrlArbreExercicesEleve(myTree, appli,monEleve);
        myTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        myTree.addTreeSelectionListener(controleur);
    }
    /**
     * Méthode getArbre
     * Permet de renvoyer l'arbre où l'élève est chargé
     * @return myTree: JTree
     */
    public JTree getArbre(){
        return myTree;
    }
}
   
