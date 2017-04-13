package ihm_groupe2.Inferface.Menu;

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

/**
 *
 * @author Delphine
 */
public class AfficheEleve{
    
    private JTree myTree;
    private ArrayList<Realisation> lesRealisations;

    public AfficheEleve(Eleve monEleve, ArrayList<Exercice> Exos) {
        
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
    }
    
    public JTree getArbre(){
        return myTree;
    }
}
   
