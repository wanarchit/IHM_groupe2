package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.*;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 * Classe modèle pour un JTable
 * Permet de définir les colones du JTable
 * Notre JTable n'est pas modifiable mais clickable
 * Il renvoie vers la page de modification d'un exercice
 * 
 * @author Delphine
 */
public class TableExercices extends AbstractTableModel{
    
    private String[] columnName = {"Nom exercice", "Type de tortue", "Modifications", "Image de l'exercice"};
    private ArrayList<Exercice> listeExo;
    
    public TableExercices (ArrayList <Exercice> listeExo){
        this.listeExo = listeExo;
    }
    
    /**
     * Permet de renvoier le nombre de colonne du tableau
     * @return lenght
     */
    @Override
    public int getColumnCount(){
        return columnName.length;
    }
    
    /**
     * Permet de renvoyer le nombre de ligne du tableau
     * Cela correspond au nombre d'exercice dans la classe
     * @return nb lignes
     */
    @Override
    public int getRowCount(){
        return (listeExo.size());
    }
    
     /**
     * Retourne le nom de la colone en fonction de la colonne sélectionnée
     * @param i : numéro de la colonne
     * @return le nom de la colonne (String)
     */
    public String getColumnName(int i){
        switch(i){
            case 0: return"Nom exercice";
            case 1: return"Type de tortue";
            case 2: return"Modifications";
            case 3: return"Image de l'exercice";
            default: return "";
        }
    }
    
    @Override
    /**
     * Récupère la valeur de la cellule correspondante selon chaque colone
     */
    public Object getValueAt(int rowIndex, int columnIndex){

        switch(columnIndex){
            case 0: return listeExo.get(rowIndex).getNom();
            case 1: 
                if (listeExo.get(rowIndex).getMaTortue().getClass() == TortueCouleur.class){
                    return "Tortue couleur";
                }
                else if (listeExo.get(rowIndex).getMaTortue().getClass() == TortueRapide.class){
                    return "Tortue rapide";
                }
                else {return "Tortue classique";}
            case 2: 
                if (listeExo.get(rowIndex).isModifiable()){  
                    return "Possible";
                }
                else{
                    return "Impossible";
                }
            case 3: 
                ImageIcon ic = new ImageIcon((listeExo.get(rowIndex).getImage()).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                return ic;
            default: return "";
        }
    }
    
    public void setData(ArrayList <Exercice> listeExo){
        this.listeExo = listeExo;
    } 
    
    @Override
    /**
     * Permet de définir si les cellules sont modifiables ou non
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //Toutes les cellules sont non éditables
    }
    
    @Override
    public Class getColumnClass(int columnIndex){
        switch(columnIndex){
            case 3 : return ImageIcon.class;
            default:
                return Object.class;
        }
    }
    
    /**
     * Permet de récupérer l'objet d'une ligne
     * @param rowIndex
     * @return
     */
    public Exercice getExoRow(int rowIndex){
	return listeExo.get(rowIndex);
    }
}