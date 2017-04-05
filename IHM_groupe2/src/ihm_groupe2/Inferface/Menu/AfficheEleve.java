package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Modele.ArbreExercicesEleve;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Delphine
 */
public class AfficheEleve extends JScrollPane{
    
    public JTree tree;
    ArbreExercicesEleve modele;

    public AfficheEleve() {
        super();
        
        modele = new ArbreExercicesEleve();
        
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode(modele.E1.getNomPersonne());
        tree = new JTree(racine);
        
        //Nous allons ajouter des branches et des feuilles à notre racine
        for(int i = 0; i < modele.lesExercices.size() ; i++){
            DefaultMutableTreeNode ex = new DefaultMutableTreeNode(modele.lesExercices.get(i).getNom());
         
            //On rajoute les branches 
            for(int j = 0; j < modele.E1.getLesRealisations().size() ; j++){ 
                if (modele.E1.getLesRealisations().get(j).getExercice().getNom() == modele.lesExercices.get(i).getNom()){
                    DefaultMutableTreeNode res = new DefaultMutableTreeNode(modele.E1.getLesRealisations().get(j).getCommentaire());
                    ex.add(res);
                }
            }
            //On ajoute la feuille ou la branche à la racine
            racine.add(ex);
        }
        this.add(tree);
        this.setViewportView(tree); 
    }
}
   
